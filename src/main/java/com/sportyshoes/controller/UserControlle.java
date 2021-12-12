package com.sportyshoes.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sportyshoes.model.AdminModel;
import com.sportyshoes.model.ProductInfo;
import com.sportyshoes.model.User;
import com.sportyshoes.service.SportyShoeService;



@Controller
@RequestMapping("/user")
public class UserControlle {
	
	private String npassword;
	private String rpassword;
	
	@Autowired
	User user;
	
	
	
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
	public String user(Model model,HttpSession session)
	{
	
	
	
	User user=(User) session.getAttribute("user");
	if(user !=null) {	
		model.addAttribute("user", user);
		return "redirect:/";
	}else {
		
		return "userLogin";	
		
	}	
	
	}
	
	@RequestMapping("/login")
	public String signin(Model model, String userId,HttpSession session)
	{
    System.out.println("UserId......."+userId);
	User user=service.getUser(userId);
	System.out.println("DB UserId......."+user.getUserId());
	if(user.getUserId() !=null) {
		System.out.println("DB UserId id Found......."+user.getUserId());
		session.setAttribute("user", user);
	}
	else {
		System.out.println("DB UserId id Not Found......."+user.getUserId());
	}
	model.addAttribute("user", user);
	return "redirect:../";
	}
	
	/*
	
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
	
	*/
	/*
	@RequestMapping("/updatePassword")
	public String updatePassword(AdminModel admin,String npassword, Model model)
	{
	System.out.println("Admin userId ..."+admin.getUserId());	
	System.out.println("Admin password ..."+admin.getPassword());
	System.out.println("Admin npassword ..."+npassword);
	admin.setPassword(npassword);
	service.updateAdmin(admin);
	return "admin/changePassword";	
	}*/

}
