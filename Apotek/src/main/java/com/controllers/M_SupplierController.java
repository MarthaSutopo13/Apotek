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

import com.entities.M_Supplier;
import com.others.BaseController;

@Controller
public class M_SupplierController extends BaseController{
	
	@RequestMapping(value="/Supplier/Browse",method = RequestMethod.GET)
	public String supplierBrowse(Locale locale, Model model,HttpServletRequest request) throws ParseException {  
		String nama_supplier = request.getParameter("nama_supplier");
		if(nama_supplier == null){
			model.addAttribute("supplierList", supplierAdapter.getAllSupplier());
			return "Supplier/Browse";
		}else{
			model.addAttribute("supplierList", supplierAdapter.getSupplierByNamaSupplier(nama_supplier));
			return "Supplier/Browse";
		}
	}
	
	@RequestMapping(value={"/Supplier/Create","/Supplier"},method = RequestMethod.GET)
	public String supplierCreate(Locale locale, Model model,HttpServletRequest request,
							HttpSession session) throws ParseException{  
		
		model.addAttribute("error2", request.getParameter("error2")); 
		model.addAttribute("error3", request.getParameter("error3")); 
		model.addAttribute("action", "/Apotek/Supplier/Create/Action");
		return "Supplier/Create";
	}
	
	@RequestMapping(value="/Supplier/Create/Action",method = RequestMethod.POST)
	public String supplierCreateAction	(	Model model, RedirectAttributes redirect, 
							HttpServletRequest request, 
							@ModelAttribute("supplier") M_Supplier sup, 
							BindingResult result) throws ParseException{
			
		Integer flag3 = 0; 
		Integer flag = 0;
		Boolean flag2 = false;
		
		String nama_supplier = request.getParameter("nama_supplier");   
		String alamat = request.getParameter("alamat");   
		String email = request.getParameter("email");   
		String no_telp = request.getParameter("no_telp");   
		String keterangan = request.getParameter("keterangan");   
		
		System.out.println("nama supplier : "+alamat);
		
		if(nama_supplier != "" && alamat != "" && email != "" && no_telp != ""){    
			sup.setNama_supplier(nama_supplier); 
			sup.setAlamat(alamat);;
			sup.setNo_telp(no_telp);;
			sup.setKeterangan(keterangan);
			supplierAdapter.addObject(sup);
			
			flag3++;
		}else{
			flag ++;
		}
		
		if(!flag2){
			flag2 = true;
		}
			
		if(flag > 0){
			return "redirect:/Supplier/Create/?error3= TERDAPAT "+flag3+" DATA BERHASIL DAN "+ flag +" ERROR KARENA DATA SUDAH ADA DI DATABASE";
		}else{
			if(flag2) return "redirect:/Supplier/Create/?error2= INPUT SUKSES!";
			else return "redirect:/Supplier/Create/?error3= Nama Supplier/Alamat/Email/No Telp Tidak Boleh Kosong!";
		}
	}
	
	@RequestMapping(value={"/Supplier/Update"},method = RequestMethod.GET)
	public String supplierUpdate(Locale locale, Model model,HttpServletRequest request,
							HttpSession session) throws ParseException{  
			List<M_Supplier> su = supplierAdapter.getSupplierByIdSupplier(request.getParameter("id_supplier"));

			String nama_supplier = su.get(0).getNama_supplier();
			String alamat = su.get(0).getAlamat();
			String email = su.get(0).getEmail();
			String no_telp = su.get(0).getNo_telp();
			String keterangan = su.get(0).getKeterangan();
			
			model.addAttribute("nama_supplier",nama_supplier);
			model.addAttribute("alamat", alamat);
			model.addAttribute("email",email);
			model.addAttribute("no_telp",no_telp);
			model.addAttribute("keterangan", keterangan);
			model.addAttribute("error2", request.getParameter("error2")); 
			model.addAttribute("error3", request.getParameter("error3")); 
			model.addAttribute("action", "/Apotek/Supplier/Update/Action");
			
			return "Supplier/Edit";
	}
	
	@RequestMapping(value = {"/Supplier/Update/Action"}, method = RequestMethod.POST)
	public String supplierUpdateAction(Model model, RedirectAttributes redirect, 
									HttpServletRequest request,  
									@ModelAttribute("supplier") M_Supplier supplier, 
									BindingResult result)throws ParseException{
		
		List<M_Supplier> supplierList = supplierAdapter.getSupplierByIdSupplier(request.getParameter("id_supplier"));
		M_Supplier sup = supplierList.get(0);
		
		sup.setNama_supplier(supplier.getNama_supplier());
		sup.setAlamat(supplier.getAlamat());
		sup.setEmail(supplier.getEmail());
		sup.setNo_telp(supplier.getNo_telp());
		sup.setKeterangan(supplier.getKeterangan());
		supplierAdapter.updateObject(sup);
		
		return "redirect:/Supplier/Create/?error2= UPDATE SUKSES!";
	}
	
	@RequestMapping(value = {"/Supplier/Delete"}, method = RequestMethod.GET)
	public String supplierDelete(HttpServletRequest request, ModelMap model,RedirectAttributes redirect){
		
		supplierAdapter.deleteByIdSupplier(request.getParameter("id_supplier"));
		model.addAttribute("supplierList", supplierAdapter.getAllSupplier());
		model.addAttribute("error2","SUKSES MENGHAPUS");
		
		return "Supplier/Browse"; 
	}
	
}
