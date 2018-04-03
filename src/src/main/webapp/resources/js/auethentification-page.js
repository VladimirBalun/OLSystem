$(document).ready(function() {

    new WOW().init();

    var formSignIn = $(".sign-in-htm");
    var formSignUp = $(".sign-up-htm");

    var loggerSignIn = $(".log_in");
    var loggerSignUp = $(".log_up");

    var btnSignIn = $("button[name='btn_sign_in']");
    var btnSignUp = $("button[name='btn_sign_up']");

    formSignIn.submit(function(){
        disableButton(btnSignIn);
        var login = $("input[name='login_sign_in']");
        var password = $("input[name='pass_sign_in']");
        if(login.val() === ""){
            loggerSignIn.html("Не введен логин.");
            animate(loggerSignIn);
            enableButton(btnSignIn);
            return false;
        }
        if(password.val() === ""){
            loggerSignIn.html("Не введен пароль.");
            animate(loggerSignIn);
            enableButton(btnSignIn);
            return false;
        }
        authenticate(formSignIn, btnSignIn);
    });

    formSignUp.submit(function(){
        disableButton(btnSignUp);
        var login = $("input[name='login_sign_up']").val();
        var password = $("input[name='pass_sign_up']").val();
        var name = $("input[name='name_sign_up']").val();
        var group = $("select[name='group_sign_up']").val();
        switch("") {
            case login :
                loggerSignUp.html("Не введен логин.");
                animate(loggerSignUp);
                enableButton(btnSignUp);
                return false;
            case password :
                loggerSignUp.html("Не введен пароль.");
                animate(loggerSignUp);
                enableButton(btnSignUp);
                return false;
            case name :
                loggerSignUp.html("Не введено ФИО.");
                animate(loggerSignUp);
                enableButton(btnSignUp);
                return false;
        }
        if(group === "Не выбрано"){
            loggerSignUp.html("Не выбрана группа.");
            animate(loggerSignUp);
            enableButton(btnSignUp);
            return false;
        }
        authenticate(formSignUp, btnSignUp);
    });

    function authenticate(form, btn){
        disableButton(btn);
        $.get(form.attr("action"), form.serialize(), function(response){
            switch (response){
                case "tasks" :
                    $(location).attr("href", "/tasks/showPage");
                    btn.val("Подключаюсь...");
                    break;
                case "adminRoom" :
                    $(location).attr("href", "/adminRoom/showPage");
                    btn.val("Подключаюсь...");
                    break;
                default :
                    loggerSignIn.html(response);
                    animate(loggerSignIn);
                    enableButton(btnSignIn);
            }
        });
        event.preventDefault();
    }

    function animate(elem){
        var effect = elem.data("effect");
        if(!effect || elem.hasClass(effect)) return false;
        elem.addClass(effect);
        setTimeout( function(){
            elem.removeClass(effect);
        }, 1000);
    }

    function disableButton(btn){
        btn.css("background-color","#4D88EE");
        btn.css( 'cursor', 'default' );
        btn.disabled = true;
    }

    function enableButton(btn){
        btn.css("background-color","#1161EE");
        btn.css( 'cursor', 'pointer' );
        btn.disabled = false;
    }

});