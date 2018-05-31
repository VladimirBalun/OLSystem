new Vue({

    el: "#app",
    data: {

        creatorOlympiad : "Название авторов проводимой олимпиады",
        numberCreator : "+7(345)-345-45-45",

        nameOlympiad : "Название олимпиады",
        descriptionOlympiad : "Описание олимпиады. Описание олимпиады. Описание олимпиады. Описание олимпиады." +
                              "Описание олимпиады. Описание олимпиады. Описание олимпиады. Описание олимпиады",

        linkToWebSite : "http://www.google.com",
        linkToIconOlympiad : "img/icon.png",
		nameWebSite : "www.вашсайn.ru",
		

        // Form LogIn
        dialogLogIn : {
            username : "",
            isEmptyUsername : false,
            password : "",
            isEmptyPassword : false,
            message : ""
        },

        dialogSignUp : {
            fullName : "",
            isEmptyFullName : false,
            username : "",
            isEmptyUsername : false,
            password : "",
            isEmptyPassword : false,
            message : ""
        }

    },
    methods : {

        authentificate : function () {
            if(this.dialogLogIn.username === "" && this.dialogLogIn.password === "") {
                this.dialogLogIn.isEmptyUsername = true;
                this.dialogLogIn.isEmptyPassword = true;
                this.dialogLogIn.message = "Не введен логин и пароль.";
            } else if (this.dialogLogIn.username === "") {
                this.dialogLogIn.isEmptyUsername = true;
                this.dialogLogIn.isEmptyPassword = false;
                this.dialogLogIn.message = "Не введен логин.";
            } else if (this.dialogLogIn.password === "") {
                this.dialogLogIn.isEmptyUsername = false;
                this.dialogLogIn.isEmptyPassword = true;
                this.dialogLogIn.message = "Не введен пароль.";
            } else {
                this.dialogLogIn.isEmptyUsername = false;
                this.dialogLogIn.isEmptyPassword = false;
                this.dialogLogIn.message = "Происходит подключение...";


                axios.get("http://localhost:8080/selectedTask", {name_selected_question : "Ход конем"}).then(
                    response => (this.descriptionOlympiad = response)).catch(error => {
                        console.log(error);
                        this.errored = true;
                });
            }
        },

        register : function () {
            if (this.dialogSignUp.username === "") {
                this.dialogSignUp.isEmptyUsername = true;
            } else {
                this.dialogSignUp.isEmptyUsername = false;
            }

            if (this.dialogSignUp.password === "") {
                this.dialogSignUp.isEmptyPassword = true;
            } else {
                this.dialogSignUp.isEmptyPassword = false;
            }

            if (this.dialogSignUp.fullName === "") {
                this.dialogSignUp.isEmptyFullName = true;
            } else {
                this.dialogSignUp.isEmptyFullName = false;
            }

            if(this.dialogSignUp.username === "" || this.dialogSignUp.password === "" || this.dialogSignUp.password === "") {
                this.dialogSignUp.message = "Введены не все данные.";
            } else {
                this.dialogSignUp.message = "Происходит подключение...";
            }
        }

    }

});