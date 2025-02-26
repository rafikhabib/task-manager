package tn.esprit.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backend.entite.Task;
import tn.esprit.backend.repo.TaskRepo;

import java.util.List;

@Service
public class ServiceImpl implements IService{
    TaskRepo taskRepo;

    public ServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        task.setId(id);
        return taskRepo.save(task);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepo.findById(id).get();
    }

    @Override
    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
