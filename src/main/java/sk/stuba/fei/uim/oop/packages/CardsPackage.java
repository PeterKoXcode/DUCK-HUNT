package sk.stuba.fei.uim.oop.packages;

import sk.stuba.fei.uim.oop.action.*;

import java.util.ArrayList;
import java.util.Collections;

public class CardsPackage {

    private final ArrayList<ActionCard> cardsPackage;

    public CardsPackage() {
        this.cardsPackage = new ArrayList<>();
        for(int num = 0 ; num < 10 ; num++){
            this.cardsPackage.add(new Aim());
        }
        for(int num = 0 ; num < 12 ; num++){
            this.cardsPackage.add(new Shoot());
        }
        for(int num = 0 ; num < 6 ; num++){
            this.cardsPackage.add(new DuckMarch());
        }
        this.cardsPackage.add(new WildBill());
        this.cardsPackage.add(new WildBill());
        this.cardsPackage.add(new TurboDuck());
        this.cardsPackage.add(new Roshambo());
        this.cardsPackage.add(new Roshambo());
        this.cardsPackage.add(new DuckDance());

        Collections.shuffle(this.cardsPackage);

    }

    public ArrayList<ActionCard> getCardsPackage() {
        return cardsPackage;
    }

}