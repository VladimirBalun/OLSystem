<template>
    <div id="results">
        <div class="block">
            <p class="block-help">Динамический поиск результатов участников по ФИО участника:</p>
            <input class="half-width" v-model="searchingResults" placeholder="Поиск...">
            <button class="blue-btn" @click="removeSelectedResults">Удалить результаты</button>
            <table class="table table-striped">
                <thead class="thead-inverse">
                    <tr>
                        <th>#{{ $root.$data.results.length }}</th>
                        <th>ФИО</th>
                        <th>Логин</th>
                        <th>Дата прохождения</th>
                        <th>Результат</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="resultUser in filteredResults">
                        <td>
                            <input class="checkbox" type="checkbox" v-bind:value="resultUser" v-model="selectedResults">
                        </td>
                        <td>{{ resultUser.name}}</td>
                        <td>{{ resultUser.login }}</td>
                        <td>{{ resultUser.data }}</td>
                        <td>{{ resultUser.result }}</td>
                    </tr>
                </tbody>
            </table>
         </div><!-- End block -->
    </div><!-- End results -->
</template>

<script>

    export default {
        name : 'resultss',
        data() {
            return {
                selectedResults : [],
                searchingResults : ""
            }
        },
        created: function () {
            this.loadResultsUsers();
            this.$root.$data.titleTemplate = "Результаты участников проводимой олимпиады";
            this.$root.$data.event = "";
        },
        computed : {
            filteredResults : function() {
                var query = this.searchingResults;
                return this.$root.$data.results.filter(function (result) {
                    if(query === '') {
                        return true;
                    } else {
                        return result.name.indexOf(query) > -1;
                    }
                })
            }
        },
        methods : {

            loadResultsUsers : function() {
                var self = this;
                axios.get('/adminRoom/results/getResults').then(function (response) {
                    console.log(response);
                    // for (var i = 0; i < response.data.length; i++) {
                    //     self.$root.$data.results.push({
                    //         name : response.data[i].user.name,
                    //         login : response.data[i].user.login,
                    //         data : response.data[i].data,
                    //         result : response.data[i].result
                    //     });
                    // }
                });
            },

            removeSelectedResults : function() {
                if(this.selectedResults.length === 0) {
                    this.$root.$data.isFailureEvent = true;
                    this.$root.$data.event = "Не выбрано ни одного результата пользователя для удаления. Удаление невозможно.";
                } else {
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется удаления выбранных результатов пользователей...";
                    
                    // Deleting selected results from table
                    for(var i = 0; i < this.selectedResults.length; i++) {
                        var index = this.$root.$data.results.map(function(result) { 
                            return result; 
                        }).indexOf(this.selectedResults[i]);
                        this.$root.$data.results.splice(index, 1);
                    }
                    this.selectedResults = [];
                }   
            }

        },

    }

</script>

<style scoped>

    .block {
        height: calc(100% - 145px);
        position: absolute;
        width: 100%;
    }

    .blue-btn {
        width: 250px;
        margin: 0;
        transform: translateY(-1px);
    }

    .half-width {
        width: calc(100% - 255px);
    }

</style>