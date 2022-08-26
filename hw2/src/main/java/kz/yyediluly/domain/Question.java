package kz.yyediluly.domain;

public class Question {
    private final String text;

    private final String answer;

    public String getAnswer() {
        return answer;
    }

    public Question(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    public String getText() {
        return text;
    }
}
