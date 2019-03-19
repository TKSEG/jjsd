<%@ include file="/WEB-INF/views/user/tag.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-xs12">
            <div class="layui-card">
                <div class="layui-card-header">角色管理</div>
                <!--这里写页面的代码-->
                <div class="layui-card-body">

                    <form class="layui-form" action="">
                        <div class="layui-inline">

                            <div class="layui-inline">
                                <label class="layui-form-label">模板名称</label>
                                <div class="layui-input-inline" style="margin-right:10px;width:150px;margin-top:5px;">
                                    <input placeholder="任务" class="layui-input search_input" type="text" id="pjName_w" name="pjName" />
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">工程状态</label>
                                <div class="layui-inline" style="margin-top:5px;width:200px;">
                                    <select name="pjStatus"  id="pjStatus_w"    lay-verify="required"  >
                                        <option value="">请选择</option>
                                        <c:forEach items="${type}" var="t">
                                            <option value="${t.typecode}" > ${t.typename}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">工程进度</label>
                                <div class="layui-inline" style="margin-top:5px;width:170px;">
                                    <select name="curPsId"  id="curPsId_w"    lay-verify="required"  >
                                        <option value="">请选择</option>
                                        <c:forEach items="${schedule}" var="s">
                                            <option value="${s.typecode}" > ${s.typename}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">计划开始时间</label>
                                <div class="layui-input-inline" style="margin-right:10px;width:170px;margin-top:5px;">
                                    <input name="startTime"   id="startTime_w"     placeholder="请输入" autocomplete="off" class="layui-input" type="text">
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">计划结束时间</label>
                                <div class="layui-input-inline" style="margin-right:10px;width:170px;margin-top:5px;">
                                    <input name="endTime"   id="endTime_w"     placeholder="请输入" autocomplete="off" class="layui-input" type="text">
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

                            <a id="export" class="layui-btn layui-btn-xs">
                                <i class="layui-icon"></i>
                                <span>导出</span>
                            </a>
                        </shiro:hasPermission>

                        <a href="javascript:;" class="layui-btn layui-btn-xs layui-btn-primary" id="rhqvf8w5t6q8">
                            <i class="layui-icon"></i>
                        </a>
                    </div>

                    <table class="layui-table" id="roletable" lay-filter="roletable2"></table>

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
<script>

    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#startTime_w' //指定元素
        });
        laydate.render({
            elem: '#endTime_w' //指定元素
        });
    });

</script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;

        //select下拉框默认赋值
     //   $("#pjStatus").val(${role.pjStatus});
    //    $("#curPsId").val(${role.curPsId});

      //  form.render("select",function(data){
          //  $('#pjstatus').val(data.value);
     //   });

        // 查询
        $('#searchWXData').on('click', function() {
            table.reload("roletable", { // 此处是上文提到的 初始化标识id
                where : {
                    pjName : $("#pjName_w").val().trim(),
                    pjStatus : $("#pjStatus_w").val().trim(),
                    curPsId : $("#curPsId_w").val().trim(),
                    startTime : $("#startTime_w").val().trim(),
                    endTime:$("#endTime_w").val().trim(),
                },
                page : {
                    curr : 1
                }
            });
        });


        //让层自适应iframe
        $('#export').on('click', function () {
            var pjname = $('#pjname').val();//获取输入框的值
            var pjstatus = $('#pjstatus').val();//获取输入框的值
            $.ajax({
                type:"POST",
                url: '${basePath}/project/queryproject1',
               data:{"pjname":pjname,"pjstatus":pjstatus},

                success:function (data) {
                    layer.closeAll('loading');
                    if (data.status == 200) {
                        layer.msg(data.message, {icon: 1, time: 1000});
                        // 前端修改
                        //    layer.close(index);
                     //   table.reload("roletable", {});
                    } else {
                     //   layer.msg(data.message, {icon: 0, time: 1000});
                    //    layer.close(index);
                    }
                }

            })
        });



        //让层自适应iframe
        $('#add').on('click', function () {
            var index = layer.open({
                type: 2,
                content: '${basePath}/project/goAdd',
                area: ['800px', '500px'],
                maxmin: true,
                end: function () {
                    table.reload("roletable", {});
                }
            });
            parent.layer.iframeAuto(index);
        });



        $('#checkdelete').on('click', function () {
            var checkStatus = table.checkStatus('roletable');
            if(checkStatus.data.length==0){
                parent.layer.msg('请先选择要删除的数据行！', {icon: 2});
                return ;
            }
            var ids ="";//选择记录的序号
            for(var i=0;i<checkStatus.data.length;i++){
            //    indexs.push(checkStatus.data[i].pjId);
                ids += checkStatus.data[i].pjId+",";
            }
         //   parent.layer.msg('删除中...', {icon: 16,shade: 0.3,time:5000});

            var url='${basePath}/project/delete'
           // console.log(url)
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
                            table.reload("roletable", {});
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
            elem: '#roletable'
            , url: '${basePath}/project/getProjectPage'
            , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type:'checkbox'},
                {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                , {field: 'pjId', align: 'center', width: 70}
                , {field: 'pjName', title: '工程名称'}
                , {field: 'pjStatus', title: '工程状态'}
                , {field: 'curPsId', title: '工程进度'}
                , {field: 'functionary', title: '工程负责人'}
                , {field: 'summary', title: '工程概况'}
                , {field: 'pjStatus', title: '通讯录'}
                , {field: 'startTime', title: '开始时间', width: 170}
                , {field: 'endTime', title: '结束时间', width: 170}
                , {field: 'remarks', title: '备注'}
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
                $("[data-field='pjId']").css('display','none');
            }
        });


        //监听工具条
        table.on('tool(roletable2)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    // 写删除方法
                    $.post("${basePath}/project/del", {"id": data.pjId}, function (data) {
                        if (data.status == 200) {
                            layer.msg(data.message, {icon: 1, time: 1000});
                            // 前端修改
                            layer.close(index);
                            table.reload("roletable", {});
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
                    content: '${basePath}/project/goUpdate?id=' + data.pjId,
                    area: ['800px', '500px'],
                    maxmin: true,
                    resize: true,
                    end: function () {
                        table.reload("roletable", {});
                    }
                });
                parent.layer.iframeAuto(index);
            }
        });
    });
</script>