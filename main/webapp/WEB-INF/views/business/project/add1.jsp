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
            <label class="layui-form-label">工程名称</label>
            <div class="layui-input-block">
                <input name="pjName"  lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">工程状态：</label>
            <div class="layui-input-block">
                <select name="pjstatus"  id="pjstatus"      >
                    <option value="">请选择</option>
                    <c:forEach items="${type}" var="t">
                        <option value="${t.typecode}" > ${t.typename}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">工程进度：</label>
            <div class="layui-input-block">
                <select name="parentId"  lay-verify="required" >
                    <option value="">请选择</option>
                    <c:forEach items="${schedule}" var="s">
                        <option value="${s.typecode}" > ${s.typename}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!--
                <div class="layui-form-item">
                    <label class="layui-form-label">工程状态</label>
                    <div class="layui-input-block">
                        <input name="pjStatus"  lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">工程进度</label>
                    <div class="layui-input-block">
                        <input name="curPsId"  lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
                    </div>
                </div>
                -->
        <div class="layui-form-item">
            <label class="layui-form-label">工程负责人</label>
            <div class="layui-input-block">
                <input name="functionary"  lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">工程概况:</label>
            <div class="layui-input-block">
                <input name="summary"  lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">通讯录:</label>
            <div class="layui-input-block">
                <input name="pjStatus" lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">计划开始时间</label>
            <div class="layui-input-block">
                <input name="startTime"   id="startTime"     placeholder="请输入" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label">计划结束时间</label>
            <div class="layui-input-block">
                <input name="endTime"   id="endTime"   placeholder="请输入"  lay-verify="required"  autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block">
                <input name="remarks"  lay-verify="required" placeholder="请输入角色类型" autocomplete="off" class="layui-input" type="text">
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
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#startTime' //指定元素
        });

        laydate.render({
            elem: '#endTime' //指定元素
        });
    });

</script>

<script>
    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var form = layui.form, layer = layui.layer;
        var table = layui.table;

        //  form.render("select",function(data){
        //  $('#pjstatus').val(data.value);
        //        alert($('#pjstatus').val())
        //   });

        //监听提交，发送请求
        form.on('submit(add)', function (data) {
            $.post("${basePath}/project/add", data.field, function (data) {
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
