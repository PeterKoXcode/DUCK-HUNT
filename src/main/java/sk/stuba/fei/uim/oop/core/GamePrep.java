package sk.stuba.fei.uim.oop.core;

import sk.stuba.fei.uim.oop.packages.CardsPackage;
import sk.stuba.fei.uim.oop.packages.Players;
import sk.stuba.fei.uim.oop.packages.UnloadingPackage;

public class GamePrep {

    public GamePrep() {
        var cardsPackage = new CardsPackage();
        var players = new Players(cardsPackage);
        var unloadingPackage = new UnloadingPackage(players.getPlayersField());
        var gamingBoard = new GamingBoard(cardsPackage,unloadingPackage);

        new Game(players,gamingBoard);
    }
}