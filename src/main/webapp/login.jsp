<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta charset="UTF-8">
    <title>Система тестирования ТИ ДГТУ</title>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>
    <link rel="stylesheet" href="css/login_css.css">
    <link rel="shortcut icon" href="img/icon.png" type="image/x-icon">
    <script src="js/jquery.min.js"></script>
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

                <form method="GET" action="/LogIn" class="sign-in-htm">
                    <div class="group">
                        <label for="user" class="label">Логин</label>
                        <input name="login_sign_in" id="user" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Пароль</label>
                        <input name="pass_sign_in" id="pass" type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <button name="btn_sign_in" class="button">Войти</button>
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a href="#forgot">Забыли пароль?</a>
                    </div>
                </form><!-- end sign-in-html -->

                <form method="post" action="/LogIn" class="sign-up-htm">
                    <div class="group">
                        <label for="user" class="label">Логин</label>
                        <input name="login_sign_up" id="user" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="name" class="label">Пароль</label>
                        <input name="pass_sign_up" id="name" type="password" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">ФИО</label>
                        <input name="name_sign_up" id="pass" type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <label for="group" class="label">Группа</label>
                        <input name="group_sign_up" id="group" type="text" class="input">
                    </div>
                    <div class="group">
                        <button name="btn_sign_up" class="button">Зарегистрироваться</button>
                    </div>
                </form><!-- end sign-up-html -->

            </div><!-- end login_form -->
        </div><!-- end login_html -->
    </div><!-- end login_wrap -->

    <jsp:include page="templates/footer.jsp"/>
