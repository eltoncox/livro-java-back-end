package com.elton.java.back.end.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.elton.java.back.end.model.Shop;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ShopDTO {
	
	@NotBlank
	private String userIdentifier;
	@NotNull
	private Float total;
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date date;
	@NotNull
	private List<ItemDTO> items;
	
	
	public String getUserIdentifier() {
		return userIdentifier;
	}
	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	
	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		return shopDTO;
	}
	
	
	

}
