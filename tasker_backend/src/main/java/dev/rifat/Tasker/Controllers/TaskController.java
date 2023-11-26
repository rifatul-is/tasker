package dev.rifat.Tasker.Controllers;

import dev.rifat.Tasker.Models.Task;
import dev.rifat.Tasker.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        System.out.println("Get All Task Func");
        return new ResponseEntity<List<Task>>(taskService.findAllTask(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Task>> getTask(@PathVariable long id) {
        System.out.println("Get Single Task Func");
        return new ResponseEntity<Optional<Task>>(taskService.findTask(id), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllCatagories() {
        System.out.println("Get Category Task Func");
        return new ResponseEntity<List<String>>(taskService.findAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{taskId}/subtask")
    public ResponseEntity<List<String >> getSubTaskByCatagory(@PathVariable long taskId) {
        System.out.println("Get Category Task Func");
        return new ResponseEntity<List<String>>(taskService.findSubTask(taskId), HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Task>> getSubTaskById(@PathVariable String category) {
        System.out.println("Get Category Task Func");
        return new ResponseEntity<List<Task>>(taskService.findTasksByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/{taskId}/archive")
    public ResponseEntity<Task> getSubTaskById(@PathVariable long taskId) {
        //System.out.println("Get Category Task Func");
        return new ResponseEntity<Task>(taskService.archiveTask(taskId), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task payload) {
        System.out.println("Post Single Task Func");
        return new ResponseEntity<Task>(taskService.createTask(payload), HttpStatus.CREATED);
        //return taskService.createTask(newTask);
    }

    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task payload) {
        System.out.println("Post Single Task Func");
        return new ResponseEntity<Task>(taskService.updateTask(payload), HttpStatus.ACCEPTED);
    }

    @PutMapping("/delete")
    public void deleteTask(@RequestBody Task task) {
        System.out.println("Post Single Task Func");
        taskService.deleteTask(task);
    }
}
