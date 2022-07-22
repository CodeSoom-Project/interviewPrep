package com.example.interviewPrep.quiz.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id @GeneratedValue
    @Column(name = "QUESTION_ID")
    private Long id;

    private String title;
    private String type;

    public void change(String title, String type){
        this.title = title;
        this.type = type;
    }
}
