package blackjack;

import java.util.*;

public class GameDriver {
	Scanner kb = new Scanner(System.in);

	private Dealer dealer = new Dealer();
	private Deck d1 = new Deck();
	private Player p1 = new Player();

	private List<Card> localDeck = new ArrayList<>();
	private int turnNumber, playerRoundWins, dealerRoundWins;

	public void setUpGame() {

		System.out.println("Please choose a player name :");
		p1.setName(kb.nextLine());
		System.out.println("Good luck " + p1.getName() + "!!!!");
		localDeck = d1.createDeck();
		d1.suffleDeck(localDeck);

	}

	public void playGame() {

		if ((playerRoundWins + dealerRoundWins) == 0) {
			turnNumber = 1;
			setUpGame();

		}
		if ((playerRoundWins + dealerRoundWins) > 0) {
			turnNumber = turnNumber + 1;
			int userChoice = 0;
			if (!(localDeck.size() == 52)) {
				System.out.println("\t***Current Score***");
				System.out.println("Dealer : " + dealerRoundWins + "\t" + p1.getName() + " : " + playerRoundWins);
				System.out.println("\n\t***Menu***");
				System.out.println("\nContinue on this deck 1)");
				System.out.println("Play on a new deck 2)");
				System.out.println("New game 3)");
			}
			// Preselected menu choices in case of a new deck being created or a game started.
			if (localDeck.size() <= 7) {
				userChoice = 2;
			}
			if (localDeck.size() > 7) {
				if (localDeck.size() == 52) {
					userChoice = 1;
				} else {
					userChoice = kb.nextInt();
				}
			}
			// Menu option results.
			// Option one wishes the player luck and continues the game.
			if (userChoice == 1) {
				System.out.println("Good luck " + p1.getName());
			}
			// Change out localDeck for a new Deck.
			if (userChoice == 2) {
				localDeck = new ArrayList<>();
				localDeck = d1.createDeck();
				d1.suffleDeck(localDeck);
			// Option 3 begins a new game with a new player.
			}
			if (userChoice == 3) {
				p1 = new Player(); 
				playerRoundWins = 0;
				dealerRoundWins = 0;
				localDeck = new ArrayList<>();
				localDeck = d1.createDeck();
				d1.suffleDeck(localDeck);
				playGame();
			}

		}
		//Start a round
		do {
			System.out.println("You are on turn : " + turnNumber);

			for (int i = 0; i < 2; i++) {
				p1.addToHand(localDeck.remove(i));

			}
			for (int i = 0; i < 2; i++) {
				dealer.addToHand(localDeck.remove(i));

			}
			if (p1.playerBlackjack() && dealer.dealerBlackJackCheck()) {
				System.out.println("You both got a BlackJack");
				dealerRoundWins = dealerRoundWins + 1;
				playerRoundWins = playerRoundWins + 1;
				playGame();

			}
			if (p1.playerBlackjack()) {
				System.out.println("You got a BlackJack");
				playerRoundWins = playerRoundWins + 1;
				p1.showPlayerHand();
				dealer.showDealerHand();
				p1.discard();
				dealer.discard();
				playGame();
			}
			if (dealer.dealerBlackJackCheck()) {
				System.out.println("Dealer has a BlackJack");
				dealerRoundWins = dealerRoundWins + 1;
				playGame();

			} else {

				p1.showPlayerHand();
				System.out.println("The dealer is showing " + dealer.showDraw1());
				int userChoice;

				do {
					//System.out.println("\n **Enter 00 to Quit**");
					System.out.println("***Would you like to*** \nPass 1) \nHit 2)");
					userChoice = kb.nextInt();

					if (userChoice == 1) {
						while (dealer.dealerHitCheck()) {
							dealer.addToHand(localDeck.remove(0));
						}
						if (playerWin()) {
							System.out.println("You won this round");
							playerRoundWins = playerRoundWins + 1;
							System.out.println("\t***Dealer Hand***");
							dealer.showDealerHand();
							p1.discard();
							dealer.discard();
							playGame();
						}

						if (playerWin() == false) {
							System.out.println("You lost this round");
							dealerRoundWins = dealerRoundWins + 1;
							dealer.showDealerHand();
							p1.discard();
							dealer.discard();
							playGame();
						}
						if (playerWin() == false && p1.getPlayerHandValue() == dealer.getDealerHandValue()) {
							System.out.println("You tied the dealer");
							dealerRoundWins = dealerRoundWins + 1;
							playerRoundWins = playerRoundWins + 1;
							dealer.showDealerHand();
							p1.showPlayerHand();
							p1.discard();
							dealer.discard();
							playGame();
						}
					}
					if (userChoice == 2) {
						p1.addToHand(localDeck.remove(0));
						if (p1.playerBustCheck()) {
							System.out.println("\tYou bust 21");
							p1.showPlayerHand();
							dealerRoundWins = dealerRoundWins + 1;
							p1.discard();
							dealer.discard();
							playGame();
						}
						if (p1.playerBustCheck() == false) {
							p1.showPlayerHand();
						}
					} else {
						p1.discard();
						dealer.discard();
						playGame();
					}

				} while (userChoice != 00);
			}

		} while (localDeck.size() > 7);
		System.out.println("This deck has been exausted.");
		playGame();

	}

	private boolean playerWin() {

		if (dealer.getDealerHandValue() > 21) {
			return true;
		}
		if (p1.getPlayerHandValue() > dealer.getDealerHandValue()) {
			return true;
		}
		if (dealer.getDealerHandValue() == 21) {
			return false;
		}
		if (p1.getPlayerHandValue() < dealer.getDealerHandValue()) {
			return false;
		} else {
			return false;
		}

	}
}
