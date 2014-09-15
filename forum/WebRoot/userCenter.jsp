
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>个人中心</title>
 <link rel="shortcot icon" href="images/favicon.ico"/>
<link href="css/base.css" rel="stylesheet" type="text/css"/>
<link href="css/studentCenter.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./register_files/base.js"></script>
<script type="text/javascript" src="./register_files/lianzhui.js"></script>
<script type="text/javascript" src="./register_files/lianzhui_drag.js"></script>
<script type="text/javascript" src="./register_files/ajax.js"></script>
<!--[if lt IE 7]>
<script type="text/javascript" src="js/ltIE7hack.js"></script>
<![endif]-->
<script type="text/javascript" src="./register_files/kuangjia.js"></script>
<script type="text/javascript" src="./register_files/studentCenter.js"></script>
</head>

<body>

<div id="main_center_box">
  <div id="header">
    <div class="logo"><img src="./register_files/logo.png" alt="信管论坛" /></div>
    
   </div>
  
  <!--内容区域-->
  <div class="content">
    <div class="self-info-box">
      <div class="self-info">
        <div class="head-phto"> 
        <c:if test="${user.photo ne null}">
         	 <img src="${user.photo}" alt="${user.username}" title="${user.username}"/> 
          	</c:if>
          	<c:if test="${user.photo eq null}">
          	 <img src="images/default.jpg" alt="${user.username}" title="${user.username}"/> 
          	</c:if>
        </div>
      </div>
    </div>
    <div class="info-show">
      <div class="self-info-nav">
        <h2>个人选项</h2>
        <ul class="self-info-put">
          <li>修改基本信息</li>
          <li>修改头像</li>
          <li>修改密码</li>
        </ul>
      </div>
        
       
      <!--个人信息-->
      <div class="gerenxinxi card">
        <h2>个人信息</h2>
        <div id="gerenxinxi-box">
          <form name="register-teacher" action="<%=basePath%>servlet/ChangeInfoServlet" method="post">
            <div>
              <label for="truename">真实姓名：</label>
              <input id="truename" name="truename" type="text" />
	</div>
            <div>
              <label for="tzhuce_email">电子邮件：</label>
              <input id="tzhuce_email" name="zhuce_email" type="text" autocomplete="off" />
              <ul class="all_email">
                <li><span></span>@qq.com</li>
                <li><span></span>@163.com</li>
                <li><span></span>@sohu.com</li>
                <li><span></span>@sina.com.cn</li>
                <li><span></span>@gmail.com</li>
                <li><span></span>@126.com</li>
              </ul>
              <span class="info info_email">请输入电子邮件！</span> <span class="error error_email">邮件不合法，请重新输入！</span> <span class="succ succ_email">可用</span> </div>
            <div>
              <label for="ttel-num">手机号码：</label>
              <input id="ttel-num" name="tel-num" type="tel" />
              <span class="info info_tel">请输入手机号码！</span> <span class="error error_tel">号码不合法，请重新输入！</span> <span class="succ succ_tel">可用</span> </div>
            <div>
              <input  style="background:url(images/anniu1.png) no-repeat left top; width:102px; height:42px; border:none; margin-left:190px; cursor:pointer; font:bold 18px/42px '微软雅黑'; color:#fff;" type="button" name="sub" value="确认修改"/>
            </div>
          </form>
        </div>
      </div>
      <!--修改头像-->
      <div class="xiugaitouxiang card">
        <iframe name="iframe1" style="display:none;" frameborder="0" scrolling="no"></iframe>
        <h2>修改头像</h2>
        <div id="head-photo-see">
        <c:if test="${user.photo ne null}">
         <img  id="himage1" src="${user.photo}" alt="${user.username}" title="${user.username}"/> 
        </c:if>
        <c:if test="${user.photo eq null}">
         <img id="himage1"  src="images/default.jpg" alt="${user.username}" title="${user.username}"/> 
        </c:if>
        </div>
        <form  id="photo-send" class="photo-send" name="photo-send" _action="<%=basePath%>servlet/UpLoadServlet" action="<%=basePath%>servlet/ViewHeadServlet" target="iframe1" method="post" enctype="multipart/form-data">
         <div class="xiugai-input" style="position:relative;">
            <input name="selected-photo" id="selected-photo" type="file"/>
            <input class="" type="button" value="选择头像" />
            <p> 请尽量选择比例为1:1的图片，图片大小不能超过2M。 </p>
          </div>
          <div class="xiugai-input">
            <input type="button" id="touxiangfasong" value="保存" />
            <input type="button" id="fasongquxiao" value="取消" />
          </div>
        </form>
      </div>
      <!--修改密码-->
      <div class="xiugaimima card">
        <h2>修改密码</h2>
        <form id="xiugaimimaform" action="<%=basePath%>servlet/ChangePassServlet" name="xiugaimimaform" class="xiugaimimaform" >
          <div>
            <label for="yuashimima">当前密码：</label>
            <input id="yuashimima" name="yuashimima" type="password" value=""/>
          </div>
          <div>
            <label for="gaihoumima">新密码：</label>
            <input id="gaihoumima" name="gaihoumima" type="password" value=""/>
            <span class="info info_pass">
            <p>安全级别：<strong class="anquan anquan1">■</strong><strong class="anquan anquan2">■</strong><strong class="anquan anquan3">■</strong></strong><strong class="anquan anquan4" style="font-weight:normal;"></strong></p>
            <p><strong class="quan1" style="font-weight:normal;">○</strong> 6-20 个字符</p>
            <p><strong class="quan2" style="font-weight:normal;">○</strong> 只能包含大小写字母、数字和非空格字符</p>
            <p><strong class="quan3" style="font-weight:normal;">○</strong> 大、小写字母、数字、非空字符，2种以上</p>
            </span> <span class="error error_pass">输入不合法，请重新输入！</span> <span class="succ succ_pass">可用</span> </div>
          <div>
            <label for="querengaihoumima">确认新密码：</label>
            <input id="querengaihoumima" name="querengaihoumima" type="password" value=""/>
            <span class="info info_sure">请再一次输入密码！</span> <span class="error error_sure">密码不一致，请重新输入！</span> <span class="succ succ_sure">可用</span> </div>
          <div class="queren-box">
            <input type="button" name="xiugaitijiao" class="xiugaitijiao" value="确认修改"/>
          </div>
        </form>
        <div class="xiugai_wait"></div>
      </div>
      <!--设置密码保护-->
          
      </div>
      <div style="clear:both"></div>
    </div>
  </div>
  <div id="footer">
    <p><a href="#">友情帮助</a> | <a href="#">意见反馈</a> | <a href="#">开放平台</a> | <a href="#">网站地图</a><br />
      <a href="#">合作伙伴</a> | <a href="#">诚招英才</a> | <a href="#">法律声明</a><br />
      版权所有@胡传奇 | <a href="#">团队简介</a> | <a href="#">后台管理</a> </p>
  </div>
    </div>

<div id="screen"></div>
<div id="back_top">返回顶部</div>
</body>
</html>