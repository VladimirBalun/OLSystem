<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html >
<head>
    <meta charset="UTF-8">
    <title>Система тестирования ТИ ДГТУ</title>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>
    <link rel="stylesheet" href="<c:url value="/resources/css/login_css.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/libs/animate.css"/>">
    <link rel="shortcut icon" href="<c:url value="/resources/img/icon.png"/>" type="image/x-icon">
    <script src="<c:url value="/resources/js/libs/jquery.min.js"/>"></script>
</head>
<body>

    <div id="preloader">
        <div id="status"></div>
    </div>

    <div class="login-wrap">
        <div class="login-html">
            <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Войти</label>
            <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Зарегистрироваться</label>
            <div class="login-form">

                <form method="POST" action="<c:url value="/auethentification/logIn"/>" class="sign-in-htm">
                    <div class="group">
                        <label class="label">Логин</label>
                        <input name="login_sign_in" type="text" class="input">
                    </div>
                    <div class="group">
                        <label class="label">Пароль</label>
                        <input name="pass_sign_in" type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <button name="btn_sign_in" class="button btn">Войти</button>
                    </div>
                    <p class="log_in animated" data-effect="tada"></p>
                </form><!-- end sign-in-html -->

                <form method="post" action="/LogIn" class="sign-up-htm">
                    <div class="group">
                        <label  class="label">Логин</label>
                        <input name="login_sign_up" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="name" class="label">Пароль</label>
                        <input name="pass_sign_up" id="name" type="password" class="input">
                    </div>
                    <div class="group">
                        <label class="label">ФИО</label>
                        <input name="name_sign_up"  type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="group" class="label">Группа</label>
                        <select name="group_sign_up" id="group" class="input">
                            <option>Не выбрано</option>
                            <c:forEach var="group" items="${groups}">
                                <option class="option">${group.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="group">
                        <button name="btn_sign_up" class="button btn">Зарегистрироваться</button>
                    </div>
                    <p class="log_up animated" data-effect="tada"></p>
                </form><!-- end sign-up-html -->

            </div><!-- end login_form -->
        </div><!-- end login_html -->
    </div><!-- end login_wrap -->

    <script src="<c:url value="/resources/js/libs/wow.min.js"/>"></script>
    <script type="text/javascript">

        $(document).ready(function() {

            new WOW().init();


            var formSignIn = $(".sign-in-htm");
            var formSignUp = $(".sign-up-htm");

            var loggerSignIn = $(".log_in");
            var loggerSignUp = $(".log_up");

            var btnSignIn = $("button[name='btn_sign_in']");
            var btnSignUp = $("button[name='btn_sign_up']");

//            formSignIn.submit(function(){
//                disableButton(btnSignIn);
//                var login = $("input[name='login_sign_in']");
//                var password = $("input[name='pass_sign_in']");
//                if(login.val() === ""){
//                    loggerSignIn.html("Не введен логин.");
//                    animate(loggerSignIn);
//                    enableButton(btnSignIn);
//                    return false;
//                }
//                if(password.val() === ""){
//                    loggerSignIn.html("Не введен пароль.");
//                    animate(loggerSignIn);
//                    enableButton(btnSignIn);
//                    return false;
//                }
//                authenticate();
//            });

            function authenticate(){
                if($("input[name='login_sign_in']").val() === "admin" && $("input[name='pass_sign_in']").val() === "admin") {
                    loggerSignIn.html("Переход в комнату администратора...</br>Немного подождите");
                    $(location).attr("href", "/admin_room.jsp");
                }
                $.get(formSignIn.attr("action"), formSignIn.serialize(), function(response){
                    if(response.length < 100) {
                        loggerSignIn.html(response);
                        animate(loggerSignIn);
                        enableButton(btnSignIn);
                    } else {
                        loggerSignIn.html("Запускается тестирование...</br>Немного подождите");
                        animate(loggerSignIn);
                        $(location).attr("href", "/tasks.jsp");
                    }
                });
                event.preventDefault();
            }

//            formSignUp.submit(function(){
//                disableButton(btnSignUp);
//                var login = $("input[name='login_sign_up']").val();
//                var password = $("input[name='pass_sign_up']").val();
//                var name = $("input[name='name_sign_up']").val();
//                var group = $("select[name='group_sign_up']").val();
//                switch("") {
//                    case login :
//                        loggerSignUp.html("Не введен логин.");
//                        animate(loggerSignUp);
//                        enableButton(btnSignUp);
//                        return false;
//                    case password :
//                        loggerSignUp.html("Не введен пароль.");
//                        animate(loggerSignUp);
//                        enableButton(btnSignUp);
//                        return false;
//                    case name :
//                        loggerSignUp.html("Не введено ФИО.");
//                        animate(loggerSignUp);
//                        enableButton(btnSignUp);
//                        return false;
//                }
//                if(group === "Не выбрано"){
//                    loggerSignUp.html("Не выбрана группа.");
//                    animate(loggerSignUp);
//                    enableButton(btnSignUp);
//                    return false;
//                }
//                register();
//            });

            function register() {
                $.post(formSignUp.attr("action"), formSignUp.serialize(), function(response){
                    if(response.length < 100) {
                        loggerSignUp.html(response);
                        animate(loggerSignUp);
                        enableButton(btnSignUp);
                    } else {
                        loggerSignUp.html("Запускается тестирование...</br>Немного подождите");
                        animate(loggerSignUp);
                        $(location).attr("href", "/tasks.jsp");
                    }
                });
                event.preventDefault();
            }

            function animate(elem){
                var effect = elem.data("effect");
                if(!effect || elem.hasClass(effect)) return false;
                elem.addClass(effect);
                setTimeout( function(){
                    elem.removeClass(effect);
                }, 1000);
            }

            function disableButton(btn){
                btn.css("background-color","#4D88EE");
                btn.css( 'cursor', 'default' );
                btn.disabled = true;
            }

            function enableButton(btn){
                btn.css("background-color","#1161EE");
                btn.css( 'cursor', 'pointer' );
                btn.disabled = false;
            }

        });

    </script>

    <jsp:include page="templates/footer.jsp"/>
