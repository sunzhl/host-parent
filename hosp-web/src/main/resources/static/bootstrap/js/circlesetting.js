var CircleSettingHandler = function () {

};

CircleSettingHandler.prototype = {

    addCirclePoint: {},
    deleteCirclePoint: {},
    start: function () {
        publicQueryProject('circle_setting_project',  $('#current_worker_id').val());
        publicQuerySpaces($('#current_pro_id').val(), 'circle_points');
        this.queryCircleSetting();
        // new TableInit().Init();
        this.queryWorker();
        this.bindEvent();
    },


    queryWorker: function(){
        var data = {proId: $('#circle_setting_project').val()};
        $.sendGet('../../worker/query', data, function (res, status) {
            if(status && res['success']){
                var transType = res['data'];
                if(transType != null && transType){
                    var html = [];
                    $.each(transType, function (index, type) {
                        var val = type['id'];
                        html.push('<option value="' + val + '">' + type['workerName'] + '</option>');
                    });
                    $('#circle_setting_worker').html(html.join(''));
                }
            }
        });


    },


    bindEvent: function(){
        var  that = this;
        $('#circle_setting_submit').unbind('click').click(function () {
            var  val = $('#circle_setting_submit_id').val();
            var points = [];
            $.each($('.circle_point_delete'), function (ele, index) {
                var type = $(index).attr('type');
                var value = $(index).attr('value');
                var txt = $(index).attr('txt');
                var id = $(index).attr('id');
                if(type === 'add'){
                   points.push({
                       spaceId: value,
                       spaceName: txt,
                       type: 'add'
                   })
                }else if(type === 'del' && id !== ''){
                    points.push({
                        id: id,
                        type: 'del'
                    })
                }
            });

            var postData = {
                'workerId': $('#circle_setting_worker').val(),
                'workerName': $('#circle_setting_worker').opTxt(),
                'finishTime': $('#circle_time').val(),
                'proId': $('#circle_setting_project').val(),
                'proName': $('#circle_setting_project').opTxt(),
                'finishCount': $('#circle_count').val(),
                'id': val,
                circlePoints: points
            };

            if(val !== ''){
                $.put('../../circle/update', postData, function (data, status) {
                    if(status && data['success']){
                        alert('保存成功');
                        $('#circle_setting_form')[0].reset();
                        $('#circle_setting_modal').modal('hide');
                        that.queryCircleSetting();
                    }else{
                        alert('保存失败');
                    }
                })
            }else{
                $.sendPost('../../circle/add', postData, function (data, status) {
                    if(status && data['success']){
                        alert('保存成功');
                        $('#circle_setting_form')[0].reset();
                        $('#circle_setting_modal').modal('hide');
                        that.queryCircleSetting();
                    }else{
                        alert('保存失败');
                    }
                });
            }

        });


        $('#circle_setting_modal').on('shown.bs.modal', function () {
            // publicQuerySpaces([[${userInfo.proId}]], 'type_destination');
        }).on('hide.bs.modal', function () {
            $('#circle_setting_form')[0].reset();
            $('#circle_setting_submit_id').val('');
            $('#spaces_list').empty();
        });

        $('#circle_setting_project').unbind('click').click(function () {
           if($(this).val() !== ''){
               that.queryWorker();
           }else{
               $('#circle_setting_worker').html('');
           }
        });

        $('#add_circle_point').unbind('click').click(function () {
           var val = $('#circle_points').val();
           var txt = $('#circle_points').opTxt()
           var flag = false;
           $.each($('.circle_point_delete'), function (ele, index) {
              if(val === $(index).attr('value')){
                  flag = true;
                  return;
              }
           });
           if(flag){
               alert('此空间点已经存在,不允许重复添加');
               return false;
           }
           var html = [];
           html.push('<div class="list-group-item col-sm-6" style="text-align: center;"><span style="padding:5px;">');
           html.push(txt);
           html.push('</span><button style="margin-left: 10px;" id="" type="add" txt="' + txt + '" value="'+ val +'" class="btn btn-danger btn-xs circle_point_delete">删除</button></div>');
           $('#spaces_list').append(html.join(''));
           that.circlePointDelete();
           return false;
        });

        $('.circle_type').unbind('click').click(function () {
            
            var attr = $(this).attr('id');
            if('circle_time1' === attr){
                $('#circle_time_call').show();
                $('#circle_times_call').hide();
            }else {
                $('#circle_time_call').hide();
                $('#circle_times_call').show();
            }
            
        });

    },

    circlePointDelete: function(){
        $('.circle_point_delete').unbind('click').click(function () {
            $(this).attr('type', 'del');
            $(this).parent().hide();
            return false;
        });
    },

    queryCircleSetting: function(currentPage) {
        currentPage = currentPage || 1;
        var that = this;
        $.sendGet('../../circle/queryByPage/' + currentPage + '/20', null, function(res, status){
            console.log(res + '===' + status);
            if(res['success'] === true){
                var transType = res['data']['list'];
                if(transType != null && transType){
                    $('#circle_setting_tbody').setTemplateElement('circle_setting_temp');
                    $('#circle_setting_tbody').processTemplate(transType);
                    getMyMindMapPage(currentPage, res['data']['pageCount'], 'circle_setting_page', that.queryCircleSetting, that);
                    $('.circle_setting_delete').unbind('click').click(function (){
                        if(confirm('是否确定删除')){
                            var attr = $(this).attr('value');
                            $.delete('../../circle/delete/' + attr, null, function () {
                                that.queryCircleSetting();
                            });
                        }

                    });
                    that.editCircleSetting();
                }
            }
        });
    },



    editCircleSetting: function() {
        var that = this;
        $('.circle_setting_edit').unbind('click').click(function () {
            var attr = $(this).attr('value');
            $.get('../../circle/query/' + attr, null, function (res, status) {
                if(res['success'] === true){
                    var data = res['data'];
                    $('#circle_setting_worker').val(data['workerId']);
                    $('#circle_time').val(data['finishTime']);
                    $('#circle_setting_project').val(data['proId']);
                    $('#circle_count').val(data['finishCount']);
                    $('#circle_setting_submit_id').val(data['id']);
                    $('#spaces_list').setTemplateElement('circle_points_template');
                    $('#spaces_list').processTemplate(data['circlePoints']);
                    $('#circle_setting_modal').modal('show');
                    that.circlePointDelete();
                }
            })
        });
    }


};