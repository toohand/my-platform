<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="${ctx}/js/lib/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/artDialog/jquery.artDialog.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/respond.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/underscore-1.5.1.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/backbone-1.0.0.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/console.compatibility.plugins.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/moment.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/json2.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/Math.uuid.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jqPaginator.min.js"></script>
<script type="text/javascript" src="${ctx}/Frame/js/frame.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/plugins/jquery.filebox.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/plugins/jquery.datagrid.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/plugins/jquery.messager.js"></script>

<script type="text/javascript">
    //系统全局上下文
    window.ctx = '${ctx}';
    //backbone模版文件解析, 防止和jsp的关键符号冲突
    _.templateSettings = {
        interpolate : /\<\@\=(.+?)\@\>/gim,
        evaluate : /\<\@([\s\S]+?)\@\>/gim,
        escape : /\<\@\-(.+?)\@\>/gim
    };
    //清空ajax缓存
    $.ajaxSetup({
        cache : false
    });
</script>