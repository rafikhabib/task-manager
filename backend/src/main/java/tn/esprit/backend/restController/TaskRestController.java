package tn.esprit.backend.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.entite.Task;
import tn.esprit.backend.service.IService;

import java.util.List;

@RestController
@AllArgsConstructor
//@CrossOrigin(origins = {"http://localhost:4200", "http://frontend",http://localhost:80"})
@CrossOrigin(origins = "*")
public class TaskRestController {
    IService service;
    @GetMapping("/tasks")
     List<Task> getTasks() {
        return service.getTasks();
    }

    @GetMapping("/tasks/{id}")
     Task getTask(@PathVariable Long id) {
        return service.getTask(id);
    }

    @PostMapping("tasks")
     Task createTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @PutMapping("/tasks/{id}")
     Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("/tasks/{id}")
     void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
