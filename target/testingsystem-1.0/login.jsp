<%@ page import="ru.tidstu.testingsystem.services.GroupsService" %>
<%@ page import="ru.tidstu.testingsystem.services.models.Group" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<%
    GroupsService groupsService = new GroupsService();
    List<Group> groups = groupsService.getGroups();
    pageContext.setAttribute("groups", groups);
%>

<html >
<head>
    <meta charset="UTF-8">
    <title>Система тестирования ТИ ДГТУ</title>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>
    <link rel="stylesheet" href="css/login_css.css">
    <link rel="stylesheet" href="css/libs/animate.css">
    <link rel="shortcut icon" href="img/icon.png" type="image/x-icon">
    <script src="js/libs/jquery.min.js"></script>
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
                        <button name="btn_sign_in" class="button btn">Войти</button>
                    </div>
                    <p class="log_in animated" data-effect="tada"><c:out value="${requestScope.logIn}"/></p>
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
                        <input name="name_sign_up" id="pass" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="group" class="label">Группа</label>
                        <select name="group_sign_up" id="group" class="input">
                            <option>Не выбрано</option>
                            <c:forEach items="${groups}" var="group">
                                <option class="option">${group.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="group">
                        <button name="btn_sign_up" class="button btn">Зарегистрироваться</button>
                    </div>
                    <p class="log_up animated" data-effect="tada"><c:out value="${requestScope.signUp}"/></p>
                </form><!-- end sign-up-html -->

            </div><!-- end login_form -->
        </div><!-- end login_html -->
    </div><!-- end login_wrap -->

    <script src="js/libs/wow.min.js"></script>
    <script src="js/check_autorization.js"></script>


    <jsp:include page="templates/footer.jsp"/>
