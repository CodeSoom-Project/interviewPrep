package com.example.interviewPrep.quiz.infra;

import com.example.interviewPrep.quiz.domain.Question;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public interface QuestionRepository extends JpaRepository<Question, Long>{

    Optional<Question> findById(Long id);
    Optional<Question> findByTitle(String title);
    List<Question> findByType(String type);
    Page<Question> findByType(String type, Pageable pageable);
    Page<Question> findAllBy(Pageable pageable);

    List<Question> findAll();
    Question save(Question question);
    void delete(Question question);

    @Query(value = "SELECT * FROM Question order by RAND() limit 10",nativeQuery = true)
    List<Question> findRamdom();
}
