/**
 * Created by wangmz on 2015/6/25.
 */

var com = {};
com.huge = com.huge || {};
com.huge.message = com.huge.message || {};

$(function () {

    /**
     * 收集表单数据
     */
    com.huge.message.collect = function(){
        var $form = $('#form-message');
        var message = {};
        message.title = $form.find('input[name="title"]').val();
        message.content = $form.find('input[name="content"]').val();
        var messageType = {};
        messageType.id = $form.find('input[name="messageType"]').val();
        message.messageType = messageType;
        return message;
    };

    /**
     * 保存确认
     */
    com.huge.message.confirm = function(){
        var isValid = $('#form-message').form('validate');
        if(isValid){
            var url = window.ctx + '/api/v1/message/save';
            var data = com.huge.message.collect();
            $.messager.progress({title:'系统提示',text:'正在处理...'});
            $.ajax({
                type:'POST',
                url:url,
                contentType:'application/json',
                data:JSON.stringify(data),
                success:function(result) {
                    if (result) {
                        $.messager.progress('close');
                        $.messager.alert('系统提示', '操作成功!', 'info');
                        //关闭弹出窗口
                        $('#dialog-message').dialog('close');
                        //刷新列表数据
                        $('#datagrid-message').datagrid('reload');
                    }
                }
            });
        }
    };

    /**
     * 新增操作
     */
    com.huge.message.add = function(){
        $('#dialog-message').dialog({
            title: '发送消息',
            closed: false,
            cache: false,
//            href: 'get_content.php',
            modal: true,
            buttons:[{
                text:'确定',
                iconCls: 'icon-ok',
                handler: com.huge.message.confirm
            },{
                text:'取消',
                iconCls: 'icon-cancel',
                handler: function(){
                    //关闭弹出窗口
                    $('#dialog-message').dialog('close');
                }
            }],
            content:$('#ADD_NODE_TMP').html(),
            onOpen:function(){

            }
        });
    };

    /**
     * 删除操作
     */
    com.huge.message.del = function(){
        var choosed = $('#datagrid-message').datagrid('getChecked');
        if(choosed.length==0){
            $.messager.alert('系统提示','请选择记录!', 'warning');
            return;
        }else if(choosed.length>1){
            $.messager.alert('系统提示','只能选着一条记录!', 'warning');
            return;
        }
        $.messager.confirm('系统提示', '你确定要删除选中记录吗？', function(r){
            if(r) {
                var id = choosed[0].id;
                var url = window.ctx + '/api/v1/message/delete/' + id;
                $.get(url, function (result) {
                    $.messager.alert('系统提示', '操作成功!', 'info');
                    //刷新列表数据
                    $('#datagrid-message').datagrid('reload');
                });
            }
        });
    };

    /**
     * 页面组件渲染
     */
    com.huge.message.render = function(){
        //初始化列表组件
        $('#datagrid-message').datagrid({
            url: window.ctx + '/api/v1/message/query',
            method:'get',
            columns:[[
                {field:'id',checkbox:true},
                {field:'title',title:'消息标题'},
                {field:'messageType',title:'消息类型',formatter: function(value,row,index){
                    if(row.messageType){
                        return row.messageType.desc;
                    }else{
                        return '';
                    }
                }},
                {field:'content',title:'消息内容'},
                {field:'isRead',title:'读取状态',formatter: function(value,row,index){
                    if(row.read){
                        return '未读';
                    }else{
                        return '已读';
                    }
                }},
                {field:'messageState',title:'发送状态',formatter: function(value,row,index){
                    if(row.messageState){
                        return row.messageState.desc;
                    }else{
                        return '';
                    }
                }},
                {field:'createTime',title:'发送时间',formatter: function(value,row,index){
                    if(row.createTime){
                        return moment(row.createTime).format("YYYY-MM-DD HH:mm");
                    }else{
                        return '';
                    }
                }},
                {field:'updateTime',title:'更新时间',formatter: function(value,row,index){
                    if(row.updateTime){
                        return moment(row.updateTime).format("YYYY-MM-DD HH:mm");
                    }else{
                        return '';
                    }
                }}
            ]],
            toolbar:'#toolbar-message',
            fitColumns:true,
            striped:true,
            nowrap:true,
            loadMsg:'正在加载数据...',
            pagination:true,
            pagePosition:'bottom',
            pageNumber:1,
            pageSize:10,
            rownumbers:true,
            loadFilter:function(data){
                var result = {total:0,rows:[]};
                if(data){
                    result.total = data.totalElements;
                    result.rows = data.content;
                }
                return result;
            }
        });
    };



    /**
     * 页面事件绑定
     */
    com.huge.message.event = function(){
        $('body').on('click', '#add-btn', com.huge.message.add);
        $('body').on('click', '#del-btn', com.huge.message.del);
    };

    /**
     * 页面脚本初始化入口
     */
    com.huge.message.main = function(){
        //页面组件渲染
        com.huge.message.render();
        //页面事件绑定
        com.huge.message.event();
    };

    //运行
    com.huge.message.main();
});