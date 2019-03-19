<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/user/tag.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="wth=device-width, initial-scale=1, maximum-scale=1">
    <title>角色添加</title>
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/theme/default.css" id="theme">
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/kitadmin.css" id="kitadmin">
    <link rel="stylesheet" href="${basePath}/css/doc.css">
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/layui.css" id="layui">
    <style type="text/css">
        .layui-table-view .layui-form-radio {
            line-height: 1;
        }
    </style>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-xs12">
            <div class="layui-card">
                <div class="layui-card-body">


                    <table class="layui-table" id="example" lay-filter="example"></table>

                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/html" id="indexTpl">
    {{d.LAY_TABLE_INDEX+1}}
</script>

<script src="${basePath}/js/jquery.js"></script>
<script src="${basePath}/plugins/kitadmin/layui.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>


    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;

        var type =${type}//组员2 组长1
        if (type == "1") {
            table.render({
                elem: '#example'
                , url: '${basePath}/systemuser/selectUser'
                , method: 'post'
                , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
                , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                , cols: [[
                    {type: 'radio'},
                    {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                    , {field: 'id', align: 'center', width: 70}
                    , {field: 'username', title: '用户名'}
                    , {field: 'realname', title: '真实姓名'}
                    , {field: 'mobilePhone', title: '手机号码'}

                ]]
                , done: function () {
                    $("[data-field='id']").css('display', 'none');

                }
            });
        } else {
            table.render({
                elem: '#example'
                , url: '${basePath}/systemuser/selectUser'
                , method: 'post'
                , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
                , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                , cols: [[
                    {type: 'checkbox'},
                    {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                    , {field: 'id', align: 'center', width: 70}
                    , {field: 'username', title: '用户名'}
                    , {field: 'realname', title: '真实姓名'}
                    , {field: 'mobilePhone', title: '手机号码'}

                ]]
                , done: function () {
                    $("[data-field='id']").css('display', 'none');

                }
            });


        }


        //表格渲染


//监听行单击事件（单击事件为：rowDouble）
        /*
         table.on('row(test)', function(obj){
         var data = obj.data;

         layer.alert(JSON.stringify(data), {
         title: '当前行数据：'
         });

         //标注选中样式
         obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
         });
         */


    });
</script>
</body>
</html>
