package com.example.interviewPrep.quiz.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void creationWithId(){
        Question question = Question.builder()
                           .id(11L)
                           .title("String 클래스는 왜 불변입니까?")
                           .type("java")
                           .build();

        assertThat(question.getId()).isEqualTo(11L);
        assertThat(question.getTitle()).isEqualTo("String 클래스는 왜 불변입니까?");
        assertThat(question.getType()).isEqualTo("java");
    }


    @Test
    void creationWithoutId(){
        Question question = Question.builder()
                .title("String 클래스는 왜 불변입니까?")
                .type("java")
                .build();

        assertThat(question.getTitle()).isEqualTo("String 클래스는 왜 불변입니까?");
        assertThat(question.getType()).isEqualTo("java");
    }

}