<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@ include file="/WEB-INF/jsp/share/head.jsp"%>

<body>
	<%@ include file="/WEB-INF/jsp/share/nav.jsp"%>

	<div class="container">
	<br/>
	<br/>
	<br/>
	<br/>
	<a href="${ctx}/dept"> 查看所有部门id</a>
	<br/>
	<br/>
	<a href="${ctx}/tag"> 查看所有tag</a>
	<br/>
	<br/>
	<a href="${ctx}/accesstoken/update">刷新Accesstoken</a>
	</div>
	<!-- /container -->
</body>
</html>