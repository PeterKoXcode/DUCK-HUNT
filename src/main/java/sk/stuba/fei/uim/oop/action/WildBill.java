package sk.stuba.fei.uim.oop.action;

import sk.stuba.fei.uim.oop.core.GamingBoard;

public class WildBill extends Shoot{
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void cardPurpose(GamingBoard gamingBoard) {
        super.cardPurpose(gamingBoard);
    }

    @Override
    public String cardName() {
        return "WildBill card";
    }

    @Override
    public boolean canPlay(GamingBoard gamingBoard) {
        return true;
    }

    public WildBill() {

    }
//----------------------------------------------------------------------------------------------------------------------

    @Override
    protected int chooseAimedField(GamingBoard gamingBoard){
        int aimedFieldNum = super.chooseField("Which field do you want to shot");
        System.out.println("You have chose " + aimedFieldNum + ". field.");
        return aimedFieldNum - 1;
    }

}