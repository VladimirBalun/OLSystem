<template>
    <div id="testData">
        <div class="section row">
             
            <!-- Form of addingTestDataForTask --> 
            <div name="addingTestDataForTask" class="col-lg-12 col-md-12">
                <div class="block">
                    <p class="main-help">Добавление тестовых данных для задания</p>
                    <div class="wrap">
                        <p class="block-help" :class="{ 'warning-label' : isEmptySelectedTask }">Выберите задание:</p>
                        <select v-model="selectedTask" :class="{ 'warning-edit' : isEmptySelectedTask }">
                            <option v-for="task in $root.$data.tasks">{{ task.title }}</option>
                        </select>
                    </div>
                    <div class="wrap">
                        <p class="block-help" :class="{ 'warning-label' : isEmptyInputData }">Входные данные: [{{ inputData.length }}/ 100]:</p>
                        <input class="full-width" maxlength="100" :class="{ 'warning-edit' : isEmptyInputData }" v-model="inputData"/>
                    </div>
                    <div class="wrap">
                        <p class="block-help" :class="{ 'warning-label' : isEmptyOutputData }">Выходные данные {{ outputData.length }}[/ 100]:</p>
                        <input class="full-width" maxlength="100" :class="{ 'warning-edit' : isEmptyOutputData }" v-model="outputData"/>
                    </div>
                    <button class="blue-btn" @click="addNewTestDataForTask">Добавить</button>
                    
                </div>
            </div>

            <div class="col-lg-12 col-md-12">
                <div class="block">
                    <p class="block-help">Динамический поиск заданий по названию:</p>
                    <input class="half-width" placeholder="Поиск..." v-model="searchingTestData">
                    <button id="fixed-width" class="blue-btn" @click="removeSelectedTestData">Удалить тестовые данные</button>
                    <table class="table table-striped">
                        <thead class="thead-inverse">
                            <tr>
                                <th>#{{ $root.$data.testData.length }}</th>
                                <th>Название задания</th>
                                <th>Входные данные</th>
                                <th>Выходные данные</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="data in filteredTestData">
                                <td>
                                    <input class="checkbox" type="checkbox" v-bind:value="data" v-model="selectedTestData">
                                </td>
                                <td>{{ data.titleTask }}</td>
                                <td>{{ data.inputData }}</td>
                                <td>{{ data.outputData }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div><!-- End block -->
            </div>

        </div><!-- End section -->
    </div><!-- End testData -->
</template>

<script>

 export default {
        name : 'testData',
        data() {
            return {

                // Form addingTestDataForTask
                selectedTask : "",
                isEmptySelectedTask : false,
                inputData : "",
                isEmptyInputData : false,
                outputData : "",
                isEmptyOutputData : false,

                selectedTestData : [],
                searchingTestData : ""

            }
        },
        created : function () {
            this.loadAllTestData();
            this.$root.$data.titleTemplate = "Тестовые данные для заданий";
            this.$root.$data.event = "";
        }, 
        computed : {
            filteredTestData : function() {
                var query = this.searchingTestData;
                return this.$root.$data.testData.filter(function (data) {
                    if(query === '') {
                        return true;
                    } else {
                        return data.titleTask.indexOf(query) > -1;
                    }
                })
            }
        },
        methods : {

            loadAllTestData : function() {
                var self = this;
                axios.get('/adminRoom/testData/getTestData').then(function (response) {
                    console.log(response);
                    // for (var i = 0; i < response.data.length; i++) {
                    //     self.$root.$data.testData.push({
                    //         titleTask : response.data[i].task.title,
                    //         inputData : response.data[i].inputData,
                    //         outputData : response.data[i].outputData
                    //     });
                    // }
                });
            },

            addNewTestDataForTask : function() {
                if (this.selectedTask === "" || this.inputData === "" || this.outputData === "") {
                    this.$root.showFailedEvent("Введены не все данные. Добавление тестовых данных невозможно.");
                    this.isEmptySelectedTask = this.selectedTask === "";
                    this.isEmptyInputData = this.inputData === "";
                    this.isEmptyOutputData = this.outputData === "";
                } else {
                    this.$root.showSuccessfulEvent("Выполняется добавления тестовых данных для задания \"" + this.selectedTask + "\"...");

                    var self = this;
                    axios.post('/adminRoom/results/addTestData', { testData : {
                        // task : {
                        //     title : self.selectedTask
                        // },
                        inputData : self.inputData,
                        outputData : self.outputData
                    }}).then(function (response) {
                        console.log(response);
                        if(response.data) {
                            self.$root.showSuccessfulEvent("Тестовые данные для задания \"" + self.selectedTask + "\" успешно добавлены.");
                            self.$root.$data.testData.push({
                                titleTask : self.selectedTask,
                                inputData : self.inputData,
                                outputData : self.outputData
                            });
                            self.$root.clearInputs(self.inputData, self.outputData);
                        } else {
                            self.$root.showFailedEvent("Тестовые данные для задания \"" + self.selectedTask + "\" не были добавлены.");
                        }
                    });
                }
            },

            removeSelectedTestData : function() {
                if (this.selectedTestData.length === 0) {
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не выбрано ни одного тестового данного для удаления. Удаление невозможно.";
                } else {
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется удаления выбранных тестовых данных...";

                    // Deleting selected test data fro tasks from table
                    for(var i = 0; i < this.selectedTestData.length; i++) {
                        var index = this.$root.$data.testData.map(function(data) { 
                            return data; 
                        }).indexOf(this.selectedTestData[i]);
                        this.$root.$data.testData.splice(index, 1);
                    }
                    this.selectedTestData = [];    
                }
            }

        }
    }

</script>

<style scoped>

    .section {
        width: 102.1%;
    }

    .full-width,
    select {
        width: 100%;
    }

    .wrap {
        width: 26%;
        float: left;
        padding: 5px;
    }

    .blue-btn {
        float: left;
        width: 22%;
        margin: 28px 0 20px 0;

    }

    #fixed-width {
        float: none;
        margin: 0;
        width: 260px;       
    }

    .half-width {
        width: calc(100% - 265px);
        transform: translateY(1px);
    }

</style>