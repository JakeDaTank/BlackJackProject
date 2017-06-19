package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	private int dealerHandValue;
	private List<Card> dealerHand = new ArrayList<>();

	public void addToHand(Card hand) {

		dealerHand.add(hand);
		dealerHandValue = dealerHandValue + hand.getRank().getValue();

	}
	public Card showDraw1(){
		return dealerHand.get(0);
	}

	public void discard() {
		dealerHand = new ArrayList<>();
		dealerHandValue = 0;
	}
	public boolean dealerBlackJackCheck(){
		if (dealerHandValue == 21) {
			return true;
		}
		else{
			return false;
		}
	}

	public boolean dealerHitCheck() {
		if (dealerHandValue >= 21) {
			return false;
		}
		if (dealerHandValue < 17) {
			return true;
		} else {
			return false;
		}
	}
	public boolean dealerBustCheck(){
		if (dealerHandValue > 21) {
			return true;
		}
		else{
			return false;
		}
	}
}
