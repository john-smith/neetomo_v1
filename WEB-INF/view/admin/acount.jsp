<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>アカウント操作</h2>
<div class="tab">
<p>一般ユーザのアカウントに対する操作を行えます。</p>
<ul>
<!--  <li><html:link action="/admin/addUser">ユーザ追加</html:link></li>-->
	<li><html:link action="/admin/removeUser">ユーザ削除</html:link></li>
	<li><html:link action="/admin/initUserpass">ユーザパスワードの初期化</html:link></li>
</ul>
</div>