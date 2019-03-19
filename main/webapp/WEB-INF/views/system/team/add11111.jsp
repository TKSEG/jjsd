<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/user/tag.jsp" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="wth=device-width, initial-scale=1, maximum-scale=1">
    <title>角色添加</title>
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/theme/default.css" id="theme">
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/kitadmin.css" id="kitadmin">
    <link rel="stylesheet" href="${basePath}/css/doc.css">
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/layui.css" id="layui">

</head>
<body>

<div class="kit-doc">
    <form class="layui-form layui-form-pane" action=""  >


        <div class="layui-form-item">
            <label class="layui-form-label">班组名称</label>
            <div class="layui-input-block">
                <input name="tname" id="tname" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>




        <div class="layui-form-item">

            <div class="layui-inline">
                <label class="layui-form-label">组长</label>
                <div class="layui-input-inline" style="margin-right:10px;width:400px;margin-top:5px;">
                    <input placeholder="任务名称" class="layui-input search_input" type="text" id="taskName"
                           name="taskName"/>
                </div>
            </div>


            <div class="layui-inline">
                <div class="layui-input-inline" style="width:70px;margin-top:5px;">
                    <button class="layui-btn" id="btn"><i class="layui-icon">&#xe615;</i>选择</button>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline" style="width:70px;margin-top:5px;">
                    <button class="layui-btn"><i class="layui-icon">&#xe669;</i>重置</button>
                </div>
            </div>
        </div>




        <div class="layui-form-item">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block">
                <input name="remarks" id="remarks" disabled="" autocomplete="off" class=" layui-input layui-bg-gray "
                       type="text">
            </div>
        </div>



        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
        </div>

    </form>

    <!--这里写页面的代码-->
</div>

<script src="${basePath}/js/jquery.js"></script>
<script src="${basePath}/plugins/kitadmin/layui.js"></script>

<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#planTime' //指定元素
        });
    });

</script>

<script>


    layui.use(['form','layedit', 'table', 'laydate'], function () {
        var form = layui.form, layer = layui.layer;
        var table = layui.table;



        $(document).on('click', '#btn', function () {
            var index = top.layer.open({
                type: 2,
                content: '${basePath}/team/taskSelect',
                area: ['1100px', '600px'],
                maxmin: true,
                moveOut: true,
                shade:0,
                //   btnAlign: 'c',
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    alert("进入yes")



                    remarks.value = $(layero).find('iframe')[0].contentWindow.user_id.value; //将子窗口中的 user_id 抓过来



               //   var s=  parent.B
                  //  alert(s)
                  //  parent.layer.getChildFrame()

                    var time = setTimeout(function () {
                        //  layer.close(index);
                    }, 5000);



                //    layui-layer

               //     parent.$("#layui-layer")[0].contentWindow
//debugger;
                    //             var id=    $(layero).find('iframe')[0].contentWindow; //将子窗口中的 user_id 抓过来
//alert(id)
                //   window.parent.document.getElementsByClassName("layui-layer")[0].remove()


                }, success: function (layero, index) {
debugger;





                    var obj = $(layero).find('iframe')[0].contentWindow;
                    //定义表格行的双击处理
                    $(obj.example).find('tbody tr').dblclick(function(e){
                        $('.layui-layer-btn0').click(); //触发'确定'按钮单击事件
                    });

                   //   var time = setTimeout(function () {
                        //  layer.close(index);
                   //     }, 5000);

                //    window.parent.document.getElementsByClassName("layui-layer")[0]



                  //  var iframeWin = parent['layui-layer-iframe3'];
                  //  var test1 = iframeWin.layui.table.checkStatus('test');
                  //  alert(test1.data.length)
/*
                    var body = layer.getChildFrame('body', index);
                    var iframeWin = window[layero.find('iframe')[0]['name']];

                    debugger;
                    alert("进入success")
                    var obj = $(layero).find('iframe')[0].contentWindow;
                    debugger;
                    //定义表格行的双击处理
                    $(obj.example).find('tbody tr').dblclick(function(e){
                        $('.layui-layer-btn0').click(); //触发'确定'按钮单击事件
                    });
                    */


                },
                    end: function () {
                //    debugger;
              //      var iframeWin = top['layui-layer-iframe3']
                    //parent['layui-layer-iframe' + index];
              //      var test1 = iframeWin.layui.table.checkStatus('test');
             //       alert(test1.data.length)
                }

            });

            window.B = $('#layui-layer' + index);

            parent.layer.iframeAuto(index);
        });



        //监听提交，发送请求
        form.on('submit(add)', function (data) {
            $.post("${basePath}/tasksend/add", data.field, function (data) {
                // 获取 session
                if (data.status != 200) {
                    layer.alert(data.message, {offset: 't', icon: 2});
                }
                if (data.status == 200) {
                    layer.alert(data.message, {offset: 't', icon: 1}, function (index) {
                        layer.close(index);
                        var index2 = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index2);
                    });

                }
            });

            return false;
        });

    });
</script>

</body>
</html>
