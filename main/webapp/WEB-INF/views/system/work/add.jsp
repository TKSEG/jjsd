<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/user/tag.jsp" %>
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

<div class="kit-doc">
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-form-item">
            <div class="layui-form-item">
                <label class="layui-form-label">岗位名称</label>
                <div class="layui-input-block">
                    <input name="wpName" id="wpName" lay-verify="required"
                           placeholder="请输入岗位名称" autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">A角标准分</label>
                <div class="layui-input-block">
                    <input name="leve1Score" id="leve1Score" lay-verify="required"
                           placeholder="请输入提交人" autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">B角标准分</label>
                <div class="layui-input-block">
                    <input name="leve2Score" id="leve2Score" lay-verify="required" placeholder="请输入提交人"
                           autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">后备标准分</label>
                <div class="layui-input-block">
                    <input name="leve3Score" id="leve3Score" lay-verify="required" placeholder="请输入提交人"
                           autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">备注:</label>
                <div class="layui-input-block">
                    <input name="remarks" id="remarks"  lay-verify="remarks"
                           placeholder="请输入任务描述" autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
            </div>
        </div>
    </form>

    <!--这里写页面的代码-->
</div>

<script src="${basePath}/js/jquery.js"></script>
<script src="${basePath}/plugins/kitadmin/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var form = layui.form, layer = layui.layer;
        var table = layui.table;
        //监听提交，发送请求
        form.on('submit(add)', function (data) {
            $.post("${basePath}/work/add", data.field, function (data) {
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
