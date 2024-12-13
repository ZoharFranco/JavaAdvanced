package org.example.maman13b;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import org.example.maman13b.models.Question;
import org.example.maman13b.utils.QuestionReader;

import java.util.List;

public class TriviaGameController {

    @FXML
    private Label questionLabel;
    @FXML
    private RadioButton answer1;
    @FXML
    private RadioButton answer2;
    @FXML
    private RadioButton answer3;
    @FXML
    private RadioButton answer4;
    @FXML
    private ToggleGroup answerGroup;

    @FXML
    private Label scoreLabel;
    @FXML
    private Button nextButton;

    private final List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    public TriviaGameController() {
        questions = loadQuestions();
    }

    @FXML
    private void initialize() {
        answerGroup = new ToggleGroup();
        displayQuestion();
    }

    private List<Question> loadQuestions() {
        String workingDirectory = System.getProperty("user.dir");

        // Print the current working directory
        System.out.println("Current working directory: " + workingDirectory);
        QuestionReader questionReader = new QuestionReader("questions.txt");
        return questionReader.getQuestions();
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getQuestionText());
            answer1.setText(currentQuestion.getAnswers().get(0));
            answer2.setText(currentQuestion.getAnswers().get(1));
            answer3.setText(currentQuestion.getAnswers().get(2));
            answer4.setText(currentQuestion.getAnswers().get(3));
            answer1.setToggleGroup(answerGroup);
            answer2.setToggleGroup(answerGroup);
            answer3.setToggleGroup(answerGroup);
            answer4.setToggleGroup(answerGroup);
            answerGroup.selectToggle(null); // Clear previous selection
        } else {
            endGame();
        }
    }

    @FXML
    private void handleNextButton() {
        RadioButton selectedAnswer = (RadioButton) answerGroup.getSelectedToggle();

        if (selectedAnswer != null) {
            int selectedIndex = getSelectedAnswerIndex(selectedAnswer);
            Question currentQuestion = questions.get(currentQuestionIndex);

            if (selectedIndex == currentQuestion.getCorrectAnswerIndex()) {
                score += 10;
                showAlert(AlertType.INFORMATION, "Correct!", "You earned 10 points!");
            } else {
                score -= 5;
                showAlert(AlertType.WARNING, "Incorrect!", "The correct answer was: " + currentQuestion.getAnswers().get(currentQuestion.getCorrectAnswerIndex()));
            }

            scoreLabel.setText("Score: " + score);
            currentQuestionIndex++;
            displayQuestion();
        } else {
            showAlert(AlertType.ERROR, "No Answer Selected", "Please select an answer.");
        }
    }

    private int getSelectedAnswerIndex(RadioButton selectedAnswer) {
        if (selectedAnswer == answer1) return 0;
        if (selectedAnswer == answer2) return 1;
        if (selectedAnswer == answer3) return 2;
        if (selectedAnswer == answer4) return 3;
        return -1;
    }

    private void endGame() {
        showAlert(AlertType.INFORMATION, "Game Over!", "Your final score is: " + score);
        nextButton.setDisable(true); // Disable the next button
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
