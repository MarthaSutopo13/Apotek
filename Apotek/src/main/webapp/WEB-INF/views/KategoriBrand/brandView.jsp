<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<script>
function editdoc(e){
	var action = e.id.split("_")[0];
	var id_brand = e.id.split("_")[1];
	
	window.location="/Apotek/KategoriBrand/"+action+"/?id_brand="+id_brand+"&id_kategori=";
	
}
</script>
<form:form method="GET" action="/Apotek/KategoriBrand/BrowseBrand">
<fieldset>
<legend>Data Brand</legend>
		<div align="center">
					<table>
						<tr>
							<td>Cari : <input class="k-textbox" name="nama_brand" placeholder="Cari"/></td>   
							<td>  
							<a href="/Apotek/KategoriBrand/BrowseBrand">  
								<input class="k-button" type="submit" value="Search"/>
							</a>
							<a href="/Apotek/KategoriBrand/BrowseBrand">  
							<input class="k-button" type="button" value="Refresh"/>
							</a> 
							<a href="/Apotek/KategoriBrand/Create">
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
            <kendo:grid-column title="ID Brand" field="id_brand" width="50px"/>
            <kendo:grid-column title="Nama Brand" field="nama_brand" width="100px"/>
            <kendo:grid-column title="Edit" field="" width="100px" template="<input id='Update_#=id_brand#' type='button' onclick='editdoc(this)' value='Update' class='k-button'/><input id='Delete_#=id_brand#' type='button' onclick='editdoc(this)' value='Delete' class='k-button'/>"/>    
        </kendo:grid-columns>
        <kendo:dataSource data="${brandList}" pageSize="10">        
        </kendo:dataSource>
       <kendo:grid-pageable input="true" numeric="false" />
    </kendo:grid>