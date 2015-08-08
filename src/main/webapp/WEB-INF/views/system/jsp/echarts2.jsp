<%@ page contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<body>
    <div id="mainMap" style="height:280px;border:0px solid #ccc;padding:10px;"></div>
    
    <script type="text/javascript">
        var myChart2 = echarts.init(document.getElementById('mainMap'));
        myChart2.setOption({
            tooltip : {
                trigger: 'item',
                formatter: '{b}'
            },
            series : [
                {
                    name: '中国',
                    type: 'map',
                    mapType: 'china',
                    selectedMode : 'multiple',
                    itemStyle:{
                        normal:{label:{show:true}},
                        emphasis:{label:{show:true}}
                    },
                    data:[
                        {name:'广东',selected:true}
                    ]
                }
            ]
        });
    </script>
</body>
</html>