


function settingFactory(type) {

    if('#cancel_reason_div' === type){
        return new CancelReasonHandler();
    }else if('#delay_reason_div' === type){
        return new DelayReasonHandler();
    }else if('#trans_code_div' === type){
        return new TransCodeHandler();
    }else if('#circle_setting_div' === type){
        return new CircleSettingHandler();
    }
    return null;

}



var CancelReasonHandler = function () {

};

CancelReasonHandler.prototype = {

    start: function () {
         this.bindEvent();
         this.queryCancelReason();
         publicQueryProject('cancel_reason_project',  $('#current_worker_id').val());
    },

    bindEvent: function(){
        var  that = this;
        $('#cancel_reason_submit').unbind('click').click(function () {
            var  val = $('#cancel_reason_id').val();
            var postData = {
                'cancelCode': $('#cancel_reason_code').val(),
                'cancelName': $('#cancel_reason_remark').val(),
                'proId': $('#cancel_reason_project').val(),
                'proName': $('#cancel_reason_project').opTxt(),
                'id': val
            };

            if(val !== ''){
                $.put('../../cancel/update', postData, function (data, status) {
                    if(status && data['success']){
                        alert('修改成功');
                        $('#cancel_reason_form')[0].reset();
                        $('#cancel_reason_modal').modal('hide');
                        that.queryCancelReason();
                    }else{
                        alert('修改失败');
                    }
                })
            }else{
                $.sendPost(
                    '../../cancel/add',
                    postData,
                    function (data, status) {
                        if(status && data['success']){
                            alert('保存成功');
                            $('#cancel_reason_form')[0].reset();
                            $('#cancel_reason_modal').modal('hide');
                            that.queryCancelReason();
                        }else{
                            alert('保存失败');
                        }});
            }

        });


        $('#cancel_reason_modal').on('shown.bs.modal', function () {
            // publicQuerySpaces([[${userInfo.proId}]], 'type_destination');
        }).on('hide.bs.modal', function () {
            $('#cancel_reason_form')[0].reset();
        })
    },

    queryCancelReason: function(currentPage) {
        currentPage = currentPage || 1;
        var that = this;
        $.sendGet('../../cancel/query/' + currentPage + '/20', null, function(res, status){
            console.log(res + '===' + status);
            if(res['success'] === true){
                var transType = res['data']['list'];
                if(transType != null && transType){
                    var html = [];
                    $.each(transType, function (index, type) {
                        html.push('<tr><td>' + type['cancelCode'] + '</td>');
                        html.push('<td>' + type['cancelName'] + '</td>');
                        html.push('<td>' + type['proName'] + '</td>');
                        html.push('<td><button type="button" value="' + type['id'] +'" class="btn btn-primary btn-xs cancel_reason_edit">编辑</button>' +
                            '<button type="button" value="'+ type['id'] +'" style="margin-left: 10px;" class="btn btn-danger btn-xs cancel_reason_del">删除</button></td></tr>');
                    });
                    $('#cancel_reason_tbody').html(html.join(''));
                    var total = res['data']['total'];
                    getMyMindMapPage(currentPage, res['data']['pageCount'], 'cancel_reason_page', that.queryCancelReason, that);

                    $('.cancel_reason_del').unbind('click').click(function (){
                        if(confirm('是否确定删除')){
                            var attr = $(this).attr('value');
                            $.delete('../../cancel/delete/' + attr, null, function () {
                                that.queryCancelReason();
                            });
                        }

                    });

                    that.editCancelReason();
                }
            }
        });
    },

    editCancelReason: function() {
    $('.cancel_reason_edit').unbind('click').click(function () {
        var attr = $(this).attr('value');
        $.get('../../cancel/query/' + attr, null, function (res, status) {
            if(res['success'] === true){
                var data = res['data'];
                $('#cancel_reason_id').val(data['id']);
                $('#cancel_reason_remark').val(data['cancelName']);
                $('#cancel_reason_code').val(data['cancelCode']);
                $('#cancel_reason_project').val(data['proId']);
                $('#cancel_reason_modal').modal('show');
            }
        })
    });
}


};







