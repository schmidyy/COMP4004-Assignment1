Feature: AIP Holds

	# Royal flush
	Scenario Outline: AIP Royal Flush
		Given My AIP hand is "SA SK SQ SJ ST"
		When My AIP hand is scored
		Then My hand holds against "<Hand>"
	
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
	Scenario Outline: AIP Straight Flush
		Given My AIP hand is "S2 S3 S4 S5 S6"
		When My AIP hand is scored
		Then My hand holds against "<Hand>"
	
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
	Scenario Outline: AIP Four of a kind
		Given My AIP hand is "S9 C9 D9 H9 S4"
		When My AIP hand is scored
		Then My hand holds against "<Hand>"
	
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
	Scenario Outline: AIP Full house
		Given My AIP hand is "DA CA DK SK HK"
		When My AIP hand is scored
		Then My hand holds against "<Hand>"
	
	Examples:
		|Hand|
		|H9 H2 HA HT H8|
		|S8 C7 D6 H5 C4|
		|S3 D3 H3 S8 C5|
		|CT S4 SJ DT HJ|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|
		
	# Flush
	Scenario Outline: AIP Full house
		Given My AIP hand is "H9 H2 HA HT H8"
		When My AIP hand is scored
		Then My hand holds against "<Hand>"
	
	Examples:
		|Hand|
		|S8 C7 D6 H5 C4|
		|S3 D3 H3 S8 C5|
		|CT S4 SJ DT HJ|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|
		
	# Straight
	Scenario Outline: AIP Straight
		Given My AIP hand is "S8 C7 D6 H5 C4"
		When My AIP hand is scored
		Then My hand holds against "<Hand>"
	
	Examples:
		|Hand|
		|S3 D3 H3 S8 C5|
		|CT S4 SJ DT HJ|
		|CT S4 SJ D6 HJ|
		|DA C2 D5 S9 HQ|