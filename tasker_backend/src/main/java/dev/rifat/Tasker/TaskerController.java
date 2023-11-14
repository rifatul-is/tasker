package dev.rifat.Tasker;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
@CrossOrigin
public class TaskerController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        System.out.println("Get All Task Func");
        return new ResponseEntity<List<TaskModel>>(taskService.allTask(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<TaskModel>> getSingleTask(@PathVariable ObjectId id) {
        System.out.println("Get Single Task Func");
        return new ResponseEntity<Optional<TaskModel>>(taskService.singleTask(id), HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<TaskModel>> getCategoryTask(@PathVariable String category) {
        System.out.println("Get Category Task Func");
        return new ResponseEntity<List<TaskModel>>(taskService.categoryTask(category), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel payload) {
        System.out.println("Post Single Task Func");
        return new ResponseEntity<TaskModel>(taskService.createTask(payload), HttpStatus.CREATED);
    }
}
