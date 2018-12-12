package trylma;

import javafx.event.ActionEvent;

import javax.swing.*;
import java.util.prefs.*;

public class OptionsComputing {

    private int TotalPlayers;
    private int NumberOfPlayers;
    private int NumberOfCPU;
    private String TypeOfBoard;
    private String RuleSet;
    private String IPPort;

    private static final String NUM_PLAYERS = "num_players";

    void preferencesSave() {
        Preferences prefs = Preferences.userNodeForPackage(this.getClass());

        int numPlayers = prefs.getInt(NUM_PLAYERS, TotalPlayers);
    }

    static String ourNodeName = "/com/trylma";

    static void foo() {
        Preferences prefs = Preferences.userRoot().node(ourNodeName);
    }

    public int getTotalPlayers() {
        return TotalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        TotalPlayers = totalPlayers;
        System.out.println("Total Players set to: " + TotalPlayers);
        preferencesSave();
    }

    public int getNumberOfPlayers() {
        return NumberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        NumberOfPlayers = numberOfPlayers;
        System.out.println("Number Of Players set to: " + NumberOfPlayers);
    }

    public int getNumberOfCPU() {
        return NumberOfCPU;
    }

    public void setNumberOfCPU(int numberOfCPU) {
        NumberOfCPU = numberOfCPU;
        System.out.println("CPU set to: " + NumberOfCPU);
    }

    public String getTypeOfBoard() {
        return TypeOfBoard;
    }

    public void setTypeOfBoard(String typeOfBoard) {
        TypeOfBoard = typeOfBoard;
        System.out.println("Type of Board set to: " + TypeOfBoard);
    }

    public String getRuleSet() {
        return RuleSet;
    }

    public void setRuleSet(String ruleSet) {
        RuleSet = ruleSet;
        System.out.println("Ruleset set to: " + RuleSet);
    }

    public String getIPPort() {
        return IPPort;
    }

    public void setIPPort(String IPPort) {
        this.IPPort = IPPort;
        System.out.println("IP and Port set to: " + IPPort);
    }


}
