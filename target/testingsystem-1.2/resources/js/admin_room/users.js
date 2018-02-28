var formDelUser = $("form[name='del_user']");
var formSelectUsers = $("form[name='select_users']");

var logger = $(".log_admin");

formDelUser.submit(function(){
    var nameUser = $("select[name='name_user_for_del'] :selected");
    if(nameUser.text() == "Не выбрано"){
        logger.html(decorateError("Выберите пользователя для удаления."));
        return false;
    }
    sendDataAndUpdateUsers(formDelUser);
    logger.html(decorateSuccess("Пользователь " + nameUser.val() + " успешно удалена."));
});

formSelectUsers.submit(function(){
    var nameGroup = $("select[name='group_for_select_users'] :selected");
    if(nameGroup.text() == "Не выбрано"){
        logger.html(decorateError("Выберите группу для выборки пользователей."));
        return false;
    }
    sendDataAndUpdateUsers(formSelectUsers);
    logger.html(decorateSuccess("Выбраны студенты из группы " + nameGroup.val()));
});

function sendDataAndUpdateUsers(form){
    $.post(form.attr("action"), form.serialize(), function(responseJson){
        var oldRows = $(".del_row_users");
        oldRows.remove();
        var oldOptions = $(".del_option_users");
        oldOptions.remove();
        $.each(responseJson, function(index, user) {
            $("<tr class='del_row_users'>").appendTo($("#body_table_users"))
                .append($("<td>").text(user.name))
                .append($("<td>").text(user.login))
                .append($("<td>").text(user.group))
                .append($("<td>").text(user.bestResult));
            $("<option class='del_option_users'>").appendTo($(".select_users"))
                .append(user.name);
        });
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