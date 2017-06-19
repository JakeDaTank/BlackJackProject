package blackJackTesterClass;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import blackjack.Deck;

public class DeckTester {
	Deck testDeck = new Deck();

	@Before
	public void setUp() throws Exception {
		testDeck.createDeck();
	}

	@After
	public void tearDown() throws Exception {
		Deck testDeck = new Deck();
	}

	@Test
	public void test_Deck_for_deck_for_removal() {
		
	}

}
