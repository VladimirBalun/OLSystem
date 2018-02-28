<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="templates/header.jsp"/>

    <div class="container-fluid wrapper">

        <div class="row header">
            <div class="container">
                <div class="col-lg-6 col-md-6">
                    <img src="img/icon.png" class="icon">
                    <p class="description_icon">${nameCollege}</p>
                </div>

                <div class="col-lg-6 col-md-6 l_height">
                    <p class="description_number">${numberCollege}</p>
                    <p class="description_address">${addressCollege}</p>
                </div> <!-- end l_height -->
            </div><!-- end container -->
        </div><!-- end header -->

        <div class="row main_part">
            <div class="container">
                <div class="col-lg-6 col-md-6">
                    <p class="title">${titleResult}</p>
                    <p class="text">${descriptionResult}</p>
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