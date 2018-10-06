package Model;

// Basic Card class taken from:
// https://docs.oracle.com/javase/tutorial/java/javaOO/examples/Card.java

public final class Card {
	private final int rank;
    private final int suit;

    // Kinds of suits
    public final static int DIAMONDS = 1;
    public final static int CLUBS    = 2;
    public final static int HEARTS   = 3;
    public final static int SPADES   = 4;

    // Kinds of ranks
    public final static int DEUCE = 2;
    public final static int THREE = 3;
    public final static int FOUR  = 4;
    public final static int FIVE  = 5;
    public final static int SIX   = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE  = 9;
    public final static int TEN   = 10;
    public final static int JACK  = 11;
    public final static int QUEEN = 12;
    public final static int KING  = 13;
    public final static int ACE   = 14;

    public Card(int rank, int suit) {
        assert isValidRank(rank);
        assert isValidSuit(suit);
        this.rank = rank;
        this.suit = suit;
    }
    
    public Card(String card) {
    	// SA -> Ace of Spades
    	int suit = stringToSuit(Character.toString(card.charAt(0)));
    	int rank = stringToRank(Character.toString(card.charAt(1)));
    	
    	assert isValidRank(rank);
        assert isValidSuit(suit);
    	
    	this.rank = rank;
    	this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
    
    public String toString() {
    	return String.format("%s%s", Card.rankToString(this.rank), Card.suitToString(this.suit));
    }

    public static boolean isValidRank(int rank) {
        return DEUCE <= rank && rank <= ACE;
    }

    public static boolean isValidSuit(int suit) {
        return DIAMONDS <= suit && suit <= SPADES;
    }

    public static String rankToString(int rank) {
        switch (rank) {
        case ACE:
            return "A";
        case DEUCE:
            return "2";
        case THREE:
            return "3";
        case FOUR:
            return "4";
        case FIVE:
            return "5";
        case SIX:
            return "6";
        case SEVEN:
            return "7";
        case EIGHT:
            return "8";
        case NINE:
            return "9";
        case TEN:
            return "10";
        case JACK:
            return "J";
        case QUEEN:
            return "Q";
        case KING:
            return "K";
        default:
            return null;
        }    
    }
    
    public static String suitToString(int suit) {
        switch (suit) {
        case DIAMONDS:
            return "♦";
        case CLUBS:
            return "♣";
        case HEARTS:
            return "♥";
        case SPADES:
            return "♠";
        default:
            return null;
        }    
    }
    
    public static int stringToRank(String rank) {
    	switch(rank) {
    	case "A":
    		return 14;
    	case "K":
    		return 13;
    	case "Q":
    		return 12;
    	case "J":
    		return 11;
    	case "T":
    		return 10;
    	case "9":
    		return 9;
    	case "8":
    		return 8;
    	case "7":
    		return 7;
    	case "6":
    		return 6;
    	case "5":
    		return 5;
    	case "4":
    		return 4;
    	case "3":
    		return 3;
    	case "2":
    		return 2;
    	default:
    		return -1;
    	}
    }
    
    public static int stringToSuit(String suit) {
    	switch(suit) {
    	case "D":
    		return 1;
    	case "C":
    		return 2;
    	case "H":
    		return 3;
    	case "S":
    		return 4;
    	default:
    		return -1;
    	}
    }
}
