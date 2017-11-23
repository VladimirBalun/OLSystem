<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.tidstu.testingsystem.models.IOFile" %>

<jsp:include page="templates/header.jsp"/>

    <div class="container-fluid wrapper">

        <jsp:include page="templates/nav_main.jsp"/>

        <div class="row main_part">
            <div class="container">
                <div class="col-lg-6 col-md-6">
                    <p class="title"><%=IOFile.readFile("C:\\Users\\User\\Desktop\\TestingSystem\\src\\main\\resources\\common_date\\title_test.txt")%></p>
                    <p class="text"><%=IOFile.readFile("C:\\Users\\User\\Desktop\\TestingSystem\\src\\main\\resources\\common_date\\text_test.txt")%></p>
                    <a href="login.jsp" class="red_button">НАЧАТЬ ТЕСТ</a>
                </div>

                <div class="col-lg-6 col-md-6">
                    <img src="img/student.png" class="img_student">
                </div>
            </div><!-- end container -->
        </div><!-- end main_part -->

        <jsp:include page="templates/nav_footer_main.jsp"/>

    </div><!-- end wrapper -->

<jsp:include page="templates/footer.jsp"/>
