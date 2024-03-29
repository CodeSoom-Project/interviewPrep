package com.example.interviewPrep.quiz.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@RequiredArgsConstructor
public class QuestionDTO {

    private Long id;

    @NotNull
    private String title;
    @NotNull
    private String type;

}
