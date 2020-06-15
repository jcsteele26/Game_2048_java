package com.codegym.games.game2048;

import com.codegym.engine.cell.*;
import java.util.*;
public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    
    private void createGame(){
        createNewNumber();
        createNewNumber();
    }
    
    private void drawScene(){
        for(int row = 0; row < 4; row++){
            for(int col = 0; col < 4; col++){
                setCellColoredNumber(row, col, gameField[col][row]);
            }
        }
    }
    
    
    private void createNewNumber(){
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);

        while(gameField[x][y] != 0){
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }
        
        if (getRandomNumber(10) == 9){
            gameField[x][y] = 4;
        } else {
            gameField[x][y] = 2;
        }
        
    }
    
    private Color getColorByValue(int value){
        if (value == 0){
            return Color.WHITE;
        } else if (value == 2){
            return Color.ALICEBLUE;
        } else if (value == 4){
            return Color.ANTIQUEWHITE;
        } else if (value == 8){
            return Color.AQUA;
        } else if (value == 16){
            return Color.GREEN;
        } else if (value == 32){
            return Color.YELLOW;
        } else if (value == 64){
            return Color.BEIGE;
        } else if (value == 128){
            return Color.RED;
        } else if (value == 256){
            return Color.GRAY;
        } else if (value == 512){
            return Color.CYAN;
        } else if (value == 1024){
            return Color.BLUE;
        } else if (value == 2048) {
            return Color.FORESTGREEN;
        } else return Color.WHITE;
    }
    
    private void setCellColoredNumber(int x, int y, int value){
        if(value != 0) {
            setCellValueEx(x, y, getColorByValue(value), Integer.toString(value));
        } else {
            setCellValueEx(x, y, getColorByValue(value), "");
        }
    }
    
    @Override
    public void initialize(){
       setScreenSize(SIDE, SIDE);
       createGame();
       drawScene();
    
    }

}
