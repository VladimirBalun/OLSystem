var formAddTestDataOfQuestions = $("form[name='add_data_of_question']");
var formDelQuestion = $("form[name='del_question']");
var formAddQuestion = $("form[name='add_question']");
var formChangeQuestion = $("form[name='change_question']");

var logger = $(".log_admin");

formAddTestDataOfQuestions.submit(function () {
    var inputData = $("input[name='input_data']");
    var outputData = $("input[name='output_data']");
    var nameQuestion = $("select[name='name_question_for_add'] :selected");
    if(inputData.val() == ""){
        logger.html(decorateError("Не введены входные данные для вопроса."));
        return false;
    }
    if(outputData.val() == ""){
        logger.html(decorateError("Не введены выходные данные для вопроса."));
        return false;
    }
    if(nameQuestion.text() == "Не выбрано"){
        logger.html(decorateError("Не выбран вопрос для добавления тестовых данных."));
        return false;
    }
    sendDataAndUpdateQuestions(formAddTestDataOfQuestions);
    inputData.val("");
    outputData.val("");
    logger.html(decorateSuccess("Добавлены тестовые данные для вопроса " + nameQuestion.val()));
});

formDelQuestion.submit(function () {
    var nameQuestion = $("select[name='name_question_for_del'] :selected");
    if(nameQuestion.text() == "Не выбрано"){
        logger.html(decorateError("Не выбран вопрос для удаления."));
        return false;
    }
    sendDataAndUpdateQuestions(formDelQuestion);
    var titleQuestion = $("textarea[name='title_question_for_change']");
    var textQuestion = $("textarea[name='text_question_for_change']");
    if(nameQuestion.text() == titleQuestion.val()){
        titleQuestion.val("");
        textQuestion.val("");
    }
    logger.html(decorateSuccess("Вопрос " + nameQuestion.val() + " успешно удален."));
});

formAddQuestion.submit(function () {
    var titleQuestion = $("textarea[name='title_question_for_add']");
    var textQuestion = $("textarea[name='text_question_for_add']");
    if(titleQuestion.val() == ""){
        logger.html(decorateError("Не введено название вопроса."));
        return false;
    }
    if(textQuestion.val() == ""){
        logger.html(decorateError("Не введен текст вопроса."));
        return false;
    }
    sendDataAndUpdateQuestions(formAddQuestion);
    titleQuestion.val("");
    textQuestion.val("");
    logger.html(decorateSuccess("Добавлен вопрос " + titleQuestion.val()));
});

formChangeQuestion.submit(function () {
    var titleQuestion = $("textarea[name='title_question_for_change']");
    var textQuestion = $("textarea[name='text_question_for_change']");
    var nameQuestion = $("select[name='name_question_for_change'] :selected");
    if(nameQuestion.text() == "Не выбрано"){
        logger.html(decorateError("Не выбран вопрос для изменения."));
        return false;
    }
    if(titleQuestion.val() == ""){
        logger.html(decorateError("Не введено название вопроса."));
        return false;
    }
    if(textQuestion.val() == ""){
        logger.html(decorateError("Не введен текст вопроса."));
        return false;
    }
    sendDataAndUpdateQuestions(formChangeQuestion);
    logger.html(decorateSuccess("Вопрос " + nameQuestion.val() + " успешно изменен."));
});

function sendDataAndUpdateQuestions(form){
    $.post(form.attr("action"), form.serialize(), function(responseJson){
        var oldOptions = $(".del_option_questions");
        oldOptions.remove();
        $.each(responseJson, function(index, question) {
            $("<option class='del_option_questions'>").appendTo($(".select_questions"))
                .append(question.title);
        });
    });
    event.preventDefault();
}

var nameQuestion = $("select[name='name_question_for_change']");
nameQuestion.change(function () {
    if(nameQuestion.val() == "Не выбрано"){
        return false;
    }
    var titleQuestion = $("textarea[name='title_question_for_change']");
    var textQuestion = $("textarea[name='text_question_for_change']");
    $.ajax({
        url : 'QuestionsServlet',
        method : "GET",
        data : {
            nameQuestion : nameQuestion.val()
        },
        success : function(question) {
            titleQuestion.val(question.title);
            textQuestion.val(question.text);
        }
    });
    logger.html(decorateSuccess("Вопрос " + nameQuestion.val() + " загружен для изменений."));
});

function decorateSuccess(text){
    var successText = "Последняя информация: <font color='#33AF54'>" + text + "</font>";
    return successText;
}

function decorateError(text){
    var errorText = "Последняя информация: <font color='#AF0303'>" + text + "</font>";
    return errorText;
}