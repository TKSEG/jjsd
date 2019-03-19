<%@ include file="/WEB-INF/views/user/tag.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-xs12">
            <div class="layui-card">
                <div class="layui-card-header">工程资料管理</div>
                <!--这里写页面的代码-->
                <div class="layui-card-body">
                    <div class="demoTable">
                        <div class="layui-form" >
                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label class="layui-form-label">资料名称</label>
                                    <div class="layui-input-inline">
                                        <input  id="bfname"    placeholder="请输入角色名称" autocomplete="off" class="layui-input" type="text">
                                    </div>
                                </div>
                                <div class="layui-inline">
                                    <label class="layui-form-label">资料分类</label>
                                    <div class="layui-input-inline">
                                        <select name="bftype"  id="bftype"    lay-verify="required"  >
                                            <option value="">请选择</option>
                                            <c:forEach items="${type}" var="t">
                                                <option value="${t.typecode}" > ${t.typename}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-inline">
                                    <label class="layui-form-label">上传时间</label>
                                    <div class="layui-input-inline">
                                        <input name="uploadtime"   id="uploadtime"     placeholder="请输入" autocomplete="off" class="layui-input" type="text">
                                    </div>
                                </div>
                                <button class="layui-btn"  data-type="reload"   >搜索</button>
                            </div>
                        </div>
                    </div>

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

    <div><a href='javascript:;'  class="layui-table-link" target="_blank" onclick=onlineDetails('{{d.bfId}}') >{{ d.bfName }}</a></div>



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



    layui.use(['form', 'layedit', 'table', 'laydate'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;


        form.render("select",function(data){
            $('#bfType').val(data.value);
        });

        //搜索 ----------------------------------------------- Begin-----------------------------------------------------------
        var $ = layui.$, active =
        {
            reload: function () {

                var bfname = $('#bfname').val();//获取输入框的值
                var bftype = $('#bftype').val();//获取输入框的值
                var uploadtime = $('#uploadtime').val();//获取输入框的值
                //执行重载
                table.reload('businessfiletable',
                        {
                            page:
                            {
                                curr: 1 //重新从第 1 页开始
                            }
                            ,where : {name: bfname,type:bftype,datetime:uploadtime}
                            , url: '${basePath}/businessfile/querybusinessfile'//后台做模糊搜索接口路径
                            , method: 'post'
                        });
            }
        };


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
                content: '${basePath}/businessfile/goAdd',
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
            , url: '${basePath}/businessfile/getProjectPage'
            , method: 'post'
            , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']}
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type:'checkbox'},
                {field: '', align: 'center', width: 70, title: '序号', toolbar: '#indexTpl'}
                , {field: 'bfId', align: 'center', width: 70}
              //  , {field: 'bfName', title: '资料名称'}
                , {field: 'bfName', title: '资料名称',templet: '#usernameTpl'}
                , {field: 'type', title: '资料分类'}
                , {field: 'authorId', title: '上传人ID',hidden:'true'}
                , {field: 'authorName', title: '上传人'}
                , {field: 'uploadTime', title: '上传时间',width: 170}
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
                $("[data-field='bfId']").css('display','none');
                $("[data-field='authorId']").css('display','none');
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
                    $.post("${basePath}/businessfile/del", {"id": data.bfId}, function (data) {
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
                    content: '${basePath}/businessfile/goUpdate?id=' + data.bfId,
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