<%@ include file="/WEB-INF/views/user/tag.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<div class="layui-tab layui-tab-card" lay-filter="demo">
    <ul class="layui-tab-title">
        <li class="layui-this">我的工单</li>
        <li>用户管理</li>
        <li>权限分配</li>
    </ul>
    <div class="layui-tab-content" style="height: 100px;">
        <div class="layui-tab-item layui-show">

            <div class="layui-fluid">
                <div class="layui-row">
                    <div class="layui-col-xs12">
                        <div class="layui-card">
                            <div class="layui-card-header">任务储备</div>
                            <!--这里写页面的代码-->
                            <div class="layui-card-body">
                                <form class="layui-form" action="">
                                    <div class="layui-inline">
                                        <div class="layui-inline">
                                            <label class="layui-form-label">任务</label>
                                            <div class="layui-input-inline" style="margin-right:10px;width:150px;margin-top:5px;">
                                                <input placeholder="权限分配" class="layui-input search_input" type="text" id="taskName_w" name="taskName" />
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
                                        <div class="layui-inline">
                                            <label class="layui-form-label">级别</label>
                                            <div class="layui-inline" style="margin-top:5px;width:170px;">
                                                <select name="levelCode"  id="levelCode_w"    lay-verify="required"  >
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${level}" var="t">
                                                        <option value="${t.typecode}" > ${t.typename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">提交人</label>
                                            <div class="layui-input-inline" style="margin-right:10px;width:170px;margin-top:5px;">
                                                <input name="createdbyName"   id="createdbyName_w"     placeholder="请输入" autocomplete="off" class="layui-input" type="text">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-top:5px;">
                                        <a class="layui-btn search_btn" data-type="reload" id="searchWXData"><i class="layui-icon"></i>查询</a>
                                    </div>
                                </form>
                                <div class="layui-card-header">
                                    <!-- <span>所有会员列表</span> -->
                                    <shiro:hasPermission name="/role/add">
                                        <a id="add" class="layui-btn layui-btn-xs">
                                            <i class="layui-icon"></i>
                                            <span>新增</span>
                                        </a>
                                        <a id="checkdelete" class="layui-btn layui-btn-xs">
                                            <i class="layui-icon"></i>
                                            <span>批量删除</span>
                                        </a>
                                    </shiro:hasPermission>
                                    <a href="javascript:;" class="layui-btn layui-btn-xs layui-btn-primary" id="rhqvf8w5t6q8">
                                        <i class="layui-icon"></i>
                                    </a>
                                </div>

                                <table class="layui-table" id="businessfiletable" lay-filter="businessfiletable2"></table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>




        </div>
        <div class="layui-tab-item">

            <div class="layui-fluid">
                <div class="layui-row">
                    <div class="layui-col-xs12">
                        <div class="layui-card">
                            <div class="layui-card-header">工程资料管理</div>
                            <!--这里写页面的代码-->
                            <div class="layui-card-body">
                                <form class="layui-form" action="">
                                    <div class="layui-inline">
                                        <div class="layui-inline">
                                            <label class="layui-form-label">任务</label>
                                            <div class="layui-input-inline" style="margin-right:10px;width:150px;margin-top:5px;">
                                                <input placeholder="用户管理" class="layui-input search_input" type="text" id="taskName_c" name="taskName" />
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">类型</label>
                                            <div class="layui-inline" style="margin-top:5px;width:200px;">
                                                <select name="bpncId"  id="bpncId_c"    lay-verify="required"  >
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${type}" var="t">
                                                        <option value="${t.bpncId}" > ${t.bpncName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">级别</label>
                                            <div class="layui-inline" style="margin-top:5px;width:170px;">
                                                <select name="levelCode"  id="levelCode_c"    lay-verify="required"  >
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${level}" var="t">
                                                        <option value="${t.typecode}" > ${t.typename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">提交人</label>
                                            <div class="layui-input-inline" style="margin-right:10px;width:170px;margin-top:5px;">
                                                <input name="createdbyName"   id="createdbyName_c"     placeholder="请输入" autocomplete="off" class="layui-input" type="text">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-top:5px;">
                                        <a class="layui-btn search_btn" data-type="reload" id="searchWXData_c"><i class="layui-icon"></i>查询</a>
                                    </div>
                                </form>

                                <table class="layui-table" id="businessfiletable_c" lay-filter="businessfiletable2_c"></table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="layui-tab-item">


            <div class="layui-fluid">
                <div class="layui-row">
                    <div class="layui-col-xs12">
                        <div class="layui-card">
                            <div class="layui-card-header">工程资料管理</div>
                            <!--这里写页面的代码-->
                            <div class="layui-card-body">
                                <form class="layui-form" action="">
                                    <div class="layui-inline">
                                        <div class="layui-inline">
                                            <label class="layui-form-label">任务</label>
                                            <div class="layui-input-inline" style="margin-right:10px;width:150px;margin-top:5px;">
                                                <input placeholder="我的工单" class="layui-input search_input" type="text" id="taskName_f" name="taskName" />
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">类型</label>
                                            <div class="layui-inline" style="margin-top:5px;width:200px;">
                                                <select name="bpncId"  id="bpncId_f"    lay-verify="required"  >
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${type}" var="t">
                                                        <option value="${t.bpncId}" > ${t.bpncName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">级别</label>
                                            <div class="layui-inline" style="margin-top:5px;width:170px;">
                                                <select name="levelCode"  id="levelCode_f"    lay-verify="required"  >
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${level}" var="t">
                                                        <option value="${t.typecode}" > ${t.typename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">提交人</label>
                                            <div class="layui-input-inline" style="margin-right:10px;width:170px;margin-top:5px;">
                                                <input name="createdbyName"   id="createdbyName_f"     placeholder="请输入" autocomplete="off" class="layui-input" type="text">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-top:5px;">
                                        <a class="layui-btn search_btn" data-type="reload" id="searchWXData_f"><i class="layui-icon"></i>查询</a>
                                    </div>
                                </form>


                                <table class="layui-table" id="businessfiletable_f" lay-filter="businessfiletable2_f"></table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>

<script type="text/html" id="indexTpl">
    {{d.LAY_TABLE_INDEX+1}}
</script>

<script type="text/html" id="barDemo">

    <shiro:hasPermission name="/role/update">
        <button class="layui-btn layui-btn-xs" lay-event="edit">编辑</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="/role/del">
        <button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</button>
    </shiro:hasPermission>
</script>

<script type="text/html" id="usernameTpl">
    <div><a href='javascript:;'  class="layui-table-link" target="_blank" onclick=onlineDetails('{{d.bfId}}') >{{ d.taskName }}</a></div>

</script>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#uploadtime' //指定元素
        });

    });

</script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>


    function onlineDetails(Id){
        var index = layer.open({
            type: 2,
            content: '${basePath}/businessfile/onlineDetails?id='+Id,
            area: ['800px', '600px'],
            maxmin: true
        });
        parent.layer.iframeAuto(index);
    };



        layui.use(['form', 'layedit', 'laydate', 'element', 'layer','table','code'], function(){
            var form = layui.form, layer = layui.layer, element = layui.element,table = layui.table;
        element.on('tab(demo)', function(data){
          //  console.log(this); //当前Tab标题所在的原始DOM元素
          //  console.log(data.index); //得到当前Tab的所在下标
          //  console.log(data.elem); //得到当前的Tab大容器
        });

        form.render("select",function(data){
            $('#bfType').val(data.value);
        });


        // 查询
        $('#searchWXData').on('click', function() {
            table.reload("businessfiletable", { // 此处是上文提到的 初始化标识id
                where : {
                    taskName : $("#taskName_w").val().trim(),
                    bpncId : $("#bpncId_w").val().trim(),
                    levelCode : $("#levelCode_w").val().trim(),
                    createdbyName:$("#createdbyName_w").val().trim(),
                },
                page : {
                    curr : 1
                }
            });
        });


        //这个是用于创建点击事件的实例
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //搜索 ----------------------------------------------- End-----------------------------------------------------------


        //让层自适应iframe
        //添加
        $('#add').on('click', function () {
            var index = layer.open({
                type: 2,
                content: '${basePath}/taskstore/goAdd',
                area: ['800px', '500px'],
                maxmin: true,
                end: function () {
                    table.reload("businessfiletable", {});
                }
            });
            parent.layer.iframeAuto(index);
        });




        $('#checkdelete').on('click', function () {
            var checkStatus = table.checkStatus('businessfiletable');
            if(checkStatus.data.length==0){
                parent.layer.msg('请先选择要删除的数据行！', {icon: 2});
                return ;
            }
            var ids ="";//选择记录的序号
            for(var i=0;i<checkStatus.data.length;i++){
                //    indexs.push(checkStatus.data[i].bfId);
                ids += checkStatus.data[i].bfId+",";
            }
            //   parent.layer.msg('删除中...', {icon: 16,shade: 0.3,time:5000});

            var url='${basePath}/project/delete'
            layer.confirm("您确定要删除吗？"+ids,function(){
                $.ajax({
                    type:"POST",
                    url: '${basePath}/project/delete',
                    data:{"ids":ids},
                    success:function (data) {
                        layer.closeAll('loading');
                        if (data.status == 200) {
                            layer.msg(data.message, {icon: 1, time: 1000});
                            // 前端修改
                            //    layer.close(index);
                            table.reload("businessfiletable", {});
                        } else {
                            layer.msg(data.message, {icon: 0, time: 1000});
                            layer.close(index);
                        }
                    }
                })
            })
        });


        //表格渲染
        table.render({
            elem: '#businessfiletable'
            , url: '${basePath}/taskstore/getProjectPage'
            , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type:'checkbox'},
                {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                , {field: 'wfId', align: 'center', width: 70}
                , {field: 'taskId', align: 'center', width: 70}
                , {field: 'taskName', title: '任务',templet: '#usernameTpl'}
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
                 //   toolbar: '#barDemo',
                    defaultToolbar: ['filter', 'print', 'exports'],
                    title: '操作'
                }
            ]]
            ,done: function () {
                $("[data-field='wfId']").css('display','none');
                $("[data-field='taskId']").css('display','none');
            }
        });



        //表格渲染
        table.render({
            elem: '#businessfiletable_f'
            , url: '${basePath}/taskstore/getProjectPage'
            , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type:'checkbox'},
                {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                , {field: 'wfId', align: 'center', width: 70}
                , {field: 'taskId', align: 'center', width: 70}
                , {field: 'taskName', title: '任务',templet: '#usernameTpl'}
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
            ,done: function () {
                $("[data-field='wfId']").css('display','none');
                $("[data-field='taskId']").css('display','none');
            }
        });

        //表格渲染
        table.render({
            elem: '#businessfiletable_c'
            , url: '${basePath}/taskstore/getProjectPage'
            , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type:'checkbox'},
                {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                , {field: 'wfId', align: 'center', width: 70}
                , {field: 'taskId', align: 'center', width: 70}
                , {field: 'taskName', title: '任务',templet: '#usernameTpl'}
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
                 //  toolbar: '#barDemo',
                    defaultToolbar: ['filter', 'print', 'exports'],
                    title: '操作'
                }
            ]]
            ,done: function () {
                $("[data-field='wfId']").css('display','none');
                $("[data-field='taskId']").css('display','none');
            }
        });

        //监听工具条
        table.on('tool(businessfiletable2)', function(obj){
            var data = obj.data;

            if(obj.event === 'setSign'){

                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    // 写删除方法
                    $.post("${basePath}/taskstore/del", {"id": data.taskId}, function (data) {
                        if (data.status == 200) {
                            layer.msg(data.message, {icon: 1, time: 1000});
                            // 前端修改
                            layer.close(index);
                            table.reload("businessfiletable", {});
                        } else {
                            layer.msg(data.message, {icon: 0, time: 1000});
                            layer.close(index);
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                // 编辑
                var index = layer.open({
                    type: 2,
                    content: '${basePath}/taskstore/goUpdate?id=' + data.taskId,
                    area: ['800px', '500px'],
                    maxmin: true,
                    resize: true,
                    end: function () {
                        table.reload("businessfiletable", {});
                    }
                });
                parent.layer.iframeAuto(index);
            }
        });
    });
</script>