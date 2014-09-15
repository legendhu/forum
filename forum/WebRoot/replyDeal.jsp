
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

 <script language="JavaScript1.2" type="text/javascript">
<!--
//  Place this in the 'head' section of your page.  

function delayURL(url) {
	var delay = document.getElementById("time").innerHTML;
	if(delay>1){
		delay--;
		document.getElementById("time").innerHTML = delay;
	}else{
		window.top.location.href=url;
	}
	
    setTimeout("delayURL('"+url+"')", 1000);
}

//-->
</script>

<!-- Place this in the 'body' section -->
注册成功，<span id="time" style="background:red">5</span>秒后自动跳转，如果不跳转，请点击下面的链接！
<a href="<%=basePath%>register.jsp">重新注册</a>
<script type="text/javascript">
delayURL("<%=basePath%>index.jsp");
</script>
    

