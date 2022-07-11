package sk.stuba.fei.uim.oop.action;

import sk.stuba.fei.uim.oop.core.GamingBoard;
import sk.stuba.fei.uim.oop.unload.UnloadingCard;
import sk.stuba.fei.uim.oop.unload.UnloadingDuck;

public class TurboDuck extends ActionCard{

//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void cardPurpose(GamingBoard gamingBoard) {
        int aimedFieldNum = this.chooseRandomDuckField(gamingBoard);

        UnloadingCard turboDuck = gamingBoard.getGamingBoard().get(aimedFieldNum).getUnloadingCard();
        for(int num = aimedFieldNum - 1 ; num >= 0 ; num--){
            UnloadingCard movingDuck = gamingBoard.getGamingBoard().get(num).getUnloadingCard();
            gamingBoard.getGamingBoard().get(num+1).setUnloadingCard(movingDuck);
        }

        gamingBoard.getGamingBoard().get(0).setUnloadingCard(turboDuck);

    }

    @Override
    public String cardName() {
        return "TurboDuck card";
    }

    @Override
    public boolean canPlay(GamingBoard gamingBoard) {
        return true;
    }

    public TurboDuck() {

    }
//----------------------------------------------------------------------------------------------------------------------

    private int chooseRandomDuckField(GamingBoard gamingBoard){
        int aimedFieldNum = super.chooseField("Which duck do you want to move");
        if(!(gamingBoard.getGamingBoard().get(aimedFieldNum-1).getUnloadingCard() instanceof UnloadingDuck)){
            System.out.println("Sorry, there's no duck in the chosen field, Please type again.");
            return this.chooseRandomDuckField(gamingBoard);
        }
        System.out.println("You have chose " + aimedFieldNum + ". field.");
        return aimedFieldNum - 1;
    }
}