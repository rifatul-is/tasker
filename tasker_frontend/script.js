const url = "http://localhost:8080/api/task";

let addNewTaskCatagoryName = document.getElementById('addNewTaskCatagoryName');
let addNewTaskCatagoryBtn = document.getElementById('addNewTaskCatagoryBtn');
let taskCatagoryList = document.getElementById('taskCatagoryList');
let taskCatagoryListUl = document.getElementById('taskCatagoryListUl');

let createNewTaskBtn = document.getElementById('createNewTaskBtn')

let taskViewer = document.getElementById('taskViewer');
// let taskBox = document.getElementById('taskBox');
// let taskName = document.getElementById('taskName');
// let taskInfo = document.getElementById('taskInfo');
// let subTaskList = document.getElementById('subTaskList')

let overlay = document.getElementById('overlay');
let taskCreatorPopup = document.getElementById('taskCreatorPopup');

let closeCreateNewTaskPopup = document.getElementById('closeCreateNewTaskPopup');
let newTaskName = document.getElementById('newTaskName');
let newTaskInfo = document.getElementById('newTaskInfo')

let subtask = document.getElementById('subtask');
let subtaskTextField = document.getElementById('subtaskTextField');
let addNewSubtaskTextField = document.getElementById('addNewSubtaskTextField');
let submitNewTaskBtn = document.getElementById('submitNewTaskBtn');

addNewTaskCatagoryBtn.addEventListener('click', function(){ addNewTaskCatagory() });
createNewTaskBtn.addEventListener('click', function(){ addNewTaskPopup() });
closeCreateNewTaskPopup.addEventListener('click', function(){ closeNewTaskPopup() });

var getRequest = {
    method: 'GET'
  };
  

function getAllTask() {




    fetch(url, getRequest)
    .then(response => response.json())
    .then(data => {
        data.forEach(task => {
            let taskBox = document.createElement('div');
            taskBox.classList.add('task-box');

            let taskName = document.createElement('h3');
            taskName.classList.add('task-name');
            taskName.innerHTML = task.taskTitle;

            let taskInfo = document.createElement('p');
            taskInfo.classList.add('task-info');
            taskInfo.innerHTML = task.taskInfo;

            let subTaskUl = document.createElement('ul');

            taskViewer.appendChild(taskBox);
            taskBox.appendChild(taskName);
            taskBox.appendChild(taskInfo);
            taskBox.appendChild(subTaskUl);

            console.log(task.taskTitle);

            task.taskPreReq.forEach(subTask => {
                let subTaskList = document.createElement('li');
                subTaskList.innerHTML = subTask;
                subTaskUl.appendChild(subTaskList);

                console.log(subTask);
            });


        });
        console.log(data);
    })
    .catch(error => console.log('error', error));
}


function addNewTaskCatagory () {
    if (addNewTaskCatagoryName.value.length >= 4) {
        var newTaskCatagory = document.createElement('li')
        var newTaskCatagoryItem = document.createElement('a')
                
        taskCatagoryListUl.appendChild(newTaskCatagory);
        newTaskCatagory.appendChild(newTaskCatagoryItem);
        newTaskCatagoryItem.innerText = addNewTaskCatagoryName.value;
    }
}

function addNewTaskPopup () {
    overlay.style.display = "block";
    taskCreatorPopup.style.display = "block";
}

function closeNewTaskPopup () {
    overlay.style.display = "none";
    taskCreatorPopup.style.display = "none";
}

getAllTask();

