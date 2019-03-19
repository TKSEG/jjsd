<%@ include file="/WEB-INF/views/user/tag.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-xs12">
            <div class="layui-card">
                <div class="layui-card-header">岗位管理</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="">
                        <div class="layui-inline">
                            <div class="layui-inline">
                                <label class="layui-form-label">岗位名称</label>
                                <div class="layui-input-inline"
                                     style="margin-right:10px;width:150px;margin-top:5px;">
                                    <input placeholder="任务名称" class="layui-input search_input" type="text"
                                           id="wpName_w" name="wpName"/>
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
                    wpName: $("#wpName_w").val().trim(),
                },
                page: {
                    curr: 1
                }
            });
        });


        //让层自适应iframe
        //添加
        $('#add').on('click', function () {
            var index =
                    top.layer.open({
                        type: 2,
                        content: '${basePath}/work/getadd',
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
            , url: '${basePath}/work/getWorkPage'
            , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type: 'checkbox'},
                {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                , {field: 'wpId', align: 'center', width: 70}
                , {field: 'wpName', title: '岗位名称'}
                , {field: 'leve1Score', title: 'A角标准分'}
                , {field: 'leve2Score', title: 'B角标准分'}
                , {field: 'leve3Score', title: '后备标准分'}
                , {field: 'remarks', title: '备注 ', width: 170}
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
                $("[data-field='wpId']").css('display', 'none');

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
                    $.post("${basePath}/work/del", {"id": data.wpId}, function (data) {
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
                    content: '${basePath}/work/getupdate?id=' + data.wpId,
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