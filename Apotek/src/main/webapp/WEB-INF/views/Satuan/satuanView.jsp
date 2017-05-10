<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<script>
function editdoc(e){
	var action = e.id.split("_")[0];
	var id_satuan = e.id.split("_")[1];
	
	window.location="/Apotek/Satuan/"+action+"/?id_satuan="+id_satuan;
	
}
</script>
<form:form method="GET" action="/Apotek/Satuan/Browse">
<fieldset>
<legend>Data Satuan</legend>
		<div align="center">
					<table>
						<tr>
							<td>Cari : <input class="k-textbox" name="nama_satuan" placeholder="Cari"/></td>   
							<td>  
							<a href="/Apotek/Satuan/Browse">  
								<input class="k-button" type="submit" value="Search"/>
							</a>
							<a href="/Apotek/Satuan/Browse">  
							<input class="k-button" type="button" value="Refresh"/>
							</a> 
							<a href="/Apotek/Satuan/Create">
								<input class="k-button" type="button" value="Create"/> 
							</a>
<%-- 							<c:if test="${user == 'ADM'}"> --%>
<!-- 							<a href="/Apotek/Satuan/Log">   -->
<!-- 							<input class="k-button" type="button" value="Data Log"/> -->
<!-- 							</a> -->
<%-- 							</c:if> --%>
							</td>
						</tr>
						<tr>
							
						</tr>
					</table>
			</div>
			</fieldset>
			</form:form>


<div align="center" style="color: green;"><c:out value="${error2}"> </c:out></div> 
 <div align="center" style="color: red;"><c:out value="${error3}"> </c:out></div>   

<br></br>
	 <kendo:grid name="grid" pageable="true" sortable="true" filterable="true" scrollable="true" resizable="enable">
    	<kendo:grid-scrollable />    	
        <kendo:grid-columns> 
            <kendo:grid-column title="ID Satuan" field="id_satuan" width="50px"/>
            <kendo:grid-column title="Nama Satuan" field="nama_satuan" width="100px"/>
            <kendo:grid-column title="Hasil Jumlah" field="hasil_jumlah" width="130px"/>
            <kendo:grid-column title="Konversi Ke"  field="konversi_ke" width="80px"/>
            <kendo:grid-column title="Edit" field="" width="100px" template="<input id='Update_#=id_satuan#' type='button' onclick='editdoc(this)' value='Update' class='k-button'/><input id='Delete_#=id_satuan#' type='button' onclick='editdoc(this)' value='Delete' class='k-button'/>"/>    
        </kendo:grid-columns>
        <kendo:dataSource data="${satuanList}" pageSize="10">        
        </kendo:dataSource>
       <kendo:grid-pageable input="true" numeric="false" />
    </kendo:grid>