new Vue({
    el : '.wrapper',
    data : {

		tasks : [
			{ 
			title : "Спички",
			description : "Описание",
			inputData : "4",
			outputData : "12"
			},
			{ 
				title : "Троллейбусы",
				description : "Описание",
				inputData : "4",
				outputData : "12"
			},
			{ 
				title : "Числа фибоначчи",
				description : "Описание",
				inputData : "4",
				outputData : "12"
			},
			{ 
				title : "Ход конем",
				description : "Описание",
				inputData : "4",
				outputData : "12"
			}
		],

		events : [
			{
				text : "20:16 - Задание \"Спички\" не выполнено. Ошибка компиляции.",
				status : false
			},
			{
				text : "20:16 - Задание \"Ход конем\" не выполнено. Ошибка при тестировании программы.",
				status : false
			},
		],

        currentTask : {
    	    title : "",
            description : "",
            inputData : "",
            outputData : ""
		},
		
		isActivePageTasks : true,
		linkToIconOlympiad : "img/white-icon.png",
		
		// Form for senging task on checking
		selectedTask : '',
		isEmptySelectTasks : false,
		textProgram : '',
		isEmptyTextarea : false,

		countCorrectAnswers : 0,
		countTasks : 0,
		timeToEndOlympiad : "1:26:12",

		eventMessage : '',
		eventStatus : ''

	},
	created : function () {

		this.currentTask.title = this.tasks[0].title;
		this.currentTask.description = this.tasks[0].description;
		this.currentTask.inputData = this.tasks[0].inputData;
		this.currentTask.outputData = this.tasks[0].outputData;
		this.countTasks = this.tasks.length;

	},
  	methods : {

        openMobileMenu : function () {
            this.isActivePageTasks =! this.isActivePageTasks;
        },

        changeSelectedTask : function (titleTask) {
            alert(titleTask);
		},
		
		selectNextTask : function() {
			for(var i = 0; i < this.tasks.length; i++) {
				if(this.tasks[i].title === this.currentTask.title && i != this.tasks.length - 1) {
					this.currentTask.title = this.tasks[i + 1].title;
					this.currentTask.description = this.tasks[i + 1].description;
					this.currentTask.inputData = this.tasks[i + 1].inputData;
					this.currentTask.outputData = this.tasks[i + 1].outputData;
					break;
				}
			}
		},

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

    	sendProgram : function () {
			var currentTime = new Date().toLocaleTimeString('en-GB', { hour: "numeric", minute: "numeric"});
    		if(this.selectedTask === "" && this.textProgram === "") {
				this.eventMessage = "Ошибка. Не выбрано задание для проверки и не введен текст программы.";
				this.events.push({ text : currentTime + " - Ошибка. Не выбрано задание для проверки и не введен текст программы.", status : false }); 
 				this.isEmptyTextarea = true;	
    			this.isEmptySelectTasks = true;	
    			this.eventStatus = "error"; 		    
    		} else if(this.selectedTask === "" && this.textProgram != "") {
				this.eventMessage = "Ошибка. Не выбрано задание для проверки.";
				this.events.push({ text : currentTime + " - Ошибка. Не выбрано задание для проверки.", status : false }); 
 				this.isEmptySelectTasks = true;	
 				this.isEmptyTextarea = false;	
    			this.eventStatus = "error"; 		 						
    		} else if(this.textProgram === "" && this.selectedTask != "") {
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
					
                var index = this.tasks.map(function(task) { 
                    return task.title; 
                }).indexOf(this.selectedTask);
				this.tasks.splice(index, 1);
				this.textProgram = "";
				this.countCorrectAnswers++;
				this.events.push({ text : currentTime + " - Задание \"" + this.selectedTask + "\" успешно выполнено.", status : true }); 
    		}
    	},

        finishOlympiad : function () {
            alert("Завершить олимпиаду???");
        }

  	}

});