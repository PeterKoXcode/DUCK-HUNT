package sk.stuba.fei.uim.oop.packages;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class Players {

    private int playersNum;
    private ArrayList<Player> playersField;

    //----------------------------------------------------------------------------------------------------------------------
    public Players(CardsPackage cardsPackage) {
        this.setPlayers(cardsPackage);
    }

    //----------------------------------------------------------------------------------------------------------------------
    private void setPlayers(CardsPackage cardsPackage){
        loadingPlayers();
        this.playersField = new ArrayList<>();
        for(int i = 0; i < this.playersNum; i++){
            String name = KeyboardInput.readString("Type a name of " + (i+1) + " player");
            this.playersField.add(new Player(name,cardsPackage));
        }
    }

    private void loadingPlayers(){

        this.playersNum = KeyboardInput.readInt("Please, type a number of players (2-6)");
        if(2 > this.playersNum || 6 < this.playersNum){
            System.out.println("Wrong number of players has been typed , please type the number from interval 2-6.");
            loadingPlayers();
        } else {
            System.out.println("You have typed the number of players " + this.playersNum);
        }
    }
    //----------------------------------------------------------------------------------------------------------------------

    public ArrayList<Player> getPlayersField() {
        return this.playersField;
    }



}