/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puentiw;

public class PretestQuestion {
    private int id;
    private Category category;
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private char correctChoice;

    public PretestQuestion(int id, Category category, String question,
                           String choiceA, String choiceB,
                           String choiceC, String choiceD,
                           char correctChoice) {
        this.id = id;
        this.category = category;
        this.question = question;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.correctChoice = correctChoice;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public char getCorrectChoice() {
        return correctChoice;
    }
}