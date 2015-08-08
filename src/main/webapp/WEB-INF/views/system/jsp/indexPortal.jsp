<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/script.jsp"%>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.portal.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts/echarts-all.js"></script>
    <style type="text/css">
       .demo-rtl .portal-column-left{
            padding-left: 10px;
            padding-right: 10px;
        }
        .demo-rtl .portal-column-right{
            padding-left:10px;
            padding-right: 0;
        }
    </style>
</head>
<body>
   <div id="fp" class="easyui-panel" title="首页"     
        style="width:100%;height:100%;padding:0px;"
        data-options="iconCls:'icon-first', border:false,tools:'#tt'"> 
       <div id="pp" style="padding:2px;position:relative">
       </div>
    </div>
    
    <div id="tt">
        <a href="javascript:void(0)" class="icon-portal" onclick="javascript:setFun(event)"></a>
    </div>
    
    <div id="mm" class="easyui-menu" style="width:100px;" data-options="onClick:menuHandler">   
        <div data-options="name:1">单列</div>   
        <div data-options="name:4">双列</div>   
        <div data-options="name:3">主辅</div>
        <div data-options="name:2">辅主</div> 
        <div data-options="name:5">三列</div>
    </div>  
    <script type="text/javascript">
    
    var panels =${potals};
        function setFun(event){
        	$('#mm').menu('show',{left:event.pageX-20,top:event.pageY+10});
        }
        function menuHandler(item){
        	$.cookie('portal-cols',item.name, {
                expires : 30
            });
            $.cookie('portal-state',"", {
                expires : 30
            });
            window.location="${ctx}/sysPortal/indexPortal.do";
        }
        function getPanelOptions(id){
            for(var i=0; i<panels.length; i++){
                if (panels[i].id == id){
                    return panels[i];
                }
            }
            return undefined;
        }
        function getPortalState(){
            var aa = [];
            for(var columnIndex=0; columnIndex<3; columnIndex++){
            	var cc = [];
               var panels = $('#pp').portal('getPanels', columnIndex);
                for(var i=0; i<panels.length; i++){
                    cc.push(panels[i].attr('id'));
                }
                aa.push(cc.join(','));
            }
            return aa.join(':');
        }
        function addPanels(portalState){
            var columns = portalState.split(':');
            for(var columnIndex=0; columnIndex<columns.length; columnIndex++){
                var cc = columns[columnIndex].split(',');
                for(var j=0; j<cc.length; j++){
                    var options = getPanelOptions(cc[j]);
                    if (options){
                        var p = $('<div/>').attr('id',options.id).appendTo('body');
                        p.panel(options);
                        $('#pp').portal('add',{
                            panel:p,
                            columnIndex:columnIndex
                        });
                   }
                }
            }
            
        }
        function initPortalDiv(clos){
        	var subDiv="";
        	if (clos == 1){
        		subDiv += "<div style=\"width:100%;padding:2px;\"></div>"
        	};
        	if (clos == 2){
                subDiv += "<div style=\"width:30%;padding:2px;\"></div>"
                subDiv += "<div style=\"width:70%;padding:2px;\"></div>"
            };
        	if (clos == 3){
                subDiv += "<div style=\"width:70%;padding:2px;\"></div>"
                subDiv += "<div style=\"width:30%;padding:2px;\"></div>"
            };
        	if (clos == 4){
                subDiv += "<div style=\"width:50%;padding:2px;\"></div>"
                subDiv += "<div style=\"width:50%;padding:2px;\"></div>"
            };
        	if (clos == 5){
                subDiv += "<div style=\"width:33%;padding:2px;\"></div>"
                subDiv += "<div style=\"width:33%;padding:2px;\"></div>"
                subDiv += "<div style=\"width:33%;padding:2px;\"></div>"
            };
        	$(subDiv).appendTo($('#pp'));
        }
        function getDefaultState(panels,cols){
        	var c = 2;
        	if (cols == 1)
        		c= 1;
        	if (cols == 5)
        		c =3;
        	var aa = [];
        	var row = panels.length/c;
            for(var columnIndex=0; columnIndex<c; columnIndex++){
                var cc = [];
                for(var i=0; i<row; i++){
                	if (panels[i*c+columnIndex])
                        cc.push(panels[i*c+columnIndex].id);
                }
                aa.push(cc.join(','));
            }
            return aa.join(':');
        }
        function initPortal(){
        	 var cols =  $.cookie('portal-cols');
             if (cols== null || cols == "" ){
                 cols = 4;
             };
              initPortalDiv(cols);
              $('#pp').portal({
                 onStateChange:function(){
                     var state = getPortalState();
                     $.cookie('portal-state', state, {
                         expires : 30
                     })
                 },
               border:false,
               fit:true
             });
             var state= $.cookie('portal-state');
             if (!state || state ==""){
                 state = getDefaultState(panels,cols);   
             };
             addPanels(state);
            // $('#pp').portal('resize');  
        }
        $(function(){
            initPortal();
        });
    </script>
</body>


