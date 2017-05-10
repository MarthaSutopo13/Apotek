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
		<legend>Input Data Barang</legend>
		
		<table width="100%">
			<tr>
				<td>Nama Barang : </td>
				<td><input class="k-textbox" id="nama_barang" name="nama_barang" placeholder="Nama Barang" style="width:200px"></td>
			
				<td align="right">ID Satuan : </td>
				<td width="1px"><input class="k-textbox" id="id_satuan" name="id_satuan" placeholder="ID Satuan" style="width:200px"></td>
				<td><input type="button" class="k-button" value="..."></td>
			
			</tr>
			<tr>
				<td>Harga Jual 1: </td>
				<td><input class="k-textbox" id="harga_jual1" name="harga_jual1" placeholder="Harga Jual 1" style="width:200px"></td>
			
				<td align="right">ID Brand : </td>
				<td width="1px"><input class="k-textbox" id="id_brand" name="id_brand" placeholder="ID Brand" style="width:200px"></td>
				<td><input type="button" class="k-button" value="..." onclick="browseBrand()"></td>
			</tr>
			<tr>
				<td>Harga Jual 2 : </td>
				<td><input class="k-textbox" id="harga_jual2" name="harga_jual2" placeholder="Harga Jual 2" style="width:200px"></td>
			
				<td align="right">ID Kategori : </td>
				<td width="1px"><input class="k-textbox" id="id_kategori" name="id_kategori" placeholder="ID Kategori" style="width:200px"></td>
				<td><input type="button" class="k-button" value="..."></td>
			</tr>
			<tr>
				<td>Harga Beli : </td>
				<td><input class="k-textbox" id="harga_beli" name="harga_beli" placeholder="Harga Beli" style="width:200px"></td>
			</tr>
		</table>
		
		<br>
		<input class="k-button" value="Tambah Baris" style='width:100px;height:30px;' onclick="myCreateFunction()">
		<input class="k-button" value="Hapus Baris" style='width:100px;height:30px;' onclick="myDeleteFunction()">
		
	</fieldset>
	
	<table id="detailBarang" cellspacing="10">
		<tr>
			<th>No.</th>
			<th><b>Nama Detail Barang</b></th>
			<th>Jumlah</th>
			<th>Kadaluarsa</th>
		</tr>
		<tr>
			<td><label>1</label></td>
			<td><input class="k-textbox" style='width:200px' placeholder="Nama Detail Barang" name="nama_detail_barang_1"/></td>
			<td><input class="jumlahs" style='width:100px' placeholder="Jumlah" name="jumlah_1"/></td>
			<td><input class="dates" name="kadaluarsa_1"/></td>
		</tr>
	</table>
	
	<div id="window"></div>
	
	<br>
		<input class="k-button" value="Simpan" style='width:100px;height:30px;'>
		<a href="/Apotek/Barang/Browse"> 
		<input class="k-button" value="Lihat Data" style='width:100px;height:30px;'>
		</a>

	
</form:form>

<script>

	$(".dates").kendoDatePicker({
		format: "dd MMMM yyyy",
	    value: new Date(),
	});

	$(".jumlahs").kendoNumericTextBox({
    	format : "n2",
    	decimals : "2",
    	step:"1"
	});

function myCreateFunction() {
    var table = document.getElementById("detailBarang");
	var length = table.rows.length;
	var row = table.insertRow(length);
// 	alert(length);
	var cell0 = row.insertCell(0);
	var cell1 = row.insertCell(1);	
	var cell2 = row.insertCell(2);	
	var cell3 = row.insertCell(3);
	
	var labelnode = document.createTextNode(length);
	cell0.appendChild(labelnode);
	
	var txtnamadetailbarang = document.createElement("input");
	txtnamadetailbarang.type="textbox";
	txtnamadetailbarang.id="nama_detail_barang_"+length;
	txtnamadetailbarang.name="nama_detail_barang_"+length;
	txtnamadetailbarang.className="k-textbox";
	txtnamadetailbarang.placeholder="Nama Detail Barang";
	txtnamadetailbarang.style.width="200px";
	cell1.appendChild(txtnamadetailbarang);
	
	var txtjumlah = document.createElement("input");
	txtjumlah.type="textbox";
	txtjumlah.id="jumlah_"+length;
	txtjumlah.name="jumlah_"+length;
// 	txtjumlah.value=length+1;
	txtjumlah.style.width="100px";
	txtjumlah.className="jumlah_"+length;
	txtjumlah.placeholder="Jumlah";
	cell2.appendChild(txtjumlah);
	
	
	
	var txtkadaluarsa = document.createElement("input");
// 	txtkadaluarsa.type="date";
	txtkadaluarsa.id="kadaluarsa_"+length;
	txtkadaluarsa.name="kadaluarsa_"+length;
	txtkadaluarsa.style.width="150px";
	txtkadaluarsa.className="date_"+length;
	cell3.appendChild(txtkadaluarsa);
	
	$(".date_"+length).kendoDatePicker({
	    format: "dd MMMM yyyy",  
	    value: new Date(),
	});
	
	$(".jumlah_"+length).kendoNumericTextBox({
    	format : "n2",
    	decimals : "2",
    	step:"1"
	});
}

function myDeleteFunction() {
	var table = document.getElementById("detailBarang");
	var length = table.rows.length;
	
    document.getElementById("detailBarang").deleteRow(length-1);
}

function browseBrand(){
	$("#window").kendoWindow({
        width: "600px",  
        height: "450px",
        actions: ["Close"],
        title: "Browse",
        close: function() {  
       		$("#id_brand").val($("#selectedCode").html());  
        }  
 	});  
	var search = $("#id_brand").val().split(' ').join('%20');
	if($("#id_brand").val() != ""){
		$('#window').load("/Apotek/Barang/KendoWindowBrowseBrand/?search="+search+$("#id_brand").val("")); //ini view
	}else{
		$('#window').load("/Apotek/Barang/KendoWindowBrowseBrand/?search="+search+$("#id_brand").val());
	}    
   	var a = $("#window").data("kendoWindow").center().open();
}


</script>