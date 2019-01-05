package trylma.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import trylma.Board;
import trylma.Client;
import trylma.Main;
import trylma.OptionsComputing;

import java.io.IOException;

public class PlayGameController{

    @FXML
    public Text whoseTurnText;

    @FXML
    private Button quitBtn;

    @FXML
    void endTurn(ActionEvent event) {

        // Send state of the board to connected players and redraw whole board
        //                                  Or
        // Send moves that were made to connected players and update their boards accordingly


        Board.resetChecks();
        Board.winCondition();
        nextTurn();
    }



    public void nextTurn(){

    OptionsComputing options = new OptionsComputing();
    int totalAmountOfPlayers = options.getTotalPlayers();

    // (J) Player 0 is to make those easy to read ifs. Otherwise it would skip over Player thats in-game.

    if(totalAmountOfPlayers == 2) {
        if (whoseTurnText.getText().equals("Player 2"))
            whoseTurnText.setText("Player 0");

        if (whoseTurnText.getText().equals("Player 1"))
            whoseTurnText.setText("Player 2");

        if (whoseTurnText.getText().equals("Player 0"))
            whoseTurnText.setText("Player 1");
    }

    if(totalAmountOfPlayers == 3) {
        if (whoseTurnText.getText().equals("Player 3"))
            whoseTurnText.setText("Player 0");

        if (whoseTurnText.getText().equals("Player 2"))
            whoseTurnText.setText("Player 3");

        if (whoseTurnText.getText().equals("Player 1"))
            whoseTurnText.setText("Player 2");

        if (whoseTurnText.getText().equals("Player 0"))
            whoseTurnText.setText("Player 1");
    }

    if(totalAmountOfPlayers == 4) {
        if (whoseTurnText.getText().equals("Player 4"))
            whoseTurnText.setText("Player 0");

        if (whoseTurnText.getText().equals("Player 3"))
            whoseTurnText.setText("Player 4");

        if (whoseTurnText.getText().equals("Player 2"))
            whoseTurnText.setText("Player 3");

        if (whoseTurnText.getText().equals("Player 1"))
            whoseTurnText.setText("Player 2");

        if (whoseTurnText.getText().equals("Player 0"))
            whoseTurnText.setText("Player 1");
    }


    if(totalAmountOfPlayers == 6) {
        if (whoseTurnText.getText().equals("Player 6"))
            whoseTurnText.setText("Player 0");

        if (whoseTurnText.getText().equals("Player 5"))
            whoseTurnText.setText("Player 6");

        if (whoseTurnText.getText().equals("Player 4"))
            whoseTurnText.setText("Player 5");

        if (whoseTurnText.getText().equals("Player 3"))
            whoseTurnText.setText("Player 4");

        if (whoseTurnText.getText().equals("Player 2"))
            whoseTurnText.setText("Player 3");

        if (whoseTurnText.getText().equals("Player 1"))
            whoseTurnText.setText("Player 2");

        if (whoseTurnText.getText().equals("Player 0"))
            whoseTurnText.setText("Player 1");
    }

    Client.InformServerEndTurn();

    }

    @FXML
    private void goMainMenu() throws IOException {
        Main.showMainMenu();
    }

    @FXML
    private void goQuit(){
        Stage stage = (Stage) quitBtn.getScene().getWindow();
        stage.close();
    }
}

