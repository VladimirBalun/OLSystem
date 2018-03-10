<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<jsp:include page="header.jsp"/>

    <div class="container-fluid wrapper">

        <div class="row header_tasks">
            <div class="col-lg-6 col-md-6">
                <img src="<c:url value="/resources/img/icon.png"/>" class="icon_tasks">
                <p class="title_tasks">Система тестирования</p>
            </div>
            <div class="col-lg-6 col-md-6 l_height">
                <ul>
                    <li><a href="<c:url value="/finishOlympiad"/>" id="end_test" class="hyper_tasks">Закончить тест</a></li>
                    <li><p class="hyper_tasks" id="send_task">Отправить задание</p></li>
                    <li><p class="hyper_tasks" id="tasks">Задания</p></li>
                </ul>
            </div><!-- end l_height-->
        </div><!-- end header_tasks -->

        <section class="container-fluid" id="section_tasks">
            <div class="row tasks">
                <form id="form_change" action="<c:url value="/tasks/selectedTask"/>" method="GET" class="wrapper_tasks">
                    <c:forEach var="question" items="${questions}">
                        <button value="${question.number}" name="number_question" class="task">
                            <p class="title_question">Задание ${question.number}</p>
                            <p class="comment_question">${question.title}</p>
                        </button>
                    </c:forEach>
                </form><!-- end wrapper_tasks -->
            </div><!-- end tasks -->
            <div class="description animated" data-effect="bounceInRight">
                <p class="untitle">${questions.get(0).title}</p>
                <p class="txt_question">${questions.get(0).text}</p>
                <b>Пример входных данных:</b>
                <p class="input_data">${questions.get(0).inputData}</p>
                <b >Пример выходных данных:</b>
                <p class="output_data">${questions.get(0).outputData}</p>
            </div><!-- end description -->
        </section>

        <section class="container-fluid" id="section_send_task">
            <div class="row tasks">
                <div class="wrapper_tasks">
                    <div>
                        <div>
                            <p class="event_log">Журнал событий</p>
                        </div>
                        <div id="logs_running_test">
                            <p class="logs">
                                <c:forEach var="logRunningTest" items="${logs}">
                                   ${logRunningTest.time} : ${logRunningTest.description}</br>
                                </c:forEach>
                            </p>
                        </div>
                    </div>
                </div><!-- end wrapper_tasks -->
            </div><!-- end tasks -->
            <form action="<c:url value="/tasks/checkTask"/>" method="POST" id="form_send_task" class="description">
                <div>
                    <select name="name_question">
                        <c:forEach var="question" items="${questions}">
                            <option class="task_option">${question.title}</option>
                        </c:forEach>
                    </select>
                </div>
                <textarea name="text_program" autofocus class="txt_send"></textarea>
                <div>
                    <p id="log" class="animated" data-effect="pulse"></p>
                    <button class="small_red_button">Отправить</button>
                </div>
            </form> <!-- end description -->
        </section>

        <div class="row footer_tasks">
            <div class="col-lg-6 col-md-6">
                <p class="run_tasks">Выполненных заданий: ${statisticUser}</p>
            </div>
            <div class="col-lg-6 col-md-6 ">
                <p class="timer"><!-- timer in tasks-page.js --></p>
            </div>
        </div><!-- end footer_tasks -->


    </div><!-- end wrapper -->

    <script src="<c:url value="/resources/libs/wow.min.js"/>"></script>
    <script src="<c:url value="/resources/js/tasks-page.js"/>"></script>

<jsp:include page="footer.jsp"/>
