<template>
    <div id="users">
        <div class="block">
            <p class="block-help">Динамический поиск участников по ФИО:</p>
            <input class="half-width" v-model="searchingUsers" placeholder="Поиск...">
            <button class="blue-btn" @click="removeSelectedUsers">Удалить участников</button>
            <table class="table table-striped">
                <thead class="thead-inverse">
                    <tr>
                        <th>#{{ $root.$data.users.length }}</th>
                        <th>ФИО</th>
                        <th>Логин</th>
                        <th>Пароль</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="user in filteredUsers">
                        <td>
                            <input class="checkbox" type="checkbox" v-bind:value="user" v-model="selectedUsers">
                        </td>
                        <td>{{ user.name }}</td>
                        <td>{{ user.login }}</td>
                        <td>{{ user.password }}</td>
                    </tr>
                </tbody>
            </table>
        </div><!-- End block -->
    </div><!-- End users -->
</template>

<script>

    export default {
        name : 'users',
        data() {
            return {
                selectedUsers : [],
                searchingUsers : ""
            }
        },
        created: function () {
            this.$root.$data.titleTemplate = "Участинки олимпиады";
            this.$root.$data.event = "";
        },
        computed : {
            filteredUsers : function() {
                var query = this.searchingUsers;
                return this.$root.$data.users.filter(function (user) {
                    if(query === '') {
                        return true;
                    } else {
                        return user.name.indexOf(query) > -1;
                    }
                })
            }
        },
        methods: {
            
            removeSelectedUsers : function() {
                if(this.selectedUsers.length === 0) {
                    this.$root.$data.event = "Не выбрано ни одного пользователя для удаления. Удаление невозможно.";
                    this.$root.$data.isFailureEvent = true;
                } else {
                    this.$root.$data.isFailureEvent = false;
                    this.$root.$data.event = "Выполняется удаления выбранных пользователей...";
                    
                    // Deleting selected user from table
                    for(var i = 0; i < this.selectedUsers.length; i++) {
                        var index = this.$root.$data.users.map(function(user) { 
                            return user; 
                        }).indexOf(this.selectedUsers[i]);
                        this.$root.$data.users.splice(index, 1);
                    }

                    // Deleting results, where login of user is equal with selected user
                    for(var i = 0; i < this.selectedUsers.length; i++) {
                        for(var j = 0; j < this.$root.$data.results.length; j++) {
                            if(this.$root.$data.results[j].login == this.selectedUsers[i].login){
                                this.$root.$data.results.splice(j, 1);
                                j--;
                            }      
                        }
                    }

                    this.selectedUsers = [];
                }   
            }
        }

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