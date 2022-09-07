package com.example.interviewPrep.quiz.dto;

import lombok.*;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    private Long id;
    private Long questionId;
    private String content;


}
