package ru.system.OLSystem.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.system.OLSystem.data.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    boolean existsByTitle(String title);

    Task findByTitle(String title);

    void deleteByTitle(String title);

}
