package ru.system.OLSystem.data.entity;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tasks")
public class Task {

    @javax.persistence.Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "title",unique = true, length = 20, nullable = false)
    private String title;

    @Column(name = "description", length = 2000, nullable = false)
    private String description;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "task")
    private List<TestData> testDataForTask = new ArrayList<>();

    public Task() {}

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TestData> getTestDataForTask() {
        return testDataForTask;
    }

    public void setTestDataForTask(List<TestData> testDataForTask) {
        this.testDataForTask = testDataForTask;
    }

}
