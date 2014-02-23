<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>単語削除</h2>
<div class="tab">
<p>以下のフォームから削除したい応答文を検索してください。</p>
<html:form action="/wakai/removeResponse">
	<html:text property="word" />  <html:errors property="wordError" /><br />
	<html:submit value="検索" />
</html:form>
</div>