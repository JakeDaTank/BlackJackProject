package blackjack;

import java.util.*;


public class Player {
	private List<Card> playerHand = new ArrayList<>();
	private int playerHandValue;
	public String name;

	public List<Card> getPlayerHand() {
		return playerHand;
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

	public void showPlayerHand() {
		System.out.println("\t***Your Hand***");
		for (int i = 0; i < playerHand.size(); i++) {
			System.out.println(playerHand.get(i).toString());
		}
		System.out.println("Total hand count : " + playerHandValue);
	}
	public boolean playerBlackjack(){
		if (playerHandValue == 21) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean playerBustCheck() {
		if (playerHandValue > 21) {
			return true;
		} else {
			return false;
		}
	}

}
