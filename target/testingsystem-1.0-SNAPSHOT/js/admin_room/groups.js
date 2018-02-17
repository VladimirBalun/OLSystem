/**********************************************************
 * This file servers tab groups int the admin room. Here
 * occurs to check forms before send on server. If forms
 * is valid, then its send data on server with AJAX. After
 * update data in table of groups and selects with name of
 * groups.
 **********************************************************/

var formAddGroup = $("form[name='add_group']");
var formChangeGroup = $("form[name='change_group']");
var formDelGroup = $("form[name='del_group']");

var logger = $(".log_admin");

/**
 * This method checks form on empty inputs. If form hasn't
 * empty inputs, then send data of form on the server and
 * update data on the page with AJAX,
 */
formAddGroup.submit(function(){
    var titleGroup = $("input[name='title_group']");
    if(titleGroup.val() == ""){
        logger.html(decorateError("Введите название группы."));
        return false;
    }
    sendDataAndUpdateTable(formAddGroup);
    logger.html(decorateSuccess("Группа " + titleGroup.val() + " успешно добавлена."));
});

/**
 * This method checks form on empty input and select. If form hasn't
 * empty input and select, then send data of form on the server and
 * update data on the page with AJAX,
 */
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
    sendDataAndUpdateTable(formChangeGroup);
    logger.html(decorateSuccess("Название группы " + oldTitleGroup.val() +
                                " успешно изменено на " + newTitleGroup.val() + "."));
});

/**
 * This method checks form on empty select. If form hasn't
 * empty select, then send data of form on the server and
 * update data on the page with AJAX,
 */
formDelGroup.submit(function(){
    var titleGroup = $("select[name='title_group_del'] :selected");
    if(titleGroup.text() == "Не выбрано"){
        logger.html(decorateError("Выберите группу для удаления."));
        return false;
    }
    sendDataAndUpdateTable(formDelGroup);
    logger.html(decorateSuccess("Группа " + titleGroup.val() + " успешно удалена."));
});

/**
 * Function send data from form on server, used AJAX. Also update
 * table of groups and select with name of groups.
 * @param form form for send on server.
 */
function sendDataAndUpdateTable(form){
    $.post(form.attr("action"), form.serialize(), function(responseJson){
        deleteOldData();
        $.each(responseJson, function(index, group) {
            addNewData(index, group)
        });
    });
    event.preventDefault();
}

/**
 * Function deletes old rows in table and old options in select.
 */
function deleteOldData(){
    //Delete old rows in table
    var oldRows = $(".del_row_groups");
    oldRows.remove();
    //Delete old options in select
    var oldOptions = $(".del_option_groups");
    oldOptions.remove();
}

/**
 * Functions adds new rows in table and new options in select
 * @param index index of record.
 * @param group group for additional.
 */
function addNewData(index, group){
    //Add new rows in table
    $("<tr class='del_row_groups'>").appendTo($("#body_table_groups"))
        .append($("<td>").text(group.name))
        .append($("<td>").text(group.countUsers))
        .append($("<td>").text("0%"));
    //Add new options in selects
    $("<option class='del_option_groups'>").appendTo($(".select_groups"))
        .append(group.name);
}

/**
 * This function decorate string event in the green color.
 * @param text text for decoration.
 * @returns {string} decorated text.
 */
function decorateSuccess(text){
    var successText = "Последняя информация: <font color='#33AF54'>" + text + "</font>";
    return successText;
}

/**
 * This function decorate string event in the red color.
 * @param text text for decoration.
 * @returns {string} decorated text.
 */
function decorateError(text){
    var errorText = "Последняя информация: <font color='#AF0303'>" + text + "</font>";
    return errorText;
}