package model;

public class QuizQuestion {
    private int questionNumber;
    private String question;
    private String options[];
    private int ansIndex;

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] optons) {
        this.options = optons;
    }

    public int getAnsIndex() {
        return ansIndex;
    }

    public void setAnsIndex(int ansIndex) {
        this.ansIndex = ansIndex;
    }
    
    
}
