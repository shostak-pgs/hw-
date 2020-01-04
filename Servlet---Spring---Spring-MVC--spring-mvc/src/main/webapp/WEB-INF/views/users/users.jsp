<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div>
    <table>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>User Id: <c:out value="${user.id}"/></td>
                <td>User Email: <c:out value="${user.email}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
