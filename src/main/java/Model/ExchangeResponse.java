package Model;

public final class ExchangeResponse {
	private final boolean[] cardsToExchange;
	private final int numExchanges;
	
	public ExchangeResponse(boolean[] cardsToExchange, int numExchanges) {
        this.cardsToExchange = cardsToExchange;
        this.numExchanges = numExchanges;
    }
	
	public boolean[] getCardsToExchange() {
		return this.cardsToExchange;
	}
	
	public int getNumExchanges() {
		return this.numExchanges;
	}
}
