package com.rnbaloyi.survey.survey_app.controller;


import com.rnbaloyi.survey.survey_app.service.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultController {

    private final SurveyService surveyService;

    public ResultController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/results")
    public String viewResults(Model model) {
        var stats = surveyService.calculateSurveyStats();

        if (stats.isEmpty()) {
            model.addAttribute("noDataMessage", "No Surveys Available.");
            return "view-results";
        }

        model.addAllAttributes(stats);
        return "view-results";
    }
}
