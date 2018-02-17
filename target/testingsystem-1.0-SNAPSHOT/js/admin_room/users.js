/**********************************************************
 * This file servers tab users in the admin room. Here
 * occurs to check forms before send on server. If forms
 * is valid, then its send data on server with AJAX. After
 * update data in table of users and selects with name of
 * users.
 **********************************************************/

var formDelUser = $("form[name='del_user']");
var formSelectUsers = $("form[name='select_users']");

var logger = $(".log_admin");

/**
 * This method checks form on empty select. If form hasn't
 * empty select, then send data of form on the server and
 * update data on the page with AJAX,
 */
formDelUser.submit(function(){
    var nameUser = $("select[name='name_user_for_del'] :selected");
    if(nameUser.text() == "Не выбрано"){
        logger.html(decorateError("Выберите пользователя для удаления."));
        return false;
    }
    sendDataAndUpdateTable(formDelUser);
    logger.html(decorateSuccess("Пользователь " + nameUser.val() + " успешно удалена."));
});

/**
 * This method checks form on empty select. If form hasn't
 * empty select, then send data of form on the server and
 * update data on the page with AJAX,
 */
formSelectUsers.submit(function(){
    var nameGroup = $("select[name='group_for_select_users'] :selected");
    if(nameGroup.text() == "Не выбрано"){
        logger.html(decorateError("Выберите группу для выборки пользователей."));
        return false;
    }
    sendDataAndUpdateTable(formSelectUsers);
    logger.html(decorateSuccess("Выбраны студенты из группы " + nameGroup.val()));
});

/**
 * Function send data from form on server, used AJAX. Also update
 * table of users and select with name of users.
 * @param form form for send on server.
 */
function sendDataAndUpdateTable(form){
    $.post(form.attr("action"), form.serialize(), function(responseJson){
        deleteOldData();
        $.each(responseJson, function(index, user) {
            addNewData(index, user)
        });
    });
    event.preventDefault();
}

/**
 * Function deletes old rows in table and old options in select.
 */
function deleteOldData(){
    //Delete old rows in table
    var oldRows = $(".del_row_users");
    oldRows.remove();
    //Delete old options in select
    var oldOptions = $(".del_option_users");
    oldOptions.remove();
}

/**
 * Functions adds new rows in table and new options in select
 * @param index index of record.
 * @param group user for additional.
 */
function addNewData(index, user){
    //Add new rows in table
    $("<tr class='del_row_users'>").appendTo($("#body_table_users"))
        .append($("<td>").text(user.name))
        .append($("<td>").text(user.login))
        .append($("<td>").text(user.group))
        .append($("<td>").text(user.bestResult));
    //Add new options in selects
    $("<option class='del_option_users'>").appendTo($(".select_users"))
        .append(user.name);
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