package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Map<Product, Integer> products = new LinkedHashMap<Product, Integer>();
	int number;
	static int counter = 1;
	
	public Invoice() {
		this.number = counter ++;
		
	}

	
	public Integer getNumber() {
		return this.number;
	}

	public String getAsText() {
		StringBuilder sb = new StringBuilder();
		Integer counter = 0;
		sb.append("nr: ");
		sb.append(this.number);
		sb.append("\n");
		for (Product product : products.keySet()) {
			sb.append(product.getName());
			sb.append(" ");
			sb.append(products.get(product));
			sb.append(" ");
			sb.append(product.getPrice());
			sb.append("\n");
			
			counter++;
		}
		sb.append("Liczba pozycji: ");
		sb.append(counter);
		return sb.toString();
		
	}


	public void addProduct(Product product) {
		addProduct(product, 1);
	}
	
	

	public void addProduct(Product product, Integer quantity) {
		if (product == null || quantity <= 0) {
			throw new IllegalArgumentException();
		}
		
		if(products.containsKey(product)) {
			int newVal = products.get(product)+quantity;
			products.put(product, newVal);
			
		}
		else {
		products.put(product, quantity);
		}
		
		}

	public BigDecimal getNetTotal() {
		BigDecimal totalNet = BigDecimal.ZERO;
		for (Product product : products.keySet()) {
			BigDecimal quantity = new BigDecimal(products.get(product));
			totalNet = totalNet.add(product.getPrice().multiply(quantity));
		}
		return totalNet;
	}

	public BigDecimal getTaxTotal() {
		return getGrossTotal().subtract(getNetTotal());
	}

	public BigDecimal getGrossTotal() {
		BigDecimal totalGross = BigDecimal.ZERO;
		for (Product product : products.keySet()) {
			BigDecimal quantity = new BigDecimal(products.get(product));
			totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
		}
		return totalGross;
	}
}
