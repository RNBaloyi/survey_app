package com.rnbaloyi.survey.survey_app.service;



import com.rnbaloyi.survey.survey_app.model.Survey;

import java.util.List;
import java.util.Map;

public interface SurveyService {
    Survey saveSurvey(Survey survey);
    List<Survey> getAllSurveys();

    Map<String, Object> calculateSurveyStats();
}
