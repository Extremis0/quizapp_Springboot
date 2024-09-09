package com.tanmay.quizapp.controller;

import com.tanmay.quizapp.Model.Question;
import com.tanmay.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public  ResponseEntity <List<Question> >getallQuestions(){

        return questionService.getAllQuestion();
    }
    @GetMapping("category/{category}")
    public ResponseEntity< List<Question>> getQuestionsbByCategory( @PathVariable  String category){

        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion( @RequestBody  Question question){
        return questionService.addQuestion(question);
    }

}
