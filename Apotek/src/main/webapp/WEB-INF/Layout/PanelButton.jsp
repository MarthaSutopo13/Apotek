<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br/><br/>

<c:if test="${not empty groupAccess}"> 

			<c:if test="${groupAccess.edit == 1}"><a href="${groupAccess.webName}/Edit/?${parameter}=${paramVal}">Edit</a> | </c:if>
			<c:if test="${groupAccess.delete_ == 1}"><a href="${groupAccess.webName}/Delete/?${parameter}=${paramVal}">Delete</a> | </c:if>
			<c:if test="${groupAccess.print == 1}"><a href="${groupAccess.webName}/LayoutPrint/?${parameter}=${paramVal}&replay=1&link=${groupAccess.webName}/Detail/?${parameter}=${paramVal}">Print</a> | </c:if>
			<c:if test="${groupAccess.review == 1}"><a href="${groupAccess.webName}/Review/?${parameter}=${paramVal}">Review</a> | </c:if>
			<c:if test="${groupAccess.approve == 1}"><a href="${groupAccess.webName}/Approve/?${parameter}=${paramVal}">Approve</a> | </c:if>
			<c:if test="${not empty showStatus}"><a href="${groupAccess.webName}/ShowStatus/?${parameter}=${paramVal}">Show Status</a> | </c:if>
			
</c:if> 