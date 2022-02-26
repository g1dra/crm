package com.g1dra.crm.controllers;

import com.g1dra.crm.models.User;
import com.g1dra.crm.services.FileService;
import com.g1dra.crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    };

    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
    }

    @PostMapping(path = "uploadFile")
    public void uploadFile(@Valid @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = fileService.fileUpload(file);
        userService.saveFileName(fileName);
    }
}
