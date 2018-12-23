package trylma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.scene.paint.Color;

import static trylma.Board.board;

public class Client {

        private static final int port = 9001;
        private Socket socket;
        private BufferedReader in;
        public static PrintWriter out;
        Color myColor;
        public static int Number_of_players = 0;
        public static boolean myTurn=false;
        public static boolean inMulitipalyerMode=false;
        int PlayerNumber;


    Client(String serverAddress) throws Exception {
            // Setup networking
            socket = new Socket(serverAddress, port);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        }
        public static  int getTotalPlayers(){
            return Number_of_players;
        }

        public void play() throws Exception {
            String response;
            inMulitipalyerMode=true;
            try {

                while (true) {
                    response = in.readLine();
                    System.out.println("response from server: " + response);
                    if (response.startsWith("QUIT")) {
                        return;
                    }
                    if (response.startsWith("COLOR")) {
                        String[] responseParts=response.split(" ");
                        this.myColor= Color.valueOf(responseParts[1]);
                    }
                    if (response.startsWith("NUMBER_OF_PLAYERS")) {
                        String[] responseParts=response.split(" ");
                        Number_of_players= Integer.parseInt(responseParts[1]);
                    }
                    if (response.startsWith("MOVE")) {
                        String[] responseParts=response.split(" ");
                        if(!myTurn)
                        Board.ServerForceMove(Integer.parseInt(responseParts[1]),Integer.parseInt(responseParts[2]),Integer.parseInt(responseParts[3]),Integer.parseInt(responseParts[4]));
                    }
                    if (response.startsWith("PLAYER_NUMBER")) {
                        String[] responseParts=response.split(" ");
                        PlayerNumber=Integer.parseInt(responseParts[1]);
                    }

                    if (response.startsWith("TURN")) {
                        String[] responseParts=response.split(" ");
                        if(Integer.parseInt(responseParts[1])==PlayerNumber)
                        myTurn=true;
                        else myTurn=false;
                    }

                }

            } finally {
                socket.close();
            }
        }
    }

