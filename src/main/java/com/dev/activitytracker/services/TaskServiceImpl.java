package com.dev.activitytracker.services;

import com.dev.activitytracker.exceptions.TaskNotFoundException;
import com.dev.activitytracker.exceptions.UserNotFoundException;
import com.dev.activitytracker.pojos.Task;
import com.dev.activitytracker.pojos.User;
import com.dev.activitytracker.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService{
    TaskRepository taskRepository;
    UserService userService;

    @Override
    public Task createTask(Task task, Long userId) {
       User user =  unWrapUser(userService.findByUserId(userId),userId);
        task.setUsers(user);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long userId, Task task) {
        Task newTask = unWrapTask(findTaskById(userId),userId);
        newTask.setCompletedAt(new Date());
        newTask.setStatus(task.getStatus());
        return taskRepository.save(newTask);
    }

    @Override
    public List<Task> findAllByUserId(Long userId) {
        return taskRepository.findAllTaskByUserId(userId);
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllPendingTask(Long id) {
        return taskRepository.getAllPendingTasks(id);
    }

    @Override
    public List<Task> getAllDoneTask(Long userId) {
        return taskRepository.getAllDoneTask(userId);
    }

    @Override
    public List<Task> getAllTaskInProgress(Long userId) {
        return taskRepository.getAllTaskInProgress(userId);
    }

    @Override
    public Task moveCompletedTaskToPending(Long taskId) {
        return null;
    }

    @Override
    public Task moveTaskInProgressToCompleted(Long taskId) {
        return null;
    }



    @Override
    public void deleteTask(Long taskId) {

    }
    //UNWRAP IS A USER DEFINED METHOD USED TO CONVERT A DATA FROM OPTIONAL TO NORMAL TYPE
    // OPTIONAL DATA ALWAYS OCCURS WHEN WE ARE SEARCHING FOR ITEM WHICH MAY NOT EXIST IN DATABASE
    static Task unWrapTask(Optional<Task> entity, Long userId){
        if(entity.isPresent()) return entity.get();
       else throw new TaskNotFoundException(userId);
    }

    static User unWrapUser(Optional<User> entity, Long userId){
        if(entity.isPresent()) return entity.get();
        else throw new UserNotFoundException(userId);
    }
}
