var formChangeTimeOlympiad = $("form[name='change_time_olympiad']");
var formChangeLanguageOlympiad = $("form[name='change_language_olympiad']");

var logger = $(".log_admin");

formChangeTimeOlympiad.submit(function () {
    var newTime = $("input[name='new_time']").val();
    if(newTime === ""){
        logger.html("Последняя информация: Не введено новое время для прохождения олимпиады.");
        return false;
    }
    sendDataAndGetResult(formChangeTimeOlympiad)
});

formChangeLanguageOlympiad.submit(function () {
   var newLanguage = $("select[name='new_language']").val();
   if(newLanguage === "Не выбрано"){
       logger.html("Последняя информация: Не выбран новый язык программирования для проведения олимпиады.");
       return false;
   }
   $("#cur_language").html(newLanguage);
   sendDataAndGetResult(formChangeLanguageOlympiad)
});

function sendDataAndGetResult(form) {
    $.post(form.attr("action"), form.serialize(), function(response){
        logger.html("Последняя информация: " + response);
    });
    event.preventDefault();
}
