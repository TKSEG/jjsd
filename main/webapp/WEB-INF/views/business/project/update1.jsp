<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/user/tag.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>角色编辑</title>
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
        <input name="pjId" value="${role.pjId}" hidden="hidden"/>
        <div class="layui-form-item">
            <label class="layui-form-label">工程名称</label>
            <div class="layui-input-block">
                <input name="pjName" value="${role.pjName}" lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>


        <!--
        <div class="layui-form-item">
            <label class="layui-form-label">工程进度</label>
            <div class="layui-input-block">
                <input name="curPsId" value="${role.curPsId}" lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        -->

        <!--

        <div class="layui-form-item">
            <label class="layui-form-label">工程状态</label>
            <div class="layui-input-block">
                <input name="pjStatus" value="${role.pjStatus}" lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        -->


        <div class="layui-form-item">
            <label class="layui-form-label">工程状态：：</label>
            <div class="layui-input-block">
                <select name="pjStatus" id="pjStatus"  lay-verify="required"  >
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
                <select name="schedule" id="schedule"  lay-verify="required"  >
                    <option value="">请选择</option>
                    <c:forEach items="${schedule}" var="s">
                        <option value="${s.typecode}" > ${s.typename}</option>
                    </c:forEach>
                </select>
            </div>
        </div>





        <div class="layui-form-item">
            <label class="layui-form-label">工程负责人</label>
            <div class="layui-input-block">
                <input name="functionary" value="${role.functionary}" lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">工程概况:</label>
            <div class="layui-input-block">
                <input name="summary" value="${role.summary}" lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label">计划开始时间</label>
            <div class="layui-input-block">
                <input name="startTime"   id="startTime"  value="${role.startTime}"  placeholder="请输入" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">计划结束时间</label>
            <div class="layui-input-block">
                <input name="endTime" id="endTime" value="${role.endTime}"  placeholder="yyyy-MM-dd"  lay-verify="required"  autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block">
                <input name="remarks" value="${role.remarks}" lay-verify="required" placeholder="请输入角色类型" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <button class="layui-btn" lay-submit lay-filter="update">提交</button>
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


        $("#pjStatus").val(${role.pjStatus});

        $("#schedule").val(${role.curPsId});

        //   parentId
        form.render('select');
        form.on('select(pjStatus)', function(data){
            console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            console.log(data.othis); //得到美化后的DOM对象
        });






        var start='${role.startTime}';
        var end='${role.endTime}';

        var startTime=util.toDateString(start,'yyyy-MM-dd');
        var endTime=util.toDateString(end,'yyyy-MM-dd');
        laydate.render({
            elem: '#startTime' //指定元素
            ,value: startTime //必须遵循format参数设定的格式
            ,format: 'yyyy-MM-dd' //可任意组合
            ,lang: 'cn'
        });

        laydate.render({
            elem: '#endTime' //指定元素
            ,value: endTime //必须遵循format参数设定的格式
            ,format: 'yyyy-MM-dd' //可任意组合
            ,lang: 'cn'
        });


        //监听提交，发送请求
        form.on('submit(update)', function(data){
            $.post("${basePath}/project/update",data.field,function(data){
                // 获取 session
                if(data.status!=200){
                    layer.alert(data.message, {offset: 't',icon: 2});
                }
                if(data.status==200){
                    layer.alert(data.message, {offset: 't',icon: 1},function (index) {
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
