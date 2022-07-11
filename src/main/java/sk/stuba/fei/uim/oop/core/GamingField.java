package sk.stuba.fei.uim.oop.core;

import sk.stuba.fei.uim.oop.unload.UnloadingCard;

public class GamingField {
    private boolean aimed;
    private UnloadingCard unloadingCard;

//----------------------------------------------------------------------------------------------------------------------

    public GamingField() {
        this.aimed = false;
    }

//----------------------------------------------------------------------------------------------------------------------


    public boolean isAimed() {
        return aimed;
    }

    public void setAimed(boolean aimed) {
        this.aimed = aimed;
    }

    public UnloadingCard getUnloadingCard() {
        return unloadingCard;
    }

    public void setUnloadingCard(UnloadingCard unloadingCard) {
        this.unloadingCard = unloadingCard;
    }
}