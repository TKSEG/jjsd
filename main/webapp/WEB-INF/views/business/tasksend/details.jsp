<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/user/tag.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>资料名称</title>
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

        <input name="taskId" value="${tasksend.tsId}" hidden="hidden"/>



        <div class="layui-form-item">
            <label class="layui-form-label">任务名称</label>
            <div class="layui-input-block">
                <input name="taskName" value="${tasksend.taskName}" disabled=""  lay-verify="required" placeholder="请输入任务名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">类型：</label>
            <div class="layui-input-block">
                <select name="bpncId" id="bpncId"  lay-verify="required"  disabled="" >
                    <option value="">请选择</option>
                    <c:forEach items="${type}" var="t">
                        <option value="${t.ordernum}" > ${t.bpncName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">级别</label>
            <div class="layui-input-block">
                <select name="levelCode"  id="levelCode"   disabled=""   >
                    <option value="">请选择</option>
                    <c:forEach items="${level}" var="t">
                        <option value="${t.typecode}" > ${t.typename}</option>
                    </c:forEach>
                </select>
            </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label">计划时间</label>
            <div class="layui-input-block">
                <input name="planTime" id="planTime" value="${tasksend.planTime}" disabled=""   lay-verify="required" placeholder="请输入提交人" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">任务标准:</label>
            <div class="layui-input-block">
                <input name="standard"  value="${tasksend.standard}"  disabled=""  lay-verify="standard" placeholder="请输入任务描述" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">标准分:</label>
            <div class="layui-input-block">
                <input name="bfscore" id="bfscore" value="${tasksend.bfscore}" disabled="" autocomplete="off" class=" layui-input layui-bg-gray "
                       type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">负责人</label>
            <div class="layui-input-block">
                <input name="dutyuId"  value="${tasksend.dutyuId}"  disabled=""  lay-verify="required"  placeholder="请输入提交人" autocomplete="off" class="layui-input"
                       type="text">
            </div>
        </div>

    </form>

    <!--这里写页面的代码-->
</div>

<script src="${basePath}/js/jquery.js"></script>
<script src="${basePath}/plugins/kitadmin/layui.js"></script>



<script>

    layui.use(['form', 'layedit', 'table', 'laydate','util'], function () {
        var laydate = layui.laydate;
        var util = layui.util;
        var form = layui.form;

        //select下拉框默认赋值
        $("#bpncId").val(${tasksend.bpncId});
        $("#levelCode").val(${tasksend.levelCode})

        form.render('select');

        var planTime='${task.planTime}';
        var planTime=util.toDateString(planTime,'yyyy-MM-dd');
        laydate.render({
            elem: '#planTime' //指定元素
            ,value: planTime //必须遵循format参数设定的格式
            ,format: 'yyyy-MM-dd' //可任意组合
            ,lang: 'cn'
        });
    });

</script>
</body>
</html>
