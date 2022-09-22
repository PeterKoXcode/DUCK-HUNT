package sk.stuba.fei.uim.oop.core;

import sk.stuba.fei.uim.oop.packages.Players;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.unload.UnloadingDuck;

import java.util.Iterator;

public class Game{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

//----------------------------------------------------------------------------------------------------------------------

    public Game(Players players,GamingBoard gamingBoard) {

        int currentPlayerNum = 1;

        while (this.moreThanOnePlayer(players)){
            if(currentPlayerNum == players.getPlayersField().size()+1){
                currentPlayerNum = 1;
            }
            Player currentPlayer = players.getPlayersField().get(currentPlayerNum-1);
            if(currentPlayer.getLives() > 0) {
                System.out.println("▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂");
                this.gamingBoardListing(gamingBoard);
                System.out.println("     " + ANSI_GREEN + currentPlayer.getName() + "'s turn.     \n" + ANSI_RESET);
                this.printPlayerCards(currentPlayer);

                currentPlayer.useOneCard(gamingBoard);

                if(currentPlayer.getLives() > 0){
                    currentPlayer.pullCard(gamingBoard);
                }
            }
            currentPlayerNum++;
        }
        this.printWinner(players);
    }

//----------------------------------------------------------------------------------------------------------------------

    private void printPlayerCards(Player currentPlayer){
        System.out.println("Your action cards: ");
        System.out.print("| "+currentPlayer.getMyActionCards().get(0).cardName()+" | ");
        System.out.print(" | "+currentPlayer.getMyActionCards().get(1).cardName()+" | ");
        System.out.print(" | "+currentPlayer.getMyActionCards().get(2).cardName()+" |");
        System.out.println();
    }

    private boolean moreThanOnePlayer(Players players){
        Iterator<Player> playerIterator = players.getPlayersField().iterator();
        int alivePlayerNum = 0;

        while(playerIterator.hasNext()){
            Player player = playerIterator.next();
            if(player.getLives() > 0){
                alivePlayerNum++;
            }
        }

        return alivePlayerNum > 1; // min 2 players
    }

    private void gamingBoardListing(GamingBoard gamingBoard){
        System.out.println(ANSI_BLUE+"        POND        \n"+ANSI_RESET);
        for(int num = 0 ; num < 6 ; num++){
            System.out.print((num+1)+". \uD83D\uDC1F ");
            if(gamingBoard.getGamingBoard().get(num).isAimed()){
                System.out.print("◉ ");
            } else {
                System.out.print("○ ");
            }
            if(gamingBoard.getGamingBoard().get(num).getUnloadingCard() instanceof UnloadingDuck){
                UnloadingDuck fieldDuck = (UnloadingDuck) gamingBoard.getGamingBoard().get(num).getUnloadingCard();
                System.out.println("- "+fieldDuck.getOwner().getName()+"'s duck.");
            } else {
                System.out.println("- The water itself.");
            }
        }
        System.out.println();
    }

    private void printWinner(Players players){

        for (Player player : players.getPlayersField()) {
            if (player.getLives() > 0) {
                System.out.println("\n▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂\n");
                System.out.println("WINNER IS 《" + ANSI_YELLOW + player.getName() + ANSI_RESET + "》");
                System.out.println("▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂\n");
                break;
            }
        }
    }

}