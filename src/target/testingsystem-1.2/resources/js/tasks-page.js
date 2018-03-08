$(document).ready(function(){

    new WOW().init();

    var formChangeQuestion = $("#form_change");
    var formSendTask = $("#form_send_task");
    var loggerCheckTask = $("#log");

    var sectionTasks = $("#section_tasks");
    var sectionSendTask = $("#section_send_task");

    var btnTasks = $("#tasks");
    var btnSendTask = $("#send_task");

    btnTasks.css("border-bottom", "2px solid red");
    sectionSendTask.hide();

    btnTasks.click(function(){
        sectionSendTask.hide();
        sectionTasks.show();
        btnTasks.css("border-bottom", "2px solid red");
        btnSendTask.css("border-bottom", "0");
    });

    btnSendTask.click(function(){
        sectionTasks.hide();
        sectionSendTask.show();
        btnSendTask.css("border-bottom", "2px solid red");
        btnTasks.css("border-bottom", "0");
    });

    formChangeQuestion.submit(function(){
        var number = $(this).find(".task:focus").val();
        $.get(formChangeQuestion.attr("action"), {number_question : number}, function(question){
            $(".untitle").html(question.title);
            $(".txt_question").html(question.text);
            $(".input_data").html(question.inputData);
            $(".output_data").html(question.outputData);
            animate($(".description"));
        });
        event.preventDefault();
    });

    formSendTask.submit(function(){
        if($("textarea[name='text_program']").val() === ""){
            loggerCheckTask.text("Не введен листинг программы, отправка задания невозможна");
            animate(loggerCheckTask);
            return false;
        } else {
            loggerCheckTask.text("Началась обработка задания");
            animate(loggerCheckTask);
            $.ajax({
                type: formSendTask.attr('method'),
                url: formSendTask.attr('action'),
                data: formSendTask.serialize(),
                success: function (response) {
                    loggerCheckTask.html(response);
                    animate(loggerCheckTask);
                }
            });
        }
        event.preventDefault();
    });

    var time = document.cookie;
    alert(document.cookie);
    alert(time);
    var result = time.split(":");
    alert(result);
    var hours = result[0];
    var minutes = result[1];
    var seconds = result[2];

    var timer = setInterval(function (){
        if(seconds === 0){
            if(minutes === 0){
                if(hours === 0){
                    clearInterval(timer);
                    $(location).attr("href", "/finishOlympiad");
                } else {
                    hours--;
                }
                minutes = 60;
            } else {
                minutes--;
            }
            seconds = 60;
        } else {
            seconds--;
        }
        $(".timer").html(hours + ":" + minutes + ":" + seconds);
    }, 1000);

    // Blocking is the transition to the back
    history.pushState(null, null, location.href);
    window.onpopstate = function(event) {
        history.go(1);
    };

    // Function animates any events on the page
    function animate(elem){
        var effect = elem.data("effect");
        if(!effect || elem.hasClass(effect)) return false;
        elem.addClass(effect);
        setTimeout( function(){
            elem.removeClass(effect);
        }, 1000);
    }

});