package com.example.interviewPrep.quiz.service;

import com.example.interviewPrep.quiz.domain.Question;
import com.example.interviewPrep.quiz.dto.QuestionDTO;
import com.example.interviewPrep.quiz.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class QuestionServiceTest {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionRepository questionRepository;

    private Question question;
    private QuestionDTO questionDTO;
    private QuestionDTO updatedQuestionDTO;

    @BeforeEach
    void setUp(){
        questionDTO = QuestionDTO.builder()
                                .title("자바 1번 문제")
                                .type("java")
                                .build();

        updatedQuestionDTO = QuestionDTO.builder()
                            .title("자바 1번 문제 수정")
                            .type("java")
                            .build();
    }

    @Test
    void createQuestion() {

        question = Question.builder()
                .title(questionDTO.getTitle())
                .type(questionDTO.getType())
                .build();

        assertThat(question.getTitle()).isEqualTo(questionDTO.getTitle());
        assertThat(question.getType()).isEqualTo(questionDTO.getType());
    }

    @Test
    void updateQuestion(){

       Question question = questionService.createQuestion(questionDTO);

       Question updatedQuestion = questionService.updateQuestion(question.getId(), updatedQuestionDTO);

       assertThat(updatedQuestion.getTitle()).isEqualTo(updatedQuestionDTO.getTitle());
    }


    @Test
    void deleteQuestion(){

        Question question = questionService.createQuestion(questionDTO);

        questionService.deleteQuestion(question.getId());

        assertThat(questionRepository.findById(question.getId())).isEqualTo(null);

    }
}
