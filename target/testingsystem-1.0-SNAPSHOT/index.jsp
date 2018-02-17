<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.tidstu.testingsystem.models.BasicData" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>

<%
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/app-context.xml");
    BasicData basicData = (BasicData) applicationContext.getBean("basicData");;
%>

<jsp:include page="templates/header.jsp"/>

    <div class="container-fluid wrapper">

        <div class="row header">
            <div class="container">
                <div class="col-lg-6 col-md-6">
                    <img src="img/icon.png" class="icon">
                    <p class="description_icon"><%=basicData.getNameOfCollege()%></p>
                </div>

                <div class="col-lg-6 col-md-6 l_height">
                    <p class="description_number"><%=basicData.getPhoneNumber()%></p>
                    <p class="description_address"><%=basicData.getAddress()%></p>
                </div> <!-- end l_height -->
            </div><!-- end container -->
        </div><!-- end header -->

        <div class="row main_part">
            <div class="container">
                <form action="/Index" method="GET" class="col-lg-6 col-md-6">
                    <p class="title"><%=basicData.getTitleOfTest()%></p>
                    <p class="text"><%=basicData.getDescriptionOfTest()%></p>
                    <button class="red_button">НАЧАТЬ ТЕСТ</button>
                </form>

                <div class="col-lg-6 col-md-6">
                    <img src="img/student.png" class="img_student">
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
