package javaVokabeltrainer;

public class Backend {
    int idOfWord;

    JdbcApp jdbc = new JdbcApp();

    void chooseNewWord() {
        jdbc.runCommand("");
    }
}