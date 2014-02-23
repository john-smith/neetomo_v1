<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<script src='dwr/interface/Hoge.js'></script>
<script src='dwr/engine.js'></script>
<script src='dwr/util.js'></script>
<script type="text/javascript" src="view/js/chatbot.js"></script>

<h2>about</h2>
<div class="tab">
<p> お名前を入れてはじめるボタンを押すと、コンピュータが話し相手をしてくれます。 相手はコンピュータなので変なことを言うかもしれませんが気にしないでやってください。 </p>
</div>

<h2>お話</h2>
<div class="tab">
<dl>
<dt>あなた</dt>
<dd id="you">あなたの発言が表示されます。</dd>
<dt>
<hr />
</dt>
<dt>コンピュータ</dt>
<dd id="cpu">コンピュータの発言が表示されます。</dd>
<dt>
<hr />
</dt>
</dl>
<form action="#">
	<p>
		<textarea rows="5" cols="40" id="wakai"></textarea><br />
		<input type="button" value="発言" id="wakai2" onClick='chat()' /> <span id="load"></span>
	</p>
</form>
</div>

