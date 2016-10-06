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
	部门列表
	<table width="100%">
		<thead>
			<tr>
				<th width="10%">id</th>
				<th width="20%">名称</th>
				<th width="10%">父id</th>
				<th width="60%">操作 </th>
			</tr>
		</thead>
		<c:forEach items="${depts}" var="dept">
			<tr>
			<td>${dept.id}</td>
			<td>${dept.name}</td>
			<td>${dept.parentid}</td>
			<td>
				<a href="${ctx}/user?deptID=${dept.id}">查看人员</a>
				<a href="${ctx}/msg?toparty=${dept.id}">发送</a>
			</td>
			</tr>
		</c:forEach>
	
	</table>
	</div>
</body>
</html>