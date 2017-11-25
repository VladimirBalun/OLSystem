<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.tidstu.testingsystem.models.Question" %>
<%@ page import="ru.tidstu.testingsystem.models.FactoryModels" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="templates/header.jsp"/>

<%
    int numberQuestion;
    if(request.getParameter("number_question") == null){
        numberQuestion = 1;
    } else {
        numberQuestion = Integer.valueOf(request.getParameter("number_question"));
    }
    Question curQuestion = FactoryModels.getQuestion(numberQuestion);
%>

    <div class="container-fluid wrapper">

        <jsp:include page="templates/nav_tasks.jsp"/>

        <div class="row tasks">
            <form action="tasks.jsp" method="GET" class="wrapper_tasks">
                <%
                    ArrayList<Question> listQuestions = FactoryModels.getQuestions();
                    for (Question question : listQuestions){
                %>
                    <button value="<%=question.getNumber()%>" name="number_question" class="task">
                        <p class="title_question">Задание <%=question.getNumber()%></p>
                        <p class="comment_question"><%=question.getTitle()%></p>
                    </button>
                <%
                    }
                %>
            </form><!-- end wrapper_tasks -->
        </div><!-- end tasks -->

        <div class="description wow bounceInRight" data-wow-delay=".5s">
            <p class="untitle"><%=curQuestion.getTitle()%></p>
            <%=curQuestion.getText()%><br><br>
            <b>Пример входных данных</b><br>
            <%
                ArrayList<String> listInData = curQuestion.getInData();
                for (String inData : listInData){
            %>
                <%=inData%><br>
            <%
                }
            %>
            <b>Пример выходных данных</b><br>
            <%
                ArrayList<String> listOutData = curQuestion.getOutData();
                for (String outData : listOutData){
            %>
                <%=outData%><br>
            <%
                }
            %>
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
