<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>単語操作</h2>
<div class="tab">
<p>単語に関する操作を行えます。</p>
<p>登録されている単語は入力された文章の解析や応答文の生成に用いられます。</p>
<ul>
	<li><html:link action="/wakai/addWord">単語の追加</html:link></li>
	<li><html:link action="/wakai/removeWordSearch">単語の削除</html:link></li>
</ul>
</div>