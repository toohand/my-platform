/**
 * Created by wangmz on 2015/6/25.
 */

var com = {};
com.huge = com.huge || {};
com.huge.log = com.huge.log || {};

$(function () {

    /**
     * 删除日志库
     */
    com.huge.log.del = function(){
        $.messager.confirm('系统提示', '你确定要删除当前日志库吗？', function(r){
            if(r) {
                var $tree = $('#tree-log');
                var collection = $tree.tree('getSelected').text;
                var url = window.ctx + '/api/v1/log/deleteLogHouse?collection=' + collection;
                $.get(url, function () {
                    $.messager.alert('系统提示', '操作成功!', 'info');
                    //刷新树
                    $tree.tree('reload');
                });
            }
        });
    };

    /**
     * 初始化树形组件
     */
    com.huge.log.tree = function(){
        //初始化树形组件
        $('#tree-log').tree({
            url: window.ctx + '/api/v1/log/getCollectionNames',
            method:'get',
            animate:true,
            lines:true,
            loadFilter: function(data){
                var result = [];
                var node = {
                    id:'ROOT',
                    text:'日志库',
                    state:'open',
                    children:[]
                };
                if(data){
                    _.each(data, function(item){
                        //过滤多余的系统集合
                        if(item.indexOf('chunks')>0 || item.indexOf('files')>0 || item.indexOf('indexes')>0){
                            return true;
                        }
                        var node_ = {
                            id  :item,
                            text: item
                        };
                        node.children.push(node_);
                    });
                }
                result.push(node);
                console.dir(result);
                return result;
            },
            onClick:function(node){
                //初始化列表组件
                var queryParams = {collection: node.text};
                com.huge.log.datagrid(queryParams);
            },
            onLoadSuccess:function(node, data){
                console.dir(node);
                console.dir(data);
                var $tree = $('#tree-log');
                var root = $tree.tree('getRoot');
                var children = $tree.tree('getChildren', root.target);
                if(children.length>0){
                    $(children[0].target).trigger('click');
                }
            }
        });
    };

    /**
     * 初始化列表组件
     * @param queryParams
     */
    com.huge.log.datagrid = function(queryParams){
        //初始化列表组件
        $('#datagrid-log').datagrid({
            url: window.ctx + '/api/v1/log/query',
            method:'get',
            queryParams:queryParams,
            columns:[[
                {field:'logger',title:'类名'},
                {field:'level',title:'级别'},
                {field:'host',title:'域名'},
                {field:'ip',title:'IP'},
                {field:'message',title:'日志信息'},
                {field:'detail',title:'详细'},
                {field:'createTime',title:'时间',formatter: function(value,row,index){
                    if(row.createTime){
                        return moment(row.createTime).format("YYYY-MM-DD HH:mm");
                    }else{
                        return '';
                    }
                }}
            ]],
            toolbar:'#toolbar-log',
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
     * 页面组件渲染
     */
    com.huge.log.render = function(){
        //初始化树形组件
        com.huge.log.tree();

    };

    /**
     * 页面事件绑定
     */
    com.huge.log.event = function(){
        $('body').on('click', '#del-btn', com.huge.log.del);
    };

    /**
     * 页面脚本初始化入口
     */
    com.huge.log.main = function(){
        //页面组件渲染
        com.huge.log.render();
        //页面事件绑定
        com.huge.log.event();
    };

    //运行
    com.huge.log.main();
});