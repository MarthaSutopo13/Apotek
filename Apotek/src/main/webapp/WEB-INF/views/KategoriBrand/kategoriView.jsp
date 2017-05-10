<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<script>
function editdoc(e){
	var action = e.id.split("_")[0];
	var id_kategori = e.id.split("_")[1];
	
	window.location="/Apotek/KategoriBrand/"+action+"/?id_kategori="+id_kategori+"&id_brand=";
	
}
</script>
<form:form method="GET" action="/Apotek/KategoriBrand/BrowseKategori">
<fieldset>
<legend>Data Kategori</legend>
		<div align="center">
					<table>
						<tr>
							<td>Cari : <input class="k-textbox" name="nama_kategori" placeholder="Cari"/></td>   
							<td>  
							<a href="/Apotek/KategoriBrand/BrowseKategori">  
								<input class="k-button" type="submit" value="Search"/>
							</a>
							<a href="/Apotek/KategoriBrand/BrowseKategori">  
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
            <kendo:grid-column title="ID Kategori" field="id_kategori" width="50px"/>
            <kendo:grid-column title="Nama Kategori" field="nama_kategori" width="100px"/>
            <kendo:grid-column title="Edit" field="" width="100px" template="<input id='Update_#=id_kategori#' type='button' onclick='editdoc(this)' value='Update' class='k-button'/><input id='Delete_#=id_kategori#' type='button' onclick='editdoc(this)' value='Delete' class='k-button'/>"/>    
        </kendo:grid-columns>
        <kendo:dataSource data="${kategoriList}" pageSize="10">        
        </kendo:dataSource>
       <kendo:grid-pageable input="true" numeric="false" />
    </kendo:grid>