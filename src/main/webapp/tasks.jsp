<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.tidstu.testingsystem.domain.Question" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="ru.tidstu.testingsystem.services.QuestionsService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<jsp:include page="templates/header.jsp"/>

<%
    ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
    QuestionsService questionsService = (QuestionsService) appContext.getBean("questionsService");

    List<Question> listQuestions = questionsService.getQuestionsOfUser();
    //Question selectedQuestion = listQuestions.get(0);
    pageContext.setAttribute("questions", listQuestions);
%>

    <div class="container-fluid wrapper">

        <div class="row header_tasks">
            <div class="col-lg-6 col-md-6">
                <img src="img/icon.png" class="icon_tasks">
                <p class="title_tasks">Система тестирования ТИ ДГТУ</p>
            </div>
            <div class="col-lg-6 col-md-6 l_height">
                <ul>
                    <li><a href="end_test.jsp" id="end_test" class="hyper_tasks">Закончить тест</a></li>
                    <li><a href="send_task.jsp" class="hyper_tasks">Отправить задание</a></li>
                    <li><a href="tasks.jsp" id="tasks" class="hyper_tasks">Задания</a></li>
                </ul>
            </div><!-- end l_height-->
        </div><!-- end header_tasks -->

        <div class="row tasks">
            <form id="form_change" action="/Tasks" method="GET" class="wrapper_tasks">
                <c:forEach var="question" items="${questions}">
                    <button value="${question.number}" name="number_question" class="task">
                        <p class="title_question">Задание ${question.number}</p>
                        <p class="comment_question">${question.title}</p>
                    </button>
                </c:forEach>
            </form><!-- end wrapper_tasks -->
        </div><!-- end tasks -->

        <div class="description animated" data-effect="bounceInRight">
            <p class="untitle"></p>
            <p class="txt_question"></p>
            <b>Пример входных данных:</b>
            <p class="input_data"></p>
            <b >Пример выходных данных:</b>
            <p class="output_data"></p>
        </div><!-- end description -->

        <div class="row footer_tasks">
            <div class="col-lg-6 col-md-6">
                <p class="run_tasks">Выполненных заданий: <c:out value="${Users.getCurrentUserStatistics()}"/></p>
            </div>
            <div class="col-lg-6 col-md-6 ">
                <p class="timer">02:34:14</p>
            </div>
        </div><!-- end footer_tasks -->

    </div><!-- end wrapper -->

    <script src="js/libs/wow.min.js"></script>
    <script src="js/tasks.js"></script>

<jsp:include page="templates/footer.jsp"/>
