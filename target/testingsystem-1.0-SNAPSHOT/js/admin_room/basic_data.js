/**********************************************************
 * This file servers tab basic data(title, description,
 * number, address, name of college) int the admin room. Here
 * occurs to check forms before send on server. If forms
 * is valid, then its send data on server with AJAX.
 **********************************************************/

var formTitles = $("form[name='basic_titels']");
var formContacts = $("form[name='basic_contacts']");
var formDescriptions = $("form[name='basic_descriptions']");

var logger = $(".log_admin");

/**
 * Method for send form of titles on sever. Here checks empty
 * input, if at least one input is empty - this form doesn't send.
 */
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

/**
 * Method for send form of contacts on sever. Here checks empty
 * input, if at least one input is empty - this form doesn't send.
 */
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

/**
 * Method for send form of descriptions on sever. Here checks empty
 * input, if at least one input is empty - this form doesn't send.
 */
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

/**
 * This function sends data on server without reload page. Also
 * its print result in string events int the admin room.
 * @param form form for send data on server
 */
function sendData(form){
    $.post(form.attr("action"), form.serialize(), function(response) {
        var resResponse = decorateSuccess(response);
        logger.html(resResponse);
    });
    event.preventDefault();
}

/**
 * This function decorate string event in the green color.
 * @param text text for decoration
 * @returns {string} decorated text
 */
function decorateSuccess(text){
    var successText = "Последняя информация: <font color='#33AF54'>" + text + "</font>";
    return successText;
}

/**
 * This function decorate string event in the red color.
 * @param text text for decoration
 * @returns {string} decorated text
 */
function decorateError(text){
    var errorText = "Последняя информация: <font color='#AF0303'>" + text + "</font>";
    return errorText;
}