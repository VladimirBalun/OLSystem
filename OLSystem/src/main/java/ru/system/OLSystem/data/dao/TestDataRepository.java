package ru.system.OLSystem.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.system.OLSystem.data.entity.Task;
import ru.system.OLSystem.data.entity.TestData;

import java.util.List;

public interface TestDataRepository extends JpaRepository<TestData, Long> {

    List<TestData> findByTask(Task task);

}
