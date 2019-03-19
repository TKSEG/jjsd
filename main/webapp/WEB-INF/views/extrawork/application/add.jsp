<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>角色添加</title>
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/theme/default.css" id="theme">
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/kitadmin.css" id="kitadmin">
    <link rel="stylesheet" href="${basePath}/css/doc.css">
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/layui.css" id="layui">
</head>
<body>
<div class='layui-container' style='margin-top:15px'>
    <div class="layui-form layui-form-pane">
        <div class="layui-form-item">


            <label class="layui-form-label"> <span style="color: red">* </span>申请人:</label>
            <div class="layui-input-block">
                <input name="auserId" id="auserId" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">


            <label class="layui-form-label"> <span style="color: red">* </span>申请类型:</label>
            <div class="layui-input-block">
                <input name="applyType" id="applyType" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color: red">* </span>加班类型:</label>
            <div class="layui-input-block">
                <input name="ew_type" id="ew_type" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color: red">* </span>加班内容:</label>
            <div class="layui-input-block">
                <input name="ewContent" id="ewContent" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">申请内容:</label>
            <div class="layui-input-block">
                <input name="acontent" id="acontent" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color: red">* </span>开始时间:</label>
            <div class="layui-input-block">
                <input name="startTime" id="startTime" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: red">* </span>结束时间:</label>
        <div class="layui-input-block">
            <input name="endTime" id="endTime" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                   class="layui-input" type="text">
        </div>
    </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color: red">* </span>时长:</label>
            <div class="layui-input-block">
                <input name="hours" id="hours" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>




        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
        </div>

    </div>
</div>


<script src="${basePath}/js/jquery.js"></script>
<script src="${basePath}/plugins/kitadmin/layui.js"></script>

<script>

    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var form = layui.form, layer = layui.layer;
        var table = layui.table;
        $ = layui.jquery;

        //监听提交，发送请求
        form.on('submit(add)', function (data) {
            $.post("${basePath}/extrawork/add", data.field, function (data) {
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
