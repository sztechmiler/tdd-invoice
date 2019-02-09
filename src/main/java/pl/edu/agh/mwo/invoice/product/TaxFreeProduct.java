package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class TaxFreeProduct extends Product {
	public TaxFreeProduct(String name, BigDecimal price) {
		super(name, price, BigDecimal.ZERO);
		if(name == "" || price.compareTo(BigDecimal.ZERO) == -1){
			throw new IllegalArgumentException();

			
		}
	}
}
