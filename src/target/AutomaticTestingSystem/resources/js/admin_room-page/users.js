var formDelUser = $("form[name='del_user']");
var formSelectUsers = $("form[name='select_users']");

var logger = $(".log_admin");

formDelUser.submit(function(){
    var nameUser = $("select[name='name_user_for_del'] :selected");
    if(nameUser.text() === "Не выбрано"){
        logger.html("Последняя информация: Выберите пользователя для удаления.");
        return false;
    }
    sendDataAndUpdateUsers(formDelUser);
    logger.html("Последняя информация: Пользователь [" + nameUser.val() + "] успешно удалена.");
});

formSelectUsers.submit(function(){
    var nameGroup = $("select[name='group_for_select_users'] :selected");
    if(nameGroup.text() === "Не выбрано"){
        logger.html("Последняя информация: Выберите группу для выборки пользователей.");
        return false;
    }
    sendDataAndUpdateUsers(formSelectUsers);
    logger.html("Последняя информация: Выбраны студенты из группы [" + nameGroup.val() + "]");
});

function sendDataAndUpdateUsers(form){
    $.post(form.attr("action"), form.serialize(), function(responseJson){
        // Removes old options and rows in the select and table
        var oldRows = $(".del_row_users");
        oldRows.remove();
        var oldOptions = $(".del_option_users");
        oldOptions.remove();
        $.each(responseJson, function(index, user) {
            // Adds new options and rows in the select and table
            $("<tr class='del_row_users'>").appendTo($("#body_table_users"))
                .append($("<td>").text(user.name))
                .append($("<td>").text(user.login))
                .append($("<td>").text(user.group.name))
                .append($("<td>").text(user.countTrueAnswers + "/" + user.countQuestions));
            $("<option class='del_option_users'>").appendTo($(".select_users"))
                .append(user.name);
        });
    });
    event.preventDefault();
}