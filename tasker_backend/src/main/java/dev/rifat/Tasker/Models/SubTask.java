package dev.rifat.Tasker.Models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "sub_task_data")
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @JoinColumn(name="task_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @Column(name = "task_id")
    private String taskId;


    public SubTask(Long id, String name, String taskId) {
        this.id = id;
        this.name = name;
        this.taskId = taskId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getTaskId() { return taskId; }

    public void setTaskId(String taskId) { this.taskId = taskId; }
}
