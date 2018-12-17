package trylma;

import java.io.FileOutputStream;
import java.util.prefs.Preferences;


public class OptionsComputing {

    private int TotalPlayers;
    private int NumberOfPlayers;
    private int NumberOfCPU;
    private String TypeOfBoard;
    private String RuleSet;
    private String IPPort;

    private Preferences chinesePrefs;

    // Saves settings to a file
    public void setPreference(String type, String value) {

        chinesePrefs = Preferences.userRoot().node(this.getClass().getName());
        chinesePrefs.put(type, value);

        try {
            chinesePrefs.exportNode(new FileOutputStream("checkersPrefs.xml"));
            System.out.println("[Options] Saved '" + type + "' with value '" + chinesePrefs.get(type, value) + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters & Setters
    public int getTotalPlayers() {
        return TotalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        TotalPlayers = totalPlayers;
        String TotalPlayersString = Integer.toString(TotalPlayers);
        setPreference("totalPlayers", TotalPlayersString);
    }

    public int getNumberOfPlayers() {
        return NumberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        NumberOfPlayers = numberOfPlayers;
        String NumberOfPlayersString = Integer.toString(NumberOfPlayers);
        setPreference("numberOfPlayers", NumberOfPlayersString);
    }

    public int getNumberOfCPU() {
        return NumberOfCPU;
    }

    public void setNumberOfCPU(int numberOfCPU) {
        NumberOfCPU = numberOfCPU;
        String NumberOfCPUString = Integer.toString(NumberOfCPU);
        setPreference("numberOfCPU", NumberOfCPUString);
    }

    public String getTypeOfBoard() {
        return TypeOfBoard;
    }

    public void setTypeOfBoard(String typeOfBoard) {
        TypeOfBoard = typeOfBoard;
        setPreference("typeOfBoard", TypeOfBoard);
    }

    public String getRuleSet() {
        return RuleSet;
    }

    public void setRuleSet(String ruleSet) {
        RuleSet = ruleSet;
        setPreference("ruleSet", RuleSet);
    }

    public String getIPPort() {
        return IPPort;
    }

    public void setIPPort(String IPPort) {
        this.IPPort = IPPort;
        setPreference("ipPort", IPPort);
    }


}
