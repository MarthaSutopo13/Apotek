<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<script src="/Apotek/resources/js/jquery.min.js"></script>
		<link href="/Apotek/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<a href="${link}"><input type="button" class="btn btn-medium" value="BACK"/></a>
		<div id="body" style="width:100%">
			<object data="${data}" type="application/pdf" width="100%" height="94%" />
		</div>
	</body>
</html>