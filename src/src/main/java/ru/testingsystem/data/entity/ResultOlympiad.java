package ru.testingsystem.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "results_olympiad")
public class ResultOlympiad {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "count_true_answers", nullable = false)
    private int countTrueAnswers;

    @Column(name = "count_questions", nullable = false)
    private int countQuestions;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public ResultOlympiad(){

    }

    @Builder
    public ResultOlympiad(int countTrueAnswers, int countQuestions, User user) {
        this.countTrueAnswers = countTrueAnswers;
        this.countQuestions = countQuestions;
        this.user = user;
    }

}
