<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.tidstu.testingsystem.models.Question" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.tidstu.testingsystem.models.FactoryModels" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<jsp:include page="templates/header.jsp"/>

    <div class="container-fluid wrapper">

        <jsp:include page="templates/nav_tasks.jsp"/>

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

        <form class="description">
            <div>
                <select>
                    <%
                        ArrayList<Question> listQuestions = FactoryModels.getQuestions();
                        for (Question question : listQuestions){
                    %>
                    <option><%=question.getTitle()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <textarea autofocus class="txt_send"></textarea>
            <div>
                <p id="log"></p>
                <button href="tasks.html" class="small_red_button">Отправить</button>
            </div>
        </form> <!-- end description -->

        <jsp:include page="templates/nav_footer_tasks.jsp"/>

    </div><!-- end wrapper -->

    <script type="text/javascript">

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