package trylma.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import trylma.Main;
import trylma.OptionsComputing;

import java.io.IOException;

public class ConnectionController extends OptionsComputing {

    // Connection
    @FXML
    private TextField givenIP;
    @FXML
    private TextField givenPort;

    @FXML
    void connectTo(ActionEvent event) throws IOException {

        // (J) Stick IP and port as one part
        String IPPort = givenIP.getText() + ":" + givenPort.getText();
        setIPPort(IPPort);

        Main.showJoinedGame();
    }


    @FXML
    void goMainMenu(ActionEvent event) throws IOException {
        Main.showMainMenu();
    }

}
