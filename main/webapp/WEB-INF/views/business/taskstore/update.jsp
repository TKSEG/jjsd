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
        <input name="taskId" value="${task.taskId}" hidden="hidden"/>
        <div class="layui-form-item">
            <label class="layui-form-label">任务名称</label>
            <div class="layui-input-block">
                <input name="taskName" value="${task.taskName}" lay-verify="required" placeholder="请输入任务名称" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">类型：</label>
            <div class="layui-input-block">
                <select name="bpncId" id="bpncId"  lay-verify="required"  >
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
                <select name="levelCode"  id="levelCode"      >
                    <option value="">请选择</option>
                    <c:forEach items="${level}" var="t">
                        <option value="${t.typecode}" > ${t.typename}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">提交人</label>
            <div class="layui-input-block">
                <input name="createdbyName"  value="${task.createdbyName}" lay-verify="required" placeholder="请输入提交人" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">任务描述:</label>
            <div class="layui-input-block">
                <input name="remarks" value="${task.remarks}" lay-verify="required" placeholder="请输入角色类型" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        <c:if test="${display == 'none' }">
                <div class="layui-form-item">
                    <label class="layui-form-label">*选择审批人：:</label>
                    <div class="layui-input-block">

                        <select name="approveu_id"  id="approveu_id"      >
                            <option value="">请选择</option>
                            <c:forEach items="${baseuser}" var="b">
                                <option value="${b.id}" > ${b.username}</option>
                            </c:forEach>
                        </select>

                    </div>
                </div>
        </c:if>



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

        //select下拉框默认赋值
        $("#bpncId").val(${task.bpncId});
        $("#levelCode").val(${task.levelCode});

     //   parentId
        form.render('select');
       // form.on('select(bpncId)', function(data){
           // console.log(data.elem); //得到select原始DOM对象
         //   console.log(data.value); //得到被选中的值
         //   console.log(data.othis); //得到美化后的DOM对象
     //   });


        //监听提交，发送请求
        form.on('submit(update)', function(data){
            $.post("${basePath}/taskstore/update",data.field,function(data){
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
