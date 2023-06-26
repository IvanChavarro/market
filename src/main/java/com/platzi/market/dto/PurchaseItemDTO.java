package com.platzi.market.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseItemDTO {
	private Integer productId;
	private Integer queantity;
	private Double total;
	private Boolean active;

}
