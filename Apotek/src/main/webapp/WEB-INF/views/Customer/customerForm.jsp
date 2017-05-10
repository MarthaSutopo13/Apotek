<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
	
<form:form method="POST" commandName="customer" id="formEdit" action="${action}">
<div class="error"><c:out value="${error}"/></div>
<div align="center" style="color: green;"><c:out value="${error2}"> </c:out></div>
<div align="center" style="color: red;"><c:out value="${error3}"> </c:out></div>
	<fieldset>
		<legend>Input Data Customer</legend>
		
		<table>
			<tr>
				<td>Nama Customer : </td>
				<td><input class="k-textbox" id="nama_customer" name="nama_customer" placeholder="Nama Customer" style="width:200px"></td>
			</tr>
			<tr>
				<td>Alamat : </td>
				<td><textarea rows="4" cols="50" class="k-textbox" id="alamat" name="alamat" placeholder="Alamat" style="width:200px"></textarea></td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><input class="k-textbox" id="email" name="email" placeholder="Email" style="width:200px"></td>
			</tr>
			<tr>
				<td>No Telp : </td>
				<td><input class="k-textbox" id="no_telp" name="no_telp" placeholder="No Telp" style="width:200px"></td>
			</tr>
			<tr>
				<td>Keterangan : </td>
				<td><textarea rows="4" cols="50" class="k-textbox" id="keterangan" name="keterangan" placeholder="Keterangan" style="width:200px"></textarea></td>
			</tr>
		</table>
		
		<br>
		<input id="btnSub" class="k-button" value="Simpan" style='width:100px;height:30px;'>
		<a href="/Apotek/Customer/Browse"> 
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
