$(document).ready(function() {

    new WOW().init();

    function animate(elem){
        var effect = elem.data("effect");
        if(!effect || elem.hasClass(effect)) return false;
        elem.addClass(effect);
        setTimeout( function(){
            elem.removeClass(effect);
        }, 1000);
    }

    var formSignIn = $(".sign-in-htm");
    var formSignUp = $(".sign-up-htm");

    var loggerSignIn = $(".log_in");
    var loggerSignUp = $(".log_up");

    formSignIn.submit(function(){
        var login = $("input[name='login_sign_in']");
        var password = $("input[name='pass_sign_in']");
        if(login.val() == ""){
            loggerSignIn.html("Не введен логин.");
            animate(loggerSignIn);
            return false;
        }
        if(password.val() == ""){
            loggerSignIn.html("Не введен пароль.");
            animate(loggerSignIn);
            return false;
        }
        authenticate();
    });

    function authenticate(){
        $.get(formSignIn.attr("action"), formSignIn.serialize(), function(response){
            if(response.length < 100) {
                loggerSignIn.html(response);
                animate(loggerSignIn);
            } else if($("input[name='login_sign_in']").val() == "admin" && $("input[name='pass_sign_in']").val() == "admin"){
                loggerSignIn.html("");
                $(location).attr("href", "/admin_room.jsp");
            } else {
                loggerSignIn.html("");
                $(location).attr("href", "/tasks.jsp");
            }
        });
        event.preventDefault();
    }

    formSignUp.submit(function(){
        var login = $("input[name='login_sign_up']").val();
        var password = $("input[name='pass_sign_up']").val();
        var name = $("input[name='name_sign_up']").val();
        var group = $("select[name='group_sign_up']").val();
        switch("") {
            case login :
                loggerSignUp.html("Не введен логин.");
                animate(loggerSignUp);
                return false;
            case password :
                loggerSignUp.html("Не введен пароль.");
                animate(loggerSignUp);
                return false;
            case name :
                loggerSignUp.html("Не введено ФИО.");
                animate(loggerSignUp);
                return false;
        }
        if(group == "Не выбрано"){
                loggerSignUp.html("Не выбрана группа.");
                animate(loggerSignUp);
                return false;
        }
        register();
    });

    function register() {
        $.post(formSignUp.attr("action"), formSignUp.serialize(), function(response){
            if(response.length < 100) {
                loggerSignUp.html(response);
                animate(loggerSignUp);
            } else {
                loggerSignIn.html("");
                $(location).attr("href", "/tasks.jsp");
            }
        });
        event.preventDefault();
    }

});