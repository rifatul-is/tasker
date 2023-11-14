package dev.rifat.Tasker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Document("task_data")
public class TaskModel {
    @Id
    private ObjectId objectId;
    private String taskTitle;
    private String taskInfo;
    private String taskCategory;
    private String taskPreReq [];

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public void setTaskCategory(String taskCategory) {
        this.taskCategory = taskCategory;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public String getTaskCategory() {
        return taskCategory;
    }

    public String[] getTaskPreReq() {
        return taskPreReq;
    }

    public void setTaskPreReq(String[] taskPreReq) {
        this.taskPreReq = taskPreReq;
    }
}
