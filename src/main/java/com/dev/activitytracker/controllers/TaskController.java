package com.dev.activitytracker.controllers;

import com.dev.activitytracker.pojos.Task;
import com.dev.activitytracker.pojos.User;
import com.dev.activitytracker.services.TaskService;
import com.dev.activitytracker.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {
    TaskService taskService;
    UserService userService;

    @PostMapping("/save/{userId}")
    public ResponseEntity<Task> createTask(@RequestBody Task task, @PathVariable Long userId){
        return new ResponseEntity<>(taskService.createTask(task, userId), HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<Task> upDateTask(@PathVariable Long userId, @RequestBody Task tasks){
        return new ResponseEntity<>(taskService.updateTask(userId,tasks),HttpStatus.ACCEPTED);
    }

    @GetMapping("/findTask/{userId}")
    public Optional<Task> findTaskByUserId(@PathVariable Long userId){
        return taskService.findTaskById(userId);
    }
    @GetMapping("/findAll/{userId}")
    public List<Task> findAllByUserId(@PathVariable Long userId){
        return taskService.findAllByUserId(userId);
    }

    @GetMapping("/pending/{userId}")
    public List<Task> getAllPending(@PathVariable Long userId){
        return taskService.getAllPendingTask(userId);
    }

    @GetMapping("/done/{userId}")
    public List<Task> getAllDoneTask(@PathVariable Long userId){
        return taskService.getAllDoneTask(userId);
    }


    @GetMapping("/inProgress/{userId}")
    public List<Task> getAllDTaskInProgress(@PathVariable Long userId){
        return taskService.getAllTaskInProgress(userId);
    }

}
