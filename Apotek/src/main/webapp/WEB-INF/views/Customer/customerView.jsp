<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<script>
function editdoc(e){
	var action = e.id.split("_")[0];
	var id_customer = e.id.split("_")[1];
	
	window.location="/Apotek/Customer/"+action+"/?id_customer="+id_customer;
	
}
</script>
<form:form method="GET" commandName="SaTar" action="/Apotek/Customer/Browse">
<fieldset>
<legend>Data Customer</legend>
		<div align="center">
					<table>
						<tr>
							<td>Cari : <input class="k-textbox" name="nama_customer" placeholder="Cari"/></td>   
							<td>  
							<a href="/Apotek/Customer/Browse">  
								<input class="k-button" type="submit" value="Search"/>
							</a>
							<a href="/Apotek/Customer/Browse">  
							<input class="k-button" type="button" value="Refresh"/>
							</a> 
							<a href="/Apotek/Customer/Create">
								<input class="k-button" type="button" value="Create"/> 
							</a>
<%-- 							<c:if test="${user == 'ADM'}"> --%>
<!-- 							<a href="/Apotek/Supplier/Log">   -->
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
            <kendo:grid-column title="ID Customer" field="id_customer" width="50px"/>
            <kendo:grid-column title="Nama Customer" field="nama_customer" width="100px"/>
            <kendo:grid-column title="Alamat" field="alamat" width="130px"/>
            <kendo:grid-column title="Email"  field="email" width="80px"/>
            <kendo:grid-column title="No Telp" field="no_telp" width="80px"/>
            <kendo:grid-column title="Keterangan" field="keterangan" width="100px"/>
            <kendo:grid-column title="Edit" field="" width="100px" template="<input id='Update_#=id_customer#' type='button' onclick='editdoc(this)' value='Update' class='k-button'/><input id='Delete_#=id_customer#' type='button' onclick='editdoc(this)' value='Delete' class='k-button'/>"/>    
        </kendo:grid-columns>
        <kendo:dataSource data="${customerList}" pageSize="10">        
        </kendo:dataSource>
       <kendo:grid-pageable input="true" numeric="false" />
    </kendo:grid>