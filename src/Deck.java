import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
		for (Suit suit: Suit.values()) {
			for (Rank rank: Rank.values()) {
				Card card = new Card(rank, suit);
				this.cards.add(card);
			}
			
		}
		
	}
	

	public int size() {
		return cards.size();
	}
	
	public Card draw() {
		if (cards.isEmpty()) {
			return null;
		}
		return cards.remove(0);
	}
	
	public List<Card> draw(int count) {
		if (count <= 0) {
			return new ArrayList<Card>();
		}
		if (count > cards.size()) {
			count = cards.size();
		}
		List<Card> drawnCards = new ArrayList<Card>(cards.subList(0, count));
		cards.removeAll(drawnCards);
		return drawnCards;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public List<Card> getCardsByRank(Rank rank) {
		List<Card> matchingCards = new ArrayList<Card>();
		for (Card card : cards) {
			if (card.getRank() == rank) {
				matchingCards.add(card);
			}
		}
		return matchingCards;
	}
	
	public String toString() {
		return cards.toString();
	}

}
