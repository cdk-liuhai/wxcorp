<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<c:set var="ctx" value="<%=request.getContextPath() %>" scope="page"/>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=edge; chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Cache-Control" content="no-transform"> 
<link rel="icon" href="${ctx}/img/favicon.ico">
<title></title>
<!-- Bootstrap core CSS 
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">
-->
<link href="${ctx}/css/bootstrap.css" rel="stylesheet">
<link href="${ctx}/css/my.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	      <script src="${ctx}/js/html5shiv.min.js"></script>
	      <script src="${ctx}/js/respond.min.js"></script>
	      <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <![endif]-->
</head>