<%@ include file="/WEB-INF/views/user/tag.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-xs12">
            <div class="layui-card">
                <div class="layui-card-header">我的申请列表</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="">
                        <div class="layui-inline">
                            <label class="layui-form-label">申请类型</label>
                            <div class="layui-inline" style="margin-top:5px;width:170px;">
                                <select name="applyType" id="applyType_w" lay-verify="required">
                                    <option value="">请选择</option>
                                    <c:forEach items="${type}" var="t">
                                        <option value="${t.typecode}"> ${t.typename}</option>
                                    </c:forEach>
                                </select>
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
                        </shiro:hasPermission>
                        <a href="javascript:;" class="layui-btn layui-btn-xs layui-btn-primary"
                           id="rhqvf8w5t6q8">
                            <i class="layui-icon"></i>
                        </a>
                    </div>

                    <table class="layui-table" id="businessfiletable" lay-filter="businessfiletable2"></table>
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

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;

        // 查询
        $('#searchWXData').on('click', function () {
            table.reload("businessfiletable", { // 此处是上文提到的 初始化标识id
                where: {
                    applyType: $("#applyType_w").val().trim(),
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
                content: '${basePath}/extrawork/getad',
                shade: 0,
                area: ['900px', '600px'],
                fixed: false, //不固定
                maxmin: false,
                shade: 0,
                end: function () {
                    table.reload("businessfiletable", {});
                }
            });
            parent.layer.iframeAuto(index);
        });

        //表格渲染
        table.render({
            elem: '#businessfiletable'
            , url: '${basePath}/extrawork/getExtraworkPage'
            , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type: 'checkbox'},
                {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                , {field: 'ewId', align: 'center', width: 70}
                , {field: 'wfId', align: 'center', width: 70}
                , {field: 'auser_id', title: '申请人'}
                //, {field: 'applyType', title: '申请类型'}


                , {
                    field: 'applyType', title: '申请类型', templet: function (d) {
                        if (d.applyType == 1) {
                            return "加班";
                        } else if (d.levelCode == 2) {
                            return "调休"
                        } else if (d.levelCode == 3) {
                            return "事假"
                        } else if (d.levelCode == 4) {
                            return "病假"
                        }
                    }
                }


                , {field: 'startTime', title: '开始时间'}
                , {field: 'endTime', title: '结束时间'}
                , {field: 'hours', title: '时长'}
                //   , {field: 'apply_time', title: '申请时间'}
                //   , {field: 'tstatus', title: '审核状态'}
                , {
                    field: 'right',
                    align: 'center',
                    width: 150,
                    toolbar: '#barDemo',
                    defaultToolbar: ['filter', 'print', 'exports'],
                    title: '操作'
                }
            ]]
            , done: function () {
                $("[data-field='ewId']").css('display', 'none');
                $("[data-field='wfId']").css('display', 'none');
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
                    $.post("${basePath}/extrawork/del", {"id": data.ewId}, function (data) {
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
                    content: '${basePath}/extrawork/getupdate?id=' + data.ewId,
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