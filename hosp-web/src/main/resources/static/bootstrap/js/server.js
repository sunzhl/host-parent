
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
})(jQuery);



