<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.tidstu.testingsystem.domain.Question" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="ru.tidstu.testingsystem.services.QuestionsService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<jsp:include page="templates/header.jsp"/>
<%@ page isELIgnored="false" %>

<%
    ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
    QuestionsService questionsService = (QuestionsService) appContext.getBean("questionsService");

    List<Question> listQuestions = questionsService.getQuestionsOfUser();
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
                    <li><a href="send_task.jsp" id="send_task" class="hyper_tasks">Отправить задание</a></li>
                    <li><a href="tasks.jsp" id="tasks" class="hyper_tasks">Задания</a></li>
                </ul>
            </div><!-- end l_height-->
        </div><!-- end header_tasks -->

        <div class="row tasks">
            <div class="wrapper_tasks">
                <div>
                    <div>
                        <p class="event_log">Журнал событий</p>
                    </div>
                    <div>
                        <p class="logs">
                            13:15 - Ошибка компиляции<br>
                            13:19 - Ошибка в тестепрограммы<br>
                            13:40 - Ошибка в тесте программы<br>
                            13:42 - Задание 2 выполнено<br>
                            14:22 - Ошибка компиляции<br>
                        </p>
                    </div>
                </div>
            </div><!-- end wrapper_tasks -->
        </div><!-- end tasks -->

        <form action="/GetTask" method="POST" id="form" class="description">
            <div>
                <select name="name_question">
                    <c:forEach var="question" items="${questions}">
                        <option>${question.title}</option>
                    </c:forEach>
                </select>
            </div>
            <textarea name="text_program" autofocus class="txt_send"></textarea>
            <div>
                <p id="log"></p>
                <button class="small_red_button">Отправить</button>
            </div>
        </form> <!-- end description -->

        <div class="row footer_tasks">
            <div class="col-lg-6 col-md-6">
                <p class="run_tasks">Выполненных заданий: <c:out value="${Users.getCurrentUserStatistics()}"/></p>
            </div>
            <div class="col-lg-6 col-md-6 ">
                <p class="timer">02:34:14</p>
            </div>
        </div><!-- end footer_tasks -->

    </div><!-- end wrapper -->

    <script type="text/javascript">

        $("#send_task").css("border-bottom", "2px solid red");

        var form = $("#form");
        form.submit(function(){
            if($(".txt_send").val() != "") {
                $.ajax({
                    type: form.attr('method'),
                    url: form.attr('action'),
                    data: form.serialize(),
                    success: function (data) {
                        var result = data;
                        $("#log").html(result);
                    }
                });
            }
            return false;
        });

        $(document).ready(function(){

            checkOnEmptyTextarea();
            $("#send_task").css("border-bottom", "2px solid red");

            $(".txt_send").change(
                checkOnEmptyTextarea
            );

        });

        function checkOnEmptyTextarea(){
            if($(".txt_send").val() == ""){
                $("#log").text("Не введен листинг программы, отправка задания невозможна...");
            } else {
                $("#log").text(log = "Все готово для отправки задания...");
            }
        }

    </script>

<jsp:include page="templates/footer.jsp"/>