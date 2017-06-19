package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Card> playerHand = new ArrayList<>();
	private int playerHandValue;
	public String name;

	public List<Card> getPlayerHand() {
		return playerHand;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.name + " your hand is is");
		builder.append(playerHand + "\nYour total is: " +this.playerHandValue);
		return builder.toString();
	}
	public boolean playerBustCheck(){
		if (playerHandValue > 21) {
			return true;
		}
		else{
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addToHand(Card hand) {
		playerHand.add(hand);
		playerHandValue = playerHandValue + hand.getRank().getValue();
	}

	public void discard() {
		playerHand = new ArrayList<>();
		playerHandValue = 0;
	}

	public int getPlayerHandValue() {
		return playerHandValue;
	}

}
