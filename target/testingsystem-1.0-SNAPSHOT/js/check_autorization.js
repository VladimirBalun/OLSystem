/*
 * This script check data in the inputs. If inputs is empty,
 * then form don't send on the Server.
 */
$(document).ready(function() {

    //Check on empty data in the Login form
    $(".sign-in-htm").submit(function(){
        var login = $("input[name='login_sign_in']").val();
        var password = $("input[name='pass_sign_in']").val();

        if(login == "" || password == ""){
            $(".log_in").html("Введены не все данные...");
            return false;
        }

    });

    //Check on empty data in the SignUp form
    $(".sign-up-htm").submit(function(){
        var login = $("input[name='login_sign_up']").val();
        var password = $("input[name='pass_sign_up']").val();
        var name = $("input[name='name_sign_up']").val();
        var group = $("input[name='group_sign_up']").val();

        switch(""){
            case login :
                $(".log_up").html("Не введен логин...");
                return false;
            case password :
                $(".log_up").html("Не введен пароль...");
                return false;
            case name :
                $(".log_up").html("Не введена ФИО...");
                return false;
            case group :
                $(".log_up").html("Не введена группа...");
                return false;
        }


    });

});