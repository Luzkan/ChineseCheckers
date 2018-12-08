package trylma;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

public class OptionsController {

    // Game Options
    @FXML
    private ComboBox numberOfPlayers;
    private ObservableList<String> numberOfPlayersList = FXCollections.observableArrayList("1", "2", "3", "4", "6");

    @FXML
    private ComboBox typeOfBoard;
    private ObservableList<String> typeOfBoardList = FXCollections.observableArrayList("6-Shaped Start");

    @FXML
    private ComboBox ruleSet;
    private ObservableList<String> ruleSetList = FXCollections.observableArrayList("Blocked Switch", "Blocked Loses");


    // CPU Options
    @FXML
    private ComboBox numberOfCPU;
    private ObservableList<String> numberOfCPUList = FXCollections.observableArrayList("0", "1", "2", "3", "5");


    // Connection
    @FXML
    private TextField givenIP;
    @FXML
    private TextField givenPort;


    // Graphic
    @FXML
    private Slider sliderSizeOfBoard;


    // Initialize
    @FXML
    private void initialize(){
        numberOfPlayers.setValue("1");
        numberOfPlayers.setItems(numberOfPlayersList);

        typeOfBoard.setValue("6-Shaped Star");
        typeOfBoard.setItems(typeOfBoardList);

        ruleSet.setValue("Blocked Switch");
        ruleSet.setItems(ruleSetList);

        numberOfCPU.setValue("0");
        numberOfCPU.setItems(numberOfCPUList);
    }


    // Confirmation Button
    public final void confirmOptions (ActionEvent actionEvent) throws IOException {

        String NumberOfPlayersString = numberOfPlayers.getValue().toString();
        int NumberOfPlayers = Integer.parseInt(NumberOfPlayersString);

        String TypeOfBoard = typeOfBoard.getValue().toString();
        String RuleSet = ruleSet.getValue().toString();

        String NumberOfCPUString = numberOfCPU.getValue().toString();
        int NumberOfCPU = Integer.parseInt(NumberOfCPUString);

        int TotalPlayers = NumberOfPlayers + NumberOfCPU;


        if(TotalPlayers <= 4 || TotalPlayers == 6){

            // Game Options
            System.out.println("Total Players: " + TotalPlayers );
            System.out.println("Real/CPU: [" + numberOfPlayers.getValue() + "/" + numberOfCPU.getValue() + "]");
            System.out.println("Type of Board: " + typeOfBoard.getValue());
            System.out.println("Ruleset: " + ruleSet.getValue());

            // Connection
            System.out.println("IP/port: " + givenIP.getText() + ":" + givenPort.getText());

            // Graphic Size Change
            // my god why this slider do not give a damn?
            //System.out.println("Size of Board: " + sliderSizeOfBoard.getValue());


            //TODO: Return of the selected options
            //also: a checks for selected CPU/Players amount

            main.showMainMenu();
        }
    }


    // Stuff to accept / cancel the options
    private Main main;

    @FXML
    private void goMainMenu() throws IOException {
        main.showMainMenu();
    }
}
