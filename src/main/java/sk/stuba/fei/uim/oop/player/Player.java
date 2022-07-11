package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.action.ActionCard;
import sk.stuba.fei.uim.oop.core.GamingBoard;
import sk.stuba.fei.uim.oop.core.GamingField;
import sk.stuba.fei.uim.oop.packages.CardsPackage;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class Player {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private final String name;
    private int lives;
    private ArrayList<ActionCard> myActionCards;
    private int chosenActionCardPosition;
//----------------------------------------------------------------------------------------------------------------------

    public Player(String name,CardsPackage cardsPackage) {
        this.name = name;
        this.lives = 5;

        this.myActionCards = new ArrayList<>();
        for(int num = 0 ; num < 3 ; num++){
            this.myActionCards.add(cardsPackage.getCardsPackage().remove(0));
        }
    }

    //----------------------------------------------------------------------------------------------------------------------

    public void useOneCard(GamingBoard gamingBoard) {
        if(this.canPlayWithThreeShootOrAimCards(gamingBoard)) {
            ArrayList<ActionCard> playAbleCards;
            playAbleCards = this.setUpPlayAbleCards(gamingBoard);
            this.printPlayableCards(playAbleCards);
            this.chosenActionCardPosition = this.chooseCard(playAbleCards.size(),playAbleCards);
            playAbleCards.get(this.chosenActionCardPosition).cardPurpose(gamingBoard);
            if(this.lives > 0){
                this.throwPlayAbleCard(playAbleCards,gamingBoard);
            }
        } else {
            this.chosenActionCardPosition = this.chooseCard(3,this.myActionCards);
            this.throwCard(gamingBoard);
        }
    }

    private boolean canPlayWithThreeShootOrAimCards(GamingBoard gamingBoard){
        if(this.specialConditions(gamingBoard,this.myActionCards,"Aim card")){
            System.out.println(ANSI_RED+"Unfortunately, you have three Aim cards and there's sight on each field."+ANSI_RESET);
            return false;
        }
        if(this.specialConditions(gamingBoard,this.myActionCards,"Shoot card")){
            System.out.println(ANSI_RED+"Unfortunately, you have three Shoot cards , but there's no sight."+ANSI_RESET);
            return false;
        }
        return true;
    }

    private boolean specialConditions(GamingBoard gamingBoard, ArrayList<ActionCard> myActionCards,String s){
        for (ActionCard actionCard : myActionCards){
            if(!(actionCard.cardName().equals(s))){
                return false;
            }
        }

        for(GamingField gamingField : gamingBoard.getGamingBoard()){
            if(s.equals("Aim card") && !gamingField.isAimed()){
                return false;
            }
            if (s.equals("Shoot card") && gamingField.isAimed()) {
                return false;
            }

        }

        return true;
    }

    private void throwPlayAbleCard(ArrayList<ActionCard> playAbleCards,GamingBoard gamingBoard){
        for(ActionCard actionCard : this.myActionCards){
            if(actionCard.equals(playAbleCards.get(this.chosenActionCardPosition))){
                gamingBoard.getCardsPackage().getCardsPackage().add(actionCard);
                this.myActionCards.remove(actionCard);
                break;
            }
        }
    }

    private void printPlayableCards(ArrayList<ActionCard> playableCards){
        System.out.println("You can play :");
        for(int num = 0 ; num < playableCards.size() ; num++){
            System.out.println((num+1)+". "+playableCards.get(num).cardName());
        }
    }

    private ArrayList<ActionCard> setUpPlayAbleCards(GamingBoard gamingBoard) {
        ArrayList<ActionCard> playAbleCards = new ArrayList<>();
        for (ActionCard actionCard : this.getMyActionCards()){
            if(actionCard.canPlay(gamingBoard)){
                playAbleCards.add(actionCard);
            }
        }
        return playAbleCards;
    }

    private int chooseCard(int range, ArrayList<ActionCard> playableCards){
        int number = KeyboardInput.readInt("Which one do you want to use ");
        if(number < 1 || number > range){
            System.out.println("Wrong number of your action card has been typed , please type the number again.");
            return this.chooseCard(range,playableCards);
        } else {
            number--;
            System.out.println("You chose " + playableCards.get(number).cardName() + ".");
            return number;
        }
    }

    private void throwCard(GamingBoard gamingBoard){
        gamingBoard.getCardsPackage().getCardsPackage().add(this.myActionCards.remove(this.chosenActionCardPosition));
    }
    public void pullCard(GamingBoard gamingBoard){
        this.myActionCards.add(gamingBoard.getCardsPackage().getCardsPackage().remove(0));
    }

//----------------------------------------------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public ArrayList<ActionCard> getMyActionCards() {
        return myActionCards;
    }

    public void setMyActionCards(ArrayList<ActionCard> myActionCards) {
        this.myActionCards = myActionCards;
    }

}