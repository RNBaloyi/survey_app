package com.rnbaloyi.survey.survey_app.repository;


import com.rnbaloyi.survey.survey_app.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
