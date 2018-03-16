var formTitles = $("form[name='basic_titels']");
var formContacts = $("form[name='basic_contacts']");
var formDescriptions = $("form[name='basic_descriptions']");

var logger = $(".log_admin");

formTitles.submit(function(){
    var titleOfTest = $("input[name='title_test']");
    var titleOfResult = $("input[name='title_result_test']");
    if(titleOfTest.val() === ""){
        logger.html("Последняя информация: Введите название системы тестирования.");
        return false;
    }
    if(titleOfResult.val() === ""){
        logger.html("Последняя информация: Введите заголовок результата прохождения системы тестирования.");
        return false;
    }
    updateBasicData(formTitles);
});

formContacts.submit(function(){
    var address = $("input[name='address']");
    var phoneNumber = $("input[name='phone_number']");
    var nameOfCollege = $("input[name='name_college']");
    if(address.val() === ""){
        logger.html("Последняя информация: Введите адрес учебного заведения.");
        return false;
    }
    if(phoneNumber.val() === ""){
        logger.html("Последняя информация: Введите телефонный номер учебного заведения.");
        return false;
    }
    if(nameOfCollege.val() === ""){
        logger.html("Последняя информация: Введите название учебного заведения.");
        return false;
    }
    updateBasicData(formContacts);
});

formDescriptions.submit(function () {
    var descriptionOfTest = $("input[name='description_test']");
    var descriptionOfResult = $("input[name='description_result_test']");
    if(descriptionOfTest.val() === ""){
        logger.html("Последняя информация: Введите описание системы тестирования.");
        return false;
    }
    if(descriptionOfResult.val() === ""){
        logger.html("Последняя информация: Введите описание результата прохождения системы тестирования.");
        return false;
    }
    updateBasicData(formDescriptions);
});

function updateBasicData(form){
    $.post(form.attr("action"), form.serialize(), function(response) {
        logger.html("Последняя информация: " + response);
    });
    event.preventDefault();
}