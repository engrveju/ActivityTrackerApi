package com.dev.activitytracker.repository;

import com.dev.activitytracker.pojos.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM TASK WHERE SATUS = 'Pending' AND USER_ID=?1", nativeQuery = true)
    List<Task> getAllPendingTasks(Long userId);

    @Query(value = "SELECT * FROM TASK WHERE USER_ID=?", nativeQuery = true)
    List<Task> findAllTaskByUserId(Long userId);
    @Query(value = "SELECT * FROM TASK WHERE SATUS = 'Done' AND USER_ID=?", nativeQuery = true)
    List<Task> getAllDoneTask(Long userId);
    @Query(value = "SELECT * FROM TASK WHERE SATUS = 'In Progress' AND USER_ID=?", nativeQuery = true)
    List<Task> getAllTaskInProgress(Long userId);
}
