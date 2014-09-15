
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信管论坛注册页面</title>
  <link href="<%=basePath%>css/base.css" rel="stylesheet">
<link href="<%=basePath%>css/register.css" rel="stylesheet">
<script type="text/javascript" src="./register_files/base.js"></script>
<script type="text/javascript" src="./register_files/lianzhui.js"></script>
<script type="text/javascript" src="./register_files/ajax.js"></script>
<script type="text/javascript" src="./register_files/lianzhui_drag.js"></script>
<!--[if lt IE 7]>
<script type="text/javascript" src="js/ltIE7hack.js"></script>
<![endif]-->
<script type="text/javascript" src="./register_files/kuangjia.js"></script>
<script type="text/javascript" src="./register_files/register.js"></script>
</head>

<body id="home">
<div id="main_box">
  <div id="main_center_box">
    <div id="header">
      <div class="logo"><img src="./register_files/logo.png" alt="信管论坛"></div>
      <div class="login_user"><em class="login_user_denglu">登陆</em> | <a class="login_user_zhuce" href="#">注册</a></div>
      
    </div>
    <div id="nav"></div>
    <!--内容区域-->
<div class="content">
<div class="primary">
<div class="welcome"></div>

<div id="register-teacher">
<form name="register-teacher" action="<%=basePath%>servlet/RegisterServlet" method="post">
<input type="hidden" name="formnum01" value="formnum">
<!-- 防止表单重复提交标签 -->
<input type="hidden" name="thtoken" value="c092c656-5152-4637-ad3b-fd874321c37a">
<div>
<label for="tzhuce_user">用 户 名：</label><input id="tzhuce_user" name="zhuce_user" type="text">
<span class="info info_user">请输入用户名，4~20 位，由字母、数字和下划线组成！</span>
<span class="error error_user">输入不合法，请重新输入！</span>
<span class="succ succ_user">可用</span>
<span class="user_wait"></span>
<span class="error error_repeat">此用户名已被注册！</span>
</div>
<div>
<label for="tzhuce_mima">密　　码：</label><input id="tzhuce_mima" name="zhuce_mima" type="password">
<span class="info info_pass">
<p>安全级别：<strong class="anquan anquan1">■</strong><strong class="anquan anquan2">■</strong><strong class="anquan anquan3">■</strong><strong class="anquan anquan4" style="font-weight:normal;"></strong></p>
<p><strong class="quan1" style="font-weight:normal;">○</strong> 6-20 个字符</p>
<p><strong class="quan2" style="font-weight:normal;">○</strong> 只能包含大小写字母、数字和非空格字符</p>
<p><strong class="quan3" style="font-weight:normal;">○</strong>  大、小写字母、数字、非空字符，2种以上</p>
</span>
<span class="error error_pass">输入不合法，请重新输入！</span>
<span class="succ succ_pass">可用</span>
</div>
<div>
<label for="tquerenmima">确认密码：</label><input id="tquerenmima" name="querenmima" type="password">
<span class="info info_sure">请再一次输入密码！</span>
<span class="error error_sure">密码不一致，请重新输入！</span>
<span class="succ succ_sure">可用</span>
</div>
<div>
<label>性　　别：</label><label class="sex" for="men">男</label><input name="sex" id="men" type="radio" checked="checked" value="男"><label class="sex" for="female">女</label><input name="sex" id="female" type="radio" value="女">
</div>
<div>
<label for="teducation_bg">主修专业：</label><select id="teducation_bg" name="education_bg">
<option value="0">- - - - 请选择 - - - -</option>
<option value="电子商务">- - - - 电子商务 - - - -</option>
<option value="信息管理与信息系统">- - - - 信息管理与信息系统 - - - -</option>
<option value="图书馆学">- - - - 图书馆学 - - - -</option>
<option value="编辑出版学">- - - - 编辑出版学 - - - -</option>
<option value="档案学">- - - - 档案学 - - - -</option>
</select>
<span class="error error_bg">请选择专业！</span>
</div>
<div>
<label for="tgraduate"></label>
</div>
<div>
<label for="tzhuce_email">电子邮件：</label><input id="tzhuce_email" name="zhuce_email" type="text" autocomplete="off">
	<ul class="all_email">
      	<li><span></span>@qq.com</li>
		<li><span></span>@163.com</li>
		<li><span></span>@sohu.com</li>
		<li><span></span>@sina.com.cn</li>
		<li><span></span>@gmail.com</li> 
            <li><span></span>@126.com</li> 
	</ul>
<span class="info info_email">请输入电子邮件！</span>
<span class="error error_email">邮件不合法，请重新输入！</span>
<span class="succ succ_email">可用</span>
</div>
<div>
<label for="ttel-num">手机号码：</label><input id="ttel-num" name="tel-num" type="tel">
<span class="info info_tel">请输入手机号码！</span>
<span class="error error_tel">号码不合法，请重新输入！</span>
<span class="succ succ_tel">可用</span>
</div>
<div>

</div>
<p class="word_over" style="display:none;margin:10px 0;">已超出<span style="color:red;font-weight:bold; font-size:16px;"></span>字　<span style="color:blue; cursor:pointer;">清理</span></p>
<div><input style="background:url(images/reg.png) no-repeat left top; width:143px; height:33px; border:0; margin-left:150px; cursor:pointer;" type="button" name="sub"></div>
</form>
</div>
</div>
<div style="clear:both;"></div>
    <div id="footer">
      <p><a href="#">常见问题</a> | <a href="mailto:netservice@bk.ru">意见反馈</a> | <a href="#">开放平台</a> | <a href="#">网站地图</a><br>
        <a href="#">合作伙伴</a> | <a href="#">诚招英才</a> | <a href="#">法律声明</a><br>
            版权所有@胡传奇| <a href="#">团队简介</a> | <a href="#">后台管理</a> </p>
    </div>
  </div>
</div>
<!--主体外布局-->
<div class="login_box">
  <h1 id="tuodong">用户登录<img src="./register_files/close.png" alt="关闭" title="关闭" width="14" height="14"></h1>
  <form name="login" action="<%=basePath%>servlet/LoginServlet" method="post">
    <div>
      <label for="login_user">用户名：</label>
      <input class="login_text" id="login_user" name="login_user" type="text">
    </div>
    <div>
      <label for="login_pass">密码：</label>
      <input class="login_text" id="login_pass" name="login_pass" type="password">
    </div>
    <div>
      <input class="login_butt" name="sub" type="button">
      <p><a href="http://localhost:8080/translation/shasha/getque.html">忘记密码</a> | <a href="./register_files/register.htm">免费注册</a></p>
    </div>
    <div class="login_wait"></div>
  </form>
</div>
<div id="screen"></div>
<div id="back_top" style="display: none; ">返回顶部</div>


</div></body></html>