package com.sportyshoes.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportyshoes.model.MyModel;
import com.sportyshoes.model.OrderModel;
import com.sportyshoes.model.ProductInfo;
import com.sportyshoes.model.User;
import com.sportyshoes.service.SportyShoeService;

@Controller
public class SportyShoesController {
	
	@Autowired
	SportyShoeService service;
	
	 @GetMapping("/")
	    public String home(Model model) throws UnsupportedEncodingException {
		 List<ProductInfo> products = service.getProducts();
		 List<ProductInfo> viewProducts=new ArrayList<ProductInfo>();
		 ProductInfo prodinfo=null;
		 for (ProductInfo product : products) {
			 prodinfo=new ProductInfo();
			 byte[] encodedImage = java.util.Base64.getEncoder().encode(product.getImage());
			 prodinfo.setEncodeImage(new String(encodedImage, "UTF-8"));
			 prodinfo.setCreationDt(product.getCreationDt());
			 prodinfo.setProductId(product.getProductId());
			 prodinfo.setProductName(product.getProductName());
			 prodinfo.setProductType(product.getProductType());		
			 prodinfo.setModelNo(product.getModelNo());	
			 prodinfo.setEachProdCost(product.getEachProdCost());
			 viewProducts.add(prodinfo);
	      }
		
     	model.addAttribute("products", viewProducts);
		 
	   return "home";
	    }
	 
	 @GetMapping("/getProducts")
	    public String getProducts(Model model) {
	       
	           
	        	List<ProductInfo> products = service.getProducts();
	        	model.addAttribute("products", products);
	           return "home";
	    }
	 
	 @GetMapping("/buyProduct/{prodctId}")
	    public String buyProduct(@PathVariable("prodctId") int prodctId,HttpSession session,Model model) {
	       
	           User user=(User) session.getAttribute("user");
	           System.out.println("user from session is :"+user);
	           ProductInfo product=service.getProduct(prodctId);
	          System.out.println("out Product Name........."+product.getProductName());
	   		System.out.println("out ProductType........."+product.getProductType());
	   		System.out.println("out ModelNo........."+product.getModelNo());
	   		System.out.println("out EachProdCost........."+product.getEachProdCost());
	   		System.out.println("out CreationDt........."+product.getCreationDt());
	   		System.out.println("out ProductStatus........."+product.getProductStatus());
	   		System.out.println("out NoOfProduct........."+product.getNoOfProducts());
	   		
	   	    
	   		
	           model.addAttribute("product", product);
	        	if (user !=null) {
	        		System.out.println("userId from session is :"+user.getUserId());
	        		OrderModel order=new OrderModel();
	        		order.setEachProdCost(product.getEachProdCost());
	        		order.setProductName(product.getProductName());
	        		order.setModelNo(product.getModelNo());
	        		model.addAttribute("order", order);
	        		return "order";
	        	}
	        	
	        	else {
	        		return "userLogin";
	        	}
	           
	    }
	 
	 
	 @PostMapping("/order")
	    public String placeOrder(OrderModel order,HttpSession session,Model model) {
	       
	          
	        System.out.println("out Product Name........."+order.getProductName());
	   		System.out.println("out ProductType........."+order.getOrderType());
	   		System.out.println("out ModelNo........."+order.getModelNo());
	   		System.out.println("out EachProdCost........."+order.getEachProdCost());
	   		System.out.println("out CreationDt........."+order.getCreationDt());
	   		System.out.println("out Email........."+order.getUserEamil());
	   		System.out.println("out User Name........."+order.getUserName());
	   		LocalDate currentDt = LocalDate.now();
	   		System.out.println("out Current........."+currentDt);
	   		
	   		LocalDate despatchDt = LocalDate.now().plusDays(7);
	   		System.out.println("out despatchDt........."+despatchDt);
	   		
	   		order.setCreationDt(currentDt.toString());
	   		order.setDispatchDt(despatchDt.toString());
	   		order.setOrderType("Web");
	   		order.setOrdertStatus("Created");
	   		
	   		OrderModel orderModel = service.addOrder(order);
	   	    model.addAttribute("order", orderModel);
	   		return "viewOrder";
	   		
	       
	           
	    }
	 
	 
		

}
