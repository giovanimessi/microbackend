package br.com.spring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.model.Purchase;
import br.com.spring.repository.PurchaseRepository;
import br.com.spring.repository.projection.PurchaseItem;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	
	public PurchaseServiceImpl (PurchaseRepository purchaseRepository) {
		
		this.purchaseRepository = purchaseRepository;
	}
	
	@Override
	public Purchase savePurchase(Purchase purchase) {
		
		purchase.setPurchaseTime(LocalDateTime.now());
		
		
		return purchaseRepository.save(purchase);
	}
	
	
	@Override
	public List<PurchaseItem>findPurChaseItemOFUser(Long userId){
		
		return purchaseRepository.findAllPurchasesOfUser(userId);
	}
}
