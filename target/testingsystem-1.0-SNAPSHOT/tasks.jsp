<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.tidstu.testingsystem.models.Question" %>
<%@ page import="ru.tidstu.testingsystem.models.FactoryModels" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="templates/header.jsp"/>

    <div class="container-fluid wrapper">

        <jsp:include page="templates/nav_tasks.jsp"/>

        <div class="row tasks">
            <div class="wrapper_tasks">
                <%
                    ArrayList<Question> listQuestions = FactoryModels.getQuestions();
                    for (Question question : listQuestions){
                %>
                    <div id="<%=question.getNumber()%>" class="task">
                        <p class="title_question">Задание <%=question.getNumber()%></p>
                        <p class="comment_question"><%=question.getTitle()%></p>
                    </div>
                <%
                    }
                %>
            </div><!-- end wrapper_tasks -->
        </div><!-- end tasks -->

        <div class="description wow bounceInRight" data-wow-delay=".5s">
            <p class="untitle">Числа Фибоначчи</p>
            Время на тест: 1 секунда.<br>
            Размер программы меньше 200Мб.<br>
            Последовательность Фибоначчи F[n] задается следующим образом:<br>
            F[0]=1<br>
            F[1]=1<br>
            F[n]=F[n]-1+F[n]-2.<br>
            Начало ряда Фибоначчи выглядит так:<br>
            1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...<br>
            Программа должна по данному n, 0 ≤ n≤ 40 вычиcлить F[n].<br><br>
            <b>Пример входных данных</b><br>
            10<br>
            <b>Пример выходных данных</b><br>
            89<br>
        </div><!-- end description -->

        <jsp:include page="templates/nav_footer_tasks.jsp"/>

    </div><!-- end wrapper -->


    <script>

        $(document).ready(function(){

            $(".task").click(function(){
                location.reload();
            });

            $("#tasks").css("border-bottom", "2px solid red");
            new WOW().init();
        });

    </script>

    <script src="js/wow.min.js"></script>

<jsp:include page="templates/footer.jsp"/>
