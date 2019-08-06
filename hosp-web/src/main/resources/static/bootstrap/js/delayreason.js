var DelayReasonHandler = function () {
    
};

DelayReasonHandler.prototype = {


    start: function () {
        this.bindEvent();
        this.queryDelayReason();
       // new TableInit().Init();
        publicQueryProject('delay_reason_project',  $('#current_worker_id').val());
    },


    pageQuery: function(){



    },


    bindEvent: function(){
        var  that = this;
        $('#delay_reason_submit').unbind('click').click(function () {
            var  val = $('#delay_reason_id').val();
            var postData = {
                'delayCode': $('#delay_reason_code').val(),
                'delayName': $('#delay_reason_remark').val(),
                'proId': $('#delay_reason_project').val(),
                'proName': $('#delay_reason_project').opTxt(),
                'id': val
            };

            if(val !== ''){
                $.put('../../delay/update', postData, function (data, status) {
                    if(status && data['success']){
                        alert('修改成功');
                        $('#delay_reason_form')[0].reset();
                        $('#delay_reason_modal').modal('hide');
                        that.queryDelayReason();
                    }else{
                        alert('修改失败');
                    }
                })
            }else{
                $.sendPost(
                    '../../delay/add',
                    postData,
                    function (data, status) {
                        if(status && data['success']){
                            alert('保存成功');
                            $('#delay_reason_form')[0].reset();
                            $('#delay_reason_modal').modal('hide');
                            that.queryDelayReason();
                        }else{
                            alert('保存失败');
                        }});
            }

        });


        $('#delay_reason_modal').on('shown.bs.modal', function () {
            // publicQuerySpaces([[${userInfo.proId}]], 'type_destination');
        }).on('hide.bs.modal', function () {
            $('#delay_reason_form')[0].reset();
        })
    },

    queryDelayReason: function(currentPage) {
        currentPage = currentPage || 1;
        var that = this;
        $.sendGet('../../delay/query/' + currentPage + '/20', null, function(res, status){
            console.log(res + '===' + status);
            if(res['success'] === true){
                var transType = res['data']['list'];
                if(transType != null && transType){
                    var html = [];
                    $.each(transType, function (index, type) {
                        html.push('<tr><td>' + type['delayCode'] + '</td>');
                        html.push('<td>' + type['delayName'] + '</td>');
                        html.push('<td>' + type['proName'] + '</td>');
                        html.push('<td><button type="button" value="' + type['id'] +'" class="btn btn-primary btn-xs delay_reason_edit">编辑</button>' +
                            '<button type="button" value="'+ type['id'] +'" style="margin-left: 10px;" class="btn btn-danger btn-xs delay_reason_del">删除</button></td></tr>');
                    });
                    $('#delay_reason_tbody').html(html.join(''));
                    getMyMindMapPage(currentPage, res['data']['pageCount'], 'delay_reason_page', that.queryDelayReason, that);
                    $('.delay_reason_del').unbind('click').click(function (){
                        if(confirm('是否确定删除')){
                            var attr = $(this).attr('value');
                            $.delete('../../delay/delete/' + attr, null, function () {
                                that.queryDelayReason();
                            });
                        }

                    });

                    that.editDelayReason();
                }
            }
        });
    },



    editDelayReason: function() {
        $('.delay_reason_edit').unbind('click').click(function () {
            var attr = $(this).attr('value');
            $.get('../../delay/query/' + attr, null, function (res, status) {
                if(res['success'] === true){
                    var data = res['data'];
                    $('#delay_reason_id').val(data['id']);
                    $('#delay_reason_remark').val(data['delayName']);
                    $('#delay_reason_code').val(data['delayCode']);
                    $('#delay_reason_project').val(data['proId']);
                    $('#delay_reason_modal').modal('show');
                }
            })
        });
    }


};



var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#delay_reason_table').bootstrapTable({
            url: '../../delay/query/1/1',         //请求后台的URL（*）
            method: 'GET',                      //请求方式（*）
           // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 1,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            contentType: "application/x-www-form-urlencoded",
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            //height: 700,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "no",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            dataField: 'list',
            columns: [
                {
                    field: 'delayCode',
                    title: '编号'
                }, {
                    field: 'delayName',
                    title: '名称'
                }, {
                    field: 'proName',
                    title: '所属项目'
                },
                {
                    field: 'id',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                },
            ],
            rowStyle: function (row, index) {
                var classesArr = ['success', 'info'];
                var strclass = "";
                if (index % 2 === 0) {//偶数行
                    strclass = classesArr[0];
                } else {//奇数行
                    strclass = classesArr[1];
                }
                return { classes: strclass };
            },//隔行变色

            onLoadSuccess: function (data) {
                $('.delay_reason_del').unbind('click').click(function (){
                    if(confirm('是否确定删除')){
                        var attr = $(this).attr('value');
                        $.delete('../../delay/delete/' + attr, null, function () {
                            oTableInit.Init();
                        });
                    }

                });
                return false;
            }
        });

    };


    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset:params.offset
        };
        return temp;
    };
    return oTableInit;
};


function operateFormatter(value, row, index) {//赋予的参数
    return [
        '<button type="button" value="' + value +'" class="btn btn-primary btn-xs delay_reason_edit">编辑</button>',
        '<button type="button" value="'+ value +'" style="margin-left: 10px;" class="btn btn-danger btn-xs delay_reason_del">删除</button>'
    ].join('');
}