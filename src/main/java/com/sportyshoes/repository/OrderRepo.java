package com.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sportyshoes.model.OrderModel;


public interface OrderRepo extends JpaRepository<OrderModel, Integer>{
	
	@Query("Select o from OrderModel o WHERE userName = :userid")
	public List<OrderModel> findOrderModels(String userid);
	
	
	@Query("Select o from OrderModel o WHERE creationDt = :creationDt or dispatchDt = :dispatchDt or ordertStatus = :ordertStatus or  orderType = :orderType")
	public List<OrderModel> findByCreationDtOrDispatchDtOrOrdertStatusOrOrderType(@Param("creationDt") String creationDt, @Param("dispatchDt")String dispatchDt,
			@Param("ordertStatus") String ordertStatus, @Param("orderType")String orderType);

}
