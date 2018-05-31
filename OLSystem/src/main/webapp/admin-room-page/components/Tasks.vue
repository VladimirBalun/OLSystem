<template>
    <div id="tasks">
        <div class="section row">
             
            <!-- Form of addingNewTask -->
            <div class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Добавление нового задания</p>
                    <p class="block-help" :class="{ 'warning-label' : addingForm.isEmptyTitle }">Название задания [{{ addingForm.title.length }}/ 20]:</p>
                    <input class="full-width" maxlength="20" v-model="addingForm.title" :class="{ 'warning-edit' : addingForm.isEmptyTitle }"/>
                    <p class="block-help" :class="{ 'warning-label' : addingForm.isEmptyDescription }">Описание задания [{{ addingForm.description.length }}/ 2000]:</p>
                    <textarea id="big-height" maxlength="2000" v-model="addingForm.description" :class="{ 'warning-edit' : addingForm.isEmptyDescription }"/>
                    <button class="blue-btn" @click="addNewTask">Добавить</button>
                </div>
            </div>

            <!-- Form of changingSelectedTask -->
            <div class="col-lg-6 col-md-6">
                <div class="block">
                    <p class="main-help">Изменение выбранного задания</p>
                    <p class="block-help" :class="{ 'warning-label' : changingForm.isEmptySelectedTask }">Выберите задание:</p>
                    <select @change="onChangeSelectedTask" v-model="changingForm.selectedTask" :class="{ 'warning-edit' : changingForm.isEmptySelectedTask }">
                        <option v-for="task in $root.$data.tasks">{{ task.title }}</option>
                    </select>
                    <p class="block-help" :class="{ 'warning-label' : changingForm.isEmptyTitle }">Название задания [{{ changingForm.title.length }}/ 20]:</p>
                    <input class="full-width" maxlength="20" v-model="changingForm.title" :class="{ 'warning-edit' : changingForm.isEmptyTitle }"/>
                    <p class="block-help" :class="{ 'warning-label' : changingForm.isEmptyDescription }">Описание задания [{{ changingForm.description.length }}/ 2000]:</p>
                    <textarea maxlength="2000" v-model="changingForm.description" :class="{ 'warning-edit' : changingForm.isEmptyDescription }"/>
                    <button class="blue-btn" @click="changeSelectedTask">Изменить</button>
                </div>
            </div>

            <div class="col-lg-12 col-md-12">
                <div class="block">
                    <p class="block-help">Динамический поиск заданий по названию:</p>
                    <input class="half-width" placeholder="Поиск..." v-model="searchingTasks">
                    <button class="blue-btn" @click="removeSelectedTasks">Удалить задания</button>
                    <table class="table table-striped">
                        <thead class="thead-inverse">
                            <tr>
                                <th>#{{ $root.$data.tasks.length }}</th>
                                <th>Название</th>
                                <th>Описание</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="task in filteredTasks">
                                <td>
                                    <input class="checkbox" type="checkbox" v-bind:value="task.title" v-model="selectedTasks">
                                </td>
                                <td>{{ task.title }}</td>
                                <td>{{ task.description }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div><!-- End block -->
            </div>
        
        </div><!-- End section -->
    </div><!-- End tasks -->
</template>

<script>

    export default {
        name : 'tasks',
        data() {
            return {

                // Form of addingNewTask
                addingForm : {
                    title : "",
                    isEmptyTitle : false,
                    description : "",
                    isEmptyDescription : false
                },

                // Form of changingNewTask
                changingForm : {
                    selectedTask : "",
                    isEmptySelectedTask : false,
                    title : "",
                    isEmptyTitle : false,
                    description : "",
                    isEmptyDescription : false
                },

                selectedTasks : [],
                searchingTasks : ""

            }
        },
        created : function () {
            this.loadAllTasks();
            this.$root.$data.titleTemplate = "Задания для прохождения олимпиады";
            this.$root.$data.event = "";
        }, 
        computed : {
            filteredTasks : function() {
                var query = this.searchingTasks;
                return this.$root.$data.tasks.filter(function (task) {
                    if(query === '') {
                        return true;
                    } else {
                        return task.title.indexOf(query) > -1;
                    }
                })
            }
        },
        methods : {

            onChangeSelectedTask : function() {
                for (var i = 0; i < this.$root.$data.tasks.length; i++) {
                    if(this.$root.$data.tasks[i].title === this.changingForm.selectedTask) {
                        this.changingForm.title = this.$root.$data.tasks[i].title;
                        this.changingForm.description = this.$root.$data.tasks[i].description;
                    }
                }
            },

            clearInputs : function(){
                for (var i = 0; i < arguments.length; i++) {
                    arguments[i] = "";
                }
            },

            loadAllTasks : function () {
                var self = this;
                axios.get('/adminRoom/tasks/getTasks').then(function (response) {
                    console.log(response);
                    // for (var i = 0; i < response.data.length; i++) {
                    //     self.$root.$data.tasks.push({
                    //         title : response.data[i].title,
                    //         description : response.data[i].description
                    //     });
                    // }
                });
            },

            addNewTask : function(){
                if (this.addingForm.title === "" && this.addingForm.description === "") {
                    this.addingForm.isEmptyTitle = true;
                    this.addingForm.isEmptyDescription = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введено название задания и его описание. Добавление задания невозможно.";
                } else if (this.addingForm.title === "") {
                    this.addingForm.isEmptyTitle = true;
                    this.addingForm.isEmptyDescription = false;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введено название задания. Добавление задания невозможно.";
                } else if (this.addingForm.description === "") {
                    this.addingForm.isEmptyTitle = false;
                    this.addingForm.isEmptyDescription = true;
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не введено описание задания. Добавление задания невозможно.";
                } else {
                    this.addingForm.isEmptyTitle = false;
                    this.addingForm.isEmptyDescription = false;
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется добавление нового задания...";

                    var resultAdding = this.$root.sendPostRequest('/adminRoomTabs/tasks/addTask', { task : {
                        title : this.addingForm.title,
                        description : this.addingForm.description
                    }});
                    var self = this;
                    axios.post('/adminRoom/tasks/addTask', {
                        title : self.addingForm.title,
                        description : self.addingForm.description
                    }).then(function (response) {
                        console.log(response);
                        if(response.data) {
                            self.$root.$data.isFailureEvent = false;
                            self.$root.$data.event = "Задание \"" + self.addingForm.title + "\" успешно добавлено.";
                            self.$root.$data.tasks.push({
                                title : self.addingForm.title,
                                description : self.addingForm.description
                            });
                            self.$root.clearInputs(self.addingForm.title, self.addingForm.description);
                        } else {
                            self.$root.$data.isFailureEvent = true;
                            self.$root.$data.event = "Ошибка. Задание \"" + self.addingForm.title + "\" не было добавлено.";
                        }
                    });
                }
            },

            changeSelectedTask : function() {
                if (this.changingForm.title === "" || this.changingForm.description === "" || this.changingForm.selectedTask === "") {
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Введены не все данные. Изменение данных невозможно.";

                    this.changingForm.isEmptySelectedTask = this.changingForm.selectedTask === "";
                    this.changingForm.isEmptyTitle = this.changingForm.title === "";
                    this.changingForm.isEmptyDescription = this.changingForm.description === "";

                } else {
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется изменение задания \"" + this.changingForm.selectedTask + "\"..."



                    if (this.sendRequestOnChangingTask()) {
                        this.$root.$data.isFailureEvent = false;
                        this.$root.$data.event = "Задание \"" + this.changingForm.selectedTask + "\" успешно изменено.";

                        // Changing data in table, after changing in database
                        for(var i = 0; i < this.$root.$data.tasks.length; i++) {
                            if(this.$root.$data.tasks[i].title === this.changingForm.selectedTask) {
                                this.$root.$data.tasks[i].title = this.changingForm.title;
                                this.$root.$data.tasks[i].description = this.changingForm.description;
                                break;
                            }
                        }

                        this.clearInputs(this.changingForm.title, this.changingForm.description);
                    } else {
                        this.$root.$data.isFailureEvent = true;
                        this.$root.$data.event = "Ошибка. Задание \"" + this.changingForm.selectedTask + "\" не изменено.";
                    }
                }
            },

            sendRequestOnChangingTask : function() {
                var self = this;
                axios.put('/adminRoom/tasks/changeTask', {
                    title : self.changingForm.selectedTask,
                    newTitle : self.changingForm.title,
                    newDescription : self.changingForm.description
                }).then(function (response) {
                    return response.data;
                });
            },

            removeSelectedTasks : function() {
                if (this.selectedTasks.length === 0) {
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не выбрано ни одного задания для удаления. Удаление невозможно.";
                } else {
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется удаления выбранных заданий: \"" + this.selectedTasks + "\"...";

                    if (this.sendRequestOnDeletingTask()) {
                        this.$root.$data.isFailureEvent = false;
                        this.$root.$data.event = "Задания успешно удалены.";

                        // Deleting selected tasks from table
                        for(var i = 0; i < this.selectedTasks.length; i++) {
                            var index = this.$root.$data.tasks.map(function(task) {
                                return task.title;
                            }).indexOf(this.selectedTasks[i]);
                            this.$root.$data.tasks.splice(index, 1);
                        }

                        // Deleting test data, where title of test data is equal with selected task
                        for(var i = 0; i < this.selectedTasks.length; i++) {
                            for(var j = 0; j < this.$root.$data.testData.length; j++) {
                                if(this.$root.$data.testData[j].titleTask === this.selectedTasks[i]){
                                    this.$root.$data.testData.splice(j, 1);
                                    j--;
                                }
                            }
                        }

                        this.clearInputs(this.changingForm.title, this.changingForm.description, )
                        this.selectedTasks = [];
                    } else {
                        this.$root.$data.isFailureEvent = true;
                        this.$root.$data.event = "Ошибка. Задания не были удалены.";
                    }
                }
            },

            sendRequestOnDeletingTask : function() {
                var self = this;
                axios.delete('/adminRoomTabs/tasks/removeTasks', { data:
                        { titles : self.selectedTasks}
                }).then(function (response) {
                    return response.data;
                });
            }

        }
    }

</script>

<style scoped>

    .section {
        width: 102.1%;
    }

    .block {
        padding-bottom: 15px;
    }

    .blue-btn {
        width: 250px;
        margin: 0;
        transform: translateY(-1px);
    }

    .half-width {
        width: calc(100% - 255px);
    }

    .full-width,
    select {
        width: 100%;
    }

    textarea {
        resize: none;
        width: 100%;
        height: 100px;
    }

    #big-height {
        height: 161px;
    }

</style>