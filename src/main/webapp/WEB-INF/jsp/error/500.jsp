<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@ include file="/WEB-INF/jsp/share/head.jsp"%>

<%@ page import="org.apache.logging.log4j.LogManager" %>
<%@ page import="org.apache.logging.log4j.Logger" %>
<%@ page isErrorPage="true" %>
<%	
	//设置返回码200，避免浏览器自带的错误页面
	response.setStatus(200);
	//记录日志
	Logger logger = LogManager.getLogger("500.jsp");
	logger.error(exception.getMessage(), exception);
	
%>

<body>

	<%@ include file="/WEB-INF/jsp/share/nav.jsp"%>

	<div class="container marketing">
		<hr>
		<div class="row">
			<div class="col-lg-12">
				<!-- /.col-lg-4 -->
				<p><%=exception.getMessage() %></p>
			</div>
		</div>
		<!-- /.row -->
		<hr>


		<%@ include file="/WEB-INF/jsp/share/footer.jsp"%>
	</div>
	<!-- /container -->




</body>

</html>