package sk.stuba.fei.uim.oop.unload;

import sk.stuba.fei.uim.oop.player.Player;

public class UnloadingDuck extends UnloadingCard{
    private final Player Owner;

//----------------------------------------------------------------------------------------------------------------------

    public UnloadingDuck(Player owner) {
        this.Owner = owner;
    }
//----------------------------------------------------------------------------------------------------------------------


    public Player getOwner() {
        return Owner;
    }
}