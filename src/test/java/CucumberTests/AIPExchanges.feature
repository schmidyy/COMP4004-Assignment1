Feature: AIP Exchange

	# Royal flush
	Scenario Outline: AIP One Away from Royal Flush
		Given My original AIP hand is "SA SK SQ SJ D5"
		When My AIP hand is exchanged with "<Exchange cards>"
		Then My new AIP hand "<Wins>" against "<Opponent hand>"
	
	Examples:
		|Exchange cards|Wins|Opponent hand |
		|ST            |Yes |S3 D3 H3 S8 C5|
		|H4            |No  |SA SK SQ SJ ST|
		
	# Straight flush
	Scenario Outline: AIP One Away from Straight Flush
		Given My original AIP hand is "S2 S3 DK S5 S6"
		When My AIP hand is exchanged with "<Exchange cards>"
		Then My new AIP hand "<Wins>" against "<Opponent hand>"
	
	Examples:
		|Exchange cards|Wins|Opponent hand |
		|S4            |Yes |S3 D3 H2 S8 C5|
		|C9            |No  |SA SK SQ SJ ST|
		
	# Three of a kind
	Scenario Outline: AIP Three of a kind, exchanges one
		Given My original AIP hand is "S3 D3 H3 S8 C5"
		When My AIP hand is exchanged with "<Exchange cards>"
		Then My new AIP hand "<Wins>" against "<Opponent hand>"
	
	Examples:
		|Exchange cards|Wins|Opponent hand |
		|D8            |Yes |S3 D3 H2 S8 C5|
		|C9            |No  |SA SK SQ SJ ST|
		
	# Two pair
	Scenario Outline: AIP Two pair, exchanges one
		Given My original AIP hand is "CT S4 SJ DT HJ"
		When My AIP hand is exchanged with "<Exchange cards>"
		Then My new AIP hand "<Wins>" against "<Opponent hand>"
	
	Examples:
		|Exchange cards|Wins|Opponent hand |
		|HT            |Yes |S3 D3 H2 S8 C5|
		|C9            |No  |SA SK SQ SJ ST|
		
	# Flush
	Scenario Outline: AIP One away from flush
		Given My original AIP hand is "H9 H2 CA HT H8"
		When My AIP hand is exchanged with "<Exchange cards>"
		Then My new AIP hand "<Wins>" against "<Opponent hand>"
	
	Examples:
		|Exchange cards|Wins|Opponent hand |
		|HA            |Yes |S3 D3 H2 S8 C5|
		|C9            |No  |SA SK SQ SJ ST|
		
	# Straight
	Scenario Outline: AIP One away from straight
		Given My original AIP hand is "S8 C7 D6 H5 C2"
		When My AIP hand is exchanged with "<Exchange cards>"
		Then My new AIP hand "<Wins>" against "<Opponent hand>"
	
	Examples:
		|Exchange cards|Wins|Opponent hand |
		|D4            |Yes |S3 DT H2 S8 C5|
		|C9            |No  |SA SK SQ SJ ST|
		
	# Three of same suit
	Scenario Outline: AIP Three of same suit, exchanges two
		Given My original AIP hand is "S8 C7 S2 S5 CQ"
		When My AIP hand is exchanged with "<Exchange cards>"
		Then My new AIP hand "<Wins>" against "<Opponent hand>"
	
	Examples:
		|Exchange cards|Wins|Opponent hand |
		|S6 SA         |Yes |S3 D3 H2 S8 C5|
		
	# Three cards in sequence
	Scenario Outline: AIP Three in sequence, exchanges two
		Given My original AIP hand is "S8 C7 D6 HA C3"
		When My AIP hand is exchanged with "<Exchange cards>"
		Then My new AIP hand "<Wins>" against "<Opponent hand>"
	
	Examples:
		|Exchange cards|Wins|Opponent hand |
		|S5 S4         |Yes |S3 D3 H2 S8 C5|
		
	# One pair
	Scenario Outline: AIP Three in sequence, exchanges two
		Given My original AIP hand is "CT S2 SJ D6 HJ"
		When My AIP hand is exchanged with "<Exchange cards>"
		Then My new AIP hand "<Wins>" against "<Opponent hand>"
	
	Examples:
		|Exchange cards|Wins|Opponent hand |
		|S5 S4 SA      |Yes |S3 D3 H2 S8 C5|
		
	# High card
	Scenario Outline: AIP Three in sequence, exchanges two
		Given My original AIP hand is "CT S2 S4 D6 HJ"
		When My AIP hand is exchanged with "<Exchange cards>"
		Then My new AIP hand "<Wins>" against "<Opponent hand>"
	
	Examples:
		|Exchange cards|Wins|Opponent hand |
		|S5 S4 SA      |Yes |S3 D9 H2 S8 C5|
		