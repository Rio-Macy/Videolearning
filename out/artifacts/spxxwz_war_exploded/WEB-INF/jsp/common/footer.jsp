<%--
  Created by IntelliJ IDEA.
  User: sujuntao
  Date: 2021/4/8
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="background-color: #f3f5f7; box-shadow: 0px 0px 1px 0px #ccc;">
    <div class="container" >
        <div class="pt-4">
            <a href="" class="text-secondary">联系我们</a>
            <a href="" class="text-secondary ml-3">关于我们</a>
        </div>
        <br>
        <div class="pb-4">
            <a href="" class="text-secondary">联系我们</a>
            <a href="" class="text-secondary ml-3">关于我们</a>
            <a href="" class="text-secondary ml-3">联系我们</a>
            <a href="" class="text-secondary ml-3">关于我们</a>
        </div>
    </div>
</div>

<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>

<!-- 登录 -->
    <div class="modal fade " id="loginModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">登录</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form  action="/login" method="post" onsubmit="return loginSubmit()">
                    <div class="form-group">
                        <label for="loginInputEmail">邮箱</label>
                        <input name="email" type="email" class="form-control" id="loginInputEmail"
                               aria-describedby="emailHelpLon">

                    </div>
                    <div class="form-group">
                        <label for="loginInputPwd">密码</label>
                        <input name="password" type="password" class="form-control" id="loginInputPwd">
                    </div>
                    <small id="emailHelpLogin" class="form-text text-muted"></small>
                    <div class="form-group form-check">
                        <input type="checkbox" name="autoLogin" value="1" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">自动登录</label>

                        <a href="/forgetPage" class="float-right">忘记密码</a>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary">登录</button>
                    </div>
                </form>
            </div>
            <a href="#" class="ml-3 mb-3" data-toggle="modal" data-dismiss="modal"
               data-target="#registModal">还没有账号？点我注册</a>
        </div>

    </div>
</div>

<!-- 注册 -->
    <div class="modal fade " id="registModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel4">注册</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
<%--                spxxwz_war/  /spxxwz_war  --%>
                <form action="/regist" method="post" onsubmit=" return registSubmit()">
                    <div class="form-group">
                        <label for="RegEmailInput">邮箱</label>
                        <input type="email" name="email" class="form-control" id="RegEmailInput"
                               onblur="checkEmail(this)" aria-describedby="emailHelp" required>
                        <small id="emailHelpReg" class="form-text text-muted"></small>
                    </div>
                    <div class="form-group">
                        <label for="RegPasswordInput">密码</label>
                        <input type="password" name="password" class="form-control"  onblur="checkPassword(this)" id="RegPasswordInput"  required>
                        <small id="pwdHelpReg" class="form-text text-muted"></small>
                    </div>
                    <div class="form-group">
                        <label for="RegvcodeInput">验证码</label>
                        <div class="row">
                            <input name="vcode"  type="vcode" class="form-control col-md-6 ml-3"  id="RegvcodeInput" maxlength="4">
                            <%--     将图片路径改为/vode        --%>
                            <img src="vcode" onclick="changeVCode(this)" class="col-md-2">
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary">注册</button>
                    </div>
                </form>
            </div>
            <a  href="#" class="ml-3 mb-3" data-toggle="modal" data-dismiss="modal" data-target="#loginModal">已有账号？点我登录</a>
        </div>
    </div>
</div>

<script type="application/javascript">

    function loginSubmit() {

        let submitFlag = false;
        let email = $("#loginInputEmail").val();
        let pwd = $("#loginInputPwd").val();

        $.ajax({
            url: "/checkLogin",
            type: "POST",
            data: {email: email, password: pwd},
            async: false,
            success: function (result) {

                if (result.code == 1) {

                    submitFlag = true
                }else {

                    $("#emailHelpLogin").text("账号或密码不正确");
                    $("#emailHelpLogin").attr("class", "invalid-feedback");
                    $("#emailHelpLogin").css("display","block");
                    submitFlag = false;
                }

            }
        });
        return submitFlag;
    }

    function changeVCode(imgNode) {

        imgNode.src = "vcode?ramdom=" + new Date().getTime();
    }

    let registEmailFlag = false;
    let registPwdFlag = false;

    function registSubmit() {

        if (registEmailFlag && registPwdFlag) {

            return true;
        }
        return false;
    }

    function checkPassword(pwdNode) {

        let pwd = pwdNode.value;
        let pwdLen = pwd.length;

        console.log(pwd);
        if (pwdLen < 6) {

            $("#RegPasswordInput").removeClass("is-valid");
            $("#RegPasswordInput").addClass("is-invalid");
            $("#pwdHelpReg").text("密码不能小于6位数");
            $("#pwdHelpReg").attr("class", "invalid-feedback");

            registEmailFlag = false;
        }else {

            $("#RegPasswordInput").removeClass("is-invalid");
            $("#pwdHelpReg").attr("class", "valid-feedback");
            $("#RegPasswordInput").addClass("is-valid");
            $("#pwdHelpReg").text("");

            registPwdFlag = true;
        }
    }

    function checkEmail(emailNode) {

        let email = emailNode.value;

        let pattern = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        let suc = pattern.test(email);

        if (!suc) {

            // 不正确的邮箱格式提示
            $("#RegEmailInput").removeClass("is-valid");
            $("#RegEmailInput").addClass("is-invalid");
            $("#emailHelpReg").text("email格式不正确");
            $("#emailHelpReg").attr("class", "invalid-feedback");
            registEmailFlag = false;

            return;
        }

        $("#RegEmailInput").removeClass("is-invalid");
        $("#emailHelpReg").attr("class", "valid-feedback");
        $("#RegEmailInput").addClass("is-valid");
        $("#emailHelpReg").text("");

        $.ajax({
            url: "checkEmail?email=" + email,
            success: function (result) {

                if (result.code == 1) {

                    registEmailFlag = true;
                }else {

                    registEmailFlag = false;
                }
            }
        });

    }
    


</script>






