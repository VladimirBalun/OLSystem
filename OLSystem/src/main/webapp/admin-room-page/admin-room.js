var Vue = require('vue');

import VueRouter from 'vue-router'

var Information = require('./components/Information.vue');
var Tasks = require('./components/Tasks.vue');
var TestData = require('./components/TestData.vue');
var Users = require('./components/Users.vue');
var Results = require('./components/Results.vue');
var Settings = require('./components/Settings.vue');

Vue.use(VueRouter);

var router = new VueRouter({
    routes: [
        { path: '/', component: Information },
        { path: '/tasks', component: Tasks },
        { path: '/users', component: Users },
        { path: '/testData', component: TestData },
        { path: '/results', component: Results },
        { path: '/settings', component: Settings }
    ]
});

new Vue({
    el: '#app',
    router: router,
    data: {

        tasks : [],
        testData : [],

        results : [],
        users : [],
        
        titleTemplate : "",

        isFailureEvent : false,
        event : ""

    },
    methods : {

        showSuccessfulEvent : function(message) {
            this.isFailureEvent = false;
            this.event = message;
        },

        showFailedEvent : function(message) {
            this.isFailureEvent = true;
            this.event = message;
        },

        clearInputs : function(){
            for (var i = 0; i < arguments.length; i++) {
                arguments[i] = "";
            }
        },

        sendPutRequest : function(url, data) {
            axios.put(url, data).then(function(response) {
                console.log(response);
                return response;
            });
        },

        sendPostRequest : function(url, data) {
            axios.post(url, data).then(function(response) {
                console.log(response);
                return response;
            });
        },

        sendDeleteRequest : function(url, data) {
            axios.delete(url, data).then(function(response) {
                console.log(response);
                return response;
            });
        }

    }

});
