<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<html:html xhtml="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<!-- InstanceBeginEditable name="doctitle" -->
<title><tiles:getAsString name="title" /></title>
<meta name="Description" content="wakai" />
<meta name="Keywords" content="wakai" />

<link rel="stylesheet" href="<%=request.getContextPath() %>/view/css/style.css" />
</head>

<body>
<div id="wrapper">

<!-- ここにheaderが入ります。 -->
<div id="header">
<tiles:insert name="header" />
</div>
<!-- ここにheaderが入ります。 -->

<!-- ここにmenuが入ります。 -->
<div id="menu">
<tiles:insert name="menu" />
</div>
<!-- ここにmenuが入ります。 -->

<!-- ここにcontentが入ります。 -->
<div id="content">
<tiles:insert name="content" />
</div>
<!-- ここにcontentが入ります。 -->

<!-- ここにfooterが入ります。 -->
<div id="footer">
<tiles:insert name="footer" />
</div>
<!-- ここにfooterが入ります。 -->

</div>

</body>
</html:html>