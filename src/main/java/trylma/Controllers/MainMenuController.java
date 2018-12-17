package trylma.Controllers;

import javafx.fxml.FXML;
import trylma.Main;

import java.io.IOException;

public class MainMenuController {

    // (J) Main Screen at which user will end up with after starting program
    // Here are just the button controllers

    @FXML
    private void goPlayGame() throws IOException {
        Main.showPlayGame();
    }

    @FXML
    void goHostGame() {

    }

    // (J) Join Game
    @FXML
    private void goConnection() throws IOException {
        Main.showConnection();
    }

    @FXML
    private void goOptions() throws IOException {
        Main.showOptions();
    }



}
