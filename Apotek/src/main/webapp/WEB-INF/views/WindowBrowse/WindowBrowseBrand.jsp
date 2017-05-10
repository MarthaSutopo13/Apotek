<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="browse-wrapper">
<c:url value="${readUrl}" var="readUrl"/>

<div id="selectedCode" style="display:none"></div>
<div id="selectedName" style="display:none"></div>

<div>
	<fieldset>
		<legend>Look Up</legend>
			<div class="search">Cari <input type="text" name="search" id="search" class="k-textbox"/></div>
		</fieldset>
</div>
<!-- <div id="window"> -->
<fieldset>
		<kendo:grid name="grid" groupable="false" sortable="true" filterable="true" selectable="true" height="280px" scrollable="true" pageable="true" >
	        <kendo:grid-columns> 
	            <kendo:grid-column title="ID Brand" field="id" width="110px"/>
	            <kendo:grid-column title="Nama Brand" field="value" width="250px"/>
	        </kendo:grid-columns>  

	        <kendo:dataSource pageSize="25">
	        	<kendo:dataSource-transport>
	            	<kendo:dataSource-transport-read url="${readUrl}" dataType="json" type="GET" contentType="application/json"/>
				</kendo:dataSource-transport>
	            <kendo:dataSource-schema>
	               <kendo:dataSource-schema-model id="id">
	                   <kendo:dataSource-schema-model-fields>
	                       <kendo:dataSource-schema-model-field name="id" type="string" />
	                       <kendo:dataSource-schema-model-field name="value" type="string" />
	                   </kendo:dataSource-schema-model-fields>
	               </kendo:dataSource-schema-model>
	           </kendo:dataSource-schema>
	       </kendo:dataSource>
		</kendo:grid>
</fieldset>
<!-- </div> -->
	

<input type="button" value="Select" onClick="getRow()" class="k-button"/>
<input type="hidden" value="${url}" id="url" />
<input type="hidden" value="${search}" id="search_hidden"/>
</div> 

<script type="text/javascript">
	$('#search').change(function() {
		var search = $("#search").val().split(' ').join('%20'); 
		$('#browse-wrapper').load($('#url').val()+search);
	});
	
	
	function getRow(){
		var entityGrid = $("#grid").data("kendoGrid");
		var selectedItem = entityGrid.dataItem(entityGrid.select());
		
		$("#selectedCode").html(selectedItem.no);
		$("#selectedName").html(selectedItem.value);

		$("#window").data("kendoWindow").close();
	}
	
	$("#grid").dblclick(function() {
			getRow();
		}
	);
	
	$(document).ready(function(){
		$("#search").focus();
		$("#search").val(document.getElementById('search_hidden').value);
	});
</script>