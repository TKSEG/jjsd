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
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-form-item">

            <div class="layui-inline">
                <label class="layui-form-label">任务</label>
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
            <label class="layui-form-label">类型：</label>
            <div class="layui-input-block">
                <select name="bpncId" id="bpncId" lay-filter="bpncId">
                    <option value="">请选择</option>
                    <c:forEach items="${type}" var="t">
                        <option value="${t.ordernum}"> ${t.bpncName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">级别</label>
            <div class="layui-input-block">
                <select name="levelCode" id="levelCode">
                    <option value="">请选择</option>
                    <c:forEach items="${level}" var="t">
                        <option value="${t.typecode}"> ${t.typename}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">计划时间</label>
            <div class="layui-input-block">
                <input name="planTime" id="planTime" lay-verify="required" placeholder="请输入提交人" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">任务标准:</label>
            <div class="layui-input-block">
                <input name="standard" lay-verify="standard" placeholder="请输入任务描述" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">标准分:</label>
            <div class="layui-input-block">
                <input name="bfscore" id="bfscore" disabled="" autocomplete="off" class=" layui-input layui-bg-gray "
                       type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">负责人</label>
            <div class="layui-input-block">
                <input name="dutyuId" lay-verify="required" placeholder="请输入提交人" autocomplete="off" class="layui-input"
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


    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var form = layui.form, layer = layui.layer;
        var table = layui.table;

        $(document).on('click', '#btn', function () {
            var index = parent.layer.open({
                type: 2,
                content: '${basePath}/tasksend/taskSelect',
                area: ['1100px', '600px'],
                maxmin: true,
                moveOut: true,
                shade:0,
                //   btnAlign: 'c',
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    window.parent.document.getElementsByClassName("layui-layer")[1].remove()


                }, success: function (layero, index) {


                }
            });
            parent.layer.iframeAuto(index);
        });


        //   form.render('select');
        form.on('select(bpncId)', function (data) {
            var value = data.value
            if (value == 1) {
                $("#bfscore").val("8");
            } else if (value == 2) {
                $("#bfscore").val("10");
            } else if (value == 3) {
                $("#bfscore").val("10");
            } else if (value == 4) {
                $("#bfscore").val("8");
            } else if (value == 5) {
                $("#bfscore").val("10");
            } else if (value == 6) {
                $("#bfscore").val("8");
            } else if (value == 7) {
                $("#bfscore").val("8");
            } else if (value == 8) {
                $("#bfscore").val("10");
            } else if (value == 9) {
                $("#bfscore").val("6");
            } else if (value == 10) {
                $("#bfscore").val("5");
            }
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
