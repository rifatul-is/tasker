package dev.rifat.Tasker.Models;

import jakarta.persistence.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Document("task_data")
@Table(name="task_data")
@Entity
public class Task {
//  private int objectId;
    @Column(name="task_title")
    private String taskTitle;
    @Column(name="task_info")
    private String taskInfo;
    @Column(name="task_category")
    private String taskCategory;
    @Id
    @GeneratedValue
    private Long id;

//    private String taskPreReq [];
//    public int getObjectId() { return objectId; }
//    public void setObjectId(int objectId) { this.objectId = objectId; }

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


//    public String[] getTaskPreReq() {
//        return taskPreReq;
//    }

//    public void setTaskPreReq(String[] taskPreReq) {
//        this.taskPreReq = taskPreReq;
//    }
}
