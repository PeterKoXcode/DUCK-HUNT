package sk.stuba.fei.uim.oop.action;

import sk.stuba.fei.uim.oop.core.GamingBoard;
import java.util.Collections;

public class DuckDance extends ActionCard{

//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void cardPurpose(GamingBoard gamingBoard) {
        for(int num = 0 ; num < 6 ; num++){
            gamingBoard.getUnloadingPackage().getUnloadingPackage().add(gamingBoard.getGamingBoard().get(num).getUnloadingCard());
        }
        Collections.shuffle(gamingBoard.getUnloadingPackage().getUnloadingPackage());
        gamingBoard.prepareTable(gamingBoard.getUnloadingPackage());
    }

    @Override
    public String cardName() {
        return "DuckDance card";
    }

    @Override
    public boolean canPlay(GamingBoard gamingBoard) {
        return true;
    }

    public DuckDance() {

    }

//----------------------------------------------------------------------------------------------------------------------
}