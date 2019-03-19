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
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-xs12">
            <div class="layui-card">
                <div class="layui-card-header">工程资料管理</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="">
                        <div class="layui-inline">
                            <div class="layui-inline">
                                <label class="layui-form-label">任务</label>
                                <div class="layui-input-inline" style="margin-right:10px;width:150px;margin-top:5px;">
                                    <input placeholder="任务名称" class="layui-input search_input" type="text" id="taskName_w" name="taskName" />
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">类型</label>
                                <div class="layui-inline" style="margin-top:5px;width:200px;">
                                    <select name="bpncId"  id="bpncId_w"    lay-verify="required"  >
                                        <option value="">请选择</option>
                                        <c:forEach items="${type}" var="t">
                                            <option value="${t.bpncId}" > ${t.bpncName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="layui-inline" style="margin-top:5px;">
                            <a class="layui-btn search_btn" data-type="reload" id="searchWXData"><i class="layui-icon"></i>查询</a>
                        </div>
                    </form>
                    <table class="layui-table" id="test" lay-filter="test1"></table>
                </div>
            </div>
        </div>
    </div>
</div>



<script src="${basePath}/js/jquery.js"></script>
<script src="${basePath}/plugins/kitadmin/layui.js"></script>
<script type="text/html" id="indexTpl">
    {{d.LAY_TABLE_INDEX+1}}
</script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>





    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;

        form.render('select');

        // 查询
        $('#searchWXData').on('click', function() {
            table.reload("test", { // 此处是上文提到的 初始化标识id
                where : {
                    taskName : $("#taskName_w").val().trim(),
                    bpncId : $("#bpncId_w").val().trim()
                },
                page : {
                    curr : 1
                }
            });
        });



        //表格渲染
      //  tableIns=
         table.render({

            elem: '#test'
            , url: '${basePath}/task/datagridstore'
             , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增a
            , cols: [[
                {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                , {field: 'wfId', align: 'center', width: 70}
                , {field: 'taskId', align: 'center', width: 70}
                , {field: 'taskName', title: '任务'}
                , {field: 'bpncId', title: '类型'}
                ,{field:'levelCode',  title: '播放器样式',templet:function (d) {
                    if(d.levelCode==1){
                        return "国网";
                    }else if(d.levelCode==2){
                        return "省公司"
                    }else if(d.levelCode==3){
                        return "公司"
                    }else if(d.levelCode==4){
                        return "中心"
                    }else if(d.levelCode==5){
                        return "班组"
                    }
                }}
                , {field: 'createdbyName', title: '提交人'}
                , {field: 'remarks', title: '任务描述'}
                 , {
                     field: 'right',
                     align: 'center',
                     width: 150,
                     toolbar: '#barDemo',
                     defaultToolbar: ['filter', 'print', 'exports'],
                     title: '操作'
                 }

            ]]
            ,done: function (res,curr,count) {
                $("[data-field='wfId']").css('display','none');
                $("[data-field='taskId']").css('display','none');
            }
        });



      //  这个事件无法进入；
table.on('row(test1)', function(obj){
    var data = obj.data;

    // window.parent.$("#taskName").val(data.taskName);

   // $("#taskName_w").val().trim()
  //  parent.$('#taskName').val(data.taskName)
  //  console.log(parent.$('#taskName').val());

    //     console.log(data);

  //  console.log(data.taskName);

 //   alert("123");
  //  if(data === ''){
  //      parent.layer.msg('请填写标记');
  //      return;
  //  }
  //  parent.layer.msg('您将标记 [ ' +data + ' ] 成功传送给了父窗口');
 //   parent.layer.close(index);
  //  layer.alert(JSON.stringify(data), {
   //     title: '当前行数据：'
   // });

    //标注选中样式
    obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
});


/*
        table.on('rowDouble(businessfiletable2)', function(obj){

            alert("1234")

        });
        //监听行单击事件（单击事件为：rowDouble）

//监听行单击事件
        table.on('row(test1)', function(obj){
            alert("1234")
            console.log(obj.tr) //得到当前行元素对象
            console.log(obj.data) //得到当前行数据
            //obj.del(); //删除当前行
            //obj.update(fields) //修改当前行数据
        });



/*
        //监听行单击事件（单击事件为：rowDouble）
        table.on('row(businessfiletable2)', function(obj){

            var data = obj.data;

            layer.alert(JSON.stringify(data), {
                title: '当前行数据：'
            });

            //标注选中样式
          //  obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
        });
*/
    });
</script>
</body>
</html>


