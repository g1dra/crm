package com.g1dra.crm.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Entity
@Table
public class Task {
    public Task(){}
    public Task(String title, String description,
                LocalDateTime deadline, TaskStatus status,
                LocalDateTime createdAt, LocalDateTime updatedAt)
    {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Task title is required")
    private String title;

    private String description;

    private LocalDateTime deadline;

    private TaskStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
