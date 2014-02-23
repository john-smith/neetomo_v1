<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>追加確認</h2>
<div class="tab">
<p> 
	以下の応答文の登録を行います
</p>
<p>
<bean:write name="addWord"  />
</p>
<p><html:link action="/wakai/addResponseComplete">登録する</html:link> / <html:link action="/index">やめる</html:link></p>
</div>