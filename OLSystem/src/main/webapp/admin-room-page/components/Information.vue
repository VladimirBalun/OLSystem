<template>
    <div id="information">
        <div class="section row">
             
            <!-- Form of changingDataOlympiad -->
            <div class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение описания олимпиды</p>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyNameOlympiad }" >Название олимпиады [{{ nameOlympiad.length }}/ 25]:</p>
                    <input class="full-width" maxlength="25" v-model="nameOlympiad" :class="{ 'warning-edit' : isEmptyNameOlympiad }"/>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyDescriptionOlympiad }">Описание олимпиады [{{ descriptionOlympiad.length }}/ 150]:</p>
                    <textarea maxlength="150" v-model="descriptionOlympiad" :class="{ 'warning-edit' : isEmptyDescriptionOlympiad }"></textarea>
                    <button class="blue-btn" @click="changeDataOlympiad">Изменить</button>
                </div>
            </div>

            <!-- Form of changingDataResultOlympiad -->
            <div class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение описания результа олимпиды</p>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyTitleEndOlympiad }" >Заголовок конца
                        олимпиады [{{ titleEndOlympiad.length }}/ 25]:</p>
                    <input class="full-width" maxlength="25" v-model="titleEndOlympiad" :class="{ 'warning-edit' : isEmptyTitleEndOlympiad }"/>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyDescriptionEndOlympiad }">Описание конца
                        олимпиады [{{ descriptionEndOlympiad.length }}/ 150]:</p>
                    <textarea maxlength="150" v-model="descriptionEndOlympiad" :class="{ 'warning-edit' : isEmptyDescriptionEndOlympiad }"></textarea>
                    <button class="blue-btn" @click="changeDataResultOlympiad">Изменить</button>
                </div>
            </div>

            <!-- Form of changingIconOlympiad -->
            <div class="col-lg-6 col-md-6">
                <div id="icon-block" class="block">
                    <p class="main-help">Изменение логотипа олимпиады</p>
                    <img alt="Incorrect URL" :src="linkToIconOlympiad"/>
                    <p id="short-p" class="block-help" :class="{ 'warning-label' : isEmptyLinkToIconOlympiad }">URL логотипа
                        олимпиады [{{ linkToIconOlympiad.length }}/150]:</p>
                    <input maxlength="150" id="short-width-with-img" v-model="linkToIconOlympiad" :class="{ 'warning-edit' : isEmptyLinkToIconOlympiad }"/>
                    <button class="blue-btn short-btn" @click="changeIconOlympiad">Изменить</button>
                </div>
            </div>
            
            <!-- Form of changingNameCreatorsOlympiad -->
            <div class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение авторов олимпиады</p>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyCreatorOlympiad }">Название авторов олимпиады
                        [{{ creatorOlympiad.length }}/35]:</p>
                    <input maxlength="35" class="short-width" v-model="creatorOlympiad" :class="{ 'warning-edit' : isEmptyCreatorOlympiad }"/>
                    <button class="blue-btn" @click="changeNameCreatorsOlympiad">Изменить</button>
                </div>
            </div>
           
           <!-- Form of changingWebSiteCreatorsOlympiad -->
            <div class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение WEB-сайта авторов</p>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyNameWebsite }">Название WEB-сайта [{{ nameWebSite.length }}/30]:</p>
                    <input maxlength="30" class="full-width" v-model="nameWebSite" :class="{ 'warning-edit' : isEmptyNameWebsite }"/>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyLinkToWebSite }">Адрес WEB-сайта [{{
                        linkToWebSite.length }}/150]:</p>
                    <input maxlength="150" class="full-width" v-model="linkToWebSite" :class="{ 'warning-edit' : isEmptyLinkToWebSite }"/>
                    <button class="blue-btn" @click="changeWebSiteCreatorsOlympiad">Изменить</button>
                </div>
            </div>

            <!-- Form of changingContactCreators -->
            <div class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение контактных данных авторов</p>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyNumberCreator }">Контактные данные
                        авторов олимпиады [{{ numberCreator.length }}/20]:</p>
                    <input maxlength="20" class="short-width" v-model="numberCreator" :class="{ 'warning-edit' : isEmptyNumberCreator }"/>
                    <button class="blue-btn" @click="changeContactDataCreators">Изменить</button>
                </div>
            </div>
            
        </div><!-- End section -->
    </div><!-- End information -->
</template>

<script>

    export default {
        name : 'information',
        data() {
            return {

                // Form of changingDataOlympiad
                nameOlympiad : "",
                isEmptyNameOlympiad : false,
                descriptionOlympiad : "",
                isEmptyDescriptionOlympiad : false,

                // Form of changingDataResultOlympiad
                titleEndOlympiad : "",
                isEmptyTitleEndOlympiad : false,
                descriptionEndOlympiad : "",
                isEmptyDescriptionEndOlympiad : false,

                // Form of changingIconOlympiad
                linkToIconOlympiad : "",
                isEmptyLinkToIconOlympiad : false,

                // Form of changingNameCreatorsOlympiad 
                creatorOlympiad : "",
                isEmptyCreatorOlympiad : false,

                // Form of changingWebSiteCreatorsOlympiad
                nameWebSite : "",
                isEmptyNameWebsite : false,
                linkToWebSite : "",
                isEmptyLinkToWebSite : false,

                // Form of changingContactCreators
                numberCreator : "",
                isEmptyNumberCreator : false

            }
        },
        created: function () {
            this.loadAllDataOlympiad();
            this.$root.$data.titleTemplate = "Основная информация о проводимой олимпиаде";
            this.$root.$data.event = "";
        },
        methods: {

            loadAllDataOlympiad : function() {
                var self = this;
                axios.get('/adminRoom/information/getDataOlympiad').then(function (response) {
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
                            case "descriptionOlympiad" :
                                self.descriptionOlympiad = info[i].data;
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
            },

            changeDataOlympiad : function() {
                if (this.nameOlympiad === "" && this.descriptionOlympiad === ""){
                    this.isEmptyNameOlympiad = true;
                    this.isEmptyDescriptionOlympiad = true;
                    this.$root.showFailedEvent("Не введено название олимпиады и ее описание. Изменение данных невозможно.");
                } else if (this.nameOlympiad === "") {
                    this.isEmptyNameOlympiad = true;
                    this.isEmptyDescriptionOlympiad = false;
                    this.$root.showFailedEvent("Не введено название олимпиады. Изменение данных невозможно.");
                } else if (this.descriptionOlympiad === "") {
                    this.isEmptyNameOlympiad = false;
                    this.isEmptyDescriptionOlympiad = true;
                    this.$root.showFailedEvent("Не введено описание олимпиады. Изменение данных невозможно.");
                } else {
                    this.isEmptyNameOlympiad = false;
                    this.isEmptyDescriptionOlympiad = false;
                    this.$root.showSuccessfulEvent("Выполняется изменения названия и описания олимпиады...");
                    this.sendRequestOnChangingDataOlympiad([
                            { name : "nameOlympiad", data : this.nameOlympiad },
                            { name : "descriptionOlympiad", data : this.descriptionOlympiad }
                        ], "Название олимпиады и ее описание успешно измены.",
                        "Ошибка. Название олимпиады и ее описание не были изменены.");
                }
            },

            changeDataResultOlympiad : function() {
                if (this.titleEndOlympiad === "" && this.descriptionEndOlympiad === ""){
                    this.isEmptyTitleEndOlympiad = true;
                    this.isEmptyDescriptionEndOlympiad = true;
                    this.$root.showFailedEvent("Не введены заголовок конца олимпиады и ее описание. Изменение данных невозможно.");
                } else if (this.titleEndOlympiad === "") {
                    this.isEmptyTitleEndOlympiad = true;
                    this.isEmptyDescriptionEndOlympiad = false;
                    this.$root.showFailedEvent("Не введены заголовок конца олимпиады. Изменение данных невозможно.");
                } else if (this.descriptionEndOlympiad === "") {
                    this.isEmptyTitleEndOlympiad = false;
                    this.isEmptyDescriptionEndOlympiad = true;
                    this.$root.showFailedEvent("Не введено описание конца олимпиады. Изменение данных невозможно.");
                } else {
                    this.isEmptyTitleEndOlympiad = false;
                    this.isEmptyDescriptionEndOlympiad = false;
                    this.$root.showSuccessfulEvent("Выполняется изменения заголовка конца олимпиады и ее описание...");
                    this.sendRequestOnChangingDataOlympiad([
                             { name : "titleEndOlympiad", data : this.titleEndOlympiad },
                             { name : "descriptionEndOlympiad", data : this.descriptionEndOlympiad }
                        ], "Заголовок конца олимпиады и его описание успешно изменены.",
                        "Ошибка. Заголовок конца олимпиады и его описание не были изменены.");
                }
            },

            changeIconOlympiad : function() {
                if(this.linkToIconOlympiad === "") {
                    this.isEmptyLinkToIconOlympiad = true;
                    this.$root.showFailedEvent("Не введен URL логотипа олимпиады. Изменение данных невозможно.");
                } else {
                    this.isEmptyLinkToIconOlympiad = false;
                    this.$root.showSuccessfulEvent("Выполняется изменение логотипа олимпиады...");
                    this.sendRequestOnChangingDataOlympiad([
                            { name : "linkToIconOlympiad", data : this.linkToIconOlympiad }
                        ], "Логотип олимпиады успешно изменен.",
                        "Ошибка. Логотип олимпиады не был изменен.");
                }
            },

            changeNameCreatorsOlympiad : function() {
                if (this.creatorOlympiad === ""){
                    this.isEmptyCreatorOlympiad = true;
                    this.$root.showFailedEvent("Не введен название авторов олимпиады. Изменение данных невозможно.");
                } else {
                    this.isEmptyCreatorOlympiad = false;
                    this.$root.showSuccessfulEvent("Выполняется изменение авторов олимпиады...");
                    this.sendRequestOnChangingDataOlympiad([
                            { name : "creatorOlympiad", data : this.creatorOlympiad }
                        ], "Название Авторов олимпиады успешно изменены.",
                        "Ошибка. Название Авторов олимпиады не были изменены.");
                }
            },

            changeWebSiteCreatorsOlympiad : function() {
               if (this.nameWebSite === "" && this.linkToWebSite === ""){
                    this.isEmptyNameWebsite = true;
                    this.isEmptyLinkToWebSite = true;
                    this.$root.showFailedEvent("Не введены название сайта и ссылка авторов олимпиады. Изменение данных невозможно.");
                } else if (this.nameWebSite === "") {
                    this.isEmptyNameWebsite = true;
                    this.isEmptyLinkToWebSite = false;
                    this.$root.showFailedEvent("Не введено название сайта авторов олимпиады. Изменение данных невозможно.");
                } else if (this.linkToWebSite === "") {
                    this.isEmptyNameWebsite = false;
                    this.isEmptyLinkToWebSite = true;
                    this.$root.showFailedEvent("Не введена ссылка сайта авторов олимпиады. Изменение данных невозможно.");
                } else {
                    this.isEmptyNameWebsite = false;
                    this.isEmptyLinkToWebSite = false;
                    this.$root.showSuccessfulEvent("Выполняется изменение сайта авторов олимпиады...");
                    this.sendRequestOnChangingDataOlympiad([
                            { name : "nameWebSite", data : this.nameWebSite },
                            { name : "linkToWebSite", data : this.linkToWebSite }
                        ], "Сайт авторов олимпиады успешно изменен.",
                        "Ошибка. Сайт авторов олимпиады не был изменен.");
                }
            },

            changeContactDataCreators : function() {
                if (this.numberCreator === ""){
                    this.isEmptyNumberCreator = true;
                    this.$root.showFailedEvent("Не введены контактные данные авторов олимпиады. Изменение данных невозможно.");
                } else {
                    this.isEmptyNumberCreator = false;
                    this.$root.showSuccessfulEvent("Выполняется изменение контактных данных авторов олимпиады...");
                    this.sendRequestOnChangingDataOlympiad([
                            { name : "numberCreator", data : this.numberCreator }
                        ], "Контактные данные авторов олимпиады успешно изменены.",
                        "Ошибка. Контактные данные авторов олимпиады не были изменены.");
                }
            },

            sendRequestOnChangingDataOlympiad : function(data, successfulMessage, failedMessage) {
                var self = this;
                axios.put('/adminRoom/information/changeDataOlympiad', data).then(function(resultChanging) {
                    if (resultChanging.data) {
                        self.$root.showSuccessfulEvent(successfulMessage);
                    } else {
                        self.$root.showFailedEvent(failedMessage);
                    }
                });
            }

        }
    }

</script>

<style scoped>

    .section {
        width: 102.1%;
    }

    img {
        float: left;
        width: 55px;
        height: 55px;
        border: 1px solid #3A8BCE;
        background-color: white;
        margin-right: 5px;
    }

    textarea {
        resize: none;
        width: 100%;
        height: 100px;
    }

    .full-width {
        width: 100%;
    }

    .short-width {
        margin-right: 5px;
        float: left;
        width: calc(100% - 145px);
    }

    #short-width-with-img {
       float: left;
       width: calc(100% - 205px); 
    }

    #short-p {
        float: left;
        width: calc(100% - 60px);
    }

    .short-btn{
        float: left;
        margin-left: 5px;
        margin-bottom: 10px;
    }

    #icon-block {
        padding-top: 14px;
        height: 116px;
    }

</style>