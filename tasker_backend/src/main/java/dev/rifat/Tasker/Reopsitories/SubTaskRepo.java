package dev.rifat.Tasker.Reopsitories;

import dev.rifat.Tasker.Models.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubTaskRepo extends JpaRepository<SubTask, Long> {
    List<SubTask> findByTaskId (String taskId);
}
