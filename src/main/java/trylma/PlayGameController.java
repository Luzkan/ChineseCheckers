package trylma;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class PlayGameController{

    @FXML
    private Text whoseTurnText;

    @FXML
    void endTurn(ActionEvent event) {

        // Send state of the board to connected players and redraw whole board
        //                                  Or
        // Send moves that were made to connected players and update their boards accordingly

        //winCondition();
        nextTurn();
    }

    void nextTurn(){

        /*
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

        */
        //if(totalAmountOfPlayers == 6) {
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
       // }
    }
}

