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

import com.entities.M_Satuan;
import com.others.BaseController;

@Controller
public class M_SatuanController extends BaseController{
	
	@RequestMapping(value="/Satuan/Browse",method = RequestMethod.GET)
	public String satuanBrowse(Locale locale, Model model,HttpServletRequest request) throws ParseException {  
		String nama_satuan = request.getParameter("nama_satuan");
		if(nama_satuan == null){
			model.addAttribute("satuanList", satuanAdapter.getAllSatuan());
			return "Satuan/Browse";
		}else{
			model.addAttribute("satuanList", satuanAdapter.getSatuanByNamaSatuan(nama_satuan));
			return "Satuan/Browse";
		}
	}
	
	@RequestMapping(value={"/Satuan/Create","/Satuan"},method = RequestMethod.GET)
	public String satuanCreate(Locale locale, Model model,HttpServletRequest request,
							HttpSession session) throws ParseException{  
		
		model.addAttribute("error2", request.getParameter("error2")); 
		model.addAttribute("error3", request.getParameter("error3")); 
		model.addAttribute("action", "/Apotek/Satuan/Create/Action");
		return "Satuan/Create";
	}
	
	@RequestMapping(value="/Satuan/Create/Action",method = RequestMethod.POST)
	public String satuanCreateAction	(	Model model, RedirectAttributes redirect, 
							HttpServletRequest request, 
							@ModelAttribute("satuan") M_Satuan sat, 
							BindingResult result) throws ParseException{
			
		Integer flag3 = 0; 
		Integer flag = 0;
		Boolean flag2 = false;
		
		String nama_satuan = request.getParameter("nama_satuan");   
		Integer hasil_jumlah_konversi = Integer.parseInt(request.getParameter("hasil_jumlah_konversi")) ;   
		String konversi_ke = request.getParameter("konversi_ke");  
		
		
		if(nama_satuan != "" && hasil_jumlah_konversi != 0 && konversi_ke != ""){    
			sat.setNama_satuan(nama_satuan); 
			sat.setHasil_jumlah_konversi(hasil_jumlah_konversi);
			sat.setKonversi_ke(konversi_ke);
			satuanAdapter.addObject(sat);
			
			flag3++;
		}else{
			flag ++;
		}
		
		if(!flag2){
			flag2 = true;
		}
			
		if(flag > 0){
			return "redirect:/Satuan/Create/?error3= TERDAPAT "+flag3+" DATA BERHASIL DAN "+ flag +" ERROR KARENA DATA SUDAH ADA DI DATABASE";
		}else{
			if(flag2) return "redirect:/Satuan/Create/?error2= INPUT SUKSES!";
			else return "redirect:/Satuan/Create/?error3= Nama Satuan/Hasil Jumlah/Konversi Ke Tidak Boleh Kosong!";
		}
	}
	
	@RequestMapping(value={"/Satuan/Update"},method = RequestMethod.GET)
	public String satuanUpdate(Locale locale, Model model,HttpServletRequest request,
							HttpSession session) throws ParseException{  
			List<M_Satuan> sa = satuanAdapter.getSatuanByIdSatuan(request.getParameter("id_satuan"));

			String nama_satuan = sa.get(0).getNama_satuan();
			Integer hasil_jumlah_konversi = sa.get(0).getHasil_jumlah_konversi();
			String konversi_ke = sa.get(0).getKonversi_ke();
			
			model.addAttribute("nama_satuan",nama_satuan);
			model.addAttribute("hasil_jumlah_konversi", hasil_jumlah_konversi);
			model.addAttribute("konversi_ke",konversi_ke);
			model.addAttribute("error2", request.getParameter("error2")); 
			model.addAttribute("error3", request.getParameter("error3")); 
			model.addAttribute("action", "/Apotek/Satuan/Update/Action");
			
			return "Satuan/Edit";
	}
	
	@RequestMapping(value = {"/Satuan/Update/Action"}, method = RequestMethod.POST)
	public String satuanUpdateAction(Model model, RedirectAttributes redirect, 
									HttpServletRequest request,  
									@ModelAttribute("satuan") M_Satuan satuan, 
									BindingResult result)throws ParseException{
		
		List<M_Satuan> satuanList = satuanAdapter.getSatuanByIdSatuan(request.getParameter("id_satuan"));
		M_Satuan sat = satuanList.get(0);
		
		sat.setNama_satuan(satuan.getNama_satuan());
		sat.setHasil_jumlah_konversi(satuan.getHasil_jumlah_konversi());
		sat.setKonversi_ke(satuan.getKonversi_ke());
		satuanAdapter.updateObject(sat);
		
		return "redirect:/Satuan/Create/?error2= UPDATE SUKSES!";
	}
	
	@RequestMapping(value = {"/Satuan/Delete"}, method = RequestMethod.GET)
	public String satuanDelete(HttpServletRequest request, ModelMap model,RedirectAttributes redirect){
		
		satuanAdapter.deleteByIdSatuan(request.getParameter("id_satuan"));
		model.addAttribute("satuanList", satuanAdapter.getAllSatuan());
		model.addAttribute("error2","SUKSES MENGHAPUS");
		
		return "Satuan/Browse"; 
	}
	
}
