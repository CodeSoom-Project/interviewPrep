package com.example.interviewPrep.quiz.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class QuestionDTOTest {

    @Test
    void create(){
        QuestionDTO question = QuestionDTO.builder()
                .id(1L)
                .title("problem1")
                .build();

        assertThat(question.getId()).isEqualTo(1L);
        assertThat(question.getTitle()).isEqualTo("problem1");
    }

}