package com.rnbaloyi.survey.survey_app.service;


import com.rnbaloyi.survey.survey_app.model.Survey;
import com.rnbaloyi.survey.survey_app.repository.SurveyRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Map<String, Object> calculateSurveyStats() {
        List<Survey> surveys = surveyRepository.findAll();

        Map<String, Object> stats = new HashMap<>();
        if (surveys.isEmpty()) {
            return stats;
        }

        int total = surveys.size();
        stats.put("totalSurveys", total);

        // Calculate ages
        List<Integer> ages = surveys.stream().map(Survey::getAge).collect(Collectors.toList());
        double avgAge = ages.stream().mapToInt(i -> i).average().orElse(0);
        int maxAge = ages.stream().mapToInt(i -> i).max().orElse(0);
        int minAge = ages.stream().mapToInt(i -> i).min().orElse(0);

        stats.put("averageAge", Math.round(avgAge * 10) / 10.0);
        stats.put("maxAge", maxAge);
        stats.put("minAge", minAge);

        // Percentage of people who like each food
        long pizzaCount = surveys.stream()
                .filter(s -> s.getFavoriteFoods() != null && s.getFavoriteFoods().contains("Pizza"))
                .count();
        long pastaCount = surveys.stream()
                .filter(s -> s.getFavoriteFoods() != null && s.getFavoriteFoods().contains("Pasta"))
                .count();
        long papAndWorsCount = surveys.stream()
                .filter(s -> s.getFavoriteFoods() != null && s.getFavoriteFoods().contains("Pap and Wors"))
                .count();

        stats.put("percentPizza", Math.round(((double)pizzaCount / total) * 1000) / 10.0);
        stats.put("percentPasta", Math.round(((double)pastaCount / total) * 1000) / 10.0);
        stats.put("percentPapAndWors", Math.round(((double)papAndWorsCount / total) * 1000) / 10.0);

        // Average ratings (1 to 5)
        double avgMovies = surveys.stream().mapToInt(Survey::getRatingMovies).average().orElse(0);
        double avgRadio = surveys.stream().mapToInt(Survey::getRatingRadio).average().orElse(0);
        double avgEatOut = surveys.stream().mapToInt(Survey::getRatingEatOut).average().orElse(0);
        double avgWatchTV = surveys.stream().mapToInt(Survey::getRatingWatchTV).average().orElse(0);

        stats.put("avgMovies", Math.round(avgMovies * 10) / 10.0);
        stats.put("avgRadio", Math.round(avgRadio * 10) / 10.0);
        stats.put("avgEatOut", Math.round(avgEatOut * 10) / 10.0);
        stats.put("avgWatchTV", Math.round(avgWatchTV * 10) / 10.0);

        return stats;
    }
}
