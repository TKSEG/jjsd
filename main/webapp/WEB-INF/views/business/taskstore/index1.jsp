<%@ include file="/WEB-INF/views/user/tag.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<div class="layui-tab layui-tab-card" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this" id="scan">我的工单</li>
        <li id="scan1">待审核</li>
        <li id="scan2">已审核</li>
    </ul>
    <div class="layui-tab-content" style="height: 100px;">
        <div class="layui-tab-item layui-show">

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
                                            <div class="layui-input-inline"
                                                 style="margin-right:10px;width:150px;margin-top:5px;">
                                                <input placeholder="任务名称" class="layui-input search_input" type="text"
                                                       id="taskName_w" name="taskName"/>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">类型</label>
                                            <div class="layui-inline" style="margin-top:5px;width:200px;">
                                                <select name="bpncId" id="bpncId_w" lay-verify="required">
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${type}" var="t">
                                                        <option value="${t.ordernum}"> ${t.bpncName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">级别</label>
                                            <div class="layui-inline" style="margin-top:5px;width:170px;">
                                                <select name="levelCode" id="levelCode_w" lay-verify="required">
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${level}" var="t">
                                                        <option value="${t.typecode}"> ${t.typename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">提交人</label>
                                            <div class="layui-input-inline"
                                                 style="margin-right:10px;width:170px;margin-top:5px;">
                                                <input name="createdbyName" id="createdbyName_w" placeholder="请输入"
                                                       autocomplete="off" class="layui-input" type="text">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-top:5px;">
                                        <a class="layui-btn search_btn" data-type="reload" id="searchWXData"><i
                                                class="layui-icon"></i>查询</a>
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
                                    <a href="javascript:;" class="layui-btn layui-btn-xs layui-btn-primary"
                                       id="rhqvf8w5t6q8">
                                        <i class="layui-icon"></i>
                                    </a>
                                </div>

                                <table class="layui-table" id="businessfiletable"
                                       lay-filter="businessfiletable2"></table>
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
                                            <div class="layui-input-inline"
                                                 style="margin-right:10px;width:150px;margin-top:5px;">
                                                <input placeholder="任务名称" class="layui-input search_input" type="text"
                                                       id="taskName_d" name="taskName"/>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">类型</label>
                                            <div class="layui-inline" style="margin-top:5px;width:200px;">
                                                <select name="bpncId" id="bpncId_d" lay-verify="required">
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${type}" var="t">
                                                        <option value="${t.bpncId}"> ${t.bpncName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">级别</label>
                                            <div class="layui-inline" style="margin-top:5px;width:170px;">
                                                <select name="levelCode" id="levelCode_d" lay-verify="required">
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${level}" var="t">
                                                        <option value="${t.typecode}"> ${t.typename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">提交人</label>
                                            <div class="layui-input-inline"
                                                 style="margin-right:10px;width:170px;margin-top:5px;">
                                                <input name="createdbyName" id="createdbyName_d" placeholder="请输入"
                                                       autocomplete="off" class="layui-input" type="text">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-top:5px;">
                                        <a class="layui-btn search_btn" data-type="reload" id="searchWXData_d"><i
                                                class="layui-icon"></i>查询</a>
                                    </div>
                                </form>

                                <table class="layui-table" id="businessfiletable_d"
                                       lay-filter="businessfiletable2_d"></table>
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
                                            <div class="layui-input-inline"
                                                 style="margin-right:10px;width:150px;margin-top:5px;">
                                                <input placeholder="任务名称" class="layui-input search_input" type="text"
                                                       id="taskName_s" name="taskName"/>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">类型</label>
                                            <div class="layui-inline" style="margin-top:5px;width:200px;">
                                                <select name="bpncId" id="bpncId_s" lay-verify="required">
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${type}" var="t">
                                                        <option value="${t.ordernum}"> ${t.bpncName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">级别</label>
                                            <div class="layui-inline" style="margin-top:5px;width:170px;">
                                                <select name="levelCode" id="levelCode_s" lay-verify="required">
                                                    <option value="">请选择</option>
                                                    <c:forEach items="${level}" var="t">
                                                        <option value="${t.typecode}"> ${t.typename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">提交人</label>
                                            <div class="layui-input-inline"
                                                 style="margin-right:10px;width:170px;margin-top:5px;">
                                                <input name="createdbyName" id="createdbyName_s" placeholder="请输入"
                                                       autocomplete="off" class="layui-input" type="text">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-top:5px;">
                                        <a class="layui-btn search_btn" data-type="reload" id="searchWXData_s"><i
                                                class="layui-icon"></i>查询</a>
                                    </div>
                                </form>
                                <table class="layui-table" id="businessfiletable_s"
                                       lay-filter="businessfiletable2_s"></table>
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
    <div>
        <a href='javascript:;' class="layui-table-link" target="_blank" onclick=onlineDetails('{{d.taskId}}')>{{d.taskName
            }}</a>
    </div>
</script>

<!--
<script type="text/html" id="bpnc">

<div>

{{# if(d.bpncId =="8a10e4495880d68c015880e2679e0001" ){ }}
制度编制
{{# } else if(d.bpncId == '8a10e4495880d68c01588571a3d80004'){ }}
科技项目
{{# } else if(d.bpncId == '8a10e4495880d68c0158857218e40006'){ }}
基建验收
{{# } else if(d.bpncId == '8a10e4495880d68c0158857257dc0008'){ }}
大修技改
{{# } else if(d.bpncId == '8a10e4495880d68c01588572b137000a'){ }}
巡视巡检
{{# } else if(d.bpncId == '8a10e4495880d68c01588572f788000c'){ }}
故障消缺
{{# } else if(d.bpncId == '8a10e4495880d68c015885732737000e'){ }}
班组建设
{{# } else if(d.bpncId == '8a10e4495880d68c015885735bc50010'){ }}
项目管理
{{# } else if(d.bpncId == '8a10e4495880d68c01588573a3f30012'){ }}
政工宣传
{{# } else if(d.bpncId == '8a10e4495880d68c0158857508cf001c'){ }}
其他
{{# } else if(d.bpncId == "1"){ }}
其他dsdsdsds
{{# } }}
</div>
</script>
-->
<script type="text/html" id="auditcriteria">
    <div>
        {{# if(d.wfStatus == null){ }}
        <a href='javascript:;' style="color:#2195D9" onclick=approveDetail('STORE','{{d.wfId}}','{{d.taskId}}')>创建流程</a>
        {{# } else if(d.wfStatus == 'APPLY'){ }}
        待审批
        {{# } else { }}
        已审批
        {{# } }}
    </div>
</script>


<script type="text/html" id="auditcriteriaapprove">
    <div>
        已审批
    </div>
</script>
<script type="text/html" id="auditcriteriaapply">
    <div>
        <a href='javascript:;' style="color:#2195D9" onclick=approveDetail('STORE','{{d.wfId}}','{{d.taskId}}')>待审核</a>
    </div>
</script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->


<script>


    /*
     function approveDetail1(typeCode,wf_id,task_id){
     // 编辑
     var index = layer.open({
     type: 2,
     content: '${basePath}/taskstore/approveDetail?typeCode='+typeCode+'&wfId='+wf_id+'&objId='+task_id,
     area: ['800px', '500px'],
     maxmin: true,
     resize: true,
     //  end: function () {
     //      table.reload("businessfiletable", {});
     //  }
     });
     parent.layer.iframeAuto(index);
     };
     */
    var table;
    var tableIns;
    layui.use(['form', 'layedit', 'laydate', 'element', 'layer', 'table', 'code'], function () {
        var form = layui.form, layer = layui.layer, element = layui.element, table = layui.table;

        //选项卡点击事件
        element.on('tab(docDemoTabBrief)', function (data) {
            var index = data.index
            if (index == 0) {
                return;
            } else if (index == 1) {//待审核
                table.reload("businessfiletable_d", { // 此处是上文提到的 初始化标识id
                    where: {
                        approveType: '0'
                    },
                    page: {
                        curr: 1
                    }
                });
            } else if (index == 2) {//已审核
                table.reload("businessfiletable_s", { // 此处是上文提到的 初始化标识id
                    where: {
                        approveType: '1'
                    },
                    page: {
                        curr: 1
                    }
                });
            }
        });

        form.render('select');


        // 查询
        $('#searchWXData').on('click', function () {
            table.reload("businessfiletable", { // 此处是上文提到的 初始化标识id
                where: {
                    taskName: $("#taskName_w").val().trim(),
                    bpncId: $("#bpncId_w").val().trim(),
                    levelCode: $("#levelCode_w").val().trim(),
                    createdbyName: $("#createdbyName_w").val().trim(),
                },
                page: {
                    curr: 1
                }
            });
        });
        // 查询
        $('#searchWXData_d').on('click', function () {
            table.reload("businessfiletable_d", { // 此处是上文提到的 初始化标识id
                where: {
                    taskName: $("#taskName_d").val().trim(),
                    bpncId: $("#bpncId_d").val().trim(),
                    levelCode: $("#levelCode_d").val().trim(),
                    createdbyName: $("#createdbyName_d").val().trim(),
                    approveType: '0'
                },
                page: {
                    curr: 1
                }
            });
        });
        // 查询
        $('#searchWXData_s').on('click', function () {
            table.reload("businessfiletable_s", { // 此处是上文提到的 初始化标识id
                where: {
                    taskName: $("#taskName_s").val().trim(),
                    bpncId: $("#bpncId_s").val().trim(),
                    levelCode: $("#levelCode_s").val().trim(),
                    createdbyName: $("#createdbyName_s").val().trim(),
                    approveType: '1'
                },
                page: {
                    curr: 1
                }
            });
        });

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
            if (checkStatus.data.length == 0) {
                parent.layer.msg('请先选择要删除的数据行！', {icon: 2});
                return;
            }
            var ids = "";//选择记录的序号
            for (var i = 0; i < checkStatus.data.length; i++) {
                ids += checkStatus.data[i].bfId + ",";
            }
            var url = '${basePath}/project/delete'
            layer.confirm("您确定要删除吗？" + ids, function () {
                $.ajax({
                    type: "POST",
                    url: '${basePath}/project/delete',
                    data: {"ids": ids},
                    success: function (data) {
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
        tableIns = table.render({
            elem: '#businessfiletable'
            , url: '${basePath}/taskstore/getProjectPage'
            , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增a
            , cols: [[
                {type: 'checkbox'},
                {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                , {field: 'wfId', align: 'center', width: 70}
                , {field: 'taskId', align: 'center', width: 70}
                , {field: 'taskName', title: '任务', templet: '#usernameTpl', hide: true}
                //  , {field: 'bpncId', title: '类型', templet: '#bpnc'}


                , {
                    field: 'bpncId', title: '类型', templet: function (d) {
                        if (d.levelCode == 1) {
                            return "制度编制";
                        } else if (d.levelCode == 2) {
                            return "科技项目";
                        } else if (d.levelCode == 3) {
                            return "基建验收";
                        } else if (d.levelCode == 4) {
                            return "大修技改"
                        } else if (d.levelCode == 5) {
                            return "巡视巡检"
                        } else if (d.levelCode == 6) {
                            return "故障消缺"
                        } else if (d.levelCode == 7) {
                            return "班组建设"
                        } else if (d.levelCode == 8) {
                            return "项目管理"
                        } else if (d.levelCode == 9) {
                            return "政工宣传"
                        } else if (d.levelCode == 0) {
                            return "其他"
                        }

                    }
                }


                , {
                    field: 'levelCode', title: '级别', templet: function (d) {
                        if (d.levelCode == 1) {
                            return "国网";
                        } else if (d.levelCode == 2) {
                            return "省公司";
                        } else if (d.levelCode == 3) {
                            return "公司";
                        } else if (d.levelCode == 4) {
                            return "中心"
                        } else if (d.levelCode == 5) {
                            return "班组"
                        }

                    }
                }


                , {field: 'createdbyName', title: '提交人'}
                , {field: 'remarks', title: '任务描述'}
                , {
                    field: 'right',
                    align: 'center',
                    width: 150,
                    toolbar: '#barDemo',
                    defaultToolbar: ['filter', 'print', 'exports'],
                    title: '操作'
                }, {
                    field: 'right',
                    align: 'center',
                    width: 150,
                    defaultToolbar: ['filter', 'print', 'exports'],
                    title: '审核',
                    templet: '#auditcriteria'
                }
            ]]
            , done: function () {
                $("[data-field='wfId']").css('display', 'none');
                $("[data-field='taskId']").css('display', 'none');
            }
        });


//表格渲染
        table.render({
            elem: '#businessfiletable_d'
            , url: '${basePath}/taskstore/getProjectPage'
            , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 130 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type: 'checkbox'},
                {field: '', align: 'center', width: 170, title: '序号', toolbar: '#indexTpl'}
                , {field: 'wfId', align: 'center', width: 170}
                , {field: 'taskId', align: 'center', width: 170}
                , {field: 'taskName', title: '任务', templet: '#usernameTpl', width: 170}
                , {field: 'bpncId', title: '类型'}
                , {
                    field: 'levelCode', title: '播放器样式', width: 170, templet: function (d) {
                        if (d.levelCode == 1) {
                            return "国网";
                        } else if (d.levelCode == 2) {
                            return "省公司"
                        } else if (d.levelCode == 3) {
                            return "公司"
                        } else if (d.levelCode == 4) {
                            return "中心"
                        } else if (d.levelCode == 5) {
                            return "班组"
                        }
                    }
                }
                , {field: 'createdbyName', title: '提交人', width: 170}
                , {field: 'remarks', title: '任务描述', width: 170}
                , {
                    field: 'right',
                    align: 'center',
                    width: 150,
                    defaultToolbar: ['filter', 'print', 'exports'],
                    title: '审核',
                    templet: '#auditcriteriaapply'
                }
            ]]
            , done: function () {
                $("[data-field='wfId']").css('display', 'none');
                $("[data-field='taskId']").css('display', 'none');
            }
        });

        //表格渲染
        table.render({
            elem: '#businessfiletable_s'
            , url: '${basePath}/taskstore/getProjectPage'
            , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type: 'checkbox'},
                {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                , {field: 'wfId', align: 'center', width: 70}
                , {field: 'taskId', align: 'center', width: 70}
                , {field: 'taskName', title: '任务', templet: '#usernameTpl'}
                , {field: 'bpncId', title: '类型'}
                , {
                    field: 'levelCode', title: '播放器样式', templet: function (d) {
                        if (d.levelCode == 1) {
                            return "国网";
                        } else if (d.levelCode == 2) {
                            return "省公司"
                        } else if (d.levelCode == 3) {
                            return "公司"
                        } else if (d.levelCode == 4) {
                            return "中心"
                        } else if (d.levelCode == 5) {
                            return "班组"
                        }
                    }
                }
                , {field: 'createdbyName', title: '提交人'}
                , {field: 'remarks', title: '任务描述'}
                , {
                    field: 'right',
                    align: 'center',
                    width: 150,
                    //  toolbar: '#barDemo',
                    defaultToolbar: ['filter', 'print', 'exports'],
                    title: '操作',
                    templet: '#auditcriteriaapprove'
                }
            ]]
            , done: function () {
                $("[data-field='wfId']").css('display', 'none');
                $("[data-field='taskId']").css('display', 'none');
            }
        });


        //监听工具条
        table.on('tool(businessfiletable2)', function (obj) {
            var data = obj.data;

            if (obj.event === 'setSign') {

                layer.msg('ID：' + data.id + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
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
            } else if (obj.event === 'edit') {
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


    //流程操作
    function approveDetail(typeCode, wf_id, task_id) {
        var index = layer.open({
            type: 2,
            content: '${basePath}/taskstore/approveDetail?typeCode=' + typeCode + '&wfId=' + wf_id + '&objId=' + task_id,
            area: ['800px', '500px'],
            maxmin: true,
            resize: true,
            end: function () {

                tableIns.reload();


                //  table.reload("businessfiletable", {});
            }
        });
        parent.layer.iframeAuto(index);
    }
    ;

    //点击详细查询
    function onlineDetails(Id) {
        var index = layer.open({
            type: 2,
            content: '${basePath}/taskstore/onlineDetails?id=' + Id,
            area: ['800px', '600px'],
            maxmin: true
        });
        parent.layer.iframeAuto(index);
    }
    ;
</script>