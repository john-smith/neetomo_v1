<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>アカウント削除</h2>
<div class="tab">
<p>現在ログインしているユーザのアカウント削除します。よろしいですか？</p>
<p><html:link action="/wakai/removeAccountComplete">はい</html:link> / <html:link action="/index">いいえ</html:link></p>
</div>