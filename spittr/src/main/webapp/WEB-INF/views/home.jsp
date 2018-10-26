<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" href="<c:url value="/resource/style.css"/>">
</head>
<body>
<h1>Welcome to Spittr</h1>

<a href="<c:url value="/spittles"/>">Spittles</a>
<a href="<c:url value="/spittr/register"/>">Register</a>
</body>
</html>
