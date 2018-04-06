package desafio.saraiva;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
	public BestPrice getBestPrice() {
		return bestPrice;
	}

	public void setBestPrice(BestPrice bestPrice) {
		this.bestPrice = bestPrice;
	}

	BestPrice bestPrice;
}
