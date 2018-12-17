package trylma.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import trylma.Main;

import java.io.IOException;

public class MainWindowController {

    // (J) Top Menu
    @FXML
    final void aboutClick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rules");
        alert.setHeaderText("You can move any direction but only one space.\n" +
                "If there's another checker u can jump over it with yours continuously if the condition is still met.\n" +
                "Your goal is to get all of your checkers to opposite triangle.");
        alert.setContentText("This simple game is made for college project.\n" +
                "Hope you enjoy.\n" +
                "Credits: Luzkan & Gorsky");
        alert.show();
    }

    @FXML
    final void closeClick() {
        Runtime.getRuntime().exit(0);
    }

    // (J) Developer Options just to move around right now
    @FXML
    private Button quitBtn;

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
