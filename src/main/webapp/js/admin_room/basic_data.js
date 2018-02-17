var formTitles = $("form[name='basic_titels']");
var formContacts = $("form[name='basic_contacts']");
var formDescriptions = $("form[name='basic_descriptions']");

var logger = $(".log_admin");

formTitles.submit(function(){
    var titleOfTest = $("input[name='title_test']");
    var titleOfResult = $("input[name='title_result_test']");
    if(titleOfTest.val() == ""){
        logger.html(decorateError("Введите название системы тестирования."));
        return false;
    }
    if(titleOfResult.val() == ""){
        logger.html(decorateError("Введите заголовок результата прохождения системы тестирования."));
        return false;
    }
    sendData(formTitles);
});

formContacts.submit(function(){
    var address = $("input[name='address']");
    var phoneNumber = $("input[name='phone_number']");
    var nameOfCollege = $("input[name='name_college']");
    if(address.val() == ""){
        logger.html(decorateError("Введите адрес учебного заведения."));
        return false;
    }
    if(phoneNumber.val() == ""){
        logger.html(decorateError("Введите телефонный номер учебного заведения."));
        return false;
    }
    if(nameOfCollege.val() == ""){
        logger.html(decorateError("Введите название учебного заведения."));
        return false;
    }
    sendData(formContacts);
});

formDescriptions.submit(function () {
    var descriptionOfTest = $("input[name='description_test']");
    var descriptionOfResult = $("input[name='description_result_test']");
    if(descriptionOfTest.val() == ""){
        logger.html(decorateError("Введите описание системы тестирования."));
        return false;
    }
    if(descriptionOfResult.val() == ""){
        logger.html(decorateError("Введите описание результата прохождения системы тестирования."));
        return false;
    }
    sendData(formDescriptions);
});

function sendData(form){
    $.post(form.attr("action"), form.serialize(), function(response) {
        var resResponse = decorateSuccess(response);
        logger.html(resResponse);
    });
    event.preventDefault();
}

function decorateSuccess(text){
    var successText = "Последняя информация: <font color='#33AF54'>" + text + "</font>";
    return successText;
}

function decorateError(text){
    var errorText = "Последняя информация: <font color='#AF0303'>" + text + "</font>";
    return errorText;
}