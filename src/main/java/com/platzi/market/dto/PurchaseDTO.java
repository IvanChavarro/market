package com.platzi.market.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDTO {
	private Integer purchaseId;
	private String clienteId;
	private LocalDateTime date;
	private String paymentMethod;
	private String comment;
	private String state;
	private List<PurchaseItemDTO> item;
}
