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
    private TextField IP;
    @FXML
    private TextField Port;


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
    public final void confirmOptions (ActionEvent actionEvent) {

        String NumberOfPlayersString = numberOfPlayers.getValue().toString();
        int NumberOfPlayers = Integer.parseInt(NumberOfPlayersString);

        String TypeOfBoard = typeOfBoard.getValue().toString();
        String RuleSet = ruleSet.getValue().toString();

        String NumberOfCPUString = numberOfCPU.getValue().toString();
        int NumberOfCPU = Integer.parseInt(NumberOfCPUString);


        if(!((NumberOfPlayers + NumberOfCPU > 6) && (NumberOfPlayers + NumberOfCPU == 5))){

            // Game Options
            System.out.println("Number of Players: " + numberOfPlayers.getValue());
            System.out.println("Type of Board: " + typeOfBoard.getValue());
            System.out.println("Ruleset: " + ruleSet.getValue());

            // CPU
            System.out.println("CPU Players: " + numberOfCPU.getValue());

            // Connection
            //System.out.println("IP/port: " + IP.get() + ":" + Port.getText());

            // Graphic Size Change
            //System.out.println("Size of Board: " + sliderSizeOfBoard.getValue());

            //TODO: Return of the selected options
            //also: a checks for selected CPU/Players amount
        }
    }


    // Stuff to accept / cancel the options
    private Main main;

    @FXML
    private void goMainMenu() throws IOException {
        main.showMainMenu();
    }
}
