package br.com.spring.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.model.Purchase;
import br.com.spring.repository.projection.PurchaseItem;



public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

	
	//pesquisa por usuario
	
	@Query("select "+
	"d.name as name , d.deviceType as type,p.price as price,p.color as color,p.purchaseTime as purchaseTime " +
	"from Puchase p left join Device d on d.id = p.deviceId " + "where p userId = :userId ")
	List<PurchaseItem>findAllPurchasesOfUser(@Param("userid")Long  userid);
	
}
