<template>
    <div id="settings">
        <div class="section row">
             
            <!-- Form of changingProgrammingLanguageOlympiad -->
            <div class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение языка программирования олимпиады</p>
                    <div class="wrap">
                        <p class="block-help" >Текущий язык:</p>
                        <input disabled="true" class="half-width" v-model="oldProgLanguageOlympiad">
                    </div>
                    <div class="wrap">
                        <p class="block-help" :class="{ 'warning-label' : isEmptyNewProgLanguageOlympiad }">Новый язык:</p>
                        <select class="half-width" v-model="newProgLanguageOlympiad" :class="{ 'warning-edit' : isEmptyNewProgLanguageOlympiad }">
                            <option v-for="language in programmingLanguages">{{ language }}</option>
                        </select>
                    </div>
                    <button class="blue-btn" @click="changeProgrammingLanguageOlympiad">Изменить</button>
                </div>
            </div>

            <!-- Form of changingTimeOltmpiad -->
            <div class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение времени для прохождение олимпиады</p>
                    <div class="wrap">
                        <p class="block-help">Текущее время:</p>
                        <input type="time" disabled="true" class="half-width" v-model="oldTimeOlympiad">
                    </div>
                    <div class="wrap">
                        <p class="block-help" :class="{ 'warning-label' : isEmptyNewTimeOlympiad }">Новое время:</p>
                        <input type="time" class="half-width" v-model="newTimeOlympiad" :class="{ 'warning-edit' : isEmptyNewTimeOlympiad }">
                    </div>
                    <button class="blue-btn" @click="changeTimeOlympiad">Изменить</button>
                </div>
            </div>
            
        </div><!-- End section -->
    </div><!-- End settings -->
</template>

<script>

    export default {
        name : 'settings',
         data() {
            return {

                // Form of changingProgrammingLanguageOlympiad
                oldTimeOlympiad : "",
                newTimeOlympiad : "",
                isEmptyNewTimeOlympiad : false,

                // Form of changingTimeOltmpiad
                oldProgLanguageOlympiad : "",
                newProgLanguageOlympiad : "",
                isEmptyNewProgLanguageOlympiad : false,

                programmingLanguages : []
            }
        },
        created : function () {
            this.loadAllPossibleLanguagesForOlympiad();
            this.loadAllSettingOlympiad();
            this.$root.$data.titleTemplate = "Основные настройки для олимпиады";
            this.$root.$data.event = "";
        }, 
        methods : {

            loadAllPossibleLanguagesForOlympiad : function() {
                var self = this;
                axios.get('/adminRoom/settings/getProgrammingLanguages').then(function (response) {
                    for (var i = 0; i < response.data.length; i++) {
                        self.programmingLanguages.push(response.data[i].name);
                    }
                });
            },

            loadAllSettingOlympiad : function() {
                var self = this;
                axios.get('/adminRoom/settings/getSettingsOlympiad').then(function (response) {
                    for (var i = 0; i < response.data.length; i++) {
                        switch (response.data[i].name) {
                            case "languageOlympiad" :
                                self.oldProgLanguageOlympiad = response.data[i].property;
                                break;
                            case "timeOlympiad" :
                                self.oldTimeOlympiad = response.data[i].property;
                        }
                    }
                });
            },

            changeTimeOlympiad : function() {
                if (this.newTimeOlympiad === "") {
                    this.isEmptyNewTimeOlympiad = true;
                    this.$root.showFailedEvent("Не введено новое время на прохождение олимпиады. Изменение данных невозможно.");
                } else {
                    this.isEmptyNewTimeOlympiad = false;
                    this.$root.showSuccessfulEvent("Выполняется изменение времени для прохождения олимпиады...");

                    var self = this;
                    axios.put('/adminRoom/settings/changeSettingsOlympiad', {
                        name : "timeOlympiad", property : self.newTimeOlympiad
                    }).then(function(resultChanging) {
                        if (resultChanging.data) {
                            self.$root.showSuccessfulEvent("Время проведения олимпиады успешно изменено.");
                            self.oldTimeOlympiad = self.newTimeOlympiad;
                            self.newTimeOlympiad = "";
                        } else {
                            self.$root.showFailedEvent("Ошибка. Времяпроведения олимпиады не было изменено.");
                        }
                    });
                }
            },

            changeProgrammingLanguageOlympiad : function() {
                if (this.newProgLanguageOlympiad === "") {
                    this.isEmptyNewProgLanguageOlympiad = true;
                    this.$root.showFailedEvent("Не выбран новый язык программирования для проведения олимпиады. Изменение данных невозможно.");
                } else {
                    this.isEmptyNewProgLanguageOlympiad = false;
                    this.$root.showSuccessfulEvent("Выполняется изменение языкы программирования для проведения олимпиады...");

                    var self = this;
                    axios.put('/adminRoom/settings/changeSettingsOlympiad', {
                        name : "languageOlympiad", property : this.newProgLanguageOlympiad
                    }).then(function(resultChanging) {
                        if (resultChanging.data) {
                            self.$root.showSuccessfulEvent("Язык программирования для проведения олимпиады успешно изменен..");
                            self.oldTimeOlympiad = self.newTimeOlympiad;
                            self.newTimeOlympiad = "";
                        } else {
                            self.$root.showFailedEvent("Ошибка. Язык программирования для проведения олимпиады не был изменен.");
                        }
                    });
                }
            }

        }

    }

</script>

<style scoped>

    .section {
        width: 102.1%;
    }

    .blue-btn {
        transform: translateY(-1px);
        margin: 4px 0 20px 1%;
    }

    .half-width {
        width: 100%;
    }

    .wrap {
        float: left;
        width: 48%;
        margin: 0 1% 0 1%;
    }

</style>