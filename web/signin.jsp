<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>hello world</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <link rel="icon" href="favicon.ico">
    <script src="./js/jquery-2.1.1.min.js"></script>
    <script src="./js/jquery.validate.min.js"></script>
    <script src="./js/signin.js"></script>
    <script src="./bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">Home</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right ">
                <li><a id="signup" href="signup.jsp">注册</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid" style="margin-top: 60px">
    <form name="signInForm" id="signInForm" class="form-signin" role="form" method="post" action="signIn.do" >
        <logic:messagesPresent>
            <label class="error"><html:errors/></label>
        </logic:messagesPresent>
        <logic:present name="info" scope="request">
            <label class="error">${requestScope.info}</label>
        </logic:present>
        <input name="account" type="text" class="form-control" placeholder="账号" autofocus>
        <input name="password" type="password" class="form-control" placeholder="密码">
        <label class="control-label">
            <input name="rememberMe" type="checkbox" value="true">
            记住我
        </label>
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="登录">
    </form>
</div>
</body>
</html>
