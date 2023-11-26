package dev.rifat.Tasker.Reopsitories;

import dev.rifat.Tasker.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface TaskerRepository extends MongoRepository<TaskModel, ObjectId> {
//    List<TaskModel> findTaskModelsByTaskCategory(String category);
//}

public interface TaskDataRepo extends JpaRepository<Task, Long> {
    public List<Task> findByTaskCategory(String category);

    @Query(value = "SELECT DISTINCT task_category from task_data", nativeQuery = true)
    public List<String> getCatagories();

    @Query(value = "select name from sub_task_data where task_id = :taskId", nativeQuery = true)
    public List<String> getSubTask(@Param("taskId") long taskId);

}
