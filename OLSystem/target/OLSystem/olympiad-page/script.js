new Vue({
    el : '.wrapper',
    data : {

        ResultChecking : {
            SUCCESSFUL_CHECKING : 100,
            USER_ERROR : 101,
            SYSTEM_ERROR : 102,
            COMPILATION_ERROR : 103,
            RUN_TIME_ERROR : 105,
            UNKNOWN_ERROR : 105
        },

		tasks : [],
		events : [],

        currentTask : {
    	    title : "",
            description : "",
            inputData : "",
            outputData : ""
		},
		
		isActivePageTasks : true,
		linkToIconOlympiad : "img/white-icon.png",
		
		// Form for sending task on checking
		selectedTask : '',
		isEmptySelectTasks : false,
		textProgram : '',
		isEmptyTextarea : false,

		countCorrectAnswers : 0,
		countTasks : 0,
		timeToEndOlympiad : "2:00:00",

		eventMessage : '',
		eventStatus : ''

	},
	created : function () {
        this.loadCurrentParticipantOlympiad();
        this.events.push({ text : " - Олимпиада началась.", status : true });
    },
  	methods : {

        /**
         *
         */
        loadCurrentParticipantOlympiad : function() {
            var self = this;
            axios.get('/olympiad/getParticipant').then(function (participant) {
                console.log(participant);
                self.countCorrectAnswers = participant.data.countTruthAnswers;
                self.countTasks = participant.data.countTasks;
                for (var i = 0; i < participant.data.tasksParticipant.length; i++) {
                    self.tasks.push({
                       title :  participant.data.tasksParticipant[i].title,
                       description : participant.data.tasksParticipant[i].description,
                       inputData : participant.data.tasksParticipant[i].inputData,
                       outputData : participant.data.tasksParticipant[i].outputData
                    });
                }
            }).catch(function (error) {
                console.log(error);
            });
        },

        /**
		 *
         * @param titleTask
         */
        changeSelectedTask : function (titleTask) {
            var selectedTask =  this.tasks.find(selectedTask => selectedTask.title === titleTask);
            this.currentTask.title = selectedTask.title;
            this.currentTask.description = selectedTask.description;
            this.currentTask.inputData = selectedTask.inputData;
            this.currentTask.outputData = selectedTask.outputData;
		},

        /**
         *
         */
        selectNextTask : function() {
			for(var i = 0; i < this.tasks.length; i++) {
				if(this.tasks[i].title === this.currentTask.title && i !== this.tasks.length - 1) {
					this.currentTask.title = this.tasks[i + 1].title;
					this.currentTask.description = this.tasks[i + 1].description;
					this.currentTask.inputData = this.tasks[i + 1].inputData;
					this.currentTask.outputData = this.tasks[i + 1].outputData;
					break;
				}
			}
		},

        /**
         *
         */
		selectBackTask : function() {
			for(var i = 0; i < this.tasks.length; i++) {
				if(this.tasks[i].title === this.currentTask.title && i > 0) {
					this.currentTask.title = this.tasks[i - 1].title;
					this.currentTask.description = this.tasks[i - 1].description;
					this.currentTask.inputData = this.tasks[i - 1].inputData;
					this.currentTask.outputData = this.tasks[i - 1].outputData;
					break;
				}
			}
		},

        /**
         *
         */
    	sendProgram : function () {
			var currentTime = new Date().toLocaleTimeString('en-GB', { hour: "numeric", minute: "numeric"});
    		if(this.selectedTask === "" && this.textProgram === "") {
				this.eventMessage = "Ошибка. Не выбрано задание для проверки и не введен текст программы.";
				this.events.push({ text : currentTime + " - Ошибка. Не выбрано задание для проверки и не введен текст программы.", status : false }); 
 				this.isEmptyTextarea = true;	
    			this.isEmptySelectTasks = true;	
    			this.eventStatus = "error"; 		    
    		} else if(this.selectedTask === "" && this.textProgram !== "") {
				this.eventMessage = "Ошибка. Не выбрано задание для проверки.";
				this.events.push({ text : currentTime + " - Ошибка. Не выбрано задание для проверки.", status : false }); 
 				this.isEmptySelectTasks = true;	
 				this.isEmptyTextarea = false;	
    			this.eventStatus = "error"; 		 						
    		} else if(this.textProgram === "" && this.selectedTask !== "") {
				this.eventMessage = currentTime + " - Ошибка. Не введен текст программы.";
				this.events.push({ text : "Ошибка. Не введен текст программы.", status : false }); 
 				this.isEmptyTextarea = true;	
    			this.isEmptySelectTasks = false;	
    			this.eventStatus = "error"; 		 						
    		} else {
    			this.eventMessage = "Задание \"" + this.selectedTask + "\" отправлено на проверку.";
 				this.isEmptyTextarea = false;	
    			this.isEmptySelectTasks = false;	
				this.eventStatus = "success"; 	
				this.sendRequestOnCheckingProgram();
    		}
    	},

        /**
         *
         */
        sendRequestOnCheckingProgram : function() {
            var self = this;
            var currentTime = new Date().toLocaleTimeString('en-GB', { hour: "numeric", minute: "numeric"});
            axios.put('/olympiad/checkTask').then(function (response) {
                console.log(response);
                switch (response.data){
                    case self.ResultChecking.SUCCESSFUL_CHECKING :
                        this.removeTaskParticipant();
                        this.events.push({ text : currentTime + " - Задание \"" + this.selectedTask + "\" успешно выполнено.", status : true });
                        break;
                    case self.ResultChecking.RUN_TIME_ERROR :
                        this.events.push({ text : currentTime + " - Задание \"" + this.selectedTask + "\" не выполнено. Ошибка при тестировании программы, либо во ремя ее выполнения.", status : false });
                        break;
                    case self.ResultChecking.COMPILATION_ERROR :
                        this.events.push({ text : currentTime + " - Задание \"" + this.selectedTask + "\" не выполнено. Ошибка компиляции.", status : false });
                        break;
                    case self.ResultChecking.SYSTEM_ERROR :
                        this.events.push({ text : currentTime + " - Задание \"" + this.selectedTask + "\" не выполнено. Системная ошибка.", status : false });
                        break;
                    case self.ResultChecking.USER_ERROR :
                        this.events.push({ text : currentTime + " - Задание \"" + this.selectedTask + "\" не выполнено. Системная ошибка.", status : false });
                        break;default :
                        this.events.push({ text : currentTime + " - Задание \"" + this.selectedTask + "\" не выполнено. Неизвестная ошибка.", status : false })
                }
            }).catch(function (error) {
                console.log(error);
            });
        },

        /**
         *
         */
        removeTaskParticipant : function() {
            var index = this.tasks.map(function(task) {
                return task.title;
            }).indexOf(this.selectedTask);
            this.tasks.splice(index, 1);
            this.textProgram = "";
            this.countCorrectAnswers++;
            if (this.tasks.length === 0) {
                window.location.href = "../end-olympiad-page/page.html";
            }
        },

        /**
         *
         */
        finishOlympiad : function () {
            window.location.href = "../end-olympiad-page/page.html";
        }

  	}

});