package ru.testingsystem.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "test_data_questions")
public class TestData {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "input_data", length = 300, nullable = false)
    private String inputData;

    @Column(name = "output_data", length = 300, nullable = false)
    private String outputData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_question", nullable = false)
    private Question question;

    public TestData(){

    }

    @Builder
    public TestData(String inputData, String outputData, Question question) {
        this.inputData = inputData;
        this.outputData = outputData;
        this.question = question;
    }

}
