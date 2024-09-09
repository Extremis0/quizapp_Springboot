package com.tanmay.quizapp.service;

import com.tanmay.quizapp.Dao.QuestionDao;
import com.tanmay.quizapp.Dao.QuizDao;
import com.tanmay.quizapp.Model.Question;
import com.tanmay.quizapp.Model.QuestionWrapper;
import com.tanmay.quizapp.Model.Quiz;
import com.tanmay.quizapp.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question > questions =questionDao.findRandomQuestionByCategory(category ,numQ);
        Quiz quiz =new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);
        return new ResponseEntity<>("Success" , HttpStatus.CREATED);

    }
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

       Optional<Quiz> quiz =quizDao.findById(id);
       List<Question> questionsdb =quiz.get().getQuestions();
       List<QuestionWrapper> questionForUser =new ArrayList<>();

       for(Question q:questionsdb){
           QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestiontitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
       }
       return new ResponseEntity<>(questionForUser,HttpStatus.OK);

    }
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz =quizDao.findById(id).get();
        System.out.println(quiz);
        List<Question> questions =quiz.getQuestions();
        System.out.println();

        int numquestion =0;
        int right=0;
        for(Response response :responses){
            if(response.getResponse().equals( questions.get(numquestion).getRightanswer()))

                 right++;

            numquestion++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }

}
