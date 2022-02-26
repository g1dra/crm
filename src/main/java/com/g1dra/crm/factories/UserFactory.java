package com.g1dra.crm.factories;

import com.g1dra.crm.models.Task;
import com.g1dra.crm.models.TaskStatus;
import com.g1dra.crm.models.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class UserFactory {

    public static List<User> create(int count) {
        Faker faker = new Faker();
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < count; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = faker.internet().safeEmailAddress();
            String password = faker.internet().password();
            Boolean enabled = faker.random().nextBoolean();
            Boolean tokenExpired = faker.random().nextBoolean();
            LocalDateTime createdAt = LocalDateTime.now();
            LocalDateTime updatedAt = LocalDateTime.now();

            list.add(new User(
                    firstName,
                    lastName,
                    email,
                    password,
                    enabled,
                    tokenExpired,
                    createdAt,
                    updatedAt
            ));
        }

        return list;
    }
}
