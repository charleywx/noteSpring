<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
    <sf:form method="post">
        <sf:input path="name"/>
        <sf:input path="email"/>
        <sf:password path="password"/>
        <<input type="submit" value="register">
    </sf:form>
</head>
<body>
    <h1>Welcome!</h1>
</body>
</html>