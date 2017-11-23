<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.tidstu.testingsystem.models.IOFile" %>

<div class="row header">
    <div class="container">
        <div class="col-lg-6 col-md-6">
            <img src="img/icon.png" class="icon">
            <p class="description_icon"><%=IOFile.readFile("C:\\Users\\User\\Desktop\\TestingSystem\\src\\main\\resources\\common_date\\title.txt")%></p>
        </div>

        <div class="col-lg-6 col-md-6 l_height">
            <p class="description_number"><%=IOFile.readFile("C:\\Users\\User\\Desktop\\TestingSystem\\src\\main\\resources\\common_date\\number.txt")%></p>
            <p class="description_address"><%=IOFile.readFile("C:\\Users\\User\\Desktop\\TestingSystem\\src\\main\\resources\\common_date\\address.txt")%></p>
        </div> <!-- end l_height -->
    </div><!-- end container -->
</div><!-- end header -->
