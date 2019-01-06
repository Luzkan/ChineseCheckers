package trylma.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Starting up a server");
        alert.setHeaderText("Use 'ChineseCheckersServer' to start-up a server in order to play online.");
        alert.setContentText("In future release it's possible to merge both into one executable.");
        alert.show();
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
