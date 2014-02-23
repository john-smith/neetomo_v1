<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<h2>about</h2>
<div class="tab">
<p> お名前を入れてはじめるボタンを押すと、コンピュータが話し相手をしてくれます。 相手はコンピュータなので変なことを言うかもしれませんが気にしないでやってください。 </p>
</div>

<h2>お話</h2>
<p class="flash">
<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="550" height="430">
<param name="movie" value="<%=request.getContextPath()%>/view/swf/chatbot.swf" />
<param name="quality" value="high" />
<embed src="<%=request.getContextPath()%>/view/swf/chatbot.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="550" height="430"></embed>
</object>
</p>

