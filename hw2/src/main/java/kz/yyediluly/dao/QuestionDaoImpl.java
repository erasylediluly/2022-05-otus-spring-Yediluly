package kz.yyediluly.dao;


import kz.yyediluly.domain.Question;
import kz.yyediluly.exception.QuestionsLoadingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
@PropertySource("classpath:app.properties")
public class QuestionDaoImpl implements QuestionDao{

    private String csv;

    public QuestionDaoImpl(@Value("${csvPath}") String csv) {
        this.csv = csv;
    }

    public List<Question> getQuestions() throws QuestionsLoadingException {

        List<Question> list = new ArrayList<>();

        String line;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(csv)))) {
            while ((line = br.readLine()) != null) {
                list.add(new Question(line.split(";")[0], line.split(";")[1]));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

       return list;
    }
}

