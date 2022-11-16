package com.example.interviewPrep.quiz.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    Member member;

    @ManyToMany
    @JoinColumn(name = "ANSWER_ID")
    List<Answer> answers = new ArrayList<>();

}
