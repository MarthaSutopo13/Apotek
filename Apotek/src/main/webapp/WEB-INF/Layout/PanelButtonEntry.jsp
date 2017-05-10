<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<input type="submit" value="Save" name="save" />
	<input type="submit" value="Cancel" name="cancel" />
<c:if test="${not empty panelButtonEntry.send}">
	<input type="submit" value="Send" name="send" />
</c:if> 
<c:if test="${not empty panelButtonEntry.pending}">
	<input type="submit" value="Pending" name="pending" />
</c:if> 
<c:if test="${not empty panelButtonEntry.return_}">
	<input type="submit" value="Return" name="return_" />
</c:if>
<c:if test="${not empty panelButtonEntry.saveAndSend}">
	<input type="submit" value="Save & Send" name="saveAndSend" />
</c:if>
<c:if test="${not empty panelButtonEntry.saveAndClose}">
	<input type="submit" value="Save & Close" name="saveAndClose" />
</c:if>
<c:if test="${not empty panelButtonEntry.saveAndApprove}">
	<input type="submit" value="Save & Approve" name="saveAndApprove" />
</c:if>