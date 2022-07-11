package sk.stuba.fei.uim.oop.action;

import sk.stuba.fei.uim.oop.core.GamingBoard;
import sk.stuba.fei.uim.oop.core.GamingField;
import sk.stuba.fei.uim.oop.unload.UnloadingCard;
import sk.stuba.fei.uim.oop.unload.UnloadingDuck;

import java.util.ArrayList;

public class Shoot extends ActionCard{

//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void cardPurpose(GamingBoard gamingBoard) {
        int aimedFieldNum = this.chooseAimedField(gamingBoard);
        GamingField aimedField = gamingBoard.getGamingBoard().get(aimedFieldNum);
        if(aimedField.getUnloadingCard() instanceof UnloadingDuck){
            UnloadingDuck fieldDuck = (UnloadingDuck) aimedField.getUnloadingCard();
            System.out.println("There's " + fieldDuck.getOwner().getName() + "'s duck on it.");
            fieldDuck.getOwner().setLives(fieldDuck.getOwner().getLives()-1);
            if(fieldDuck.getOwner().getLives() < 1){
                System.out.println(ANSI_RED+fieldDuck.getOwner().getName()+" has no lives and is out of the game."+ANSI_RESET);
                gamingBoard.getCardsPackage().getCardsPackage().addAll(fieldDuck.getOwner().getMyActionCards());
                fieldDuck.getOwner().setMyActionCards(null);
            }
            aimedField.setUnloadingCard(null);
            aimedField.setAimed(false);
            this.fillUpTheGamingBoard(aimedFieldNum,gamingBoard);
        } else {
            System.out.println("Poor water was shot.");
            aimedField.setAimed(false);
        }
    }

    @Override
    public String cardName() {
        return "Shoot card";
    }

    @Override
    public boolean canPlay(GamingBoard gamingBoard) {
        for(GamingField gamingField : gamingBoard.getGamingBoard()){
            if(gamingField.isAimed()){
                return true;
            }
        }
        return false;
    }

    public Shoot() {

    }
//----------------------------------------------------------------------------------------------------------------------

    protected int chooseAimedField(GamingBoard gamingBoard){
        int aimedFieldNum = super.chooseField("Which field do you want to shot");
        if(!gamingBoard.getGamingBoard().get(aimedFieldNum-1).isAimed()){
            System.out.println("Sorry, field which you chose is not aimed yet, Please type again.");
            return this.chooseAimedField(gamingBoard);
        }
        System.out.println("You have chose " + aimedFieldNum + ". field.");
        return aimedFieldNum - 1;
    }


    protected void fillUpTheGamingBoard(int aimedFieldNum, GamingBoard gamingBoard){
        UnloadingCard movingCard;
        ArrayList<UnloadingCard> unloadingCards = gamingBoard.getUnloadingPackage().getUnloadingPackage();
        for(int num = aimedFieldNum+1 ; num < 6 ; num++){
            movingCard = gamingBoard.getGamingBoard().get(num).getUnloadingCard();
            gamingBoard.getGamingBoard().get(num-1).setUnloadingCard(movingCard);
        }
        movingCard = unloadingCards.get(0);
        gamingBoard.getGamingBoard().get(5).setUnloadingCard(movingCard);
        unloadingCards.remove(0);
    }

//----------------------------------------------------------------------------------------------------------------------

}