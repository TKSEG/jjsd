<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <meta charset='UTF-8'>
    <meta name='Author' content='wanghua'>
    <title>Test Layui2 use iframe</title>
<link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/theme/default.css" id="theme">
<link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/kitadmin.css" id="kitadmin">
<link rel="stylesheet" href="${basePath}/css/doc.css">
<link rel="stylesheet" href="${basePath}/plugins/kitadmin/css/layui.css" id="layui">
</head>
<body>

<div class='layui-container' style='margin-top:15px'>
    <div class='layui-form'>
        <div class='layui-form-item'>
            <label class='layui-form-label'>ID</label>
            <div class='layui-input-block'>
                <input type='text' id='uid' value='' class='layui-input' placeholder='一会儿会得到iframe弹窗中选中的 user_id'/><br>
            </div>
        </div>
        <div class='layui-form-item'>
            <div class='layui-input-block'>
                <input type='button' value=' 打开iframe弹窗 ' id='btn_test' class='layui-btn'/>
            </div>
        </div>
    </div>
</div>
<script src="${basePath}/js/jquery.js"></script>
<script src="${basePath}/plugins/kitadmin/layui.js"></script>
<script type='text/javascript'>
    layui.use('layer', function(){
        var layer = layui.layer, $ = layui.jquery;


        $('#btn_test').on('click', function() {
            layer.open({
                type: 2,
                title: '新增',
                btn: ['确定', '取消'],
                area: ['500px', '330px'],
                fixed: false,
                content: '${basePath}/team/taskSelect',

                yes: function(index, layero) {
                    debugger;
                    uid.value = $(layero).find('iframe')[0].contentWindow.user_id.value; //将子窗口中的 user_id 抓过来
                    layer.close(index); //关闭弹窗
                },
                btn2: function(index) {
                    debugger;
                    layer.close(index);
                },
                success: function(layero, index) {
                    debugger;
                    var obj = $(layero).find('iframe')[0].contentWindow;
                    //定义表格行的双击处理
                    $(obj.example).find('tbody tr').dblclick(function(e){
                        $('.layui-layer-btn0').click(); //触发'确定'按钮单击事件
                    });
                }
            });
        });
    });
</script>

</body>
</html>