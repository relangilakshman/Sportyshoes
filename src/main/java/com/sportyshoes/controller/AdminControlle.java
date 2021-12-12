package com.sportyshoes.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sportyshoes.model.AdminModel;
import com.sportyshoes.model.OrderModel;
import com.sportyshoes.model.ProductInfo;
import com.sportyshoes.model.User;
import com.sportyshoes.service.SportyShoeService;



@Controller
@RequestMapping("/admin")
public class AdminControlle {
	
	private String npassword;
	private String rpassword;
	
	@Autowired
	AdminModel admin;
	
	
	@Autowired
	OrderModel order;
	
	@Autowired
	ProductInfo product;
	
	@Autowired
	SportyShoeService service;
	
	
	public String getNpassword() {
		return npassword;
	}



	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}



	public String getRpassword() {
		return rpassword;
	}



	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}



	@RequestMapping("")
	public String admin(Model model,HttpSession session)
	{
	System.out.println("Admi.......");
	
	AdminModel adminModel=(AdminModel) session.getAttribute("admin");
	if(adminModel !=null) {	
		model.addAttribute("admin", adminModel);
		model.addAttribute("product", product);
	return "adminHome";	
	}else {
		return "login";	
		
	}
	
	}
	
	@RequestMapping("/login")
	public String signin(String userId,Model model,HttpSession session)
	{
	model.addAttribute("product", product);	
	
	
	
	
	   AdminModel adminModel=service.getAdmin(userId);
		System.out.println("DB UserId......."+adminModel.getUserId());
		if(adminModel.getUserId() !=null) {
			System.out.println("DB UserId id Found......."+adminModel.getUserId());
			session.setAttribute("admin", adminModel);
		}
		else {
			System.out.println("DB UserId id Not Found......."+adminModel.getUserId());
		}
		
	
	
	return "adminHome";	
	}
	
	
	
	@PostMapping("/addProduct")
	public String addProduct(ProductInfo product,Model model,@RequestParam("file") MultipartFile file)
	{
		String msg=null;
		System.out.println("AddProduct.......");
		byte[] image=null;
		System.out.println("input Product Name........."+product.getProductName());
		System.out.println("input ProductType........."+product.getProductType());
		System.out.println("input ModelNo........."+product.getModelNo());
		System.out.println("input EachProdCost........."+product.getEachProdCost());
		System.out.println("input CreationDt........."+product.getCreationDt());
		System.out.println("input ProductStatus........."+product.getProductStatus());
		System.out.println("input NoOfProduct........."+product.getNoOfProducts());
		String filename=file.getOriginalFilename(); 
		System.out.println("input filename........."+filename);
		try {
			 image = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		product.setImage(image);
		product=service.addProduct(product);
		model.addAttribute("product", product);
		model.addAttribute("message", "Product Added successfully");
		model.addAttribute("filename", filename);
	return "adminHome";	
	}
	
	
	@RequestMapping("/changePassword")
	public String changePassword(Model model)
	{
	model.addAttribute("admin", admin);
	return "changePassword";	
	}
	
	
	@RequestMapping("/updatePassword")
	public String updatePassword(AdminModel admin,String npassword, Model model)
	{
	System.out.println("Admin userId ..."+admin.getUserId());	
	System.out.println("Admin password ..."+admin.getPassword());
	System.out.println("Admin npassword ..."+npassword);
	admin.setPassword(npassword);
	AdminModel adminModel=service.updateAdmin(admin);
	model.addAttribute("pmessage", "Password updated successfully");
	return "changePassword";	
	}
	
	
	    @GetMapping("/getUsers")
	    public String getUsers(Model model) {
	       
	    	System.out.println("getUsers...");
	        	List<User> userList = service.getUsers();
	        	model.addAttribute("users", userList);
	           return "searchUsers";
	    }
	    
	    
	    @GetMapping("/getUserOrders/{userId}")
	    public String getUserOrders(@PathVariable("userId") String userId, Model model) {
	       
	    	System.out.println("getUserOrder ..."+userId);
	        	List<OrderModel> orders = service.getUserOrders(userId);
	        	model.addAttribute("orders", orders);
	           return "userOrders";
	    }
	    
	    
	    @RequestMapping("/report")
		public String crearteReport(Model model,HttpSession session)
		{
		System.out.println("purchaseReport.......");
		
		AdminModel adminModel=(AdminModel) session.getAttribute("admin");
		if(adminModel !=null) {	
			model.addAttribute("admin", adminModel);
			model.addAttribute("product", product);
			model.addAttribute("order", order);
		return "report";	
		}else {
			return "login";	
			
		}
		}
		
		@RequestMapping("/showReport")
		public String showReport(OrderModel order,Model model,HttpSession session)
		{
		System.out.println("ShowReport.......");
		
		System.out.println("Order Purchase Date ..."+order.getCreationDt());	
		System.out.println("Order Dispatch Date  ..."+order.getDispatchDt());
		System.out.println("Order Status ..."+order.getOrdertStatus());
		System.out.println("Order Type ..."+order.getOrderType());
		List<OrderModel> orders = service.getReport(order.getCreationDt(), order.getDispatchDt(), order.getOrdertStatus(), order.getOrderType());
    	model.addAttribute("orders", orders);
		return "showReport";
		
		}

}
