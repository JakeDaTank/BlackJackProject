package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	
	public List<Card> createDeck() {

		List<Card> deck = new ArrayList<>(52);
		for (Suit r : Suit.values()) {
			for (Rank s : Rank.values()) {
				deck.add(new Card(s, r));
			}
		}
		return deck;
	}

	public List<Card> suffleDeck(List<Card> deck) {
		Collections.shuffle(deck);
		return deck;
	}

	public Card removeCard(List<Card> deck) {
		Card drawnCard = deck.remove(0);
		return drawnCard;
	}
}
