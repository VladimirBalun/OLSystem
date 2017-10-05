<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../templates/header.jsp"/>

    <div class="container-fluid background_login">

        <center><form method="post" action="tasks.jsp" class="login_block">
            <div class="login_inputs">
                <p>Логин</p>
                <input type="text" required>
                <p>Пароль</p>
                <input type="password" required>
            </div>
            <div class="login_buttons">
                <a href="">Регистрация</a>
                <button title="Нажмите на кнопку, чтобы начать тест">Войти</button>
            </div>
        </form></center>

    </div>

<jsp:include page="../templates/footer.jsp"/>
