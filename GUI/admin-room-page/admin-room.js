var Vue = require('vue')
import VueRouter from 'vue-router'

var Information = require('./components/Information.vue')
var Tasks = require('./components/Tasks.vue')
var TestData = require('./components/TestData.vue')
var Users = require('./components/Users.vue')
var Results = require('./components/Results.vue')
var Settings = require('./components/Settings.vue')

Vue.use(VueRouter)

var router = new VueRouter({
    routes: [
        { path: '/', component: Information },
        { path: '/tasks', component: Tasks },
        { path: '/users', component: Users },
        { path: '/testData', component: TestData },
        { path: '/results', component: Results },
        { path: '/settings', component: Settings }
    ]
})

new Vue({
    el: '#app',
    router: router,
    data: {

        tasks : [
            {
                 title : "Ход конем",
                 description : "На пустой шахматной доске в одной из клеток стоит шахматный конь." +
                               "Напишите программу, которая выводит на экран список клеток, которые конь может достичь за один ход из данной клетки." +
                               "Формат входных данных:" +
                               "На вход программы с клавиатуры поступают два целых числа x и y через пробел- координаты клетки, где стоит конь (1 <= x , y <= 8)." +
                               "Формат выходных данных:" +
                               "На выходе программы должен быть выведен в столбик список пар целых чисел –координаты клеток, достижимых конем из исходной клетки за один ход.",
            },
            {
                 title : "Спички",
                 description : "На стол выкладываются спички. Спички нельзя ломать и класть друг на друга. Какое минимальное количество" +
                               "спичек необходимо выложить, чтобы образовалось N квадратов со стороной в одну спичку? Вершинами квадратов" +
                               "являются точки, в которых сходятся концы спичек, а сторонами квадратов – сами спички. Спички необходимо" +
                               "считать отрезками. Формат входных данных: На вход программа получает количество квадратов N, не превосходящее 109." +
                               "Формат выходных данных: Программа должна вывести единственное число – необходимое количество спичек."
            }
        ],

        testData : [
            {
                titleTask : "Ход конем",
                inputData : "4 6 1",
                outputData : "14"
            },
            {
                titleTask : "Спички",
                inputData : "4 234 123",
                outputData : "45 23"
            },
            {
                titleTask : "Спички",
                inputData : "4354 2124 ",
                outputData : "1233"
            },
            {
                titleTask : "Спички",
                inputData : "44 234123",
                outputData : "45 723"
            }
        ],

        results : [
            {
                name : "Балун Владимир Николаевич",
                login : "vovka123",
                data : "10.01.2017",
                result : "1/5"
            },
            {
                name : "Балун Владимир Николаевич",
                login : "vovka123",
                data : "10.04.2017",
                result : "2/5"
            },
            {
                name : "Петров Дмитрий Павлович",
                login : "dgdfgdg34",
                data : "10.01.2017",
                result : "1/5"
            },
            {
                name : "Сморльников Андрей Тимофеевич",
                login : "hockeist",
                data : "10.01.2017",
                result : "1/5"
            }
            
        ],

        users : [
            {
                name : "Балун Владимир Николаевич",
                login : "vovka123",
                password : "dfg7384gjunu884hbsdbs7fgs7f"
            },
            {
                name : "Петров Дмитрий Павлович",
                login : "dgdfgdg34",
                password : "dfg7384gjunu884hbsdbs7fgs7f"
            },
            {
                name : "Сморльников Андрей Тимофеевич",
                login : "hockeist",
                password : "dfg7384gjunu884hbsdbs7fgs7f"
            }
        ],
        
        titleTemplate : "",

        isFailureEvent : false,
        event : ""

    }

})
