package blackjack;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand {
	private List<Card> playerHand = new ArrayList<>();
	
	public void addToHand(Card hand){
		playerHand.add(hand);
	}

	public void discard(){
		playerHand = new ArrayList<>();
	}
}
