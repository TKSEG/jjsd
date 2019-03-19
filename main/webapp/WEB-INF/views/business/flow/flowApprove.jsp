<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/user/tag.jsp" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="wth=device-width, initial-scale=1, maximum-scale=1">
    <title>审核</title>
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/theme/default.css" id="theme">
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/kitadmin.css" id="kitadmin">
    <link rel="stylesheet" href="${basePath}/css/doc.css">
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/layui.css" id="layui">

</head>
<body>

<div class="kit-doc">
    <form class="layui-form layui-form-pane" action="">
        <input name="wfId" value="${flowItem.wfId}" hidden="hidden"/>
        <input name="objId" value="${flowItem.objId}" hidden="hidden"/>


        <input name="typeCode" value="${flowItem.typeCode}" hidden="hidden"/>


        <div class="layui-form-item">
            <label class="layui-form-label">审核状态</label>
            <div class="layui-input-block">
                <input type="radio" name="approveResult" value="Y" title="同意" checked>
                <input type="radio" name="approveResult" value="N" title="不同意" >
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">审核意见</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容"  name="approveDes" class="layui-textarea" ></textarea>
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
    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var form = layui.form, layer = layui.layer;
        var table = layui.table;

        //监听提交，发送请求
        form.on('submit(add)', function (data) {
            $.post("${basePath}/taskstore/approveFlow", data.field, function (data) {
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
