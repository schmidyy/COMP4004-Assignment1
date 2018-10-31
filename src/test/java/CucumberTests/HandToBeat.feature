Feature: Hand to beat

	# Royal flush
	Scenario Outline: HTB Royal Flush
		Given My HTB hand is "SA SK SQ SJ ST"
		When My HTB hand is scored
		Then My hand beats "<Hand>"
	
	Examples:
		|Hand|
		|S2 S3 S4 S5 S6|
		|S9 C9 D9 H9 S4|
		|DA CA DK SK HK|
		|H9 H2 HA HT H8|
		|S8 C7 D6 H5 C4|
		|S3 D3 H3 S8 C5|
		|CT S4 SJ DT HJ|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|
		
	# Straight Flush
	Scenario Outline: HTB Straight Flush
		Given My HTB hand is "S2 S3 S4 S5 S6"
		When My HTB hand is scored
		Then My hand beats "<Hand>"
	
	Examples:
		|Hand|
		|S9 C9 D9 H9 S4|
		|DA CA DK SK HK|
		|H9 H2 HA HT H8|
		|S8 C7 D6 H5 C4|
		|S3 D3 H3 S8 C5|
		|CT S4 SJ DT HJ|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|
		
	# Four of a kind
	Scenario Outline: HTB Four of a kind
		Given My HTB hand is "S9 C9 D9 H9 S4"
		When My HTB hand is scored
		Then My hand beats "<Hand>"
	
	Examples:
		|Hand|
		|DA CA DK SK HK|
		|H9 H2 HA HT H8|
		|S8 C7 D6 H5 C4|
		|S3 D3 H3 S8 C5|
		|CT S4 SJ DT HJ|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|
		
	# Full house
	Scenario Outline: HTB Full house
		Given My HTB hand is "DA CA DK SK HK"
		When My HTB hand is scored
		Then My hand beats "<Hand>"
	
	Examples:
		|Hand|
		|H9 H2 HA HT H8|
		|S8 C7 D6 H5 C4|
		|S3 D3 H3 S8 C5|
		|CT S4 SJ DT HJ|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|
		
	# Flush
	Scenario Outline: HTB Full house
		Given My HTB hand is "H9 H2 HA HT H8"
		When My HTB hand is scored
		Then My hand beats "<Hand>"
	
	Examples:
		|Hand|
		|S8 C7 D6 H5 C4|
		|S3 D3 H3 S8 C5|
		|CT S4 SJ DT HJ|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|
		
	# Straight
	Scenario Outline: HTB Straight
		Given My HTB hand is "S8 C7 D6 H5 C4"
		When My HTB hand is scored
		Then My hand beats "<Hand>"
	
	Examples:
		|Hand|
		|S3 D3 H3 S8 C5|
		|CT S4 SJ DT HJ|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|
		
	# Three of a kind
	Scenario Outline: HTB Three of a kind
		Given My HTB hand is "S3 D3 H3 S8 C5"
		When My HTB hand is scored
		Then My hand beats "<Hand>"
	
	Examples:
		|Hand|
		|CT S4 SJ DT HJ|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|
		
	# Two pair
	Scenario Outline: HTB Two pair
		Given My HTB hand is "CT S4 SJ DT HJ"
		When My HTB hand is scored
		Then My hand beats "<Hand>"
	
	Examples:
		|Hand|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|
		
	# Pair
	Scenario Outline: HTB Pair
		Given My HTB hand is "CT S4 SJ D6 HJ"
		When My HTB hand is scored
		Then My hand beats "<Hand>"
	
	Examples:
		|Hand|
		|DA C2 D5 S9 HQ|
		