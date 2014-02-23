<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>ログイン</h2>
<div class="tab">
<p class="error">
<html:messages id="errors" message="true" property="collision">
	<%=errors %>
</html:messages>
</p>

<html:form action="/afterLogin">
	<p>
		USER ID:<br />
		<html:text property="userId" /> <html:errors property="id" /><br />
		PASSWORD:<br />
		<html:password property="passwd" /> <html:errors property="pass" /><br />
		<html:submit value="ログイン" />
	</p>
</html:form>
</div>