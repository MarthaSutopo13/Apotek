<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
	
<form:form method="POST" id="formEdit" action="${action}">
<div class="error"><c:out value="${error}"/></div>
<div align="center" style="color: green;"><c:out value="${error2}"> </c:out></div>
<div align="center" style="color: red;"><c:out value="${error3}"> </c:out></div>
	<fieldset>
		<legend>Input Data Kategori</legend>
		
		<table>
			<tr>
				<td>Nama Kategori : </td>
				<td><input class="k-textbox" id="nama_kategori" name="nama_kategori" placeholder="Nama Kategori" style="width:200px"></td>
			</tr>
		</table>
		
		<br>
		<input id="btnSub" class="k-button" value="Simpan" style='width:100px;height:30px;'>
		<a href="/Apotek/KategoriBrand/BrowseKategori"> 
			<input class="k-button" value="Lihat Data" style='width:100px;height:30px;'>
		</a>
		
	</fieldset>
	
	<br>
	
	<fieldset>
		<legend>Input Data Brand</legend>
		
		<table>
			<tr>
				<td>Nama Brand : </td>
				<td><input class="k-textbox" id="nama_brand" name="nama_brand" placeholder="Nama Brand" style="width:200px"></td>
			</tr>
		</table>
		
		<br>
		<input id="btnSub1" class="k-button" value="Simpan" style='width:100px;height:30px;'>
		<a href="/Apotek/KategoriBrand/BrowseBrand"> 
			<input class="k-button" value="Lihat Data" style='width:100px;height:30px;'>
		</a>
		
	</fieldset>

</form:form>

<script type="text/javascript">

$(document).ready(function() {  
	
	$("#btnSub").click(function(){
// 	 	var x = $("#gridSa").data().kendoGrid.dataSource.view(); 
// 		var json = JSON.stringify(x);
// 		$("#jsonDoc").val(json);	 
		$("#formEdit").submit();   
	});
	
	$("#btnSub1").click(function(){
// 	 	var x = $("#gridSa").data().kendoGrid.dataSource.view(); 
// 		var json = JSON.stringify(x);
// 		$("#jsonDoc").val(json);	 
		$("#formEdit").submit();   
	});
	
});

</script>
