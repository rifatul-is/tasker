package dev.rifat.Tasker.Controllers;

import dev.rifat.Tasker.Models.SubTask;
import dev.rifat.Tasker.Models.Task;
import dev.rifat.Tasker.Reopsitories.SubTaskRepo;
import dev.rifat.Tasker.Services.SubTaskService;
import dev.rifat.Tasker.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subtask")
@CrossOrigin
public class SubTaskController {
    @Autowired
    private SubTaskService subTaskService;

    @GetMapping("/all")
    public ResponseEntity<List<SubTask>> getAllSubTask() {
        return new ResponseEntity<List<SubTask>>(subTaskService.findAllSubTask(), HttpStatus.OK);
    }

    @GetMapping("/{subTaskId}")
    public ResponseEntity<Optional<SubTask>> getAllSubTask(@PathVariable long subTaskId) {
        return new ResponseEntity<Optional<SubTask>>(subTaskService.findSubTaskById(subTaskId), HttpStatus.OK);
    }

    @GetMapping("/task_id/{taskId}")
    public ResponseEntity<List<SubTask>> getSubTaskbyTaskId(@PathVariable String taskId) {
        return new ResponseEntity<List<SubTask>>(subTaskService.findSubTaskByTaskId(taskId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<SubTask>> createSubTask(@RequestBody List<SubTask> subTask) {
        return new ResponseEntity<List<SubTask>>(subTaskService.createSubTask(subTask), HttpStatus.CREATED);
    }
}
