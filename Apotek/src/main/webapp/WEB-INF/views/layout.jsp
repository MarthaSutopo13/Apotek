<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<meta http-equiv="cache-control" content="max-age=0" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
		<meta http-equiv="pragma" content="no-cache" />
		
		<title><tiles:insertAttribute name="title" /></title>
		<link href="/Apotek/resources/css/kendo.common.min.css" rel="stylesheet" type="text/css" />
	    <link href="/Apotek/resources/css/kendo.default.min.css" rel="stylesheet" type="text/css" />
		<link href="/Apotek/resources/css/colorbox.css" rel="stylesheet" type="text/css" />
		<link href="/Apotek/resources/css/style.css" rel="stylesheet" type="text/css" />
		
	    <script src="/Apotek/resources/js/jquery.min.js"></script>
	    <script src="/Apotek/resources/js/kendo.web.min.js"></script>
	    <script src="/Apotek/resources/js/jquery.colorbox-min.js"></script>
	    <script src="/Apotek/resources/js/custom.js"></script>
	</head>
	<body  class="backcolor">
		<div id="wrapper">
			<tiles:insertAttribute name="header" />
			<div id="content">
				<div class="content-wrapper">
					<c:if test="${panelButton == null}">
						<tiles:insertAttribute name="panelButton" /> <br />
					</c:if>
					<tiles:insertAttribute name="body" /> <br />
					<c:if test="${panelButton == null}">
						<tiles:insertAttribute name="panelButton" /> <br />
					</c:if>
					<div style="display:none;"><tiles:insertAttribute name="panelButtonEntry" /></div>
				</div>
			</div>
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>