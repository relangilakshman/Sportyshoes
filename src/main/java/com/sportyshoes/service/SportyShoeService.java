package com.sportyshoes.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.AdminModel;
import com.sportyshoes.model.MyModel;
import com.sportyshoes.model.OrderModel;
import com.sportyshoes.model.ProductInfo;
import com.sportyshoes.model.User;
import com.sportyshoes.repository.AdminRepo;
import com.sportyshoes.repository.OrderRepo;
import com.sportyshoes.repository.ProductInfoRepo;
import com.sportyshoes.repository.UserRepo;



@Service
public class SportyShoeService {
	
	@Autowired
	AdminRepo adminrepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ProductInfoRepo productInfoRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	
	public ProductInfo addProduct(ProductInfo productInfo)
	{
		productInfo=productInfoRepo.save(productInfo);
		return productInfo;
		
	}
	
	public OrderModel addOrder(OrderModel order)
	{
		OrderModel orderModel=orderRepo.save(order);
		return orderModel;
		
	}
	
	
	
	
	public AdminModel updateAdmin(AdminModel admin)
	{
		
		AdminModel adm=adminrepo.findById(admin.getUserId()).orElse(new AdminModel());
		adm.setPassword(admin.getPassword());
		int i=adminrepo.updatPasswordByUserId(admin.getPassword(), admin.getUserId());
		return adm;
	}
	
	
	public AdminModel getAdmin(String userId)
	{
		
		AdminModel adm=adminrepo.findById(userId).orElse(new AdminModel());
		
		return adm;
	}
	
	
	public List<ProductInfo> getProducts() {
       List<ProductInfo>  productsList= productInfoRepo.findAll();
       
      return productsList;
    }
	
	public ProductInfo getProduct(int productId) {
	       ProductInfo  product= productInfoRepo.findById(productId).orElse(new ProductInfo());;
	       
	      return product;
	    }
	
	
	public User getUser(String userId)
	{
		
		User user=userRepo.findById(userId).orElse(new User());
		
		return user;
	}
	
	public List<User> getUsers() {
	       List<User>  userList= userRepo.findAll();
	       
	      return userList;
	    }
	
	public List<OrderModel> getUserOrders(String userId) {
		List<OrderModel>  userOrders= orderRepo.findOrderModels(userId);
	       
	      return userOrders;
	    }
	
	
	public List<OrderModel> getReport(String purDt,String disDt,String ordStatus,String ordType) {
		List<OrderModel>  userOrders= orderRepo.findByCreationDtOrDispatchDtOrOrdertStatusOrOrderType(purDt, disDt, ordStatus, ordType);
	       
	      return userOrders;
	    }

}
