package dev.rifat.Tasker;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskerRepository extends MongoRepository<TaskModel, ObjectId> {
    List<TaskModel> findTaskModelsByTaskCategory(String category);
}
