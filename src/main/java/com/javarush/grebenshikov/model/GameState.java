package com.javarush.grebenshikov.model;



public class GameState {
    private String playerName;
    private int gamesPlayed;
    private String currentScene;
    private boolean isMad;


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(String currentScene) {
        this.currentScene = currentScene;
    }

    public boolean isMad() {
        return isMad;
    }

    public void setMad(boolean isMad) {
        this.isMad = isMad;
    }
}
