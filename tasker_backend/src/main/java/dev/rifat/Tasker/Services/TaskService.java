package dev.rifat.Tasker.Services;

import dev.rifat.Tasker.Models.Task;
import dev.rifat.Tasker.Reopsitories.TaskDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskDataRepo taskDataRepo;
    //private MongoTemplate mongoTemplate;

    public List<Task> findAllTask(){
        System.out.println("Fine All Started");
        System.out.println(taskDataRepo.findAll());
        return taskDataRepo.findAll();
    }

    public Optional<Task> findTask(long id) {
        System.out.println("Fine by Id Started");
        return taskDataRepo.findById(id);
    }

    public List<Task> findTasksByCategory(String category) {
        System.out.println("Fine by category Started");
        System.out.println(taskDataRepo.findByTaskCategory(category));
        return taskDataRepo.findByTaskCategory(category);
    }

    public Task createTask(Task task) {
        System.out.println(task.getId());
        return taskDataRepo.save(task);
        //return subTask;
    }

    public List<String> findAllCategories() {
        return taskDataRepo.getCatagories();
    }

    public List<String> findSubTask(long taskId) {
        System.out.println(taskDataRepo.getSubTask(taskId));
        return taskDataRepo.getSubTask(taskId);
    }

    public Task archiveTask(long taskId) {
        Optional<Task> task = taskDataRepo.findById(taskId);
        if (task.isPresent()) {
            Task t = task.get();
            t.setTaskCategory("Archive");
            return taskDataRepo.save(t);
        }
        return null;
    }

    public Task updateTask(Task task) {
        return taskDataRepo.save(task);
    }

    public void deleteTask(Task task) {
        taskDataRepo.delete(task);
    }
}
