package trylma;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private ObservableList<String> typeOfBoardList = FXCollections.observableArrayList("Regular");

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


    // Initialize
    @FXML
    private void initialize(){
        numberOfPlayers.setValue("1");
        numberOfPlayers.setItems(numberOfPlayersList);

        typeOfBoard.setValue("Regular");
        typeOfBoard.setItems(typeOfBoardList);

        ruleSet.setValue("1");
        ruleSet.setItems(ruleSetList);

        numberOfCPU.setValue("0");
        numberOfCPU.setItems(numberOfCPUList);
    }


    // Stuff to accept / cancel the options
    private Main main;

    @FXML
    private void goMainMenu() throws IOException {
        main.showMainMenu();
    }

    public final void confirmOptions (ActionEvent actionEvent) {
        //TODO: Reading the selected options
        //also: a checks for selected CPU/Players amount
    }


}
