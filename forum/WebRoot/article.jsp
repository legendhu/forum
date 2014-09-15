
<%@ page language="java" import="java.util.*,com.xxcyjd.domain.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>
<base href="<%=basePath%>">
<title>信息管理学院创业基地论坛</title>
<link href="<%=basePath%>css/base.css" rel="stylesheet">
<script type="text/javascript" src="./register_files/base.js"></script>
<script type="text/javascript" src="./register_files/lianzhui.js"></script>
<script type="text/javascript" src="./register_files/lianzhui_drag.js"></script>
<script type="text/javascript" src="./register_files/ajax.js"></script>

<script type="text/javascript" src="./register_files/kuangjia.js"></script>
<link rel="stylesheet" type="text/css" href="images/style.css"
	title="Integrated Styles">
<script language="JavaScript" type="text/javascript"
	src="images/global.js"></script>
<script language="JavaScript" type="text/javascript"
	src="images/common.js"></script>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody>
			<tr>
				<td width="140"><a href="#"><img
						src="images/logo.png" alt="信管论坛" border="0"></a></td>
				<td><img src="images/header-stretch.gif" alt="信管论坛" border="0"
					height="57" width="100%"></td>
				<td width="1%"><img src="images/header-right.gif" alt=""
					border="0"></td>
			</tr>
		</tbody>
	</table>
	<br>
	<div id="jive-forumpage">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="98%"><p class="jive-breadcrumbs">论坛:
							黑龙江大学信息管理学院创业基地</p>
						<p class="jive-description">友情提示：仅限黑龙江大学信息管理学院创业基地同学探讨学习！杜绝恶意言论。。。</p>
					</td>
				</tr>
			</tbody>
		</table>
	  
      
      <div class="login_user" style="float:right"><em class="login_user_denglu">登录</em> | <a class="login_user_zhuce" href="<%=basePath%>register.jsp">注册</a></div>
      
		<div class="jive-buttons">
			<table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="jive-icon"><a href="post.jsp"><img
								src="images/post-16x16.gif" alt="发表新主题" border="0" height="16"
								width="16"></a></td>
						<td class="jive-icon-label"><a id="jive-post-thread"
							href="<%=basePath%>post.jsp">发表新主题</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<br>
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td><span class="nobreak"> 共[${page.totalpage}]页 <span
							class="jive-paginator"> [ <a href="<%=basePath%>index.jsp?pagenum=${page.pagenum -1}">上一页</a> | 
								<c:forEach begin="${page.forEachBegin}" end="${page.forEachEnd}" var="pagenum">
		          <a href="<%=basePath%>index.jsp?pagenum=${pagenum}"  <c:if test="${page.pagenum eq pagenum}"></c:if>>${pagenum}</a>
		    </c:forEach>
								| <a href="<%=basePath%>index.jsp?pagenum=${page.pagenum +1}">下一页</a>
								]
						</span>
					</span></td>
				</tr>
			</tbody>
		</table>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="99%"><div class="jive-thread-list">
							<div class="jive-table">
								<table summary="List of threads" cellpadding="0" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<th class="jive-first" colspan="3">主题</th>
											<th class="jive-author"><nobr> 作者 &nbsp; </nobr></th>
											<th class="jive-msg-count" nowrap="nowrap">回复</th>
											<th class="jive-last" nowrap="nowrap">发帖时间</th>
										</tr>
									</thead>
									<tbody>

										<%
											List<Article> articles = (List<Article>) session.getAttribute("articles");
											for (Iterator<Article> it = articles.iterator(); it.hasNext();) {
												Article a = it.next();
												String preStr = "";
												for (int i = 0; i < a.getGrade(); i++) {
													preStr += "----";
												}
										%>


										<tr class="jive-even">
											<td class="jive-first" nowrap="nowrap" width="1%"><div
													class="jive-bullet">
													<img src="images/read-16x16.gif" alt="已读" border="0"
														height="16" width="16">
													<!-- div-->
												</div></td>
											<td nowrap="nowrap" width="1%">&nbsp; &nbsp;</td>
											<td class="jive-thread-name" width="95%"><a
												id="jive-thread-1"
												href="<%=basePath%>servlet/ArticleDetailServlet?id=<%=a.getId()%>">
													<%=preStr + a.getTitle()%></a></td>
											<td class="jive-author" nowrap="nowrap" width="1%"><span
												class=""> <a
													href="#"><%=a.getAuthor()%></a>
											</span></td>
											<td class="jive-view-count" width="1%"><%=a.getCount()%></td>
											<td class="jive-last" nowrap="nowrap" width="1%"><div
													class="jive-last-post">
													<%=a.getDate()%>
													<br>

												</div></td>
										</tr>
										<%
											}
										%>


									</tbody>
								</table>
							</div>
						</div>
						<div class="jive-legend"></div></td>
				</tr>
			</tbody>
		</table>
		<br> <br>
	</div>
	<!-- 登录弹出框 -->
<div class="login_box">
  <h1 id="tuodong">用户登录<img src="./register_files/close.png" alt="关闭" title="关闭" width="14" height="14"></h1>
  <form id="login-form" name="login" action="<%=basePath%>servlet/LoginServlet" method="post">
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
      <p><a href="#">忘记密码</a> | <a href="./register_files/register.htm">免费注册</a></p>
    </div>
    <div class="login_wait"></div>
  </form>
</div>
 <div id="footer">
    <p><a href="#">友情帮助</a> | <a href="#">意见反馈</a> | <a href="#">开放平台</a> | <a href="#">网站地图</a><br />
      <a href="#">合作伙伴</a> | <a href="#">诚招英才</a> | <a href="#">法律声明</a><br />
      版权所有@胡传奇 | <a href="#">团队简介</a> | <a href="<%=basePath%>login_back.jsp">后台管理</a> </p>
  </div>
</body>
</html>

