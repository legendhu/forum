
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
int id = Integer.parseInt(request.getParameter("id"));
int rootId =Integer.parseInt(request.getParameter("rootId"));

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <title>信息管理学院论坛</title>
<link rel="stylesheet" type="text/css" href="images/style.css" title="Integrated Styles">
<script language="JavaScript" type="text/javascript" src="images/global.js"></script>
 <script src="<%=basePath%>ckeditor/ckeditor.js"></script>
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td width="140"><a href="#"><img src="images/logo.png" alt="信管论坛" border="0"></a></td>
      <td><img src="images/header-stretch.gif" alt="信管论坛" border="0" height="57" width="100%"></td>
      <td width="1%"><img src="images/header-right.gif" alt="信管论坛" border="0"></td>
    </tr>
  </tbody>
</table>
<br>
<div id="jive-flatpage">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="99%"><p class="jive-breadcrumbs"> <a href="<%=basePath%>index.jsp">首页</a> &#187; <a href="http://210.46.102.123">黑龙江大学</a> &#187; <a href="<%=basePath%>index.jsp">信息管理学院创业基地论坛</a> &#187;  </p> <p class="jive-page-title"> 回复主题 </p></td>
        <td width="1%"><div class="jive-accountbox"></div></td>
      </tr>
    </tbody>
  </table>
  <div class="jive-buttons">
    <table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
      <tbody>
        
      </tbody>
    </table>
  </div>
  <br>
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="99%"><div id="jive-message-holder">
            <div class="jive-message-list">
              <div class="jive-table">
                <div class="jive-messagebox">
                	<form action="<%=basePath%>servlet/ReplyDealServlet" method="post">
                		<input type="hidden" name="pid" value="<%=id%>" />
                		<input type="hidden" name="rootId" value="<%=rootId%>" />
                		标题：<input type="text" name="title"><br/>
                		内容：<textarea rows="15" cols="80" name="content" id="editor1"></textarea>
                		 <script>
                CKEDITOR.replace( 'editor1' );
            </script>
                		<input type="submit" value="提交">
                		<input type="reset" value="重置">
                	</form> 
           
                </div>
              </div>
            </div>
            <div class="jive-message-list-footer">
              <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody>
                  <tr>
                    <td nowrap="nowrap" width="1%"></td>
                    <td align="center" width="98%"><table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                          <tr>
                            <td><a href="<%=basePath%>index.jsp"><img src="images/arrow-left-16x16.gif" alt="返回到主题列表" border="0" height="16" hspace="6" width="16"></a> </td>
                            <td><a href="<%=basePath%>index.jsp">返回到主题列表</a> </td>
                          </tr>
                        </tbody>
                      </table></td>
                    <td nowrap="nowrap" width="1%">&nbsp;</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div></td>
        <td width="1%"></td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>
