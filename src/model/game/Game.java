package model.game;

import model.FormContainer;

public class Game {
    
    private final int NB_MAX = 4;
    private FormContainer formContainer;
    private IPlayer player;

    public Game(FormContainer formContainer,IPlayer player) {
        this.formContainer = formContainer;
        this.player = player;
    }
    public boolean gameOver(){
        return false;
    }
    /*
     * somme des surfaces des 4 formes divisée par la surface du panel
     */
    public double getScore(){
        return 0;
    }

    public void play(){

    }
}
