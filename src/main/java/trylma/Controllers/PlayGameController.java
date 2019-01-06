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

import static trylma.Board.jumpMade;
import static trylma.Board.moveMade;

public class PlayGameController{

    @FXML
    public Text whoseTurnText;

    @FXML
    private Button quitBtn;

    @FXML
    void endTurn(ActionEvent event) {

        // (J) 0.6a After pressing the button these below will be performd
        // Because I still can't connect to local server on my pc
        // I can't test what will happen if a player whose turn it isn't
        // will click the button. Be aware of that. Probably add ifs if game is in multiplayer.

        if(moveMade || jumpMade) {
            Board.resetChecks();
            Board.winCondition();
            nextTurn();
            Board.turnManager();
        }
}

    private void nextTurn(){

    int totalAmountOfPlayers;

    if (!(Client.inMulitipalyerMode)){
        OptionsComputing options = new OptionsComputing();
        totalAmountOfPlayers = options.getTotalPlayers();
    }else{
        totalAmountOfPlayers = Client.Number_of_players;
    }




    // (J) Player 0 is to make those easy to read ifs. Otherwise it would skip over Player thats in-game.

    if(totalAmountOfPlayers == 2) {
        if (whoseTurnText.getText().equals("Player Red"))
            whoseTurnText.setText("Player 0");

        if (whoseTurnText.getText().equals("Player Green"))
            whoseTurnText.setText("Player Red");

        if (whoseTurnText.getText().equals("Player 0"))
            whoseTurnText.setText("Player Green");
    }

    if(totalAmountOfPlayers == 3) {
        if (whoseTurnText.getText().equals("Player Yellow"))
            whoseTurnText.setText("Player 0");

        if (whoseTurnText.getText().equals("Player Red"))
            whoseTurnText.setText("Player Yellow");

        if (whoseTurnText.getText().equals("Player Green"))
            whoseTurnText.setText("Player Red");

        if (whoseTurnText.getText().equals("Player 0"))
            whoseTurnText.setText("Player Green");
    }

    if(totalAmountOfPlayers == 4) {
        if (whoseTurnText.getText().equals("Player Blue"))
            whoseTurnText.setText("Player 0");

        if (whoseTurnText.getText().equals("Player Yellow"))
            whoseTurnText.setText("Player Blue");

        if (whoseTurnText.getText().equals("Player Red"))
            whoseTurnText.setText("Player Yellow");

        if (whoseTurnText.getText().equals("Player Green"))
            whoseTurnText.setText("Player Red");

        if (whoseTurnText.getText().equals("Player 0"))
            whoseTurnText.setText("Player Green");
    }


    if(totalAmountOfPlayers == 6) {
        if (whoseTurnText.getText().equals("Player Magenta"))
            whoseTurnText.setText("Player 0");

        if (whoseTurnText.getText().equals("Player Pink"))
            whoseTurnText.setText("Player Magenta");

        if (whoseTurnText.getText().equals("Player Blue"))
            whoseTurnText.setText("Player Pink");

        if (whoseTurnText.getText().equals("Player Yellow"))
            whoseTurnText.setText("Player Blue");

        if (whoseTurnText.getText().equals("Player Red"))
            whoseTurnText.setText("Player Yellow");

        if (whoseTurnText.getText().equals("Player Green"))
            whoseTurnText.setText("Player Red");

        if (whoseTurnText.getText().equals("Player 0"))
            whoseTurnText.setText("Player Green");
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

