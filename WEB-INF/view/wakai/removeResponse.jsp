<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="bean.noLogin.WordBean" %>

<script type="text/javascript">
size = <%= ((ArrayList<WordBean>)session.getAttribute("wordList")).size() %>;
index = 0;
range = 10;
</script>
<script type="text/javascript" src="<%= request.getContextPath() %>/view/js/userList.js"></script>

<h2>応答文削除</h2>
<div class="tab">
<p>再検索</p>
<html:form action="/wakai/removeResponse">
	<html:text property="word" />
	<html:submit value="検索" />
</html:form>
</p>
<p>削除する応答文を選んでください</p>
<p class="error">
<html:messages id="errors" message="true" property="noselect">
	<%=errors %>
</html:messages>
<p>表示件数 : <input type="text" id="input" />
	<input type="button" value="変更" size="3" onClick='inputChange()' />
	<a href="javascript:all()">全件表示</a>
</p>
<html:form action="/wakai/removeResponseConfirmation">
	<% int i = 0; %>
	<table>
		<logic:iterate id="list" name="wordList" scope="session">
			<tr id="<%= i++ %>">
				<td>
					<html:multibox property="idList"><bean:write name="list" property="id" /></html:multibox>
				</td>
				<td>
					<bean:write name="list" property="word" />
				</td>
			</tr>
		</logic:iterate>
	</table>
	<p>
	<span id="first"> &lt;&lt; </span>
	<span id="prev"> &lt; </span>
	<span id="page"> 1 </span>
	<span id="next"> &gt; </span>
	<span id="last"> &gt;&gt; </span>
	</p>
	<p><html:submit value="確認" /></p>
</html:form>

<script type="text/javascript">
init();
</script>

</div>