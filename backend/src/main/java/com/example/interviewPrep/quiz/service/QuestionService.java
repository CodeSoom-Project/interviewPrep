package com.example.interviewPrep.quiz.service;

import com.example.interviewPrep.quiz.domain.Question;
import com.example.interviewPrep.quiz.dto.QuestionDTO;
import com.example.interviewPrep.quiz.exception.QuestionNotFoundException;
import com.example.interviewPrep.quiz.repository.QuestionJpaRepository;
import com.example.interviewPrep.quiz.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionJpaRepository questionJpaRepository;


    public Question createQuestion(QuestionDTO questionDTO){
        Question question = Question.builder()
                        .title(questionDTO.getTitle())
                        .type(questionDTO.getType())
                        .build();
        questionRepository.save(question);
        return question;
    }

    public Question updateQuestion(Long id, QuestionDTO questionDTO){

        Question question = findQuestionById(id);

        if(question == null){
            throw new QuestionNotFoundException(id);
        }

        question.change(
                    questionDTO.getTitle(),
                    questionDTO.getType()
        );

        return questionRepository.update(question);


    }

    public Question deleteQuestion(Long id){
        Question question = findQuestionById(id);
        questionRepository.delete(question);
        return question;
    }

    public Optional<List<Question>> findQuestionsByType(String type){
        List<Question> questions = questionRepository.findByType(type);

        if(questions.size() == 0){
            return Optional.empty();
        }

        return Optional.ofNullable(questions);
    }


    public Optional<Page<QuestionDTO>> findByType(String type, Pageable pageable){
        Page<Question> questions = questionJpaRepository.findByType(type, pageable);


        return Optional.of(questions.map(q -> QuestionDTO.builder().
                                                        id(q.getId())
                                                        .type(q.getType())
                                                        .title(q.getTitle())
                                                        .build()));
    }


    public Question findQuestionById(Long id){
        return questionRepository.findById(id);
    }

    public Optional<QuestionDTO> findById(Long id){

        return questionJpaRepository.findById(id).map(q -> QuestionDTO.builder()
                .id(q.getId())
                .type(q.getType())
                .title(q.getTitle())
                .build());
    }


}
