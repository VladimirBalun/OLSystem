<%@ page import="ru.tidstu.testingsystem.models.FactoryModels" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="row footer_tasks">
    <div class="col-lg-6 col-md-6">
        <p class="run_tasks">Выполненных заданий: <%=FactoryModels.getUser().getCountTrueQuestions()%>/<%=FactoryModels.getCountQuestions()%></p>
    </div>
    <div class="col-lg-6 col-md-6 ">
        <p class="timer">02:34:14</p>
    </div>
</div><!-- end footer_tasks -->
