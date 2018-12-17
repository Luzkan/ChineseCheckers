package trylma.Controllers;

import javafx.fxml.FXML;
import trylma.Main;

import java.io.IOException;

public class MainMenuController {

    // Switch between Options and The Game

    @FXML
    private void goPlayGame() throws IOException {
        Main.showPlayGame();
    }

    @FXML
    void goHostGame() {

    }

    @FXML
    void goJoinGame() {

    }

    @FXML
    private void goConnection() throws IOException {
        Main.showConnection();
    }

    @FXML
    private void goOptions() throws IOException {
        Main.showOptions();
    }



}
