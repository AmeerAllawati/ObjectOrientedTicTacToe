package org.ObjectOrientedTicTacToe;

import java.io.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;

public class FileManager {
    private String boardFilePath = "boardState.json";
    private String player1FilePath = "player1.json";
    private String player2FilePath = "player2.json";

    public boolean gameExists(){
        File gameState = new File(boardFilePath);

        if (gameState.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void saveGameState(Board mainBoard, Player player1, Player player2) {
        Gson gson = new Gson();
        String boardOutput = gson.toJson(mainBoard);
        String player1Output = gson.toJson(player1);
        String player2Output = gson.toJson(player2);

        System.out.println(boardOutput);

        try(FileWriter writer = new FileWriter(boardFilePath)) {
            writer.write(boardOutput);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter(player1FilePath)) {
            writer.write(player1Output);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter(player2FilePath)) {
            writer.write(player2Output);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadGameState(Board mainBoard, Player player1, Player player2) {
        Gson gson = new Gson();
        try(BufferedReader reader = new BufferedReader(new FileReader(boardFilePath))) {
            Board loadedBoard = gson.fromJson(reader, new TypeToken<Board>(){}.getType());
            mainBoard.copyABoard(loadedBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(player1FilePath))) {
            Player loadedPlayer = gson.fromJson(reader, new TypeToken<Player>(){}.getType());
            player1.copyAPlayer(loadedPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(player2FilePath))) {
            Player loadedPlayer = gson.fromJson(reader, new TypeToken<Player>(){}.getType());
            player2.copyAPlayer(loadedPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
