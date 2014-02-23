<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>確認</h2>
<div class="tab">
<p>以下の単語を削除します。</p>

<ul>
	<logic:iterate id="word" name="removeWordList" scope="session">
		<li><bean:write name="word" /></li>
	</logic:iterate>
</ul>

<p><html:link action="/wakai/removeWordComplete">削除</html:link> / <html:link action="/index">戻る</html:link></p>
						 
</div>