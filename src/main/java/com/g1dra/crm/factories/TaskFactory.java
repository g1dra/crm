package com.g1dra.crm.factories;

import com.g1dra.crm.models.Task;
import com.g1dra.crm.models.TaskStatus;
import com.g1dra.crm.repositories.TaskRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class TaskFactory {

    public static List<Task> create(int count) {
        Faker faker = new Faker();
        List<Task> list = new ArrayList<Task>();
        for (int i = 0; i < count; i++) {
            String title = faker.name().firstName();
            String description = faker.zelda().character();
            Date futureDateTime = faker.date().future(faker.number().numberBetween(0, 30), TimeUnit.DAYS);
            LocalDateTime deadline = LocalDateTime.ofInstant(futureDateTime.toInstant(), ZoneId.of("UTC"));
            TaskStatus status = TaskStatus.values()[faker.random().nextInt(1, 3)];
            LocalDateTime createdAt = LocalDateTime.now();
            LocalDateTime updatedAt = LocalDateTime.now();

            list.add(new Task(
                    title,
                    description,
                    deadline,
                    status,
                    createdAt,
                    updatedAt
            ));
        }

        return list;
    }
}
