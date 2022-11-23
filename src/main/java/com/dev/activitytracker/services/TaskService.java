package com.dev.activitytracker.services;

import com.dev.activitytracker.pojos.Task;

import java.util.List;
import java.util.Optional;


public interface TaskService {

   Task createTask(Task task, Long UserId);

   Task  updateTask(Long userId, Task task);

   Optional<Task> findTaskById(Long id);
   List<Task> findAllByUserId(Long UserId);

   List<Task> getAllPendingTask(Long UserId);

   List<Task> getAllDoneTask(Long UserId);

   List<Task> getAllTaskInProgress(Long taskId);

   Task moveCompletedTaskToPending(Long taskId);

   Task moveTaskInProgressToCompleted(Long taskId);

   void deleteTask(Long taskId);





}
