package ru.testingsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.testingsystem.data.entity.Question;
import ru.testingsystem.data.entity.TestData;

import java.util.List;

public interface TestDataRepository extends JpaRepository<TestData, Long>{

    @Transactional
    TestData findByInputDataAndOutputData(String inputData, String outputData);

    @Transactional
    List<TestData> findByQuestion(Question question);

    @Transactional
    void deleteByInputDataAndOutputData(String inputData, String outputData);

}
