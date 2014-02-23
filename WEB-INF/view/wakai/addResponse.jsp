<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>応答文追加</h2>
<div class="tab">
<p>応答文を追加します</p>
<p class="error">
<html:messages id="errors" message="true" property="badword">
	<%=errors %>
</html:messages>
</p>
<html:form action="/wakai/addResponseConfirmation">
	<p>応答文 : <br />
	<html:text property="word" /> <html:errors property="wordError" /><br />
	<html:submit value="確認" />
</html:form>
</div>