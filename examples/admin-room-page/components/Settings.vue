<template>
    <div id="settings">
        <div class="section row">
             
            <!-- Form of changingProgrammingLanguageOlympiad -->
            <form name="changingProgrammingLanguageOlympiad" class="col-lg-6 col-md-6">
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
                    <button class="blue-btn" @click="changeProgLanguageOlympiad">Изменить</button>
                </div>
            </form>

            <!-- Form of changingTimeOltmpiad -->
            <form name="changingTimeOltmpiad" class="col-lg-6 col-md-6">
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
            </form>
            
        </div><!-- End section -->
    </div><!-- End settings -->
</template>

<script>

    export default {
        name : 'settings',
         data() {
            return {

                // Form of changingProgrammingLanguageOlympiad
                oldTimeOlympiad : "02:00",
                newTimeOlympiad : "",
                isEmptyNewTimeOlympiad : false,

                // Form of changingTimeOltmpiad
                oldProgLanguageOlympiad : "Cpp",
                newProgLanguageOlympiad : "",
                isEmptyNewProgLanguageOlympiad : false,

                programmingLanguages : [
                    "Cpp",
                    "C",
                    "Java",
                    "Python"
                ]
            }
        },
        created : function () {
            this.$root.$data.titleTemplate = "Основные настройки для олимпиады";
            this.$root.$data.event = "";
        }, 
        methods : {

            // Form of changingProgrammingLanguageOlympiad
            changeTimeOlympiad : function() {
                if (this.newTimeOlympiad === "") {
                    this.isEmptyNewTimeOlympiad = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введено новое время на прохождение олимпиады. Изменение данных невозможно."
                } else {
                    this.isEmptyNewTimeOlympiad = false;
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется изменение времени для прохождения олимпиады..."

                    this.oldTimeOlympiad = this.newTimeOlympiad;
                    this.newTimeOlympiad = "";
                }
            },

            // Form of changingTimeOltmpiad
            changeProgLanguageOlympiad : function() {
                if (this.newProgLanguageOlympiad === "") {
                    this.isEmptyNewProgLanguageOlympiad = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не выбран новый язык программирования для проведения олимпиады. Изменение данных невозможно."
                } else {
                    this.isEmptyNewProgLanguageOlympiad = false;
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется изменение языкы программирования для проведения олимпиады..."

                    this.oldProgLanguageOlympiad = this.newProgLanguageOlympiad;
                    this.newProgLanguageOlympiad = "";
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