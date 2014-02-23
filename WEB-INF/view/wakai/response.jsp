<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>応答文操作</h2>
<div class="tab">
<p>応答文に関する操作を行えます。</p>
<p>登録されている応答文は応答文の生成に用いられます。</p>
<ul>
	<li><html:link action="/wakai/addResponse">応答文の追加</html:link></li>
	<li><html:link action="/wakai/removeResponseSearch">応答文の削除</html:link></li>
</ul>
</div>