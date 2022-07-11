package sk.stuba.fei.uim.oop.action;

import sk.stuba.fei.uim.oop.core.GamingBoard;
import sk.stuba.fei.uim.oop.unload.UnloadingCard;

import java.util.ArrayList;

public class DuckMarch extends ActionCard{

//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void cardPurpose(GamingBoard gamingBoard) {

        UnloadingCard movingCard = gamingBoard.getGamingBoard().get(0).getUnloadingCard();
        ArrayList<UnloadingCard> unloadingCards = gamingBoard.getUnloadingPackage().getUnloadingPackage();
        unloadingCards.add(movingCard);

        for(int num = 1 ; num < 6 ; num++){
            movingCard = gamingBoard.getGamingBoard().get(num).getUnloadingCard();
            gamingBoard.getGamingBoard().get(num-1).setUnloadingCard(movingCard);
        }

        movingCard = unloadingCards.get(0);
        gamingBoard.getGamingBoard().get(5).setUnloadingCard(movingCard);
        unloadingCards.remove(0);

    }

    @Override
    public String cardName() {
        return "DuckMarch card";
    }

    @Override
    public boolean canPlay(GamingBoard gamingBoard) {
        return true;
    }

    public DuckMarch() {

    }

}