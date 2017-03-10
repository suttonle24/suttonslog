/**
 * Created by leens on 9/1/2016.
 */
define(['jquery'], function($) {

    var dataHandling = {};

    dataHandling.flags = {};

    dataHandling.getData = function(type, url, flag, callback){
        var response = {};
        $.ajax({
            type: type,
            url: url,
            dataType: 'json',
            beforeSend: function() {
                dataHandling.flags[flag] = new $.Deferred();
            },
            success: function (data) {
                response.data = data;
                response.success = true;
            },
            error: function (xhr, status) {
                response.xhr = xhr;
                response.status = status;
                response.success = false;
            },
            complete: function() {
                dataHandling.flags[flag].resolve();
            }
        });

        dataHandling.flags[flag].done(function(){
            callback(response);
        });
    };

    String.prototype.replaceAll = function(search, replacement) {
        var target = this;
        return target.replace(new RegExp(search, 'g'), replacement);
    };

    dataHandling.sendData = function(type, url, data, flag, callback){
        var response = {};

        data.forEach(function(item, index){
            item.name = item.name.replaceAll('-', '');
        });

        $.ajax({
            type: type,
            url: url,
            dataType: 'json',
            data: data,
            beforeSend: function() {
                dataHandling.flags[flag] = new $.Deferred();
            },
            success: function (data) {
                response.data = data;
                response.success = true;
            },
            error: function (xhr, status) {
                response.xhr = xhr;
                response.status = status;
                response.success = false;
            },
            complete: function() {
                dataHandling.flags[flag].resolve();
            }
        });

        dataHandling.flags[flag].done(function(){
            callback(response);
        });
    };

    return dataHandling;
});