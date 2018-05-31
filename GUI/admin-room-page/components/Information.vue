<template>
    <div id="information">
        <div class="section row">
             
            <!-- Form of changingDataOlympiad -->
            <form name="changingDataOlympiad" class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение описания олимпиды</p>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyNameOlympiad }" >Название олимпиады [{{ nameOlympiad.length }}/ 25]:</p>
                    <input class="full-width" maxlength="25" v-model="nameOlympiad" :class="{ 'warning-edit' : isEmptyNameOlympiad }"/>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyDescriptionOlympiad }">Описание олимпиады [{{ descriptionOlympiad.length }}/ 150]:</p>
                    <textarea maxlength="150" v-model="descriptionOlympiad" :class="{ 'warning-edit' : isEmptyDescriptionOlympiad }"/>
                    <button class="blue-btn" @click="changeDataOlympiad">Изменить</button>
                </div>
            </form>

            <!-- Form of changingDataResultOlympiad -->
            <form name="changingDataResultOlympiad" class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение описания результа олимпиды</p>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyNameResultOlympiad }" >Заголовок конца олимпиады [{{ nameResultOlympiad.length }}/ 25]:</p>
                    <input class="full-width" maxlength="25" v-model="nameResultOlympiad" :class="{ 'warning-edit' : isEmptyNameResultOlympiad }"/>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyDescriptionResultOlympiad }">Описание конца олимпиады [{{ descriptionResultOlympiad.length }}/ 150]:</p>
                    <textarea maxlength="150" v-model="descriptionResultOlympiad" :class="{ 'warning-edit' : isEmptyDescriptionResultOlympiad }"/>
                    <button class="blue-btn" @click="changeDataResultOlympiad">Изменить</button>
                </div>
            </form>

            <!-- Form of changingIconOlympiad -->
            <form  name="changingIconOlympiad" class="col-lg-6 col-md-6">
                <div id="icon-block" class="block">
                    <p class="main-help">Изменение логотипа олимпиады</p>
                    <img alt="Incorrect URL" :src="urlImage"/>
                    <p id="short-p" class="block-help" :class="{ 'warning-label' : isEmptyUrlImage }">URL логотипа олимпиады [{{ urlImage.length }}/150]:</p>
                    <input maxlength="150" id="short-width-with-img" v-model="urlImage" :class="{ 'warning-edit' : isEmptyUrlImage }"/>
                    <button class="blue-btn short-btn" @click="changeIconOlympiad">Изменить</button>
                </div>
            </form>       
            
            <!-- Form of changingNameCreatorsOlympiad -->
            <form name="changingNameCreatorsOlympiad" class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение авторов олимпиады</p>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyNameCreators }">Название авторов олимпиады [{{ nameCreators.length }}/35]:</p>
                    <input maxlength="35" class="short-width" v-model="nameCreators" :class="{ 'warning-edit' : isEmptyNameCreators }"/>
                    <button class="blue-btn" @click="changeNameCreatorsOlympiad">Изменить</button>
                </div>
            </form>
           
           <!-- Form of changingWebSiteCreatorsOlympiad -->
            <form name="changingWebSiteCreatorsOlympiad" class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение WEB-сайта авторов</p>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyNameWebsite }">Название WEB-сайта [{{ nameWebSite.length }}/30]:</p>
                    <input maxlength="30" class="full-width" v-model="nameWebSite" :class="{ 'warning-edit' : isEmptyNameWebsite }"/>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyLinkWebSite }">Адрес WEB-сайта [{{ linkWebsite.length }}/150]:</p>
                    <input maxlength="150" class="full-width" v-model="linkWebsite" :class="{ 'warning-edit' : isEmptyLinkWebSite }"/>
                    <button class="blue-btn" @click="changeWebSiteCreatorsOlympiad">Изменить</button>
                </div>
            </form>

            <!-- Form of changingContactCreators -->
            <form name="changingContactCreators" class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение контактных данных авторов</p>
                    <p class="block-help" :class="{ 'warning-label' : isEmptyContactDataCreators }">Контактные данные авторов олимпиады [{{ contactDataCreators.length }}/20]:</p>
                    <input maxlength="20" class="short-width" v-model="contactDataCreators" :class="{ 'warning-edit' : isEmptyContactDataCreators }"/>  
                    <button class="blue-btn" @click="changeContactDataCreators">Изменить</button>
                </div>
            </form>
            
        </div><!-- End section -->
    </div><!-- End information -->
</template>

<script>

    export default {
        name : 'information',
        data() {
            return {

                // Form of changingDataOlympiad
                nameOlympiad : "Название олимпиады",
                isEmptyNameOlympiad : false,
                descriptionOlympiad : "Описание олимпиады",
                isEmptyDescriptionOlympiad : false,

                // Form of changingDataResultOlympiad
                nameResultOlympiad : "Олимпиада завершена",
                isEmptyNameResultOlympiad : false,
                descriptionResultOlympiad : "Описание результата проведения олимпиады",
                isEmptyDescriptionResultOlympiad : false,

                // Form of changingIconOlympiad
                urlImage : "https://www.citibank.ru/russia/images/citigroup/citi-co-r_2c-blu_pos_rgb.jpg",
                isEmptyUrlImage : false,

                // Form of changingNameCreatorsOlympiad 
                nameCreators : "Название авторов олимпиады",
                isEmptyNameCreators : false,

                // Form of changingWebSiteCreatorsOlympiad
                nameWebSite : "www.вашсайn.ru",
                isEmptyNameWebsite : false,
                linkWebsite : "www.google.com",
                isEmptyLinkWebSite : false,

                // Form of changingContactCreators
                contactDataCreators : "+7(345)-345-45-45",
                isEmptyContactDataCreators : false

            }
        },
        created: function () {
            this.$root.$data.titleTemplate = "Основная информация о проводимой олимпиаде";
            this.$root.$data.event = "";
        },
        methods: {
            
            // Form of changingDataOlympiad
            changeDataOlympiad : function() {
                if (this.nameOlympiad === "" && this.descriptionOlympiad === ""){
                    this.isEmptyNameOlympiad = true;
                    this.isEmptyDescriptionOlympiad = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введено название олимпиады и ее описание. Изменение данных невозможно.";
                } else if (this.nameOlympiad === "") {
                    this.isEmptyNameOlympiad = true;
                    this.isEmptyDescriptionOlympiad = false;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введено название олимпиады. Изменение данных невозможно.";
                } else if (this.descriptionOlympiad === "") {
                    this.isEmptyNameOlympiad = false;
                    this.isEmptyDescriptionOlympiad = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введено описание олимпиады. Изменение данных невозможно.";
                } else {
                    this.isEmptyNameOlympiad = false;
                    this.isEmptyDescriptionOlympiad = false;
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется изменения названия и описания олимпиады..."
                }
            },

            // Form of changingDataResultOlympiad
            changeDataResultOlympiad : function() {
                if (this.nameResultOlympiad === "" && this.descriptionResultOlympiad === ""){
                    this.isEmptyNameResultOlympiad = true;
                    this.isEmptyDescriptionResultOlympiad = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введены заголовок конца олимпиады и ее описание. Изменение данных невозможно.";
                } else if (this.nameResultOlympiad === "") {
                    this.isEmptyNameResultOlympiad = true;
                    this.isEmptyDescriptionResultOlympiad = false;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введены заголовок конца олимпиады. Изменение данных невозможно.";
                } else if (this.descriptionResultOlympiad === "") {
                    this.isEmptyNameResultOlympiad = false;
                    this.isEmptyDescriptionResultOlympiad = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введено описание конца олимпиады. Изменение данных невозможно.";
                } else {
                    this.isEmptyNameResultOlympiad = false;
                    this.isEmptyDescriptionResultOlympiad = false;
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется изменения заголовка конца олимпиады и ее описание..."
                }
            },

            // Form of changingIconOlympiad
            changeIconOlympiad : function() {
                if(this.urlImage === "") {
                    this.isEmptyUrlImage = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введен URL логотипа олимпиады. Изменение данных невозможно."
                } else {
                    this.isEmptyUrlImage = false;
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется изменение логотипа олимпиады..."
                }
            },

            // Form of changingNameCreatorsOlympiad 
            changeNameCreatorsOlympiad : function() {
                if (this.nameCreators === ""){
                    this.isEmptyNameCreators = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введен название авторов олимпиады. Изменение данных невозможно."
                } else {
                    this.isEmptyNameCreators = false;
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется изменение авторов олимпиады..."
                }
            },

            // Form of changingWebSiteCreatorsOlympiad
            changeWebSiteCreatorsOlympiad : function() {
               if (this.nameWebSite === "" && this.linkWebsite === ""){
                    this.isEmptyNameWebsite = true;
                    this.isEmptyLinkWebSite = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введены название сайта и ссылка авторов олимпиады. Изменение данных невозможно."
                } else if (this.nameWebSite === "") {
                    this.isEmptyNameWebsite = true;
                    this.isEmptyLinkWebSite = false;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введено название сайта авторов олимпиады. Изменение данных невозможно."
                } else if (this.linkWebsite === "") {
                    this.isEmptyNameWebsite = false;
                    this.isEmptyLinkWebSite = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введена ссылка сайта авторов олимпиады. Изменение данных невозможно."
                } else {
                    this.isEmptyNameWebsite = false;
                    this.isEmptyLinkWebSite = false;
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется изменение сайта авторов олимпиады..."
                }
            },

            // Form of changingContactCreators
            changeContactDataCreators : function() {
                if (this.contactDataCreators === ""){
                    this.isEmptyContactDataCreators = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введены контактные данные авторов олимпиады. Изменение данных невозможно."
                } else {
                    this.isEmptyContactDataCreators = false;
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется изменение контактных данных авторов олимпиады..."
                }
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
        page-break-inside: 10px 10px 10px 10px;
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