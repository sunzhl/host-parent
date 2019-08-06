
$(document).ready(function(){
    taskInit($('#proId').val());
    addTaskFormInit();
});

function taskInit(proId){
    $('#submit').click(function(){
        $('#addTaskForm').submit();
    });

    queryTask(1);

    queryTaskSpaces(proId);
    queryTaskType(proId);
    queryTools(proId);
    queryWorkers(proId);
}


function queryTask(currentPage) {

    var pageSize = 20;

    var val = $('#task_state_select').val();
    var state = val === ''? '0,1,2,3,4': val;
    var proId =  $('#proId').val();
    currentPage = currentPage || 1;
    $.sendGet('../../task/queryByState/' + proId + '/' + state, {pageNum: currentPage, pageSize: pageSize}, function (data, status) {
        if(status && data['success']){
            var taskList = data['data']['list'];
            $('#task_list_tbody').setTemplateElement('task_list_template');
            $('#task_list_tbody').processTemplate(taskList);
            var total = data['data']['total'];
            getMyMindMapPage(currentPage, data['data']['pageCount'], 'task_page', queryTask);
            bindEvent();
        }
    })
}



function bindEvent() {


    $('.task_edit').click(taskEdit);

    $('.task_cancel').click(function () {
        var id = $(this).attr('value');
        $('#cancel_task_title').text('任务取消');
        $('#cancel_task_label').text('取消原因：');
        $('#cancel_task_submit').attr({'flag': 'cancel', 'taskId': id});
        $('#cancel_task_modal').modal('show');
    });

    $('.task_delay').click(function () {
        var id = $(this).attr('value');
        $('#cancel_task_title').text('任务延迟');
        $('#cancel_task_label').text('延迟原因：');
        $('#cancel_task_submit').attr({'flag': 'delay', 'taskId': id});
        $('#cancel_task_modal').modal('show');
    });

    $('.task_assign').click(function () {
        var id = $(this).attr('value');
        $('#cancel_task_title').text('任务分配');
        $('#cancel_task_label').text('运送员：');
        $('#cancel_task_submit').attr({'flag': 'worker', 'taskId': id});
        $('#cancel_task_modal').modal('show');
    });

    $('#cancel_task_modal').on('shown.bs.modal', selectCancelReason);

    $('#cancel_task_submit').unbind('click').click(function () {

        if($('#cancel_task').val() === ''){

        }
        var flag = $('#cancel_task_submit').attr('flag');
        var id = $('#cancel_task_submit').attr('taskId');
        var reason = $('#cancel_task').opTxt();
        var data = {id: id};
        if('cancel' === flag){ //取消
            data['cancelReason'] = reason;
            data['state'] = 6;
            data['updateType'] = 1;
        }else if('delay' === flag){ //延迟
            data['delayReason'] = reason;
            data['updateType'] = 3;
        }else{ //分配
            data['workerId'] = $('#cancel_task').val();
            data['workerName'] = reason;
            data['state'] = 1;
            data['updateType'] = 2;
        }
        $.put('../../task/update', data, function (data, status) {
            if(status && data['success']){
                alert('操作成功');
            }else {
                alert('操作失败');
            }
            $('#cancel_task_modal').modal('hide');
            queryTask(1);
        });
    });

    $('#task_state_select').change(function () {
        var val = $(this).val();
        var state = val === ''? null: val;
        queryTask(1);
    });
    
}


function selectCancelReason() {
    var flag = $('#cancel_task_submit').attr('flag');
    var data = {proId: $('#proId').val()};
    if('worker' === flag){
        //  data['state'] = 1;
    }
    $.sendGet('../../' + flag + '/query', data, function (res, status) {
        if(status && res['success']){
            var transType = res['data'];
            if(transType != null && transType){
                var html = [];
                $.each(transType, function (index, type) {
                    var val = type['id'];
                    html.push('<option value="' + val + '">' + type[flag + 'Name'] + '</option>');
                });
                $('#cancel_task').html(html.join(''));
            }
        }
    });
}


function taskEdit() {
    var id = $(this).attr('value');

    $.sendGet('../../task/query/' + id, null, function (res, status) {

        if(status && res['success']){
            $('#myModal').modal('show');
            var data = res['data'];
            $('#start').val(data['setOutPlaceId']);
            $('#transType').val(data['taskTypeId']);
            $('#destination').val(data['destinationId'] || '');
            $('#worker').val(data['workerId'] || '');
            $('#planStartTime').val(data['planStartTime']);
            $('#finishTime').val(data['finishTime']);
            $('#planTime').val(data['bookTime']);
            $('#priority').val(data['priority']);
            $('#transTool').val(data['toolId'] || '');
            $('#realNumber').val(data['actualCount'] || '1');
            $('#patientName').val(data['patientName'] || '');
            $('#sex').val(data['sex'] || '0');
            $('#age').val(data['age'] || '');
            $('#bedNumber').val(data['bedNumber'] || '');
            $('#hospNumber').val(data['number'] || '');
            $('#remark').val(data['taskDesc'] || '');
            $('#taskId').val(data['id']);
            $('#pId').val(data['pid'] || '');
        }

    })


}

function convertTaskState(state) {

    switch (state) {
        case 0: return '<span style="color: #FF0000">未分配</span>';
        case 1: return '<span style="color: #d58512">未查阅</span>';
        case 2: return '未开始';
        case 3: return '<span style="color: green">进行中</span>';
        case 4: return '未结束';
        case 5: return '已完成';
        case 6: return '已取消';
        default: return state;
    }
}



function dateCalculation(rec) {

    var planTime = rec['planStartTime'];
    var date = Date.parse(planTime.replace(/-/g, '/'));
    var finishTime = rec['finishTime'];
    var currentTime = new Date().getTime();

    var number = currentTime - date;

    var number1 = Math.floor((finishTime * 60 * 1000 - number) / (60 * 1000));

    if(number1 < 0){
        return '<span style="color: red;">' + number1 + '</span>';
    }else{
        return '<span style="color: green;">' + number1 + '</span>';
    }


}




function addTaskFormInit() {
    /**
     * 当模态框显示完成后加载数据字典
     */
    $('#myModal').on('shown.bs.modal', function () {
        var $this = $(this);
        var dialog = $this.find('.modal-dialog');

        //此种方式，在使用动画第一次显示时有问题
        //解决方案，去掉动画fade样式
        var top = ($(window).height() - dialog.height()) / 2;
        dialog.css({
            marginTop: top
        });


    }).on('hide.bs.modal', function () {
        $('#addTaskForm')[0].reset();
    });


    // $('#datetimepicker2').datetimepicker({
    //     format: 'yyyy-mm-dd HH:mm:ss',
    //     language:  'zh-CN'
    // });


    $('#add_task_submit').click(submitAddTask);

}


function submitAddTask() {
    var data = {
        createId: $('#createId').val(),                //创建者ID
        createName: $('#createName').val(),            //创建者姓名
        taskTypeId: $('#transType').val(),       //运送类型ＩＤ
        taskTypeName: $('#transType').opTxt(),   　//运送类型名称
        setOutPlaceId: $('#start').val(),        //出发地ＩＤ
        setOutPlaceName: $('#start').opTxt(),      //出发地名
        destinationId: $('#destination').val(),  // 目的地ID
        destinationName: $('#destination').opTxt(), //目的地
        planStartTime: $('#planStartTime').val(),       //计划开始时间
        finishTime: $('#finishTime').val(),             //完成时间
        bookTime: $('#planTime').val(),                 //预约时间
        priority: $('#priority').val(),                 //优先级
        toolId: $('#transTool').val(),            //运送工具ID
        toolName: $('#transTool').opTxt(),          //运送工具名
        taskDesc: $('#remark').val(),                   //任务描述
        proId: $('#proId').val(),                       //所属项目ID
        proName: $('#proName').val(),                   //所属项目
        actualCount: $('#realNumber').val(),            //实际数量
        patientName: $('#patientName').val(),           //病人姓名
        bedNumber: $('#bedNumber').val(),               //床位
        sex: $('#sex').val(),                           //性别
        number: $('#hospNumber').val(),                 //住院号
        age: $('#age').val(),                            //年龄
        id: $('#taskId').val(),
        pid: $('#pId').val()
    };
    if('' !== $('#worker').val()){
        data['workerId'] = $('#worker').val();             //运送员
        data['workerName']= $('#worker').opTxt();           //运送员名
    }

    var id = $('#taskId').val();
    if(id === ''){
        $.sendPost('../../task/add', data, function (data, status) {
            if(status && data['success']){
                alert('添加成功');
                $('#addTaskForm')[0].reset();
                $('#myModal').modal('hide');
                queryTask();
            }else{
                alert('添加失败');
            }
        })
    }else{
        $.put('../../task/update', data, function (data, status) {
            if(status && data['success']){
                alert('修改成功');
                $('#addTaskForm')[0].reset();
                $('#myModal').modal('hide');
                queryTask();
            }else{
                alert('修改失败');
            }
        })
    }



}



function queryTools(proId) {
    $.sendGet('../../tool/query', {'proId': proId}, function (res, status) {
        if(status && res['success']){
            var workTools = res['data'];
            if(workTools != null){
                var html = ['<option value=""></option>'];
                $.each(workTools, function(index, tool){
                    var val = tool['id']; // + '-' + tool['toolName'];
                    html.push('<option value="'+ val +'">' + tool['toolName'] + '</option>');
                });
                $('#transTool').html(html.join(''));
            }

        }
    });
}

function queryTaskType(proId) {

    $.sendGet('../../type/query', {'proId': proId}, function (res, status) {
        if(status && res['success']){
            var transType = res['data'];
            if(transType != null && transType){
                var html = ['<option value=""></option>'];
                $.each(transType, function (index, type) {
                    var val = type['id'];// + '-' + type['typeName'];
                    html.push('<option value="' + val + '">' + type['typeName'] + '</option>');
                });
                $('#transType').html(html.join(''));
            }
        }
    });
}

function queryTaskSpaces(proId) {
    publicQuerySpaces(proId, ['start', 'destination']);
}

function queryWorkers(proId) {
    $.sendGet('../../user/query', {'proId': proId}, function (res, status) {
        if (status && res['success']) {
            var transType = res['data'];
            if (transType != null && transType) {
                var html = ['<option value=""></option>'];
                $.each(transType, function (index, type) {
                    var val = type['id'];// + '-' + type['workerName'];
                    html.push('<option value="' + val + '">' + type['workerName'] + '</option>');
                });
                $('#worker').html(html.join(''));
            }
        }
    });
}

