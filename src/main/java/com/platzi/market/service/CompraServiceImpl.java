package com.platzi.market.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.market.dto.PurchaseDTO;
import com.platzi.market.dto.PurchaseItemDTO;
import com.platzi.market.entity.Compra;
import com.platzi.market.repository.ClienteRepository;
import com.platzi.market.repository.CompraRepository;
import com.platzi.market.repository.ComprasProductoRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompraServiceImpl implements CompraService {

	@Autowired
	private CompraRepository compraRepo;
	@Autowired
	private ClienteRepository clienteRepo;
	@Autowired
	private ComprasProductoRepo comprasProductRepo;

	@Override
	public List<PurchaseDTO> getAll() {
		log.info("Starting getAll at " + new Date());
		return compraRepo.findAll().stream().map(p -> PurchaseDTO.builder().purchaseId(p.getIdCompra())
				.clienteId(p.getIdCliente()).date(p.getFecha()).paymentMethod(p.getMedioPago())
				.comment(p.getComentario()).state(p.getEstado())
				.item(p.getProductos().stream()
						.map(pro -> PurchaseItemDTO.builder().productId(pro.getId().getIdProducto())
								.queantity(pro.getCantidad()).total(pro.getTotal()).active(pro.getEstado()).build())
						.collect(Collectors.toList()))
				.build()).collect(Collectors.toList());
	}

	@Override
	public Optional<List<PurchaseDTO>> getByClient(String clientId) {
		log.info("Starting getByClient at " + new Date());
		return Optional.of(compraRepo.findByIdCliente(clientId).stream().map(p -> PurchaseDTO.builder()
				.purchaseId(p.getIdCompra()).clienteId(p.getIdCliente()).date(p.getFecha())
				.paymentMethod(p.getMedioPago()).comment(p.getComentario()).state(p.getEstado())
				.item(p.getProductos().stream()
						.map(pro -> PurchaseItemDTO.builder().productId(pro.getId().getIdProducto())
								.queantity(pro.getCantidad()).total(pro.getTotal()).active(pro.getEstado()).build())
						.collect(Collectors.toList()))
				.build()).collect(Collectors.toList()));
	}

	@Override
	public PurchaseDTO save(PurchaseDTO dto) {
		log.info("Starting save at " + new Date());
		Compra compraEntity = Compra.builder().idCompra(dto.getPurchaseId()).idCliente(dto.getClienteId())
				.fecha(dto.getDate()).medioPago(dto.getPaymentMethod()).comentario(dto.getComment())
				.estado(dto.getState()).cliente(clienteRepo.findById(dto.getClienteId()))
				.productos(comprasProductRepo.findByIdCompra(dto.getPurchaseId())).build();
		compraRepo.save(compraEntity);
		return PurchaseDTO.builder().purchaseId(compraEntity.getIdCompra()).clienteId(compraEntity.getIdCliente())
				.date(compraEntity.getFecha()).paymentMethod(compraEntity.getMedioPago())
				.comment(
						compraEntity.getComentario())
				.state(compraEntity.getEstado())
				.item(compraEntity.getProductos().stream().map(p -> new PurchaseItemDTO(p.getProducto().getIdProducto(),
						p.getCantidad(), p.getTotal(), p.getEstado())).collect(Collectors.toList()))
				.build();
	}

}
