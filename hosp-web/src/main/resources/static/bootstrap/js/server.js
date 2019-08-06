
;(function (jq) {

    jq.extend({

        /**
         * 发生 GET 请求
         * @param url 请求路径
         * @param data 请求数据
         * @param callback 响应方法
         */
        sendGet: function (url, data, callback) {
              request(url, data, callback, 'GET');
        },

        /**
         * 发送 POST 请求
         * @param url
         * @param data
         * @param callback
         */
        sendPost: function (url, data, callback) {
            request(url, JSON.stringify(data || {}), callback, 'POST');
        },

        delete: function (url, data, callback) {
            request(url, JSON.stringify(data), callback, 'DELETE');
        },
        
        put: function (url, data, callback) {
            request(url, JSON.stringify(data), callback, 'PUT');
        }

    });


    function request(url, data, callback, method) {
        jq.ajax({
            type: method,
            dataType: 'json',
            contentType: "application/json;charset=utf-8",
            url: url,
            data: data,
            success: function (data) {
                if(callback != null && jq.isFunction(callback)){
                   callback(data, true);
                }
            },
            error: function (data) {
                callback(data, false);
            }
        });

    }


    jq.fn.extend({
        opTxt: function (){
           return this.find('option:selected').text();
        }
    });


})(jQuery);


/**
 * 根据项目编号查询空间信息
 * @param proId 项目编号
 * @param selectIds 需要展示的ID
 */
function publicQuerySpaces(proId, selectIds){
    $.sendGet('../../space/query', {proId: proId}, function (res, status) {
        if(status && res['success']){
            var transType = res['data'];
            if(transType != null && transType){
                var html = ['<option value=""></option>'];
                $.each(transType, function (index, type) {
                    var val = type['id']; // + '-' + type['spaceName'];
                    html.push('<option value="' + val + '">' + type['spaceName'] + '</option>');
                });
                var ids = selectIds;
                if(selectIds != null && !$.isArray(selectIds)){
                   ids = [selectIds];
                }
                $.each(ids, function (index, id) {
                    $('#' + id).html(html.join(''));
                });
            }
        }
    });
}

function publicQueryProject(selectIds, userId) {

    $.sendGet('../../project/up/' + userId, null, function (res, status) {
        if(status && res['success']){
            var transType = res['data'];
            if(transType != null && transType){
                var html = ['<option value=""></option>'];
                $.each(transType, function (index, type) {
                    var val = type['proId']; // + '-' + type['spaceName'];
                    html.push('<option value="' + val + '">' + type['proName'] + '</option>');
                });
                var ids = selectIds;
                if(selectIds != null && !$.isArray(selectIds)){
                    ids = [selectIds];
                }
                $.each(ids, function (index, id) {
                    $('#' + id).html(html.join(''));
                });
            }
        }
    });

}



function getMyMindMapPage(currentPage, data, showElementId, callback, caller){

    var html="";
    var lastPage;
    var nextPage;
    var showPage=4;      //每次显示的页数
    var index;
    var x;               //定义后面页数固定

    html+="<ul class='pagination'>";
    html+="<li value='1'><span>首页</span></li>";

    lastPage=currentPage;
    if(lastPage<=1){
        lastPage==1;
    }else{
        lastPage--;
    }

    html+="<li value= '"+lastPage+"'><span>上一页</span></li>";

    if(currentPage == 1 || data<=showPage){
        for(var i=1;i<=data;i++){
            html+="<li value='" +i+"' class='"+ (currentPage == i?"active": "") +"'><span>"+i+"</span></li>";
        }
    }else{
        index=currentPage+showPage;
        x=currentPage;
        if(index>data){
            index=data+1;
            x=index-showPage;
        }

        for(var i=x;i<index;i++){
            html+="<li value='"  +i+"' class='"+ (currentPage == i?"active": "") +"'><span>"+i+"</span></li>";
        }
    }
    nextPage=currentPage;
    if(nextPage<data){
        nextPage++;
    }else if(nextPage==data){
        nextPage=data;
    }
    html+="<li value='" +nextPage+"'><span>下一页</span></li>";
    html+="<li value='"+data+"'><span>尾页</span></li>";
    html+="</ul>";
    $("#" + showElementId).html(html);

    $('.pagination li').unbind('click').click(function () {
        var attr = $(this).attr('value');
        console.log("函数调用对象" + callback.caller + '--' + callback.callee + '---' + callback.call);
        callback.apply(caller == null?window: caller, [attr]);

    });

}

