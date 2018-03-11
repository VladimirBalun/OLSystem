$(document).ready(function(){

    new WOW().init();

    var formChangeQuestion = $("#form_change");
    var formSendTask = $("#form_send_task");
    var loggerCheckTask = $("#log");

    var sectionTasks = $("#section_tasks");
    var sectionSendTask = $("#section_send_task");

    var btnFinishOlympiad = $("#end_test");
    var btnTasks = $("#tasks");
    var btnSendTask = $("#send_task");

    btnTasks.css("border-bottom", "2px solid red");
    sectionSendTask.hide();

    btnFinishOlympiad.click(function () {
        if(confirm("Вы уверены, что завершить?")){
            $(location).attr("href", "/finishOlympiad");
        } else {
            return false;
        }
    });

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
        $.get(formChangeQuestion.attr("action"), {name_selected_question : number}, function(question){
            $(".untitle").html(question.title);
            $(".txt_question").html(question.text);
            $(".input_data").html(question.inputData);
            $(".output_data").html(question.outputData);
            animate($(".description"));
        });
        event.preventDefault();
    });

    /**
     * Scripts is processing to send task to the server and after
     * receive print result on the page tasks.
     */
    formSendTask.submit(function(){
        if($("textarea[name='text_program']").val() === ""){
            loggerCheckTask.text("Не введен листинг программы, отправка задания невозможна");
            animate(loggerCheckTask);
            return false;
        } else {
            loggerCheckTask.text("Началась обработка задания");
            animate(loggerCheckTask);
            $.post(formSendTask.attr("action"), formSendTask.serialize(), function(response) {
                loggerCheckTask.html(response);
                animate(loggerCheckTask);
                switch (response){
                    case "Ошибка компиляции" :
                        reloadLogs();
                        break;
                    case "Задание выполнено" :
                        reloadLogs();
                        reloadQuestions();
                        reloadUserStatistic();
                        break;
                    case "Ошибка в результате программы" :
                        reloadLogs();
                        break;
                }
            });
        }
        event.preventDefault();
    });

    function reloadLogs(){
        var oldLogs = $(".logs");
        oldLogs.remove();
        $("#logs_running_test").append("<p class='logs'></p>");
        $.get("/tasks/reloadLogs", function (logs) {
            $.each(logs, function(index, log) {
                $(".logs").append(log.time + " - " + log.description + "</br>");
            });
        });
    }

    function reloadQuestions(){
        $(".task").remove();
        $(".task_option").remove();
        $.get("/tasks/reloadQuestions", function (questions) {
            if(questions.length === 0){
                $("textarea[name='text_program']").val("");
                $(location).attr("href", "/finishOlympiad");
            }
            $.each(questions, function(index, question) {
                $("#form_change").append(
                    "<button value=" + question.number + "  name='number_question' class='task'>" +
                        "<p class='title_question'>Задание " + question.number + "</p>" +
                        "<p class='comment_question'>" + question.title + "</p>" +
                    "</button>");
                $("select[name='name_question']").append(
                    "<option class='task_option'>" + question.title + "</option>"
                );
            });
        });
    }

    function reloadUserStatistic(){
        var statistic = $(".run_tasks");
        statistic.html("");
        $.get("/tasks/reloadStatistic", function(response) {
            statistic.html("Выполненных заданий: " + response);
        });
    }


    /**
     * Script is running timer on page of tasks. After the
     * end of the timer, forwards to the page end of the test,
     */
    var hours = 0;
    var minutes = 30;
    var seconds = 25;

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
        $(".timer").html((hours.toString().length === 1 ?  "0" + hours : hours) + ":" +
                         (minutes.toString().length === 1 ? "0" + minutes : minutes) +":" +
                         (seconds.toString().length === 1 ? "0" + seconds : seconds));
        if(hours === 0 && minutes < 10){
            $(".timer").css("color", "#ff574b");
        }
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