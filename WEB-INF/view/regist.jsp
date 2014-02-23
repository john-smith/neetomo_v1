<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>ユーザ登録</h2>
<div class="tab">
<p class="error">
<html:messages id="errors" message="true" property="badname">
	<%=errors %>
</html:messages>
</p>
<html:form action="/confirmation">
	<p>
		USER ID:<br />
		<html:text property="userId" /> <html:errors property="id" /><br />
		PASSWORD:<br />
		<html:password property="passwd" /> <html:errors property="pass" /><br />
		PASSWORD(確認):<br />
		<html:password property="passwd2" /> <html:errors property="pass2" /><br />
		<html:hidden property="role" value="一般" />
		<html:submit value="確認" />
	</p>
</html:form>
</div>