<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>登録確認</h2>
<div class="tab">
<p> 
	以下の内容でユーザ登録を行います
</p>
<p>
USER ID : <bean:write name="regist" property="userId" /><br />
権限 : <bean:write name="regist" property="role" />

</p>
<p><html:link action="/admin/addUserComplete">登録する</html:link> / <html:link action="/index">やめる</html:link></p>
</div>