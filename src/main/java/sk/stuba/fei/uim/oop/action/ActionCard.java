package sk.stuba.fei.uim.oop.action;

import sk.stuba.fei.uim.oop.core.GamingBoard;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public abstract class ActionCard {



    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    //----------------------------------------------------------------------------------------------------------------------
    public abstract void cardPurpose(GamingBoard gamingBoard);
    public abstract String cardName();
    public abstract boolean canPlay(GamingBoard gamingBoard);

    protected int chooseField(String s){
        int aimedFieldNum = KeyboardInput.readInt(s);
        if(aimedFieldNum < 1 || aimedFieldNum > 6){
            System.out.println("Wrong number of playing field has been typed , please type the number again.");
            return this.chooseField(s);
        }
        return aimedFieldNum;
    }

}