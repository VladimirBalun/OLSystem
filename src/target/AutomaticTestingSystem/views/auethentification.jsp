<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html >
<head>
    <meta charset="UTF-8">
    <title>Система тестирования ТИ ДГТУ</title>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>
    <link rel="stylesheet" href="<c:url value="/resources/css/auethentification.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/libs/animate.css"/>">
    <link rel="shortcut icon" href="<c:url value="/resources/img/icon.png"/>" type="image/x-icon">
    <script src="<c:url value="/resources/libs/jquery.min.js"/>"></script>
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

                <form method="GET" action="<c:url value="/auethentification/logIn"/>" class="sign-in-htm">
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

                <form method="GET" action="<c:url value="/auethentification/SignUp"/>" class="sign-up-htm">
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

    <script src="<c:url value="/resources/libs/wow.min.js"/>"></script>
    <script src="<c:url value="/resources/js/auethentification-page.js"/>"></script>

    <jsp:include page="footer.jsp"/>
