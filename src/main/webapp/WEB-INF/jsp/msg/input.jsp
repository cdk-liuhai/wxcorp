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
	<p><a href="javascript:history.go(-1)">返回</a></p>
	<br/>
	<form action="${ctx }/msg" method="post">
	<input type="text" name="msgtype" hidden="true" value="text">
	<table width="100%">
		<tr>
		<td width="20%">目标人员：</td><td><input type="text" name="touser" value=""${msg.touser }""/></td>
		</tr>
		<tr>
		<td>目标部门:</td><td><input type="text" name="toparty" value="${msg.toparty }"/></td>
		</tr>
		<tr>
		<td>目标标签:</td><td><input type="text" name="totag"  value="${msg.totag }"/></td>
		</tr>
		<tr>
		<td>目标应用:</td><td><input type="text" name="agentid" value="1"/></td>
		</tr>
		<tr>
		<td>目标内容:</td><td><input type="text" name="Text.content"/></td>
		</tr>
		
		<tr>
		<td><input type="submit" value="发送"/></td><td><input type="reset" value="重置" /></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>