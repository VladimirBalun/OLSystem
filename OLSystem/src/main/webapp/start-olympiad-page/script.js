new Vue({
    el: "#app",
    data: {

        creatorOlympiad : "",
        numberCreator : "",

        nameOlympiad : "",
        descriptionOlympiad : "",

        linkToWebSite : "",
        linkToIconOlympiad : "",
		nameWebSite : "",

        // Form LogIn
        dialogLogIn : {
            username : "",
            isEmptyUsername : false,
            password : "",
            isEmptyPassword : false,
            message : ""
        },

        // Form SignUp
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
    created : function() {
        this.loadInitialDataForPage();
    },
    methods : {

        /**
         *
         */
        loadInitialDataForPage : function() {
            var self = this;
            axios.get('/olympiad/getDataOlympiad').then(function (response) {
                var info = response.data;
                for (var i = 0; i < info.length; i++) {
                    switch (info[i].name) {
                        case "creatorOlympiad" :
                            self.creatorOlympiad = info[i].data;
                            break;
                        case "numberCreator" :
                            self.numberCreator = info[i].data;
                            break;
                        case "nameOlympiad" :
                            self.nameOlympiad = info[i].data;
                            break;
                        case "descriptionOlympiad" :
                            self.descriptionOlympiad = info[i].data;
                            break;
                        case "linkToWebSite" :
                            self.linkToWebSite = info[i].data;
                            break;
                        case "nameWebSite" :
                            self.nameWebSite = info[i].data;
                            break;
                        case "linkToIconOlympiad" :
                            self.linkToIconOlympiad = info[i].data;
                    }
                }
            });
        },

        /**
         *
         */
        authentificate : function () {
            if (this.dialogLogIn.username === "" && this.dialogLogIn.password === "") {
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
                this.sendRequestOnAuthentication();
            }
        },

        /**
         *
         * @param loginUser
         * @param passwordUser
         */
        sendRequestOnAuthentication : function(loginUser, passwordUser){
            var self = this;
            axios.get('/authenticate', {
                params: {
                    login: self.dialogLogIn.username,
                    password : md5(self.dialogLogIn.password)
                }
            }).then(function (response) {
                switch (response.data) {
                    case "ADMIN" :
                        window.location.href = "../admin-room-page/admin-room.html";
                        break;
                    case "PARTICIPANT" :
                        window.location.href = "../olympiad-page/page.html";
                        break;
                    case "UNKNOWN" :
                        self.dialogLogIn.message = "Не правильно введен логин или пароль.";
                }
            }).catch(function (error) {
                console.log(error);
            });
        },

        /**
         *
         */
        register : function () {
            this.dialogSignUp.isEmptyUsername = this.dialogSignUp.username === "";
            this.dialogSignUp.isEmptyPassword = this.dialogSignUp.password === "";
            this.dialogSignUp.isEmptyFullName = this.dialogSignUp.fullName === "";
            if (this.dialogSignUp.username === "" || this.dialogSignUp.password === "" || this.dialogSignUp.password === "") {
                this.dialogSignUp.message = "Введены не все данные.";
            } else {
                this.dialogSignUp.message = "Происходит подключение...";
                this.sendRequestOnRegistration();
            }
        },

        /**
         *
         * @param nameUser
         * @param loginUser
         * @param passwordUser
         */
        sendRequestOnRegistration : function(){
            var self = this;
            const requestParams = new URLSearchParams();
            requestParams.append('name', self.dialogSignUp.fullName);
            requestParams.append('login', self.dialogSignUp.username);
            requestParams.append('password', md5(self.dialogSignUp.password));
            axios.post('/register', requestParams).then(function (response) {
                if (response.data) {
                    self.dialogSignUp.message = "Пользователь успешно зарегистрирован. Можете войти в систему!";
                    self.dialogSignUp.fullName = "";
                    self.dialogSignUp.username = "";
                    self.dialogSignUp.password = "";
                } else {
                    self.dialogSignUp.message = "Ошибка, участник с таким логином уже существует.";
                }
            }).catch(function (error) {
                console.log(error);
            });
        }

    }
});