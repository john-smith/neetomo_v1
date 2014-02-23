<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>パスワード変更</h2>
<div class="tab">
<p class="error">
<html:messages id="errors" message="true" property="passmiss">
	<%=errors %>
</html:messages>
</p>
<html:form action="/wakai/changePassComplete">
<p>
	新しいパスワード:<br />
	<html:password property="newPass" /> <html:errors property="new" /><br />
	新しいパスワード(確認):<br />
	<html:password property="newPass2" /> <html:errors property="new2" /><br />
	<html:submit value="変更" />
</p>
</html:form>
</div>