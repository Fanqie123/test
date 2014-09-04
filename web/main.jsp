<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>hello world</title>
    <link rel="icon" href="favicon.ico">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/dashboard.css" rel="stylesheet">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="javascript:void(0)">Home</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="javascript:void(0)">注销</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar" id="sidebar">
            <li class="active" value="0"><a href="javascript:void(0)">房间查询</a></li>
            <li value="1" id="list_order"><a href="javascript:void(0)">预定房间</a></li>
            <li value="2"><a href="javascript:void(0)">我的订单</a></li>
            <li value="3"><a href="javascript:void(0)">个人信息</a></li>
        </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="container0">
        <h2 class="sub-header">房间信息</h2>

        <div class="container-fluid">
            <label class="label1">房间类型:</label>
            <label style="float: left">
                <select class="form-control">
                    <option selected value="0">全部</option>
                    <option>a</option>
                    <option>b</option>
                    <option>c</option>
                </select>
            </label>
            <label for="start_date_search" class="control-label label1" style="float: left">开始日期</label>

            <div class="input-group date form_date col-sm-2" style="float: left;">
                <input class="form-control" size="16" type="text" id="start_date_search" readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
            <label for="end_date_search" class="control-label label1" style="float: left">结束日期</label>

            <div class="input-group date form_date col-sm-2" style="float: left">
                <input class="form-control" size="16" type="text" id="end_date_search" readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
            <button class="btn btn-primary" onclick="select()" style="margin-left: 10px">搜索</button>
        </div>
        <!-- /input-group -->
        <div class="table-responsive" id="table1">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>房间号</th>
                    <th>房间类型</th>
                    <th>价格</th>
                    <th>房间信息</th>
                </tr>
                </thead>
                <tbody id="table_body"></tbody>
            </table>
            <div class="btn-group" id="buttons"></div>
            <button class="btn btn-danger" style="float:right" id="btn_order">预定</button>
            <label class="label1" style="float: right" id="result"></label>
        </div>
    </div>

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="container1" style="display: none">
        <h2 class="sub-header">预定房间</h2>

        <div class="form-horizontal" role="form" style="margin: 60px auto;width: 500px;">
            <div class="form-group">
                <label for="room_no_order" class="col-sm-2 control-label">房间号码</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="room_no_order"
                           placeholder="请输入房间号码" required>List list = daoProxy.findAll();
                </div>
            </div>
            <div class="form-group" style="display: none" id="alert_order">
                <div class="col-sm-10 col-sm-offset-2">
                    <div class="alert alert-danger">不存在的房间号码</div>
                </div>
            </div>
            <div class="form-group">
                <label for="start_date_order" class="col-sm-2 control-label">开始日期</label>

                <div class="col-sm-10">
                    <div class="input-group date form_date">
                        <input class="form-control" size="16" type="text" id="start_date_order" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="end_date_order" class="col-sm-2 control-label">结束日期</label>

                <div class="col-sm-10">
                    <div class="input-group date form_date">
                        <input class="form-control" size="16" type="text" id="end_date_order" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </div>
                </div>
            </div>

            <button class="btn btn-primary col-lg-3" style="float: right" id="room_order">预定</button>
        </div>
    </div>

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="container2" style="display: none">
        <h2>订单信息</h2>
        <hr>
        <div class="table-responsive" id="tablle2">
            <button class="btn btn-primary" id="btn_my_order" style="float:right">查询</button>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>房间编号</th>
                    <th>开始日期</th>
                    <th>结束日期</th>
                    <th>预定日期</th>
                </tr>
                </thead>
                <tbody id="table_body1"></tbody>
            </table>
            <button class="btn btn-danger" style="float: right" id="btn_order_cancel" disabled>退订</button>
        </div>
    </div>

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="container3" style="display: none">
        <h2 class="sub-header">个人信息</h2>

        <div class="form-horizontal form-disabled" style="margin: 60px auto;width: 500px">
            <div class="form-group" aria-disabled="true">
                <label for="account" class="col-sm-2 control-label">账号</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control col-sm-10" id="account" disabled
                           placeholder="请输入账号" required>
                </div>
            </div>
            <div class="form-group">
                <label for="password_i" class="col-sm-2 control-label">密码</label>

                <div class="col-sm-10">
                    <input type="password" class="form-control col-sm-10" id="password_i" disabled
                           placeholder="请输入密码" required>
                </div>
            </div>

            <div class="form-group">
                <label for="name_i" class="col-sm-2 control-label">姓名</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control col-sm-10" id="name_i" disabled
                           placeholder="请输入姓名" required>
                </div>
            </div>

            <div class="form-group">
                <label for="id_i" class="col-sm-2 control-label">身份证</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control col-sm-10" id="id_i" disabled
                           placeholder="请输入身份证号码" required>
                </div>
            </div>

            <div class="form-group">
                <label for="sex1_i" class="col-sm-2 control-label">性别</label>

                <div class="col-sm-10" style="margin-top: 1px">
                    <label for="sex1_i" class="control-label">男</label><input type="radio" name="sex" value="男" id="sex1_i" disabled>
                    <label for="sex2_i" class="control-label">女</label><input type="radio" name="sex" value="女" id="sex2_i" disabled>
                </div>
            </div>

            <button class="btn btn-danger col-sm-4 col-sm-offset-2" style="float:left" id="modify">修改</button>
            <button class="btn btn-success col-sm-4" style="float:right" id="save" disabled>保存</button>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
            </div>
            <div id="info" class="modal-body"
                 style="font-size: 150%; text-align: center;">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery-2.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="js/main.js"></script>
</body>
</html>
