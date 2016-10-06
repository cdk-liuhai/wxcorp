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
	标签列表
	<table width="100%">
		<thead>
			<tr>
				<th width="10%">id</th>
				<th width="20%">名称</th>
				<th width="70%">操作 </th>
			</tr>
		</thead>
		<c:forEach items="${tags}" var="tag">
			<tr>
			<td>${tag.tagid}</td>
			<td>${tag.tagname}</td>
			<td>
				<a href="${ctx}/msg?totag=${tag.tagid}">发送</a>
			</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>