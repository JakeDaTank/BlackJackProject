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

*The Dealer I designed to have much of the functionality of a Player, however the Dealer has to be able to respond to the events on the board and make decisions 