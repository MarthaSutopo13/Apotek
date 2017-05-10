<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<script src="/Apotek/resources/js/jquery.min.js"></script>
		<link href="/Apotek/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<a href="${link}"><input type="button" class="btn btn-medium" value="BACK"/></a>
<!-- 		<div id="body" style="width:46%">  -->
			<object data="${data}" style="overflow: hidden;margin-right: 60%;"  type="application/pdf" width="100%" height="100%"></object>
			<object data="${data2}" type="application/pdf" width="100%" height="100%"></object>
<!-- 		</div> --> 
<!-- 		<div style="width:2%; height:100%"></div> -->
<!-- 		<div id="body2" style="width:100%">  -->
<%-- 			<object data="${data2}" type="application/pdf" width="46%" height="100%"></object> --%>
<!-- 		</div> -->
	</body>
</html>