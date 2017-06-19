## BlackJack Project
								
* First approach I took was to draw out a diagram of what a Card class would consist of.
* After deciding that a Card needed a Suit and a Rank I decided to give each Rank a value 
attached to it in order to allow for the individual Cards to be counted and counted up by the program.

* After finishing a single Card, I designed what I thought a Deck class should be able to do.
* A Deck should be able to shuffle itself
* Create an ordered "New Deck" by "manufacturing" Cards. 
* Remove a card from the top and hand it off.

* Although many functions of a Dealer and Player are similar, I decided not to make an abstracted
Person class because I wanted to keep the Dealer and the Player as separate as possible.

* Dealers I designed to have much of the functionality of a Player, however Dealers have to be able 
to respond to the events on the board and return booleans based off of their current Hand.
* Dealer was able to receive Cards into their Hand and determine the Value of those cards along 
with discard that hand.
* Based on Card Values the Dealer was able to make checks as to weather they had a BlackJack, 
busted, or if the dealer should continue to hit.
* Dealers are also able to show their first draw to the table and their whole hand when appropriate

* Players much like dealers can receive and discard Cards. However unlike the Dealer class they do
have name and have far less logic checking since that is left up to the Player.
* Player does know if they have a BlackJack, if they have busted, and can show their cards to the 
Table

* The Game Driver did have a method that would compare the player and dealers score in various ways
in order to determine if the match was a win, loss or draw. Both the player and Dealer received a 
point for a win in order to keep the game logic running in the case of a first round draw and
this is a flaw that I would like to address.
* Much of the initial Game logic went by quickly after having set up the classes however, the most
difficult part of the project was trying to loop through the game for multiple decks and keep the
menu options organized in such a way that they appeared at the appropriate times.