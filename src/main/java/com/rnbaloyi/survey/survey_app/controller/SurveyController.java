package com.rnbaloyi.survey.survey_app.controller;

import com.rnbaloyi.survey.survey_app.model.Survey;
import com.rnbaloyi.survey.survey_app.service.SurveyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/")
    public String showSurveyForm(Model model) {
        model.addAttribute("survey", new Survey());
        model.addAttribute("minDate", LocalDate.now().minusYears(120));
        model.addAttribute("maxDate", LocalDate.now().minusYears(1));
        return "fill-survey";
    }

    @PostMapping("/submit-survey")
    public String submitSurvey(@Valid @ModelAttribute("survey") Survey survey,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("minDate", LocalDate.now().minusYears(120));
            model.addAttribute("maxDate", LocalDate.now().minusYears(1));
            return "fill-survey";
        }
        surveyService.saveSurvey(survey);
        model.addAttribute("message", "Survey submitted successfully!");
        model.addAttribute("submitted", true);
        model.addAttribute("survey", new Survey());
        model.addAttribute("minDate", LocalDate.now().minusYears(120));
        model.addAttribute("maxDate", LocalDate.now().minusYears(1));
        return "fill-survey";
    }

}
