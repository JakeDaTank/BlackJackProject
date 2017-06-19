##BlackJack Project
								
*First approach I took was to draw out a diagram of what a Card class would consist of.
*After deciding that a Card needed a Suit and a Rank I decided to give each Rank a value 
attached to it in order to allow for the individual Cards to be counted and counted up by the program.

*After finishing a single Card, I designed what I thought a Deck class should be able to do.
*A Deck should be able to shuffle itself
*Create an ordered "New Deck" by "manufacturing" Cards. 
*Remove a card from the top and hand it off.

*Although many functions of a Dealer and Player are similar, I decided not to make an abstracted
Person class because I wanted to keep the Dealer and the Player as separate as possible.

*Dealers I designed to have much of the functionality of a Player, however Dealers have to be able 
to respond to the events on the board and return booleans based off of their current Hand.
*Dealer was able to receive Cards into their Hand and determine the Value of those cards along 
with discard that hand.
*Based on Card Values the Dealer was able to make checks as to weather they had a BlackJack, 
busted, or if the dealer should continue to hit.
*Dealers are also able to show their first draw to the table and their whole hand when appropriate

*Players much like dealers can receive and discard Cards. However unlike the Dealer class they do
have name and have far less logic checking since that is left up to the Player.
*Player does know if they have a BlackJack, if they have busted, and can show their cards to the 
Table

* much of the 