package kz.yyediluly.dao;

import kz.yyediluly.domain.Question;
import kz.yyediluly.exception.QuestionsLoadingException;

import java.io.IOException;
import java.util.List;

public interface QuestionDao {
    public List<Question> getQuestions() throws QuestionsLoadingException;
}
