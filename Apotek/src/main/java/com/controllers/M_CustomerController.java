package com.controllers;

import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entities.M_Customer;
import com.others.BaseController;

@Controller
public class M_CustomerController extends BaseController{
	
	@RequestMapping(value="/Customer/Browse",method = RequestMethod.GET)
	public String customerBrowse(Locale locale, Model model,HttpServletRequest request) throws ParseException {  
		String nama_customer = request.getParameter("nama_customer");
		if(nama_customer == null){
			model.addAttribute("customerList", customerAdapter.getAllCustomer());
			return "Customer/Browse";
		}else{
			model.addAttribute("supplierList", customerAdapter.getCustomerByNamaCustomer(nama_customer));
			return "Customer/Browse";
		}
	}
	
	@RequestMapping(value={"/Customer/Create","/Customer"},method = RequestMethod.GET)
	public String customerCreate(Locale locale, Model model,HttpServletRequest request,
							HttpSession session) throws ParseException{  
		
		model.addAttribute("error2", request.getParameter("error2")); 
		model.addAttribute("error3", request.getParameter("error3")); 
		model.addAttribute("action", "/Apotek/Customer/Create/Action");
		return "Customer/Create";
	}
	
	@RequestMapping(value="/Customer/Create/Action",method = RequestMethod.POST)
	public String customerCreateAction	(	Model model, RedirectAttributes redirect, 
							HttpServletRequest request, 
							@ModelAttribute("customer") M_Customer cus, 
							BindingResult result) throws ParseException{
			
		Integer flag3 = 0; 
		Integer flag = 0;
		Boolean flag2 = false;
		
		String nama_customer = request.getParameter("nama_customer");   
		String alamat = request.getParameter("alamat");   
		String email = request.getParameter("email");   
		String no_telp = request.getParameter("no_telp");   
		String keterangan = request.getParameter("keterangan");   
		
		System.out.println("nama supplier : "+alamat);
		
		if(nama_customer != "" && alamat != "" && email != "" && no_telp != ""){    
			cus.setNama_customer(nama_customer); 
			cus.setAlamat(alamat);;
			cus.setNo_telp(no_telp);;
			cus.setKeterangan(keterangan);
			customerAdapter.addObject(cus);
			
			flag3++;
		}else{
			flag ++;
		}
		
		if(!flag2){
			flag2 = true;
		}
			
		if(flag > 0){
			return "redirect:/Customer/Create/?error3= TERDAPAT "+flag3+" DATA BERHASIL DAN "+ flag +" ERROR KARENA DATA SUDAH ADA DI DATABASE";
		}else{
			if(flag2) return "redirect:/Customer/Create/?error2= INPUT SUKSES!";
			else return "redirect:/Customer/Create/?error3= Nama Customer/Alamat/Email/No Telp Tidak Boleh Kosong!";
		}
	}
	
	@RequestMapping(value={"/Customer/Update"},method = RequestMethod.GET)
	public String customerUpdate(Locale locale, Model model,HttpServletRequest request,
							HttpSession session) throws ParseException{  
			List<M_Customer> cu = customerAdapter.getCustomerByIdCustomer(request.getParameter("id_customer"));

			String nama_customer = cu.get(0).getNama_customer();
			String alamat = cu.get(0).getAlamat();
			String email = cu.get(0).getEmail();
			String no_telp = cu.get(0).getNo_telp();
			String keterangan = cu.get(0).getKeterangan();
			
			model.addAttribute("nama_customer",nama_customer);
			model.addAttribute("alamat", alamat);
			model.addAttribute("email",email);
			model.addAttribute("no_telp",no_telp);
			model.addAttribute("keterangan", keterangan);
			model.addAttribute("error2", request.getParameter("error2")); 
			model.addAttribute("error3", request.getParameter("error3")); 
			model.addAttribute("action", "/Apotek/Customer/Update/Action");
			
			return "Customer/Edit";
	}
	
	@RequestMapping(value = {"/Customer/Update/Action"}, method = RequestMethod.POST)
	public String customerUpdateAction(Model model, RedirectAttributes redirect, 
									HttpServletRequest request,  
									@ModelAttribute("customer") M_Customer customer, 
									BindingResult result)throws ParseException{
		
		List<M_Customer> customerList = customerAdapter.getCustomerByIdCustomer(request.getParameter("id_customer"));
		M_Customer cus = customerList.get(0);
		
		cus.setNama_customer(customer.getNama_customer());
		cus.setAlamat(customer.getAlamat());
		cus.setEmail(customer.getEmail());
		cus.setNo_telp(customer.getNo_telp());
		cus.setKeterangan(customer.getKeterangan());
		customerAdapter.updateObject(cus);
		
		return "redirect:/Customer/Create/?error2= UPDATE SUKSES!";
	}
	
	@RequestMapping(value = {"/Customer/Delete"}, method = RequestMethod.GET)
	public String customerDelete(HttpServletRequest request, ModelMap model,RedirectAttributes redirect){
		
		customerAdapter.deleteByIdCustomer(request.getParameter("id_customer"));
		model.addAttribute("customerList", customerAdapter.getAllCustomer());
		model.addAttribute("error2","SUKSES MENGHAPUS");
		
		return "Customer/Browse"; 
	}
	
}
