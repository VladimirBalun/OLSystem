new Vue({
    el: ".wrapper",
    data: {

        creatorOlympiad : "",
        numberCreator : "",

        nameOlympiad : "",
        titleEndOlympiad : "",
        descriptionEndOlympiad : "",

        linkToWebSite : "",
		linkToIconOlympiad : "",
        nameWebSite : ""

    },
    created : function () {
        this.loadInitialDataForPage();
    },
    methods : {

        /**
         *
         */
        loadInitialDataForPage : function() {
            var self = this;
            axios.get('/olympiad/getDataOlympiad').then(function (response) {
                var info = response.data;
                for (var i = 0; i < info.length; i++) {
                    switch (info[i].name) {
                        case "creatorOlympiad" :
                            self.creatorOlympiad = info[i].data;
                            break;
                        case "numberCreator" :
                            self.numberCreator = info[i].data;
                            break;
                        case "nameOlympiad" :
                            self.nameOlympiad = info[i].data;
                            break;
                        case "titleEndOlympiad" :
                            self.titleEndOlympiad = info[i].data;
                            break;
                        case "descriptionEndOlympiad" :
                            self.descriptionEndOlympiad = info[i].data;
                            break;
                        case "linkToWebSite" :
                            self.linkToWebSite = info[i].data;
                            break;
                        case "nameWebSite" :
                            self.nameWebSite = info[i].data;
                            break;
                        case "linkToIconOlympiad" :
                            self.linkToIconOlympiad = info[i].data;
                    }
                }
            });
        }

    }
});