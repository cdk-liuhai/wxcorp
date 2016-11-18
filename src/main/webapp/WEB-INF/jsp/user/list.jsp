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
	用户列表
	<table width="100%">
		<thead>
			<tr>
				<th width="30%">id</th>
				<th width="20%">名称</th>
				<th width="30%">部门id</th>
				<th width="20%">操作 </th>
			</tr>
		</thead>
		<c:forEach items="${users}" var="u">
			<tr>
			<td>${u.userid}</td>
			<td>${u.name}</td>
			<td>
			<c:forEach items="${u.department}" var="d">
				${d} &nbsp;
			</c:forEach>
			</td>
			<td>
			<a href="${ctx}/msg?touser=${u.userid}">发送</a>
			</td>
			</tr>
		</c:forEach>
	
	</table>
	</div>
</body>
</html>