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
    <link rel="stylesheet" href="${basePath}/plugins/layui-treeselect/src/css/ztree/metro/ztree.css" media="all"/>
    <link rel="stylesheet" href="${basePath}/plugins/layui-treeselect/src/css/treeselect.css" media="all"/>
</head>
<body>

<div class="kit-doc">
    <form class="layui-form layui-form-pane" action="">
        <input name="id" value="${system.id}" hidden="hidden"/>
        <div class="layui-form-item">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input name="username" id="username" value="${system.username}" lay-verify="required"
                           placeholder="请输入提交人" autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">真实姓名</label>
                <div class="layui-input-block">
                    <input name="realname" id="realname" value="${system.realname}" lay-verify="required"
                           placeholder="请输入提交人" autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>
            <c:if test="${system.id ==mull}">
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input name="password" id="password" lay-verify="required" placeholder="请输入提交人"
                               autocomplete="off"
                               class="layui-input" type="text">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">重复密码</label>
                    <div class="layui-input-block">
                        <input name="password_test" id="password_test" lay-verify="required" placeholder="请输入提交人"
                               autocomplete="off"
                               class="layui-input" type="text">
                    </div>
                </div>
            </c:if>

            <div class="layui-form-item">
                <label class="layui-form-label">角色名称</label>
                <div class="layui-input-block layui-input-treeselect">
                    <input type="text" name="rids" value="${selectvalue}" id="treeselect1" required
                           lay-verify="required" autocomplete="off" placeholder="请选择角色"
                           class="layui-input">
                </div>

            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">所属班组</label>
                <div class="layui-input-block">
                    <input name="teamid" id="teamid" value="${system.teamid}" lay-verify="required" placeholder="请输入提交人"
                           autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">手机号码</label>
                <div class="layui-input-block">
                    <input name="mobilePhone" id="mobilePhone" value="${system.mobilePhone}" lay-verify="phone"
                           placeholder="请输入提交人"
                           autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">常用邮箱:</label>
                <div class="layui-input-block">
                    <input name="email" lay-verify="email" value="${system.email}" placeholder="请输入任务描述"
                           autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">备注:</label>
                <div class="layui-input-block">
                    <input name="remarks" id="remarks" value="${system.remarks}" lay-verify="remarks"
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
        //监听提交，发送请求
        form.on('submit(add)', function (data) {
            $.post("${basePath}/systemuser/addupdate", data.field, function (data) {
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

<script>
    layui.config({
        base: '/plugins/layui-treeselect/src/js/' //自定义组件的目录--相对路径
    }).use(['form', 'treeselect'], function () {
        var form = layui.form, treeselect = layui.treeselect;

        var data = [];
        $.ajax({
            async: false,
            type: "GET",
            url: "/systemrole/getAllRole",
            dataType: "json",
            success: function (resule) {
                data = resule;
            }
        });

        //通过调用render方法进行渲染 [render支持链式调用]
        treeselect.render({ //渲染第一个
            elem: '#treeselect1', //这个设置必要为id属性且必须加上#号
            data: data
        });

    });
</script>
</body>
</html>
