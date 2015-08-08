/**
 * Created by wangmz on 2015/6/25.
 */

var com = {};
com.huge = com.huge || {};
com.huge.attachment = com.huge.attachment || {};

$(function () {

    /**
     * 上传操作
     * <该方法暂时没用>
     */
    com.huge.attachment.upload = function(){
        $('#fileupload').fileupload('add');
    };

    /**
     * 上传插件初始化
     */
    com.huge.attachment.initUploader = function(){
        var url = window.ctx + '/api/v1/attachment/upload';
        $('#fileupload').fileupload({
            url: url,
            dataType: 'json',
            autoUpload: false,
            add: function (e, data) {
                data.submit();
            },
            done: function (e, data) {
                //TODO
            },
            progressall: function (e, data) {
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $('#progressbar-attachment').progressbar('setValue', progress);
            }

        });
    };

    /**
     * 新增操作
     */
    com.huge.attachment.add = function(){
        $('#dialog-attachment').dialog({
            title: '上传附件',
            closed: false,
            cache: false,
//            href: 'get_content.php',
            modal: true,
            buttons:[{
                text:'确定',
                iconCls: 'icon-ok',
                handler: function(){
                    //关闭弹出窗口
                    $('#dialog-attachment').dialog('close');
                    //刷新列表数据
                    $('#datagrid-attachment').datagrid('reload');
                }
            }],
            content:$('#ADD_NODE_TMP').html(),
            onOpen:function(){
                com.huge.attachment.initUploader();
                $('#progressbar-attachment').progressbar();
            }
        });
    };

    /**
     * 删除操作
     */
    com.huge.attachment.del = function(){
        var choosed = $('#datagrid-attachment').datagrid('getChecked');
        if(choosed.length==0){
            $.messager.alert('系统提示','请选择记录!', 'warning');
            return;
        }else if(choosed.length>0){
            $.messager.alert('系统提示','只能选着一条记录!', 'warning');
            return;
        }
        $.messager.confirm('系统提示', '你确定要删除选中附件吗？', function(r){
            if(r) {
                var id = choosed[0].id;
                var url = window.ctx + '/api/v1/attachment/delete/' + id;
                $.get(url, function (result) {
                    $.messager.alert('系统提示', '操作成功!', 'info');
                    //刷新列表数据
                    $('#datagrid-attachment').datagrid('reload');
                });
            }
        });
    };

    /**
     * 页面组件渲染
     */
    com.huge.attachment.render = function(){
        //初始化列表组件
        $('#datagrid-attachment').datagrid({
            url: window.ctx + '/api/v1/attachment/query',
            method:'get',
            columns:[[
                {field:'id',checkbox:true},
                {field:'name',title:'附件名',formatter: function(value,row,index){
                    return row.name +'.'+ row.suffix;
                }},
                {field:'dir',title:'存储目录'},
                {field:'size',title:'附件大小',formatter: function(value,row,index){
                    return row.size + row.unit;
                }},
                {field:'type',title:'附件类型',formatter: function(value,row,index){
                    if(row.type){
                        return row.type.desc;
                    }else{
                        return '';
                    }
                }},
                {field:'associateType',title:'关联类型',formatter: function(value,row,index){
                    if(row.associateType){
                        return row.associateType.desc;
                    }else{
                        return '';
                    }
                }},
                {field:'md5',title:'MD5码'},
                {field:'creator',title:'上传人',formatter: function(value,row,index){
                    if(row.creator && row.creator.user){
                        return row.creator.user.name;
                    }else{
                        return '';
                    }
                }},
                {field:'createTime',title:'上传时间',formatter: function(value,row,index){
                    if(row.createTime){
                        return moment(row.createTime).format("YYYY-MM-DD HH:mm");
                    }else{
                        return '';
                    }
                }},
                {field:'operate',title:'操作',formatter: function(value,row,index){
                    var btn = '<a href="'+ window.ctx +'/api/v1/attachment/download/'+ row.id +'" class="easyui-linkbutton" data-options="iconCls:'+'"icon-search"'+'" style="width:80px">下载</a>';
                    return btn;
                }}
            ]],
            toolbar:'#toolbar-attachment',
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
    com.huge.attachment.event = function(){
        $('body').on('click', '#attachment-upload', com.huge.attachment.upload);
        $('body').on('click', '#add-btn', com.huge.attachment.add);
        $('body').on('click', '#del-btn', com.huge.attachment.del);
    };

    /**
     * 页面脚本初始化入口
     */
    com.huge.attachment.main = function(){
        //页面组件渲染
        com.huge.attachment.render();
        //页面事件绑定
        com.huge.attachment.event();
    };

    //运行
    com.huge.attachment.main();
});