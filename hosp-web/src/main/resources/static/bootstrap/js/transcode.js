var TransCodeHandler = function () {

};

TransCodeHandler.prototype = {

    start: function () {
        this.bindEvent();
        this.queryTransCode();
        // new TableInit().Init();
        publicQueryProject('trans_code_project',  $('#current_worker_id').val());
    },


    pageQuery: function(){



    },


    bindEvent: function(){
        var  that = this;
        $('#trans_code_submit').unbind('click').click(function () {
            var  val = $('#trans_code_id').val();
            var postData = {
                'codeName': $('#trans_code_remark').val(),
                'timeCode': $('#trans_code_code').val(),
                'proId': $('#trans_code_project').val(),
                'proName': $('#trans_code_project').opTxt(),
                'effectiveTime': $('#effectiveTime').val(),
                'reserveTime': $('#reserveTime').val(),
                'standardTime': $('#standardTime').val(),
                'warnTime': $('#warnTime').val(),
                'criticalTime': $('#criticalTime').val(),
                'id': val
            };

            if(val !== ''){
                $.put('../../tcode/update', postData, function (data, status) {
                    if(status && data['success']){
                        alert('保存成功');
                        $('#trans_code_form')[0].reset();
                        $('#trans_code_modal').modal('hide');
                        that.queryTransCode();
                    }else{
                        alert('保存失败');
                    }
                })
            }else{
                $.sendPost('../../tcode/add', postData, function (data, status) {
                    if(status && data['success']){
                        alert('保存成功');
                        $('#trans_code_form')[0].reset();
                        $('#trans_code_modal').modal('hide');
                        that.queryTransCode();
                    }else{
                        alert('保存失败');
                    }
                });
            }

        });


        $('#trans_code_modal').on('shown.bs.modal', function () {
            // publicQuerySpaces([[${userInfo.proId}]], 'type_destination');
        }).on('hide.bs.modal', function () {
            $('#trans_code_form')[0].reset();
            $('#trans_code_id').val('');
        })
    },

    queryTransCode: function(currentPage) {
        currentPage = currentPage || 1;
        var that = this;
        $.sendGet('../../tcode/query/' + currentPage + '/20', null, function(res, status){
            console.log(res + '===' + status);
            if(res['success'] === true){
                var transType = res['data']['list'];
                if(transType != null && transType){
                    $('#trans_code__tbody').setTemplateElement('trans_time_code_temp');
                    $('#trans_code__tbody').processTemplate(transType);
                    getMyMindMapPage(currentPage, res['data']['pageCount'], 'trans_code__page', that.queryTransCode, that);
                    $('.trans_code_delete').unbind('click').click(function (){
                        if(confirm('是否确定删除')){
                            var attr = $(this).attr('value');
                            $.delete('../../tcode/delete/' + attr, null, function () {
                                that.queryTransCode();
                            });
                        }

                    });
                    that.editTransCode();
                }
            }
        });
    },



    editTransCode: function() {
        $('.trans_code_edit').unbind('click').click(function () {
            var attr = $(this).attr('value');
            $.get('../../tcode/query/' + attr, null, function (res, status) {
                if(res['success'] === true){
                    var data = res['data'];
                        $('#trans_code_remark').val(data['codeName']);
                        $('#trans_code_code').val(data['timeCode']);
                        $('#trans_code_project').val(data['proId']);
                        $('#effectiveTime').val(data['effectiveTime']);
                        $('#reserveTime').val(data['reserveTime']);
                        $('#standardTime').val(data['standardTime']);
                        $('#warnTime').val(data['warnTime']);
                        $('#criticalTime').val(data[ 'criticalTime']);
                        $('#trans_code_modal').modal('show');
                        $('#trans_code_id').val(data['id']);
                }
            })
        });
    }


};