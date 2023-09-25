package br.com.spring.service;

import java.util.List;

import br.com.spring.model.Purchase;
import br.com.spring.repository.projection.PurchaseItem;

public interface PurchaseService {

	Purchase savePurchase(Purchase purchase);

	List<PurchaseItem> findPurChaseItemOFUser(Long userId);

}
