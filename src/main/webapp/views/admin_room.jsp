<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<jsp:include page="templates/header.jsp"/>

    <div class="container-fluid wrapper">

        <header class="row header_admin">
            <div class="col-lg-8 col-md-8">
                <img src="img/icon.png" class="icon_admin">
                <p class="title_room">Комната администратора системы тестирования</p>
            </div>
            <div class="col-lg-4 col-md-4">
                <p class="data_admin">00.00.0000</p>
            </div>
        </header><!-- end header_admin -->

        <nav class="row menu_admin">
            <div id="tab_basic_data" class="btn_admin">Основные данные</div>
            <div id="tab_questions" class="btn_admin">Вопросы</div>
            <div id="tab_users" class="btn_admin">Пользователи</div>
            <div id="tab_groups" class="btn_admin">Группы</div>
            <div id="tab_results_test" class="btn_admin">Результаты тестов</div>
            <div id="tab_settings" class="btn_admin">Общие настройки</div>
        </nav><!-- end menu_admin -->

        <div class="description_admin">


            <section class="basic_data" hidden>
                <p class="title_admin">Основные данные о системе тестирвания:</p>
                <form action="/BasicData" name="basic_titels" method="POST" class="wrapper_admin row">
                    <div class="col-lg-5 col-md-5">
                        <label class="label_admin">Заголовок названия системы тестирования:</label>
                        <input name="title_test" type="text" class="input_admin" value="${title}">
                    </div>
                    <div class="col-lg-5 col-md-5">
                        <label class="label_admin">Заголовок результата тестирования:</label>
                        <input name="title_result_test" type="text" class="input_admin" value="${titleResult}">
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button class="button_admin">Изменить</button>
                    </div>
                </form><!-- end wrapper_admin -->
                <form action="/BasicData" name="basic_contacts" method="POST" class="wrapper_admin row">
                    <div class="col-lg-4 col-md-4">
                        <label class="label_admin">Полное название учебного заведения:</label>
                        <input name="name_college" type="text" class="input_admin" value="${nameCollege}">
                    </div>
                    <div class="col-lg-3 col-md-3">
                        <label class="label_admin">Адрес:</label>
                        <input name="address" type="text" class="input_admin" value="${addressCollege}">
                    </div>
                    <div class="col-lg-3 col-md-3">
                        <label class="label_admin">Телефон:</label>
                        <input name="phone_number" type="text" class="input_admin" value="${numberCollege}">
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button class="button_admin">Изменить</button>
                    </div>
                </form><!-- end wrapper_admin -->
                <form action="/BasicData" name="basic_descriptions" method="POST" class="wrapper_admin row">
                    <div class="col-lg-6 col-md-6">
                        <label class="label_admin">Описание системы тестирования:</label>
                        <textarea name="description_test" class="textarea_admin">${description}</textarea>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <label class="label_admin">Описание результата тестирования:</label>
                        <textarea name="description_result_test" class="textarea_admin">${descriptionResult}</textarea>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button class="button_admin">Изменить</button>
                    </div>
                </form><!-- end wrapper_admin -->
            </section><!-- end common_data -->


            <section class="questions" hidden>
                <p class="title_admin">Вопросы системы тестирования:</p>
                <form action="/Questions" name="add_data_of_question" method="POST" class="wrapper_admin row">
                    <div class="col-lg-3 col-md-3">
                        <label class="label_admin">Введите входные данные:</label>
                        <input name="input_data" type="text" class="input_admin">
                    </div>
                    <div class="col-lg-3 col-md-3">
                        <label class="label_admin">Введите выходные данные:</label>
                        <input name="output_data" type="text" class="input_admin">
                    </div>
                    <div class="col-lg-4 col-md-4">
                        <label class="label_admin">Выберите вопрос:</label>
                        <select name="name_question_for_add" class="select_admin select_questions">
                            <option>Не выбрано</option>
                            <c:forEach var="question" items="${questions}">
                                <option class="del_option_questions">${question.title}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button name="btn_add_data_of_question" class="button_admin">Добавить</button>
                    </div>
                </form><!-- end wrapper_admin -->
                <form action="/Questions" name="del_question" method="POST" class="wrapper_admin row">
                    <div class="col-lg-10 col-md-10">
                        <label class="label_admin">Выберите вопрос:</label>
                        <select name="name_question_for_del" class="select_admin select_questions">
                            <option>Не выбрано</option>
                            <c:forEach var="question" items="${questions}">
                                <option class="del_option_questions">${question.title}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button name="btn_del_question" class="button_admin">Удалить</button>
                    </div>
                </form><!-- end wrapper_admin -->
                <form action="/Questions" name="add_question" method="POST" class="wrapper_admin row">
                    <div class="col-lg-5 col-md-5">
                        <label class="label_admin">Название вопроса:</label>
                        <textarea name="title_question_for_add" class="textarea_admin"></textarea>
                    </div>
                    <div class="col-lg-5 col-md-5">
                        <label class="label_admin">Описание вопроса:</label>
                        <textarea name="text_question_for_add" class="textarea_admin"></textarea>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button name="btn_add_question" class="button_admin">Добавить</button>
                    </div>
                </form><!-- end wrapper_admin -->
                <form action="/Questions" name="change_question" method="POST" class="wrapper_admin row">
                    <div class="col-lg-5 col-md-5">
                        <label class="label_admin">Название вопроса:</label>
                        <textarea name="title_question_for_change" class="textarea_admin"></textarea>
                    </div>
                    <div class="col-lg-5 col-md-5">
                        <label class="label_admin">Описание вопроса:</label>
                        <textarea name="text_question_for_change" class="textarea_admin"></textarea>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <label class="label_admin">Выберите вопрос:</label>
                        <select name="name_question_for_change" class="select_admin select_questions">
                            <option>Не выбрано</option>
                            <c:forEach items="${questions}" var="question">
                                <option class="del_option_questions">${question.title}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button name="btn_change_question" class="button_admin">Изменить</button>
                    </div>
                </form><!-- end wrapper_admin -->
            </section><!-- end_questions -->


            <section class="users" hidden>
                <p class="title_admin">Все пользователи системы тестирования:</p>
                <form action="/Users" name="del_user" method="POST" class="wrapper_admin row">
                    <div class="col-lg-10 col-md-10">
                        <label class="label_admin">Выберите пользователя:</label>
                        <select name="name_user_for_del" class="select_admin select_users">
                            <option>Не выбрано</option>
                            <c:forEach items="${users}" var="user">
                                <option class="del_option_users">${user.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button title="Удаление выбранного пользователя" class="button_admin">Удалить</button>
                    </div>
                </form><!-- end wrapper_admin -->
                <div id="table_users" class="wrapper_admin row">
                    <div class="col-lg-12 col-md-12">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>ФИО</th>
                                    <th>Логин</th>
                                    <th>Группа</th>
                                    <th>Лучший результат</th>
                                </tr>
                            </thead>
                            <tbody id="body_table_users">
                                <c:forEach items="${users}" var="user">
                                    <tr class="del_row_users">
                                        <td>${user.name}</td>
                                        <td>${user.login}</td>
                                        <td>${user.group}</td>
                                        <td>${user.bestResult}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div><!-- end wrapper_admin -->
                <form action="/Users" name="select_users" method="POST" class="wrapper_admin row">
                    <div class="col-lg-10 col-md-10">
                        <label class="label_admin">Выберите группу для выборки судентов:</label>
                        <select name="group_for_select_users" class="select_admin select_groups">
                            <option>Не выбрано</option>
                            <c:forEach items="${groups}" var="group">
                                <option class="del_option_groups">${group.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button title="Выборка пользователей по выбранной группе." class="button_admin">Выбрать</button>
                    </div>
                </form><!-- end wrapper_admin -->
            </section><!-- end users -->


            <section class="groups" hidden>
                <p class="title_admin">Группы принимающие участие в тестировании:</p>
                <form action="/Groups" name="add_group" method="POST" class="wrapper_admin row">
                    <div class="col-lg-10 col-md-10">
                        <label class="label_admin">Введите название группы:</label>
                        <input name="title_group" type="text" class="input_admin">
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button class="button_admin">Добавить</button>
                    </div>
                </form><!-- end wrapper_admin -->
                <form action="/Groups" name="change_group" method="POST" class="wrapper_admin row">
                    <div class="col-lg-5 col-md-5">
                        <label class="label_admin">Выберите старое название группы:</label>
                        <select name="old_title_group" class="select_admin select_groups">
                            <option>Не выбрано</option>
                            <c:forEach items="${groups}" var="group">
                                <option class="del_option_groups">${group.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-5 col-md-5">
                        <label class="label_admin">Введите новое название группы:</label>
                        <input name="new_title_group" type="text" class="input_admin">
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button class="button_admin">Изменить</button>
                    </div>
                </form><!-- end wrapper_admin -->
                <form action="/Groups" name="del_group" method="POST" class="wrapper_admin row">
                    <div class="col-lg-10 col-md-10">
                        <label class="label_admin">Введите группу:</label>
                        <select name="title_group_del" class="select_admin select_groups">
                            <option>Не выбрано</option>
                            <c:forEach items="${groups}" var="group">
                                <option class="del_option_groups">${group.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button name="btn_del_group" class="button_admin">Удалить</button>
                    </div>
                </form><!-- end wrapper_admin -->
                <div id="table_groups" class="wrapper_admin row">
                    <div id="test_mark" class="col-lg-12 col-md-12">
                        <table id="table_of_groups" class="table table-bordered">
                            <thead>
                            <tr>
                                <th>Группа</th>
                                <th>Количество пользователей в группе</th>
                                <th>Средний результат</th>
                            </tr>
                            </thead>
                            <tbody id="body_table_groups">
                                <c:forEach items="${groups}" var="group">
                                    <tr class="del_row_groups">
                                        <td>${group.name}</td>
                                        <td>${group.countUsers}</td>
                                        <td>0</td>
                                    </tr>
                                </c:forEach>
     					    </tbody>
                        </table>
                    </div>
                </div><!-- end wrapper_admin -->
            </section><!-- end groups -->


            <section class="result_of_test" hidden>
                <p class="title_admin">Результаты тестирования студентов:</p>
                <div id="table_results" class="wrapper_admin row">
                    <div class="col-lg-12 col-md-12">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>ФИО</th>
                                <th>Группа</th>
                                <th>Дата и время прохождения теста:</th>
                                <th>Результат</th>
                            </tr>
                            </thead>
                            <tbody id="body_table_results">
                                <c:forEach items="${resultsOfUsers}" var="result">
                                    <tr class="del_row_results">
                                        <td>${result.name}</td>
                                        <td>${result.group}</td>
                                        <td>${result.dateOfResult}</td>
                                        <td>${result.result}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div><!-- end wrapper_admin -->
                <form action="/Results" name="sort_results" method="GET" class="wrapper_admin row">
                    <div class="col-lg-10 col-md-10">
                        <label class="label_admin">Выберите способ сортировки:</label>
                        <select name="name_sort" class="select_admin">
                            <option>Не выбрано</option>
                            <option>По ФИО</option>
                            <option>По дате проведения</option>
                            <option>По результатам теста</option>
                        </select>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        <button name="btn_sort_results" class="button_admin">Сортировать</button>
                    </div>
                </form>
            </section><!-- end result_of_test -->


        </div><!-- end description_admin -->

        <footer class="footer_admin">
            <p class="log_admin"><!--Последняя информация: <c:out value="${requestScope.log}"/>--></p>
        </footer>

    </div><!-- end wrapper -->

    <!-- Script is processing forward between tabs in menu -->
    <script src="<c:url value="/resources/js/admin_room/menu.js"/>"></script>

    <!-- Scripts are processing data exchange between
         server and client with AJAX-->
    <script src="<c:url value="/resources/js/admin_room/basic_data.js"/>"></script>
    <script src="<c:url value="/resources/js/admin_room/questions.js"/>"></script>
    <script src="<c:url value="/resources/js/admin_room/users.js"/>"></script>
    <script src="<c:url value="/resources/js/admin_room/groups.js"/>"></script>
    <script src="<c:url value="/resources/js/admin_room/results.js"/>"></script>

<jsp:include page="templates/footer.jsp"/>