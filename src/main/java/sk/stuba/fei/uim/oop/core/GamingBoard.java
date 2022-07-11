package sk.stuba.fei.uim.oop.core;

import sk.stuba.fei.uim.oop.packages.CardsPackage;
import sk.stuba.fei.uim.oop.packages.UnloadingPackage;
import sk.stuba.fei.uim.oop.unload.UnloadingCard;

import java.util.ArrayList;

public class GamingBoard {
    private ArrayList<GamingField> gamingBoard;
    private final UnloadingPackage unloadingPackage;
    private final CardsPackage cardsPackage;


    //----------------------------------------------------------------------------------------------------------------------
    public GamingBoard(CardsPackage cardsPackage,UnloadingPackage unloadingPackage) {
        this.cardsPackage = cardsPackage;
        this.unloadingPackage = unloadingPackage;

        this.gamingBoard = new ArrayList<>();
        for(int num = 0; num < 6; num++){
            this.gamingBoard.add(new GamingField());
        }

        this.prepareTable(unloadingPackage);
    }


//----------------------------------------------------------------------------------------------------------------------

    public void prepareTable(UnloadingPackage unloadingPackage){
        for(int num = 0 ; num < 6 ; num++){
            UnloadingCard unloadingCard = unloadingPackage.getUnloadingPackage().get(0);
            this.gamingBoard.get(num).setUnloadingCard(unloadingCard);
            unloadingPackage.getUnloadingPackage().remove(0);
        }
    }

//----------------------------------------------------------------------------------------------------------------------


    public ArrayList<GamingField> getGamingBoard() {
        return gamingBoard;
    }

    public void setGamingBoard(ArrayList<GamingField> gamingBoard) {
        this.gamingBoard = gamingBoard;
    }

    public UnloadingPackage getUnloadingPackage() {
        return unloadingPackage;
    }

    public CardsPackage getCardsPackage() {
        return cardsPackage;
    }
}