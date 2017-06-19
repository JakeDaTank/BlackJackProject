package blackjack;

import java.util.*;

public class GameDriver {
	Scanner kb = new Scanner(System.in);
	private Dealer dealer = new Dealer();
	private Deck d1 = new Deck();
	private List<Card> localDeck = new ArrayList<>();
	private Player p1 = new Player();

	public void setUpGame() {

		System.out.println("Please choose a player name :");
		p1.setName(kb.nextLine());
		System.out.println("Good luck " + p1.getName() + "!!!!");
		localDeck = d1.createDeck();
		d1.suffleDeck(localDeck);

	}

	public void playGame() {
		int turnNumber = 1;
		int playerRoundWins = 0;
		int dealerRoundWins = 0;

		if (playerRoundWins + dealerRoundWins == 0) {
			setUpGame();
			
		}
		if (playerRoundWins + dealerRoundWins != 0) {
			System.out.println("\t***Current Score***");
			System.out.println("Dealer : " + dealerRoundWins + "/t"+ p1.getName() + " : " + playerRoundWins);
			System.out.println("/t***Menue***");
			System.out.println("Continue on this deck 1)");
			System.out.println("Play on a new deck 2)");
			System.out.println("New game 3)");
			
			int userChoice = kb.nextInt();
			if (userChoice == 1) {
				
			}
			if (userChoice == 2) {	
				localDeck = new ArrayList<>();
				localDeck = d1.createDeck();
				d1.suffleDeck(localDeck);
				
			}
			if (userChoice == 3) {
				localDeck = new ArrayList<>();
				localDeck = d1.createDeck();
				d1.suffleDeck(localDeck);
				playGame();
			}
			
		}
		do {
			System.out.println("You are on turn : " + turnNumber);

			for (int i = 0; i < 2; i++) {
				p1.addToHand(localDeck.remove(i));

			}
			for (int i = 0; i < 2; i++) {
				dealer.addToHand(localDeck.remove(i));

			}
			if (p1.getPlayerHandValue() == 21 && dealer.getDealerHandValue() == 21) {
				System.out.println("You both got a BlackJack");
			}
			if (dealer.dealerBlackJackCheck()) {
				System.out.println("Dealer has a BlackJack");

			} else {

				System.out.println("\n" + p1.toString());
				System.out.println("The dealer is showing " + dealer.showDraw1());
				int userChoice;

				do {
					System.out.println("\n***Would you like to*** \nStay 1) \nHit 2) \nLeaveGame 00)");
					userChoice = kb.nextInt();

					if (userChoice == 1) {
						while (dealer.dealerHitCheck()) {
							dealer.addToHand(localDeck.remove(0));
						}
						break;
					}
					if (userChoice == 2) {
						p1.addToHand(localDeck.remove(0));
						if (p1.playerBustCheck()) {
							System.out.println("\tYou bust 21");
							System.out.println(p1.toString());
						}
						if (p1.playerBustCheck() == false) {
							System.out.println(p1.toString());

						}
					}
					if (playerWin()) {
						System.out.println("You won this round");
						playerRoundWins = playerRoundWins + 1;

					}

				} while (userChoice != 00);
			}

		} while (localDeck.size() > 7);

	}

	private boolean playerWin() {
		if (p1.getPlayerHandValue() > dealer.getDealerHandValue()) {
			return true;
		}
		if (p1.getPlayerHandValue() < dealer.getDealerHandValue()) {
			return false;
		} else {
			return false;
		}
	
	}
}
