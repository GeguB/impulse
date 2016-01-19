<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>${title}</h1>
	<p>The time on the server is ${serverTime}.</p>
	<p>Today is ${serverDate}.</p>
</body>
</html>
