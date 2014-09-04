/**
 * 登录注册页面 JS
 */
$(function() {
    $.validator.addMethod("alpha_number", function(value, element) {
        var chinese = /^[a-zA-Z0-9-_]{5,9}$/;
        return this.optional(element) || (chinese.test(value));
    }, "请输入5-9位数字字母下划线组合");

    $("#signInForm").validate({
        rules:{
            account:{
                alpha_number:true,
                required:true
            },
            password:{
                alpha_number:true,
                required:true
            }
        },
        messages:{
            account:{
                required:"请输入账号"
            },
            password:{
                required:"请输入密码"
            }
        }
    });
});

