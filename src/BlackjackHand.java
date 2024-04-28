import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
	private static final int MAX_VALUE = 21;
	private static Map<Rank, Integer> CARD_VALUES;

	static {
		CARD_VALUES = new HashMap<Rank, Integer>();
		CARD_VALUES.put(Rank.ACE, 11);
		CARD_VALUES.put(Rank.TWO, 2);
		CARD_VALUES.put(Rank.THREE, 3);
		CARD_VALUES.put(Rank.FOUR, 4);
		CARD_VALUES.put(Rank.FIVE, 5);
		CARD_VALUES.put(Rank.SIX, 6);
		CARD_VALUES.put(Rank.SEVEN, 7);
		CARD_VALUES.put(Rank.EIGHT, 8);
		CARD_VALUES.put(Rank.NINE, 9);
		CARD_VALUES.put(Rank.TEN, 10);
		CARD_VALUES.put(Rank.JACK, 10);
		CARD_VALUES.put(Rank.QUEEN, 10);
		CARD_VALUES.put(Rank.KING, 10);
	}

	private List<Card> cards;
	private int value;
	private int numAcesAs11;

	public BlackjackHand(Card card1, Card card2) throws NullPointerException {
		if (card1 == null || card2 == null) {
			throw new NullPointerException();
		}
		
		this.cards = new ArrayList<Card>();
		this.cards.add(card1);
		this.cards.add(card2);
		
		this.value = 0;
		this.numAcesAs11 = 0;
		for (Card card : cards) {
			Rank rank = card.getRank();
			if (rank == Rank.ACE) {
				numAcesAs11++;
			}
			value += CARD_VALUES.get(rank);
		}
		
		while (value > MAX_VALUE && numAcesAs11 > 0) {
			value -= 10;
			numAcesAs11--;
		}
	}

	public void addCard(Card card) throws NullPointerException {
		if (card == null) {
			throw new NullPointerException();
		}
		
		if (value < MAX_VALUE) {
			cards.add(card);
			
			Rank rank = card.getRank();
			if (rank == Rank.ACE) {
				numAcesAs11++;
			}
			value += CARD_VALUES.get(rank);
			
			while (value > MAX_VALUE && numAcesAs11 > 0) {
				value -= 10;
				numAcesAs11--;
			}
		}
	}

	public static Map<Rank, Integer> getCardValues() {
		return new HashMap<Rank, Integer>(CARD_VALUES);
	}

	public List<Card> getCards() {
		return new ArrayList<Card>(cards);
	}

	public int getValue() {
		return value;
	}

	public int size() {
		return cards.size();
	}

	public String toString() {
		return cards.toString();
	}

}
