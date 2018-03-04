var formSortingResults = $("form[name='sort_results']");

formSortingResults.submit(function(){
    var nameGroup = $("select[name='name_sort'] :selected");
    if(nameGroup.text() === "Не выбрано"){
        logger.html("Последняя информация: Выберите способ для сортировки результатов.");
        return false;
    }
    sendDataAndUpdateResults(formSortingResults);
    logger.html("Последняя информация: Результаты отсортированы  [" + nameGroup.text() + "]");
});

function sendDataAndUpdateResults(form){
    $.get(form.attr("action"), form.serialize(), function(responseJson){
        var oldRows = $(".del_row_results");
        oldRows.remove();
        $.each(responseJson, function(index, user) {
            $("<tr class='del_row_results'>").appendTo($("#body_table_results"))
                .append($("<td>").text(user.name))
                .append($("<td>").text(user.group))
                .append($("<td>").text(user.dateOfResult))
                .append($("<td>").text(user.result));
        });
    });
    event.preventDefault();
}
