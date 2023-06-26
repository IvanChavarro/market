package com.platzi.market.service;

import java.util.List;
import java.util.Optional;

import com.platzi.market.dto.PurchaseDTO;

public interface CompraService {
	List<PurchaseDTO> getAll();

	Optional<List<PurchaseDTO>> getByClient(String clientId);

	PurchaseDTO save(PurchaseDTO dto);
}
