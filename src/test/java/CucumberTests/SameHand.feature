Feature: Same Hand Comparrison

	# Royal flush
	Scenario Outline: Two Royal Flushes, Highest suit wins
		Given The AIP hand is "SA SK SQ SJ ST"
		And The HTB hand is "DA DK DQ DJ DT"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Straight flush highest rank
	Scenario Outline: Two Straight Flushes with distinct highest card, Highest card wins
		Given The AIP hand is "SK SQ SJ ST S9"
		And The HTB hand is "DQ DJ DT D9 D8"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Straight flush highest suit
	Scenario Outline: Two Straight Flushes with same highest card, Highest suit wins
		Given The AIP hand is "SK SQ SJ ST S9"
		And The HTB hand is "DK DQ DJ DT D9"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Four of a kind
	Scenario Outline: Two four of a kind, highest rank wins
		Given The AIP hand is "S9 C9 D9 H9 S4"
		And The HTB hand is "S3 C3 D3 H3 S4"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Full house
	Scenario Outline: Two full houses, highest triplet wins
		Given The AIP hand is "S9 C9 D9 H4 S4"
		And The HTB hand is "S3 C3 D3 H2 S2"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Three of a kind
	Scenario Outline: Two three of a kinds, highest triplet wins
		Given The AIP hand is "S9 C9 D9 H6 S4"
		And The HTB hand is "S3 C3 D3 H6 S2"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Straight same rank
	Scenario Outline: Two Straights with same highest card, Highest suit wins
		Given The AIP hand is "SK CQ DJ HT S9"
		And The HTB hand is "DK HQ CJ ST S9"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Straight same suit
	Scenario Outline: Two Straights with distinct highest card, Highest rank wins
		Given The AIP hand is "SK CQ DJ HT S9"
		And The HTB hand is "CJ ST S9 D8 H7"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Two pair, same highest pair
	Scenario Outline: Two pair, same highest pair. Highest rank wins
		Given The AIP hand is "SK CK DT HT S9"
		And The HTB hand is "DK HK S9 D9 H7"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Two pair, distinct highest pair
	Scenario Outline: Two pair, distinct highest pair. Highest pair wins
		Given The AIP hand is "SA CA DT HT S9"
		And The HTB hand is "DK HK S9 D9 H7"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Pair, same pair
	Scenario Outline: Pair, same pair. Highest suit wins
		Given The AIP hand is "SK CK DA HT S9"
		And The HTB hand is "DK HK S5 D9 H7"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Pair, distinct pair
	Scenario Outline: Pair, distinct pair. Highest rank wins
		Given The AIP hand is "SA CA D3 HT S9"
		And The HTB hand is "DK HK S9 D4 H7"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# High card, same card
	Scenario Outline: High card, same card, highest suit wins
		Given The AIP hand is "SK C2 D5 HQ S9"
		And The HTB hand is "DK H8 S5 D9 H7"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# High card, distinct card
	Scenario Outline: High card, distinct card, highest card wins
		Given The AIP hand is "SA C2 D5 HQ S9"
		And The HTB hand is "DK H8 S5 D9 H7"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Flush, same 5 ranks
	Scenario Outline: Flush, same 5 ranks, highest suit wins
		Given The AIP hand is "SK SJ S9 S7 S5"
		And The HTB hand is "HK HJ H9 H7 H5"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
	
	# Flush, same 4 ranks
	Scenario Outline: Flush, same 4 highest ranks, highest rank of distinct card wins
		Given The AIP hand is "SK SJ S9 S7 S5"
		And The HTB hand is "HK HJ H9 H7 H3"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
	
	# Flush, same 3 ranks
	Scenario Outline: Flush, same 3 highest ranks, highest rank of distinct cards wins
		Given The AIP hand is "SK SJ S9 S7 S5"
		And The HTB hand is "HK HJ H9 H5 H3"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Flush, same 2 ranks
	Scenario Outline: Flush, same 2 highest ranks, highest rank of distinct cards wins
		Given The AIP hand is "SK SJ S9 S7 S5"
		And The HTB hand is "HK HJ H6 H5 H3"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |
		
	# Flush, same highest rank
	Scenario Outline: Flush, same highest ranks, highest rank of distinct cards wins
		Given The AIP hand is "SK SJ S9 S7 S5"
		And The HTB hand is "HK H9 H6 H5 H3"
		When The hands are compared
		Then The winner is "<Winner>"
	
	Examples:
		|Winner|
		|AIP   |