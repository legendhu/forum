
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
				<td><img src="images/header-stretch.gif" alt="" border="0"
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
		<div class="jive-buttons">
			<table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="jive-icon"><a href="post.jsp"><img
								src="images/post-16x16.gif" alt="发表新主题" border="0" height="16"
								width="16"></a></td>
						<td class="jive-icon-label"><a id="jive-post-thread"
							href="<%=basePath%>post.jsp">发表新主题</a> 
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<br>
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td><span class="nobreak"> 共1000页 <span
							class="jive-paginator"> [ <a
								href="#">上一页</a>
								| <a
								href="#"
								class="">1</a> <a
								href="#"
								class="jive-current">2</a> <a
								href="#"
								class="">3</a> <a
								href="#"
								class="">4</a> <a
								href="#"
								class="">5</a> <a
								href="#"
								class="">6</a> | <a
								href="#">下一页</a>
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
									<c:forEach items="${roots}" var="rt" varStatus="vs">
								    <c:if test="${vs.index % 2==0}">
										<tr class="jive-even" >
											<td class="jive-first" nowrap="nowrap" width="1%"><div
													class="jive-bullet">
													<img src="images/read-16x16.gif" alt="已读" border="0"
														height="16" width="16">
													<!-- div-->
												</div></td>
											<td nowrap="nowrap" width="1%">&nbsp; &nbsp;</td>
											<td class="jive-thread-name" width="95%"><a
												id="jive-thread-1"
												href="<%=basePath%>servlet/ArticleDetailFlatServlet?id=${rt.id}">${rt.title}</a></td>
											<td class="jive-author" nowrap="nowrap" width="1%"><span
												class=""> <a
													href="#">${rt.author}</a>
											</span></td>
											<td class="jive-view-count" width="1%">${rt.count}</td>
											<td class="jive-last" nowrap="nowrap" width="1%"><div
													class="jive-last-post">${rt.date}
						<br>
										
												</div></td>
										</tr>
										</c:if>
										<c:if test="${vs.index % 2 != 0}">
										<tr class="jive-odd">
                    <td class="jive-first" nowrap="nowrap" width="1%"><div class="jive-bullet"> <img src="images/read-16x16.gif" alt="已读" border="0" height="16" width="16">
                        <!-- div-->
                      </div></td>
                    <td nowrap="nowrap" width="1%">&nbsp;
                      
                      
                      
                      
                      &nbsp;</td>
                    <td class="jive-thread-name" width="95%"><a id="jive-thread-2" href="<%=basePath%>servlet/ArticleDetailFlatServlet?id=${rt.id}">${rt.title}</a></td>
                    <td class="jive-author" nowrap="nowrap" width="1%"><span class=""> <a href="#">${rt.author}</a> </span></td>
                    <td class="jive-view-count" width="1%"> ${rt.count}</td>
                    <td class="jive-last" nowrap="nowrap" width="1%"><div class="jive-last-post">${rt.date} <br>  </div>
                        
                  </tr>
                
                 </c:if>
										</c:forEach>
										 
                  
										
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
</body>
</html>
