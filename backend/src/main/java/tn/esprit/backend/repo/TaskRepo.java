package tn.esprit.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend.entite.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
}
