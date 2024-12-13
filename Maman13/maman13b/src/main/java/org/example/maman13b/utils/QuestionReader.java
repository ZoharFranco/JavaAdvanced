package org.example.maman13b.utils;

import org.example.maman13b.models.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuestionReader {
    private final List<Question> questions;


    public QuestionReader(String fileName) {
        questions = new ArrayList<>();
        readQuestionsFromFile(fileName);
    }

    private void readQuestionsFromFile(String fileName) {
        Scanner input = null;
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (input.hasNextLine()) {

            String questionText = input.nextLine();
            List<String> answers = new ArrayList<>();


            for (int i = 0; i < 4; i++) {
                if (input.hasNextLine()) {
                    answers.add(input.nextLine());
                }
            }

            String correctAnswer = answers.getFirst();
            Collections.shuffle(answers);

            int correctAnswerIndex = answers.indexOf(correctAnswer);
            questions.add(new Question(questionText, answers, correctAnswerIndex));
        }
        Collections.shuffle(questions);
        input.close();

    }


    public List<Question> getQuestions() {
        return questions;
    }
}
