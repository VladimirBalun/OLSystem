var formAddGroup = $("form[name='add_group']");
var formChangeGroup = $("form[name='change_group']");
var formDelGroup = $("form[name='del_group']");

var logger = $(".log_admin");

formAddGroup.submit(function(){
    var titleGroup = $("input[name='title_group']");
    if(titleGroup.val() == ""){
        logger.html(decorateError("Введите название группы."));
        return false;
    }
    sendDataAndUpdateGroups(formAddGroup);
    logger.html(decorateSuccess("Группа " + titleGroup.val() + " успешно добавлена."));
});

formChangeGroup.submit(function(){
    var newTitleGroup = $("input[name='new_title_group']");
    var oldTitleGroup = $("select[name='old_title_group'] :selected");
    if(newTitleGroup.val() == ""){
        logger.html(decorateError("Введите новое название группы."));
        return false;
    }
    if(oldTitleGroup.text() == "Не выбрано"){
        logger.html(decorateError("Выберите старое название группы."));
        return false;
    }
    sendDataAndUpdateGroups(formChangeGroup);
    logger.html(decorateSuccess("Название группы " + oldTitleGroup.val() +
                                " успешно изменено на " + newTitleGroup.val() + "."));
});

formDelGroup.submit(function(){
    var titleGroup = $("select[name='title_group_del'] :selected");
    if(titleGroup.text() == "Не выбрано"){
        logger.html(decorateError("Выберите группу для удаления."));
        return false;
    }
    sendDataAndUpdateGroups(formDelGroup);
    logger.html(decorateSuccess("Группа " + titleGroup.val() + " успешно удалена."));
});

function sendDataAndUpdateGroups(form){
    $.post(form.attr("action"), form.serialize(), function(responseJson){
        var oldRows = $(".del_row_groups");
        oldRows.remove();
        var oldOptions = $(".del_option_groups");
        oldOptions.remove();
        $.each(responseJson, function(index, group) {
            $("<tr class='del_row_groups'>").appendTo($("#body_table_groups"))
                .append($("<td>").text(group.name))
                .append($("<td>").text(group.countUsers))
                .append($("<td>").text("0%"));
            $("<option class='del_option_groups'>").appendTo($(".select_groups"))
                .append(group.name);
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