package dev.rifat.Tasker;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskerRepository taskerRepository;
    private MongoTemplate mongoTemplate;

    public List<TaskModel> allTask(){
        System.out.println("Fine All Started");
        System.out.println(taskerRepository.findAll());
        return taskerRepository.findAll();
    }

    public Optional<TaskModel> singleTask(ObjectId id) {
        System.out.println("Fine by Id Started");
        return taskerRepository.findById(id);
    }

    public List<TaskModel> categoryTask(String category) {
        System.out.println("Fine by category Started");
        System.out.println(taskerRepository.findTaskModelsByTaskCategory(category));
        return taskerRepository.findTaskModelsByTaskCategory(category);
    }

    public TaskModel createTask(TaskModel task) {
        return taskerRepository.save(task);
    }
}
