$(document).ready(function(){

    $("#tasks").css("border-bottom", "2px solid red");
    var formChangeQuestion = $("#form_change");
    new WOW().init();

    function animate(elem){
        var effect = elem.data("effect");
        if(!effect || elem.hasClass(effect)) return false;
        elem.addClass(effect);
        setTimeout( function(){
            elem.removeClass(effect);
        }, 1000);
    }

    formChangeQuestion.submit(function(){
        var number = $(this).find(".task:focus").val();
        $.get(formChangeQuestion.attr("action"), {num_question : number}, function(question){
            $(".untitle").html(question.title);
            $(".txt_question").html(question.text);
            $(".input_data").html(question.inputData);
            $(".output_data").html(question.outputData);
            animate($(".description"));
        });
        event.preventDefault();
    });

});