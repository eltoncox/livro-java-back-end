package com.elton.java.back.end.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.elton.java.back.end.model.Item;

public class ItemDTO {

	@NotBlank
	private String productIdentifier;
	@NotNull
	private Float price;
	
	public String getProductIdentifier() {
		return productIdentifier;
	}
	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		item.setProductIdentifier(item.getProductIdentifier());
		itemDTO.setPrice(item.getPrice());
		
		return itemDTO;
	}
	
	
}
