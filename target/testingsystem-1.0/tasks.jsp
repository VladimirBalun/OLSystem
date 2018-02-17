<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.tidstu.testingsystem.services.models.Question" %>
<%@ page import="ru.tidstu.testingsystem.services.QuestionsService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<jsp:include page="templates/header.jsp"/>

<%
    QuestionsService questionsService = new QuestionsService();
    ArrayList<Question> listQuestions = questionsService.getQuestionsOfUser();
    Question selectedQuestion = listQuestions.get(0);
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
            <p class="untitle"><%= selectedQuestion.getTitle() %></p>
            <p class="txt_question"><%= selectedQuestion.getText() %></p>
            <b>Пример входных данных:</b>
            <p class="input_data"><%= selectedQuestion.getInputData() %></p>
            <b >Пример выходных данных:</b>
            <p class="output_data"><%= selectedQuestion.getOutputData() %></p>
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

        $(document).ready(function(){

            $("#tasks").css("border-bottom", "2px solid red");
            var formChangeQuestion = $("#form_change");
            new WOW().init();

            function animate(elem){
                var effect = elem.data("effect");
                if(!effect || elem.hasClass(effect)) return false;
                elem.addClass(effect);
                setTimeout( function(){
                    elem.removeClass(effect);
                }, 1000);
            }

            formChangeQuestion.submit(function(){
                var number = $(this).find(".task:focus").val();
                $.get(formChangeQuestion.attr("action"), {num_question : number}, function(question){
                    $(".untitle").html(question.title);
                    $(".txt_question").html(question.text);
                    $(".input_data").html(question.inputData);
                    $(".output_data").html(question.outputData);
                    animate($(".description"));
                });
                event.preventDefault();
            });

        });

    </script>

    <script src="js/libs/wow.min.js"></script>

<jsp:include page="templates/footer.jsp"/>
