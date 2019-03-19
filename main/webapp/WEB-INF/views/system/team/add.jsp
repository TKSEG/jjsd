<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>角色添加</title>
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/theme/default.css" id="theme">
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/kitadmin.css" id="kitadmin">
    <link rel="stylesheet" href="${basePath}/css/doc.css">
    <link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/layui.css" id="layui">
</head>
<body>
<div class='layui-container' style='margin-top:15px'>
    <div class="layui-form layui-form-pane">
        <div class="layui-form-item">


            <label class="layui-form-label">班组名称</label>
            <div class="layui-input-block">
                <input name="tName" id="tName" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">组长</label>
                <div class="layui-input-inline" style="margin-right:10px;width:400px;margin-top:5px;">
                    <input placeholder="组长id" class="layui-input search_input" type="text" id="tLeadId"
                           style="display:none" name="tLeadId"/>
                    <input placeholder="组长" class="layui-input search_input" type="text" id="tLead"
                           name="tLead"/>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline" style="width:70px;margin-top:5px;">
                    <button class="layui-btn" id="btn_tlead"><i class="layui-icon">&#xe615;</i>选择</button>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline" style="width:70px;margin-top:5px;">
                    <button class="layui-btn"><i class="layui-icon">&#xe669;</i>重置</button>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">组员</label>
                <div class="layui-input-inline" style="margin-right:10px;width:400px;margin-top:5px;">
                    <input placeholder="组员id" class="layui-input search_input" type="text" id="teamsid"
                           style="display:none" name="teamsid"/>
                    <input placeholder="组员" class="layui-input search_input" type="text" id="teams"
                           name="teams"/>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline" style="width:70px;margin-top:5px;">
                    <button class="layui-btn" id="btn_teams"><i class="layui-icon">&#xe615;</i>选择</button>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline" style="width:70px;margin-top:5px;">
                    <button class="layui-btn"><i class="layui-icon">&#xe669;</i>重置</button>
                </div>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input name="remarks" id="remarks" lay-verify="required" placeholder="请输入班组名称" autocomplete="off"
                       class="layui-input" type="text">
            </div>
        </div>


        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
        </div>

    </div>
</div>


<script src="${basePath}/js/jquery.js"></script>
<script src="${basePath}/plugins/kitadmin/layui.js"></script>

<script>

    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var form = layui.form, layer = layui.layer;
        var table = layui.table;
        $ = layui.jquery;

        $('#btn_tlead').on('click', function () {
            layer.open({
                type: 2,
                title: '新增',
                btn: ['确定', '取消'],
                area: ['500px', '500px'],
                fixed: false,
                content: '${basePath}/team/selectUser?type=' + 1,
                yes: function (index, layero) {
                    var obj = $(layero).find('iframe')[0].contentWindow.layui.table.checkStatus('example');
                    $("#tLead").val(obj.data[0].username);
                    $("#tLeadId").val(obj.data[0].id);
                    layer.close(index); //关闭弹窗
                },
                btn2: function (index) {
                    layer.close(index);
                },
                success: function (layero, index) {
                }
            });
        });

        $('#btn_teams').on('click', function () {
            layer.open({
                type: 2,
                title: '新增',
                btn: ['确定', '取消'],
                area: ['500px', '500px'],
                fixed: false,
                content: '${basePath}/team/selectUser?type=' + 2,
                yes: function (index, layero) {
                    var obj = $(layero).find('iframe')[0].contentWindow.layui.table.checkStatus('example');
                    var team_s = "";
                    var team_s_id = "";
                    for (var i = 0; i < obj.data.length; i++) {
                        team_s += obj.data[i].username + ",";
                        team_s_id += obj.data[i].id + ",";
                    }
                    team_s = team_s.substring(0, team_s.length - 1);
                    team_s_id = team_s_id.substring(0, team_s_id.length - 1);
                    $("#teams").val(team_s);
                    $("#teamsid").val(team_s_id);
                    layer.close(index); //关闭弹窗
                },
                btn2: function (index) {
                    layer.close(index);
                },
                success: function (layero, index) {
                }
            });
        });


        //监听提交，发送请求
        form.on('submit(add)', function (data) {
            $.post("${basePath}/team/add", data.field, function (data) {
                // 获取 session
                if (data.status != 200) {
                    layer.alert(data.message, {offset: 't', icon: 2});
                }
                if (data.status == 200) {
                    layer.alert(data.message, {offset: 't', icon: 1}, function (index) {
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
