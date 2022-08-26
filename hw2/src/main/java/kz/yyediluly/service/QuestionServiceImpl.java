package kz.yyediluly.service;

import kz.yyediluly.dao.QuestionDao;
import kz.yyediluly.domain.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
@PropertySource("classpath:app.properties")
public class QuestionServiceImpl implements QuestionService{

    private final QuestionDao dao;

    @Value("${passingPercentage}")
    private int passingPercentage;

    @Override
    public void runService() throws IOException {
        Scanner in = new Scanner(System.in);

        int result = 0;

        int size = dao.getQuestions().size();

        for (Question q : dao.getQuestions()) {
            System.out.println(q.getText()) ;
            String answer = in.nextLine();
            if(answer.trim().equals(q.getAnswer().trim())) {
                result++;
            }
        }

        System.out.println(result/size*100 > passingPercentage ? "Passed" : "Not passed");
    }

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }
}
