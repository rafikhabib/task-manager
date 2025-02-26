package tn.esprit.backend.service;

import tn.esprit.backend.entite.Task;

import java.util.List;

public interface IService {
    Task addTask(Task task);
    Task updateTask(Long id, Task task);
    Task getTask(Long id);
    List<Task> getTasks();
    void deleteTask(Long id);
}
