<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
           <!--  <span class="sr-only"></span> -->
            <span class="icon-bar"></span>            
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${ctx }/">
          	<img alt="logo" src="${ctx}/img/logo2_25_25.png">
          </a>
          <a class="navbar-brand" href="${ctx }/">
          
          	
          </a>
         
        </div>
		
        <div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
            <li><a href="${ctx }/user/create"></a></li>
            <c:if test="${username != null}">
	            <li><a href="${ctx }/user/updatepwd?username=${username}"></a></li>
            </c:if>
           <li><a href="${ctx }/set/plt-select"></a></li>
           <%--  
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">使用指南 <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
              	<li class="dropdown-header">手机</li>
                <li><a href="${ctx }/set/set-iPhone">iPhone</a></li>
                <li><a href="${ctx }/set/set-android">安卓</a></li>
                <li><a href="${ctx }/set/set-WinPhone">WinPhone</a></li>
                
                <li class="divider"></li>
                <li class="dropdown-header">电脑</li>
                <li><a href="${ctx }/set/set-windows">Windows</a></li>
                <li><a href="${ctx }/set/set-MAC">Mac</a></li>
              </ul>
            </li> --%>
          </ul>
          
         
        </div><!--/.navbar-collapse -->
      </div>
    </nav>