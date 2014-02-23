<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>確認</h2>
<div class="tab">
<p>以下のユーザを削除します。</p>

<ul>
	<logic:iterate id="userId" name="removeUserList" scope="session">
		<li><bean:write name="userId" /></li>
	</logic:iterate>
</ul>

<p><html:link action="/admin/removeUserComplete">削除</html:link> / <html:link action="/index">戻る</html:link></p>
						 
</div>