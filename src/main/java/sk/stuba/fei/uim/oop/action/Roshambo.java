package sk.stuba.fei.uim.oop.action;

import sk.stuba.fei.uim.oop.core.GamingBoard;
import sk.stuba.fei.uim.oop.unload.UnloadingCard;

import java.util.ArrayList;
import java.util.Collections;

public class Roshambo extends ActionCard{
    ArrayList<UnloadingCard> mixer = new ArrayList<>();

//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void cardPurpose(GamingBoard gamingBoard) {

        for(int num = 0 ; num < 6 ; num++){
            mixer.add(gamingBoard.getGamingBoard().get(num).getUnloadingCard());
        }
        Collections.shuffle(mixer);
        for(int num = 0 ; num < 6 ; num++){
            UnloadingCard unloadingCard = mixer.get(0);
            gamingBoard.getGamingBoard().get(num).setUnloadingCard(unloadingCard);
            mixer.remove(0);
        }

    }

    @Override
    public String cardName() {
        return "Roshambo card";
    }

    @Override
    public boolean canPlay(GamingBoard gamingBoard) {
        return true;
    }

    public Roshambo() {

    }
//----------------------------------------------------------------------------------------------------------------------
}