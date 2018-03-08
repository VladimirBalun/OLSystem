var tabsMenu = {
    tabBasicData : $("#tab_basic_data"),
    tabQuestions : $("#tab_questions"),
    tabResultsOfTests : $("#tab_results_test"),
    tabGroups : $("#tab_groups"),
    tabUsers : $("#tab_users")
};

var sections = {
    basicData : $(".basic_data"),
    questions : $(".questions"),
    resultsOfTests : $(".result_of_test"),
    groups : $(".groups"),
    users : $(".users")
};


$(document).ready(function() {

    //Initial set of parameters
    sections.basicData.show();
    tabsMenu.tabBasicData.addClass("hover_btn");

    //Forward on section of basic data
    tabsMenu.tabBasicData.click(function () {
        forwardToNewTabInMenu(tabsMenu.tabBasicData, sections.basicData);
    });

    //Forward on section of questions
    tabsMenu.tabQuestions.click(function () {
        forwardToNewTabInMenu(tabsMenu.tabQuestions, sections.questions);
    });

    //Forward on section of results of the test
    tabsMenu.tabResultsOfTests.click(function () {
        forwardToNewTabInMenu(tabsMenu.tabResultsOfTests, sections.resultsOfTests);
    });

    //Forward on section of groups
    tabsMenu.tabGroups.click(function () {
        forwardToNewTabInMenu(tabsMenu.tabGroups, sections.groups);
    });

    //Forward on section of users
    tabsMenu.tabUsers.click(function () {
        forwardToNewTabInMenu(tabsMenu.tabUsers, sections.users);
    });

});

/**
 * Function runs to forward between sections on the page.
 * @param curTab selected tab of menu
 * @param curSection section, which will be open
 */
function forwardToNewTabInMenu(curTab, curSection) {
    //Remove selection from all the tabs
    for(var it in tabsMenu){
        tabsMenu[it].removeClass("hover_btn");
    }
    //Closes all the sections
    for(var it in sections){
        sections[it].hide();
    }
    //Select tab and open section
    curTab.addClass("hover_btn");
    curSection.show();
}