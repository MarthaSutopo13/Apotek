package com.others;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.adapters.M_BarangAdapter;
import com.adapters.M_BrandAdapter;
import com.adapters.M_CustomerAdapter;
import com.adapters.M_KategoriAdapter;
import com.adapters.M_SatuanAdapter;
import com.adapters.M_SupplierAdapter;;

@Controller
public class BaseController extends RootBaseController{

	@Autowired
    protected M_SupplierAdapter supplierAdapter;
	@Autowired
    protected M_CustomerAdapter customerAdapter;
	@Autowired
    protected M_KategoriAdapter kategoriAdapter;
	@Autowired
    protected M_BrandAdapter brandAdapter;
	@Autowired
    protected M_SatuanAdapter satuanAdapter;
	@Autowired
    protected M_BarangAdapter barangAdapter;
	
//	protected TrackBW prepareTrackBW(String docNo,
//			UserAccess userAccess,
//			String moduleCode, 
//			String groupCompCode, 
//			String activity,
//			String reason) {
//		
//				int year = Calendar.getInstance().get(Calendar.YEAR);
//				int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
//				TrackBW track = new TrackBW();  
//				track.setDocNo(docNo);   
//				track.setDate_(new Date());   
//				track.setUsername(userAccess.getUser().getUsername()); 
//				track.setModuleCode(moduleCode);
//				track.setActivity(activity); 
//				track.setReason(reason);
//				track.setDelegatedBy(userAccess.getDelegatedBy());
//				track.setCancelled(0); 
//				track.setYearDocNo(year);
//				track.setMonthDocNo(month);
//				track.setGroupCompCode(groupCompCode); 
//				return track;
//			}
}
