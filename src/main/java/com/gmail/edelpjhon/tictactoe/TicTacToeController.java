package com.gmail.edelpjhon.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;

import java.net.URL;
import java.util.ResourceBundle;

public class TicTacToeController implements Initializable {

    @FXML
    private Button case11,case12, case13, case21, case22, case23, case31, case32, case33, btnJouer;

    @FXML
    private Label mssgTour;

    TicTacToe ticTacToe;

    @FXML
    void btnJouerHandle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Restart Game");
        alert.setHeaderText("Are you sure to restart the game?");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.OK) {
            ticTacToe = new TicTacToe();
            updateBoard();
            btnJouer.setDisable(true);
            mssgTour.setText(" It's your turn");
        }
    }

    @FXML
    void case11Handle(ActionEvent event) {
        if(ticTacToe.isStopCondition()) return;
        if(case11.getText().trim().isEmpty()) {
            ticTacToe.placePiece(1, 1);
            updateBoard();
        }
        else {
            mssgTour.setText("Case already filled");
        }
    }

    @FXML
    void case12Handle(ActionEvent event) {
        if(ticTacToe.isStopCondition()) return;
        if(case12.getText().trim().isEmpty()) {
            ticTacToe.placePiece(1, 2);
            updateBoard();
        }
        else {
            mssgTour.setText("Case already filled");
        }
    }

    @FXML
    void case13Handle(ActionEvent event) {
        if(ticTacToe.isStopCondition()) return;
        if(case13.getText().trim().isEmpty()) {
            ticTacToe.placePiece(1, 3);
            updateBoard();
        }
        else {
            mssgTour.setText("Case already filled");
        }
    }

    @FXML
    void case21Handle(ActionEvent event) {
        if(ticTacToe.isStopCondition()) return;
        if(case21.getText().trim().isEmpty()) {
            ticTacToe.placePiece(2, 1);
            updateBoard();
        }
        else {
            mssgTour.setText("Case already filled");
        }
    }

    @FXML
    void case22Handle(ActionEvent event) {
        if(ticTacToe.isStopCondition()) return;
        if(case22.getText().trim().isEmpty()) {
            ticTacToe.placePiece(2, 2);
            updateBoard();
        }
        else {
            mssgTour.setText("Case already filled");
        }
    }

    @FXML
    void case23Handle(ActionEvent event) {
        if(ticTacToe.isStopCondition()) return;
        if(case23.getText().trim().isEmpty()) {
            ticTacToe.placePiece(2, 3);
            updateBoard();
        }
        else {
            mssgTour.setText("Case already filled");
        }
    }

    @FXML
    void case31Handle(ActionEvent event) {
        if(ticTacToe.isStopCondition()) return;
        if(case31.getText().trim().isEmpty()) {
            ticTacToe.placePiece(3, 1);
            updateBoard();
        }
        else {
            mssgTour.setText("Case already filled");
        }
    }

    @FXML
    void case32Handle(ActionEvent event) {
        if(ticTacToe.isStopCondition()) return;
        if(case32.getText().trim().isEmpty()) {
            ticTacToe.placePiece(3, 2);
            updateBoard();
        }
        else {
            mssgTour.setText("Case already filled");
        }
    }

    @FXML
    void case33Handle(ActionEvent event) {
        if(ticTacToe.isStopCondition()) return;
        if(case33.getText().trim().isEmpty()) {
            ticTacToe.placePiece(3, 3);
            updateBoard();
        }
        else {
            mssgTour.setText("Case already filled");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ticTacToe = new TicTacToe();
        updateBoard();
        setStyle();
        btnJouer.setDisable(true);
    }

    private void updateBoard() {
        if(ticTacToe.isStopCondition()){
            mssgTour.setText(ticTacToe.getPrintWinner());
        }
        case11.setText(String.valueOf(ticTacToe.getBoard()[0][0]));
        case12.setText(String.valueOf(ticTacToe.getBoard()[0][1]));
        case13.setText(String.valueOf(ticTacToe.getBoard()[0][2]));
        case21.setText(String.valueOf(ticTacToe.getBoard()[1][0]));
        case22.setText(String.valueOf(ticTacToe.getBoard()[1][1]));
        case23.setText(String.valueOf(ticTacToe.getBoard()[1][2]));
        case31.setText(String.valueOf(ticTacToe.getBoard()[2][0]));
        case32.setText(String.valueOf(ticTacToe.getBoard()[2][1]));
        case33.setText(String.valueOf(ticTacToe.getBoard()[2][2]));

        if(ticTacToe.isStarted()){
            mssgTour.setText("It's a draw");
            btnJouer.setDisable(false);
            btnJouer.setText("Restart");
        }
    }

    private void setStyle(){
       String fontStyle = " -fx-font-size: 70 ;-fx-text-fill: #000000; -fx-background-color: #ffffff; -fx-font-family: Arial ";
            case11.setStyle(fontStyle);
            case12.setStyle(fontStyle);
            case13.setStyle(fontStyle);
            case21.setStyle(fontStyle);
            case22.setStyle(fontStyle);
            case23.setStyle(fontStyle);
            case31.setStyle(fontStyle);
            case32.setStyle(fontStyle);
            case33.setStyle(fontStyle);
    }
}