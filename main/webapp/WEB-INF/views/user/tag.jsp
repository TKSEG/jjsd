<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script src="<%=basePath%>/js/jquery.js"></script>
<script src="<%=basePath%>/js/MD5.js"></script>
<link rel="stylesheet" href="<%=basePath%>/plugins/kitadmin/css/login.css">

<!--<script src="<%=basePath%>/plugins/kitadmin/layui.js"></script>-->
<!--<script src="<%=basePath%>/plugins/laydate/laydate.js"></script>-->


