package desafio.saraiva;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BestPrice {
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	String value;
}
