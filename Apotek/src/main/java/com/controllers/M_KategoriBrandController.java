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

import com.entities.M_Brand;
import com.entities.M_Kategori;
import com.others.BaseController;

@Controller
public class M_KategoriBrandController extends BaseController{
	
	@RequestMapping(value="/KategoriBrand/BrowseBrand",method = RequestMethod.GET)
	public String brandBrowse(Locale locale, Model model,HttpServletRequest request) throws ParseException {  
		String nama_brand = request.getParameter("nama_brand");
		if(nama_brand == null){
			model.addAttribute("brandList", brandAdapter.getAllBrand());
			return "Brand/Browse";
		}else{
			model.addAttribute("brandList", brandAdapter.getBrandByNamaBrand(nama_brand));
			return "Brand/Browse";
		}
	}
	
	@RequestMapping(value="/KategoriBrand/BrowseKategori",method = RequestMethod.GET)
	public String kategoriBrowse(Locale locale, Model model,HttpServletRequest request) throws ParseException {  
		String nama_kategori = request.getParameter("nama_kategori");
		if(nama_kategori == null){
			model.addAttribute("kategoriList", kategoriAdapter.getAllKategori());
			return "Kategori/Browse";
		}else{
			model.addAttribute("kategoriList", kategoriAdapter.getKategoriByNamaKategori(nama_kategori));
			return "Kategori/Browse";
		}
	}
	
	@RequestMapping(value={"/KategoriBrand/Create","/KategoriBrand"},method = RequestMethod.GET)
	public String customerCreate(Locale locale, Model model,HttpServletRequest request,
							HttpSession session) throws ParseException{  
		
		model.addAttribute("error2", request.getParameter("error2")); 
		model.addAttribute("error3", request.getParameter("error3")); 
		model.addAttribute("action", "/Apotek/KategoriBrand/Create/Action");
		return "KategoriBrand/Create";
	}
	
	@RequestMapping(value="/KategoriBrand/Create/Action",method = RequestMethod.POST)
	public String kategoribrandCreateAction	(	Model model, RedirectAttributes redirect, 
							HttpServletRequest request, 
							@ModelAttribute("kategoribrand") M_Kategori kat, 
							BindingResult result) throws ParseException{
			
		Integer flag3 = 0; 
		Integer flag = 0;
		Boolean flag2 = false;
		
		String nama_kategori = request.getParameter("nama_kategori");   
		String nama_brand = request.getParameter("nama_brand");
		
		System.out.println("aaa : "+nama_kategori + " : " + nama_brand);
		
		M_Brand brand = new M_Brand();
		
		if(nama_kategori != "" && nama_brand == ""){    
			kat.setNama_kategori(nama_kategori);
			kategoriAdapter.addObject(kat);
			
			flag3++;
		}else if(nama_brand != "" && nama_kategori == ""){
			brand.setNama_brand(nama_brand);
			brandAdapter.addObject(brand);
			
			flag3++;
		}else{
			flag ++;
		}
		
		if(!flag2){
			flag2 = true;
		}
			
		if(flag > 0){
			return "redirect:/KategoriBrand/Create/?error3= TERDAPAT "+flag3+" DATA BERHASIL DAN "+ flag +" ERROR KARENA DATA SUDAH ADA DI DATABASE";
		}else{
			if(flag2) return "redirect:/KategoriBrand/Create/?error2= INPUT SUKSES!";
			else return "redirect:/KategoriBrand/Create/?error3= Nama Kategori Tidak Boleh Kosong!";
		}
	}
	
	@RequestMapping(value={"/KategoriBrand/Update"},method = RequestMethod.GET)
	public String kategoribrandUpdate(Locale locale, Model model,HttpServletRequest request,
							HttpSession session) throws ParseException{  
		
		if(request.getParameter("id_kategori") != "" && request.getParameter("id_brand") == ""){
			List<M_Kategori> kat = kategoriAdapter.getKategoriByIdKategori(request.getParameter("id_kategori"));
			
			String nama_kategori = kat.get(0).getNama_kategori();
			model.addAttribute("nama_kategori",nama_kategori);
		}else if(request.getParameter("id_brand") !="" && request.getParameter("id_kategori") == ""){
			List<M_Brand> brand = brandAdapter.getBrandByIdBrand(request.getParameter("id_brand"));
						
			String nama_brand = brand.get(0).getNama_brand();			
			model.addAttribute("nama_brand",nama_brand);
		}
			
			model.addAttribute("error2", request.getParameter("error2")); 
			model.addAttribute("error3", request.getParameter("error3")); 
			model.addAttribute("action", "/Apotek/KategoriBrand/Update/Action");
			
			return "KategoriBrand/Edit";
	}
	
	@RequestMapping(value = {"/KategoriBrand/Update/Action"}, method = RequestMethod.POST)
	public String kategoribrandUpdateAction(Model model, RedirectAttributes redirect, 
									HttpServletRequest request,  
									@ModelAttribute("kategoribrand") M_Kategori kategori, 
									BindingResult result)throws ParseException{
		
		String id_kategori = request.getParameter("id_kategori");
		String id_brand = request.getParameter("id_brand");
		
		System.out.println("id : "+id_kategori + " : " + id_brand);
		
				
		
		if(!id_kategori.equals("")){
			List<M_Kategori> kategoriList = kategoriAdapter.getKategoriByIdKategori(id_kategori);
			M_Kategori kat = kategoriList.get(0);
			
			System.out.println("kat : "+kat);
			
			kat.setNama_kategori(kategori.getNama_kategori());
			kategoriAdapter.updateObject(kat);
		}else if(!id_brand.equals("")){
			List<M_Brand> brandList = brandAdapter.getBrandByIdBrand(id_brand);
			M_Brand brand = brandList.get(0);
			
			System.out.println("bran : "+brand.getNama_brand());
			
			brand.setNama_brand(request.getParameter("nama_brand"));
			brandAdapter.updateObject(brand);
		}
		
		return "redirect:/KategoriBrand/Create/?error2= UPDATE SUKSES!";
	}
	
	@RequestMapping(value = {"/KategoriBrand/Delete"}, method = RequestMethod.GET)
	public String kategoribrandDelete(HttpServletRequest request, ModelMap model,RedirectAttributes redirect){
		
		String id_kategori = request.getParameter("id_kategori");
		String id_brand = request.getParameter("id_brand");
		
		System.out.println("kka : "+id_kategori + " : " + id_brand);
		
		if(id_kategori != "" && id_brand == ""){
			kategoriAdapter.deleteByIdKategori(id_kategori);
			model.addAttribute("kategoriList", kategoriAdapter.getAllKategori());
			model.addAttribute("error2","SUKSES MENGHAPUS");
			
			return "Kategori/Browse"; 
		}else if(id_brand != "" && id_kategori == ""){
			brandAdapter.deleteByIdBrand(id_brand);
			model.addAttribute("brandList", brandAdapter.getAllBrand());
			model.addAttribute("error2","SUKSES MENGHAPUS");
			
			return "Brand/Browse"; 
		}
		
		return "redirect:/";
	}
	
}
