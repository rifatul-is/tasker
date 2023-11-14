let addNewTaskCatagoryName = document.getElementById('addNewTaskCatagoryName');
let addNewTaskCatagoryBtn = document.getElementById('addNewTaskCatagoryBtn');
let taskCatagoryList = document.getElementById('taskCatagoryList');
let taskCatagoryListUl = document.getElementById('taskCatagoryListUl');

let createNewTaskBtn = document.getElementById('createNewTaskBtn')

let taskViewer = document.getElementById('taskViewer');
let taskBox = document.getElementById('taskBox');
let taskName = document.getElementById('taskName');
let taskInfo = document.getElementById('taskInfo');
let subTaskList = document.getElementById('subTaskList')

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

function addNewTaskCatagory () {
    if (addNewTaskCatagoryName.value.length >= 4) {
        var newTaskCatagory = document.createElement('li')
        var newTaskCatagoryItem = document.createElement('a')
                
        //newTaskCatagory.classList.add('task-catagoty-list-item', 'task-catagoty-list-item:hover');

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

