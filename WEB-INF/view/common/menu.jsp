<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>MENU</h2>
<div class="tab">
<ul>
<li><html:link action="/index">トップ</html:link></li>

<logic:equal name="login" scope="session" value="">
	<li><html:link action="/login">ログイン</html:link></li>
	<li><html:link action="/regist">ユーザ登録</html:link></li>
</logic:equal>

<logic:notEqual name="login" scope="session" value="">
	<li><html:link action="/wakai/word">単語操作</html:link></li>
	<li><html:link action="/wakai/response">応答文操作</html:link></li>

	<logic:equal name="login" property="role" scope="session" value="admin">
		<li><html:link action="/admin/acount">アカウント操作</html:link></li>
	</logic:equal>

	<logic:notEqual name="login" property="role" scope="session" value="admin">
		<li><html:link action="/wakai/removeAccount">退会</html:link></li>
	</logic:notEqual>
	
	<li><html:link action="/wakai/changePass">パスワード変更</html:link></li>
	<li><html:link action="/wakai/logout">ログアウト</html:link></li>	
</logic:notEqual>

<li><html:link action="/about">このサイトについて</html:link></li>

</ul>
</div>

