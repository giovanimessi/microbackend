package br.com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.spring.model.Purchase;
import br.com.spring.repository.projection.PurchaseItem;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

	
	//pesquisa por usuario
	
	List<PurchaseItem>findAllPurchasesOfUser(@Param("userId")Long  userId);
	
}
