package Model;

public final class ExchangeResponse {
	private boolean[] cardsToExchange;
	private int numExchanges;
	
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
	
	public void setCardsToExchange(boolean[] cardsToExchange) {
		this.cardsToExchange = cardsToExchange;
	}
	
	public void setNumExchanges(int numExchanges) {
		this.numExchanges = numExchanges;
	}
}
