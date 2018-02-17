<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.tidstu.testingsystem.models.items.Question" %>
<%@ page import="ru.tidstu.testingsystem.models.QuestionMaker" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<jsp:include page="templates/header.jsp"/>

<%
    int numberQuestion;
    if(request.getParameter("number_question") == null){
        numberQuestion = 1;
    } else {
        numberQuestion = Integer.valueOf(request.getParameter("number_question"));
    }
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/app-context.xml");
    QuestionMaker questionsMaker = (QuestionMaker)applicationContext.getBean("questionMaker");
    Question curQuestion = questionsMaker.getQuestion(numberQuestion);
//    ArrayList<String> listInData = curQuestion.getInData();
//    pageContext.setAttribute("inData", listInData);
//    ArrayList<String> listOutData = curQuestion.getOutData();
//    pageContext.setAttribute("outData", listOutData);
    ArrayList<Question> listQuestions = questionsMaker.getQuestions();
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

        <div class="description wow bounceInRight" data-wow-delay=".5s">
            <p class="untitle"><%=curQuestion.getTitle()%></p>
            <%=curQuestion.getText()%><br><br>
            <b>Пример входных данных</b><br>
            <%--<c:forEach var="data" items="${inData}">--%>
                <%--${data}<br>--%>
            <%--</c:forEach>--%>
            <b>Пример выходных данных</b><br>
            <%--<c:forEach var="data" items="${outData}">--%>
                <%--${data}<br>--%>
            <%--</c:forEach>--%>
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

    <script>

        $("#form_change").submit(function(){
            $.get($("#form_change").attr("action"), $("#form_change").serialize(), function(responseJson){
                alert("here");
//                $.each(responseJson, function(index, question) {
//                    alert(question.title);
//                });
            });
            event.preventDefault();
        });

        $(document).ready(function(){



            $("#tasks").css("border-bottom", "2px solid red");
            new WOW().init();
        });

    </script>

    <script src="js/libs/wow.min.js"></script>

<jsp:include page="templates/footer.jsp"/>
