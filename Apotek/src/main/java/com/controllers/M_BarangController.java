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

import com.entities.M_Barang;
import com.google.gson.Gson;
import com.others.BaseController;

@Controller
public class M_BarangController extends BaseController{
	
	@RequestMapping(value = "/Barang/KendoWindowBrowseBrand", method = {RequestMethod.GET})
	public String brandBrowse(	HttpServletRequest request,
											Model model, 
											RedirectAttributes ra) { 
		model.addAttribute("search", request.getParameter("search"));
		model.addAttribute("id_brand", request.getParameter("id_brand"));
		System.out.println("comp :"+request.getParameter("id_brand"));
		String id_brand = request.getParameter("id_brand");
		model.addAttribute("readUrl", "/Barang/KendoWindowDataBrowseBrand/?search="+request.getParameter("search")+"&id_brand="+request.getParameter("id_brand"));
		model.addAttribute("url", "/Apotek/Barang/KendoWindowBrowseBrand/?id_brand="+id_brand+"&search=");
		return "WindowBrowseBrand";
	}
	
	@RequestMapping(value = "/Barang/KendoWindowDataBrowseBrand", method = RequestMethod.GET)
	public @ResponseBody String brandBrowseWindow( 	HttpServletRequest request, 
														RedirectAttributes ra) {
	    Gson gson = new Gson();
	    String json = gson.toJson(brandAdapter.getWindowDataBrand(request.getParameter("search"))); 
	    System.out.println("json : "+ json);
        return json;  
    }
	
	@RequestMapping(value="/Barang/Browse",method = RequestMethod.GET)
	public String barangBrowse(Locale locale, Model model,HttpServletRequest request) throws ParseException {  
		String nama_barang = request.getParameter("nama_barang");
		if(nama_barang == null){
			model.addAttribute("barangList", barangAdapter.getAllBarang());
			return "Barang/Browse";
		}else{
			model.addAttribute("barangList", barangAdapter.getBarangByNamaBarang(nama_barang));
			return "Barang/Browse";
		}
	}
	
	@RequestMapping(value={"/Barang/Create","/Barang"},method = RequestMethod.GET)
	public String barangCreate(Locale locale, Model model,HttpServletRequest request,
							HttpSession session) throws ParseException{  
		
		model.addAttribute("error2", request.getParameter("error2")); 
		model.addAttribute("error3", request.getParameter("error3")); 
		model.addAttribute("action", "/Apotek/Barang/Create/Action");
		return "Barang/Create";
	}
	
	@RequestMapping(value="/Barang/Create/Action",method = RequestMethod.POST)
	public String barangCreateAction	(	Model model, RedirectAttributes redirect, 
							HttpServletRequest request, 
							@ModelAttribute("barang") M_Barang bar, 
							BindingResult result) throws ParseException{
			
		Integer flag3 = 0; 
		Integer flag = 0;
		Boolean flag2 = false;
		
		String nama_barang = request.getParameter("nama_barang");
		String id_satuan = request.getParameter("id_satuan");
		Integer total_jumlah = Integer.parseInt(request.getParameter("total_jumlah"));
		Integer harga_jual1 = Integer.parseInt(request.getParameter("harga_jual1"));
		Integer harga_jual2 = Integer.parseInt(request.getParameter("harga_jual2"));
		String id_brand = request.getParameter("id_brand");
		String id_kategori = request.getParameter("id_kategori");
		Integer harga_beli = Integer.parseInt(request.getParameter("harga_beli"));
		
		
		if(nama_barang != "" && harga_jual1 != 0 && harga_jual2 != 0){ 
			for(int i=0;i<10;i++){
				String nama_detail_barang = request.getParameter("nama_detail_barang_"+i);   
				Integer jumlah = Integer.parseInt(request.getParameter("jumlah_"+i));
				String kadaluarsa = request.getParameter("kadaluarsa_"+i);
				
				bar.setNama_barang(nama_barang); 
				bar.setNama_detail_barang(nama_detail_barang);
				bar.setJumlah(jumlah);
				bar.setKadaluarsa(kadaluarsa);
				bar.setId_satuan(id_satuan);
				bar.setTotal_jumlah(total_jumlah);
				bar.setHarga_jual1(harga_jual1);
				bar.setHarga_jual2(harga_jual2);
				bar.setId_brand(id_brand);
				bar.setId_kategori(id_kategori);
				bar.setHarga_beli(harga_beli);
				barangAdapter.addObject(bar);
				
				flag3++;
			}
		}else{
			flag ++;
		}
		
		if(!flag2){
			flag2 = true;
		}
			
		if(flag > 0){
			return "redirect:/Barang/Create/?error3= TERDAPAT "+flag3+" DATA BERHASIL DAN "+ flag +" ERROR KARENA DATA SUDAH ADA DI DATABASE";
		}else{
			if(flag2) return "redirect:/Barang/Create/?error2= INPUT SUKSES!";
			else return "redirect:/Barang/Create/?error3= Nama Barang/Hasil Jumlah/Konversi Ke Tidak Boleh Kosong!";
		}
	}
	
//	@RequestMapping(value={"/Barang/Update"},method = RequestMethod.GET)
//	public String barangUpdate(Locale locale, Model model,HttpServletRequest request,
//							HttpSession session) throws ParseException{  
//			List<M_Barang> sa = barangAdapter.getBarangByIdBarang(request.getParameter("id_barang"));
//
//			String nama_barang = sa.get(0).getNama_barang();
//			Integer hasil_jumlah_konversi = sa.get(0).getHasil_jumlah_konversi();
//			String konversi_ke = sa.get(0).getKonversi_ke();
//			
//			model.addAttribute("nama_barang",nama_barang);
//			model.addAttribute("hasil_jumlah_konversi", hasil_jumlah_konversi);
//			model.addAttribute("konversi_ke",konversi_ke);
//			model.addAttribute("error2", request.getParameter("error2")); 
//			model.addAttribute("error3", request.getParameter("error3")); 
//			model.addAttribute("action", "/Apotek/Barang/Update/Action");
//			
//			return "Barang/Edit";
//	}
//	
//	@RequestMapping(value = {"/Barang/Update/Action"}, method = RequestMethod.POST)
//	public String barangUpdateAction(Model model, RedirectAttributes redirect, 
//									HttpServletRequest request,  
//									@ModelAttribute("barang") M_Barang barang, 
//									BindingResult result)throws ParseException{
//		
//		List<M_Barang> barangList = barangAdapter.getBarangByIdBarang(request.getParameter("id_barang"));
//		M_Barang sat = barangList.get(0);
//		
//		sat.setNama_barang(barang.getNama_barang());
//		sat.setHasil_jumlah_konversi(barang.getHasil_jumlah_konversi());
//		sat.setKonversi_ke(barang.getKonversi_ke());
//		barangAdapter.updateObject(sat);
//		
//		return "redirect:/Barang/Create/?error2= UPDATE SUKSES!";
//	}
//	
//	@RequestMapping(value = {"/Barang/Delete"}, method = RequestMethod.GET)
//	public String barangDelete(HttpServletRequest request, ModelMap model,RedirectAttributes redirect){
//		
//		barangAdapter.deleteByIdBarang(request.getParameter("id_barang"));
//		model.addAttribute("barangList", barangAdapter.getAllBarang());
//		model.addAttribute("error2","SUKSES MENGHAPUS");
//		
//		return "Barang/Browse"; 
//	}
	
}
