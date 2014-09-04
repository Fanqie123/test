/**
 * 登录注册页面 JS
 */
$(function() {
    $("#account").blur(function () {
        var account = $("#account").val();
        $.ajax({
            url: 'account_check',
            type: 'post',
            data: 'account=' + account,
            success: function (msg) {
                console.log(msg);
                if (msg == 'exist') {
                    $('#alert').fadeIn();
                    $('#account1').focus();
                } else {
                    $('#alert').fadeOut();
                }
            }
        });
    });

    $.validator.addMethod("alpha_number", function(value, element) {
        var chinese = /^[a-zA-Z0-9-_]{5,9}$/;
        return this.optional(element) || (chinese.test(value));
    }, "请输入5-9位数字字母下划线组合")

    $.validator.addMethod("chinese", function(value, element) {
        var chinese = /^[\u4e00-\u9fa5]{2,5}$/;
        return this.optional(element) || (chinese.test(value));
    }, "请输入中文");

    $.validator.addMethod("id_no", function(value, element) {
        var chinese = /^[0-9]{17}[X0-9]$/;
        return this.optional(element) || (chinese.test(value));
    }, "请输入18位身份证号");

    $("#signUpForm").validate({
        rules:{
            account:{
                alpha_number:true,
                required:true
            },
            password:{
                alpha_number:true,
                required:true
            },
            name:{
                chinese:true,
                required:true
            },
            id:{
                id_no:true,
                required:true
            }
        },
        messages:{
            account:{
                required:"请输入账号"
            },
            password:{
                required:"请输入密码"
            },
            name:{
                required:"请输入姓名"
            },
            id:{
                required:"请输入身份证号码"
            }
        }
    });
});

