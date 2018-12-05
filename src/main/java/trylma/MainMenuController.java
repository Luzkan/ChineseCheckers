package trylma;

import javafx.fxml.FXML;
import java.io.IOException;


public class MainMenuController {

    private Main main;

    @FXML
    private void goPlayGame() throws IOException {
        main.showPlayGame();
    }

    @FXML
    private void goOptions() throws IOException {
        main.showOptions();
    }
}
