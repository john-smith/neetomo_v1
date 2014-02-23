<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>
<%@page import="java.util.ArrayList" %>

<script type="text/javascript">
size = <%= ((ArrayList<String>)request.getAttribute("userList")).size() %>;
index = 0;
range = 10;
</script>
<script type="text/javascript" src="<%= request.getContextPath() %>/view/js/userList.js"></script>


<h2>初期化</h2>
<div class="tab">
<p>パスワードを初期化するユーザを選んでください</p>
<p class="error">
<html:messages id="errors" message="true" property="noselect">
	<%=errors %>
</html:messages>
</p>
<p>表示件数 : <input type="text" id="input" />
	<input type="button" value="変更" onClick='inputChange()' />
	<a href="javascript:all()">全件表示</a>
</p>
<html:form action="/admin/initUserpassConfirmation">
<% int i = 0; %>
	<table>
		<logic:iterate id="userId" name="userList" scope="request">
			<tr id="<%= i++ %>">
				<td>
					<html:multibox property="removeUser"><bean:write name="userId" /></html:multibox>
				</td>
				<td>
					<bean:write name="userId" />
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