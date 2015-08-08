$(function () {
    if ($.cookie('easyuiThemeName')) {
        readTheme($.cookie('easyuiThemeName'));
    }
})

function readTheme(themeName) {/* 更换主题 */
    var $easyuiTheme = $('#easyuiTheme');
    var url = $easyuiTheme.attr('href');
    var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName
        + '/easyui.css';
    $easyuiTheme.attr('href', href);
};


function closeLog() {
    if ($.messager.confirm("确认", "您确认退出吗？")) {
        window.parent.location.href = "login!closeLogin.action";
    }
}


jQuery.cookie = function (name, value, options) {
    if (typeof value != 'undefined') {
        options = options || {};
        if (value === null) {
            value = '';
            options = $.extend({}, options);
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString();
        }
        var path = options.path ? '; path=' + (options.path) : '';
        var domain = options.domain ? '; domain=' + (options.domain) : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else {
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
}

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}
// 消息提示，从上面显示
function showMsg(title, msg) {
    $.messager.show({
        title: title,
        msg: "<span style='width:100%;text-align:center;'>" + msg + "</span>",
        icon: 'info',
        timeout: 2000,
        showType: 'slide',
        style: {
            right: '',
            top: document.body.scrollTop + document.documentElement.scrollTop,
            bottom: ''
        }
    });
}
// 提交form函数，fid: form 的id；gid：要刷新Gurid的id,不传不刷新；wid：要关闭的窗口id，不传不关闭
function submitForm(fid, gid, wid) {
    $('#' + fid).form('submit', {
        onSubmit: function () {
            return $(this).form('enableValidation').form('validate');
        },
        success: function (data) {
            var data = eval('(' + data + ')');
            if (data) {
                if (data.statuscode == "1") {
                    showMsg('提示', data.message);
                    if (gid && gid != '') {
                        $('#' + gid).datagrid({});
                    }
                    if (wid && wid != '') {
                        $('#' + wid).window('close');
                    } else {
                        history.go(-1);
                    }
                } else {
                    showMsg('提示', data.message);
                }
            } else {
                showMsg('提示', '提交失败！');
            }
        }
    });
}


//新增form数据
function showWin(wid, url) {
    $('#' + wid).window('refresh', url);
    $('#' + wid).window('open');
}
//关闭form
function clearForm(wid) {
    $('#' + wid).window('close');
}
//修改grid数据
function edit(gid, wid, url) {
    var row = $('#' + gid).datagrid('getSelected');
    if (row != null) {
        $('#' + wid).window('open');
        $('#' + wid).window('refresh', url + '?id=' + row.id);
    } else {
        $.messager.alert('警告', '请选择要处理的记录！');
    }
}
function select(gid, sfun) {
    var rows = $('#' + gid).datagrid('getSelections');
    sfun(rows);
}
function del(gid, url) {
    var row = $('#' + gid).datagrid('getSelected');
    if (row != null) {
        $.messager.confirm('确认', "确认删除吗？", function (r) {
            if (r) {
                $.ajax({
                    type: 'post',
                    url: url,
                    data: {
                        'id': row.id
                    },
                    success: function (data) {
                        var data = eval('(' + data + ')');
                        if (data) {
                            if (data.statuscode == "1") {
                                showMsg('提示', data.message);
                                if (gid && gid != '') {
                                    $('#' + gid).datagrid({});
                                }
                            } else {
                                showMsg('提示', data.message);
                            }
                        } else {
                            showMsg('提示', '删除失败！');
                        }
                    }
                })
            }
        })
    } else {
        $.messager.alert('警告', '请选择要删除的记录！');
    }
}

function batchDel(gid, url) {
    var rows = $('#' + gid).datagrid('getSelections');
    var ids = "";
    for (var i = 0; i < rows.length; i++) {
        ids += rows[i].id + ","
    }
    ;
    ids = ids.substr(0, ids.length - 1);
    if (ids != '') {
        $.messager.confirm('确认', "确认删除吗？", function (r) {
            if (r) {
                $.ajax({
                    type: 'post',
                    url: url,
                    data: {
                        'ids': ids
                    },
                    success: function (data) {
                        var data = eval('(' + data + ')');
                        if (data) {
                            if (data.statuscode == "1") {
                                showMsg('提示', data.message);
                                if (gid && gid != '') {
                                    $('#' + gid).datagrid({});
                                }
                            } else {
                                showMsg('提示', data.message);
                            }
                        } else {
                            showMsg('提示', '删除失败！');
                        }
                    }
                })
            }
        })
    } else {
        $.messager.alert('警告', '请选择要删除的记录！');
    }
}

function ExportExcel(fid, url) {
    $.messager.confirm('确认', "确认导出吗？", function (r) {
        if (r) {
            var obj = $('#' + fid);
            var oldurl = $('#' + fid).form('submit', {
                'url': url
            })
        }
    })
}