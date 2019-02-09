package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.omg.PortableInterceptor.ForwardRequest;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products = new ArrayList<>();

	public void addProduct(Product product) {
		
		this.products.add(product);
		
		// TODO: implement
	}

	public void addProduct(Product product, Integer quantity) {
		// TODO: implement
		for (int i = 0; i<quantity; i ++){
			
			
			
		}
		this.products.add(product);


	}
	
	public BigDecimal getSubtotal() {
		
		BigDecimal subtotal = BigDecimal.ZERO;
		
		
		for (Product p: products){
			
			subtotal = subtotal.add(p.getPrice());
		}

		return subtotal;
	}

	public BigDecimal getTax() {
		BigDecimal taxVal = new BigDecimal(0);
		
		for (Product p: products){
			taxVal.add(p.getTaxPercent().multiply(p.getPrice()));			
		}
		
		return taxVal;
	}

	public BigDecimal getTotal() {
		BigDecimal subtotal = new BigDecimal(0);
		
		for (Product p: products){
			subtotal.add(p.getPriceWithTax());			
		}
		
		return subtotal;
	}
}
