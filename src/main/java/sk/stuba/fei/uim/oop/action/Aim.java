package sk.stuba.fei.uim.oop.action;

import sk.stuba.fei.uim.oop.core.GamingBoard;
import sk.stuba.fei.uim.oop.core.GamingField;
import sk.stuba.fei.uim.oop.unload.UnloadingDuck;

public class Aim extends ActionCard{

//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void cardPurpose(GamingBoard gamingBoard) {
        int aimedFieldNum = this.chooseAimField(gamingBoard);
        GamingField aimedField = gamingBoard.getGamingBoard().get(aimedFieldNum);
        if(aimedField.getUnloadingCard() instanceof UnloadingDuck){
            UnloadingDuck fieldDuck = (UnloadingDuck) aimedField.getUnloadingCard();
            System.out.println("There's " + fieldDuck.getOwner().getName() + "'s duck on it.");
        } else {
            System.out.println("There's just a water itself.");
        }
        aimedField.setAimed(true);
    }

    @Override
    public String cardName() {
        return "Aim card";
    }

    @Override
    public boolean canPlay(GamingBoard gamingBoard) {
        for(GamingField gamingField : gamingBoard.getGamingBoard()){
            if(!gamingField.isAimed()){
                return true;
            }
        }
        return false;
    }

    public Aim() {

    }

//**********************************************************************************************************************

    private int chooseAimField(GamingBoard gamingBoard){
        int aimedFieldNum = super.chooseField("Which field do you want to aim");
        if(gamingBoard.getGamingBoard().get(aimedFieldNum-1).isAimed()) {
            System.out.println("Sorry, field which you chose is already aimed, Please type again.");
            return this.chooseAimField(gamingBoard);
        }
        System.out.println("You have chose " + aimedFieldNum + ". field.");
        return aimedFieldNum - 1;
    }

    //----------------------------------------------------------------------------------------------------------------------

}