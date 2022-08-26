package kz.yyediluly.dao;


import kz.yyediluly.domain.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
@Component
@PropertySource("classpath:app.properties")
public class QuestionDaoImpl implements QuestionDao{

    public QuestionDaoImpl() {
    }

    @Value("${csvPath}")
    private String csv;

    public List<Question> getQuestions() throws IOException {

        ArrayList<Question> list = new ArrayList<>();

        String line;

        try(BufferedReader br = new BufferedReader(new FileReader("hw2/src/main/resources/csv/Questions.csv"))) {
            while ((line = br.readLine()) != null) {
                list.add(new Question(line.split(";")[0], line.split(";")[1]));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

       return list;
    }
}

