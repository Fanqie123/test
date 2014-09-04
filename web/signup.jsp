<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/signup.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">Home</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right ">
                <li><a id="signin" href="signin.jsp">登录</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <form name="signUpForm" id="signUpForm" class="form-horizontal" role="form" method="post" action="signUp.do">
        <logic:messagesPresent>
            <label class="error"><html:errors/></label>
        </logic:messagesPresent>
        <logic:present name="info" scope="request">
            <label class="error">${requestScope.info}</label>
        </logic:present>
        <div class="form-group">
            <label for="account" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control col-sm-10" id="account" name="account"
                       placeholder="请输入账号" autofocus>
            </div>
        </div>

        <div class="form-group" style="display: none" id="alert">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="alert alert-danger">该账号已被注册</div>
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>

            <div class="col-sm-10">
                <input type="password" class="form-control col-sm-10" id="password" name="password"
                       placeholder="请输入密码">
            </div>
        </div>

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">姓名</label>

            <div class="col-sm-10">
                <input type="text" class="form-control col-sm-10" id="name" name="name"
                       placeholder="请输入姓名">
            </div>
        </div>

        <div class="form-group">
            <label for="id" class="col-sm-2 control-label">身份证</label>

            <div class="col-sm-10">
                <input type="text" class="form-control col-sm-10" id="id" name="id"
                       placeholder="请输入身份证号码">
            </div>
        </div>

        <div class="form-group">
            <label for="sex1" class="col-sm-2 control-label">性别</label>

            <div class="col-sm-10" style="margin-top: 1px" id="sex">
                <label for="sex1" class="control-label">男</label>
                <input type="radio" value="男" name="sex" id="sex1">
                <label for="sex2" class="control-label">女</label>
                <input type="radio" value="女" name="sex" id="sex2">
            </div>
        </div>

        <input type="submit" class="btn btn-primary col-sm-4" style="float:right" value="注册">
    </form>
</div>
</body>
