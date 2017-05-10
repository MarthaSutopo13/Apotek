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
		<legend>Input Data Satuan</legend>
		
		<table>
			<tr>
				<td>Nama Satuan : </td>
				<td><input class="k-textbox" id="nama_satuan" name="nama_satuan" placeholder="Nama Satuan" style="width:200px"></td>
			</tr>
			<tr>
				<td>Hasil Jumlah Konversi: </td>
				<td><input class="k-textbox" id="hasil_jumlah_konversi" name="hasil_jumlah_konversi" placeholder="Hasil Jumlah Konversi" style="width:200px"></td>
			</tr>
			<tr>
				<td>Konversi Ke : </td>
				<td><input class="k-textbox" id="konversi_ke" name="konversi_ke" placeholder="Konversi Ke" style="width:200px"></td>
			</tr>
		</table>
		
		<br>
		<input id="btnSub" class="k-button" value="Simpan" style='width:100px;height:30px;'>
		<a href="/Apotek/Satuan/Browse"> 
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
	
});

</script>
