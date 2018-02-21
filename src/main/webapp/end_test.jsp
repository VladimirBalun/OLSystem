<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="ru.tidstu.testingsystem.data.service.BasicDataService" %>

<%
    ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
    BasicDataService basicDataService = (BasicDataService) appContext.getBean("basicDataService");
%>

<jsp:include page="templates/header.jsp"/>

    <div class="container-fluid wrapper">

        <div class="row header">
            <div class="container">
                <div class="col-lg-6 col-md-6">
                    <img src="img/icon.png" class="icon">
                    <p class="description_icon"><%=basicDataService.getNameOfCollege()%></p>
                </div>

                <div class="col-lg-6 col-md-6 l_height">
                    <p class="description_number"><%=basicDataService.getPhoneNumber()%></p>
                    <p class="description_address"><%=basicDataService.getAddress()%></p>
                </div> <!-- end l_height -->
            </div><!-- end container -->
        </div><!-- end header -->

        <div class="row main_part">
            <div class="container">
                <div class="col-lg-6 col-md-6">
                    <p class="title"><%=basicDataService.getTitleOfResult()%></p>
                    <p class="text"><%=basicDataService.getDescriptionOfResult()%></p>
                </div>
                <div class="col-lg-6 col-md-6">
                    <img src="img/student_res.png" class="img_student_res">
                </div>
            </div><!-- end container -->
        </div><!-- end main_part -->

        <div class="row footer">
            <ul class="margin_hyper">
                <li><a href="http://atidstu.ru/" class="white_button">www.tidstu.ru</a></li>
            </ul>
        </div><!-- end footer -->

    </div><!-- end wrapper -->

<jsp:include page="templates/footer.jsp"/>