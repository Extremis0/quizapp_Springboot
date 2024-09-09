package com.tanmay.quizapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Question {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String difficultylevel;

    private String option1;
    private String option2;
    private String option3;
    private  String option4;

    private String  rightanswer;
    private  String questiontitle;



}
