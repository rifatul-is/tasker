package dev.rifat.Tasker.Services;

import dev.rifat.Tasker.Models.SubTask;
import dev.rifat.Tasker.Reopsitories.SubTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubTaskService {
    @Autowired
    private SubTaskRepo subTaskRepo;

    public List<SubTask> findAllSubTask(){
        return subTaskRepo.findAll();
    }

    public Optional<SubTask> findSubTaskById(long subTaskId){
        return subTaskRepo.findById(subTaskId);
    }

    public List<SubTask> findSubTaskByTaskId(String  taskId){
        return subTaskRepo.findByTaskId(taskId);
    }

    public List<SubTask> createSubTask(List<SubTask> subTaskList){
        return subTaskRepo.saveAll(subTaskList);
    }
}
