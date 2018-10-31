Feature: In Any Order 
	
	# Royal flush
	Scenario Outline: Royal Flush
		Given My hand is "<Hand>"
		When My hand is analyzed
		Then My hand is identified as a Royal Flush
	
	Examples:
		|Hand|
		|SA SK SQ SJ ST|
		|SJ ST SA SK SQ|
		
	# Straight Flush
	Scenario Outline: Straight Flush
		Given My hand is "<Hand>"
		When My hand is analyzed
		Then My hand is identified as a Straight Flush
	
	Examples:
		|Hand|
		|S2 S3 S4 S5 S6|
		|S5 S6 S2 S3 S4|
	
	# Four of a kind
	Scenario Outline: Four of a kind
		Given My hand is "<Hand>"
		When My hand is analyzed
		Then My hand is identified as a Four of a kind
	
	Examples:
		|Hand|
		|S9 C9 D9 H9 S4|
		|H9 S4 S9 C9 D9|
		
	# Full house
	Scenario Outline: Full House
		Given My hand is "<Hand>"
		When My hand is analyzed
		Then My hand is identified as a Full House
	
	Examples:
		|Hand|
		|DA CA DK SK HK|
		|SK HK DA CA DK|
		
	# Flush
	Scenario Outline: Flush
		Given My hand is "<Hand>"
		When My hand is analyzed
		Then My hand is identified as a Flush
	
	Examples:
		|Hand|
		|H9 H2 HA HT H8|
		|HT H8 H9 H2 HA|
		
	# Straight
	Scenario Outline: Straight
		Given My hand is "<Hand>"
		When My hand is analyzed
		Then My hand is identified as a Straight
	
	Examples:
		|Hand|
		|S8 C7 D6 H5 C4|
		|H5 C4 S8 C7 D6|
	
	# Three of a kind
	Scenario Outline: Three of a kind
		Given My hand is "<Hand>"
		When My hand is analyzed
		Then My hand is identified as a Three of a kind
	
	Examples:
		|Hand|
		|S3 D3 H3 S8 C5|
		|H3 S8 C5 S3 D3|
	
	# Two pair
	Scenario Outline: Two pair
		Given My hand is "<Hand>"
		When My hand is analyzed
		Then My hand is identified as a Two pair
	
	Examples:
		|Hand|
		|CT S4 SJ DT HJ|
		|DT HJ CT S4 SJ|
		
	# Pair
	Scenario Outline: Pair
		Given My hand is "<Hand>"
		When My hand is analyzed
		Then My hand is identified as a Pair
	
	Examples:
		|Hand|
		|CT S4 SJ D6 HJ|
		|D6 HJ CT S4 SJ|
	