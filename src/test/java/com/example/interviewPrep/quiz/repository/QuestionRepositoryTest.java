package com.example.interviewPrep.quiz.repository;

import com.example.interviewPrep.quiz.domain.Question;
import com.example.interviewPrep.quiz.dto.QuestionDTO;
import com.example.interviewPrep.quiz.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
class QuestionRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionRepository questionRepository;

    @Test
    public void save(){

        // Given
        Question question = Question.builder()
                .title("problem2")
                .type("java")
                .build();

        // When
        questionRepository.save(question);

        // Then
        Long savedId = question.getId();
        assertEquals(question, questionRepository.findById(savedId));

    }

    @Test
    public void findByType() throws Exception{

        // Given
        Question question = Question.builder()
                .title("problem333")
                .type("java22")
                .build();

        // When
        questionRepository.save(question);

        // Then
        Question result = questionRepository.findByType("java22").get(0);
        assertThat(question).isEqualTo(result);

    }

}