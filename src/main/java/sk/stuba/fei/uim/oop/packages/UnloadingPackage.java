package sk.stuba.fei.uim.oop.packages;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.unload.UnloadingCard;
import sk.stuba.fei.uim.oop.unload.UnloadingDuck;
import sk.stuba.fei.uim.oop.unload.UnloadingWater;

import java.util.ArrayList;
import java.util.Collections;

public class UnloadingPackage {

    private final ArrayList<UnloadingCard> unloadingPackage;


    public UnloadingPackage(ArrayList<Player> playersField) {
        this.unloadingPackage = new ArrayList<>();
        for(int position = 0 ; position < playersField.size() ; position++){
            this.unloadDucks(position, playersField);
        }
        this.unloadWater();
        Collections.shuffle(this.unloadingPackage);
    }


//----------------------------------------------------------------------------------------------------------------------

    private void unloadDucks(int position, ArrayList<Player> playersField){
        for(int num = 0 ; num < 5 ; num++){
            this.unloadingPackage.add(new UnloadingDuck(playersField.get(position)));
        }
    }
    private void unloadWater(){
        for(int num = 0 ; num < 5 ; num++){
            this.unloadingPackage.add(new UnloadingWater());
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    public ArrayList<UnloadingCard> getUnloadingPackage() {
        return unloadingPackage;
    }

}