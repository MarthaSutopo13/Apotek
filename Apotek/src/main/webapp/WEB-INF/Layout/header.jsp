<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<div id="header">
	<div id="logo"><img src="/Apotek/resources/images/design-banner.png" style="margin-left:10px;" height="40px"></img></div>
	 
	 <table style="float:right; padding-top:-10px; margin-top:-10px;"  border=0>
	 	<tr>
	 		<td></td>
	 		<td><a href="">[ Log in ]</a></td>
	 	</tr>
	 </table>
	 
 	<br/><br/>      
	<div id="navbar">  
		<ul id="menu">
			<li>
				Main  
				<ul id="content">
					<li>Home</li>
					<li>User Guide</li>
					<li>About</li>
				</ul>
			</li>
			<li>
				Master
				<ul id="content">
					<li><a href="/Apotek/Supplier">Supplier</a></li>
					<li><a href="/Apotek/Customer">Customer</a></li>
					<li><a href="/Apotek/Barang">Barang</a></li>
					<li><a href="/Apotek/KategoriBrand">Kategori & Brand</a></li>
					<li><a href="/Apotek/Satuan">Satuan</a></li>
				</ul>
			</li>
			<li>
				Transaksi
				<ul id="content">
					<li><a href="/Apotek/Pembelian">Pembelian</a></li>
					<li><a href="/Apotek/Penjualan">Penjualan</a></li>
					<li><a href="/Apotek/Pembelian">Retur Pembelian</a></li>
					<li><a href="/Apotek/Penjualan">Retur Penjualan</a></li>
				</ul>
			</li>
		
           </ul>
	</div>
</div>
	