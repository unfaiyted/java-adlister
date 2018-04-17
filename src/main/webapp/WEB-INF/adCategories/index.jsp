<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Want something? Look here!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Where we looking?</h1>

    <c:forEach var="cat" items="${main}">
        <div class="col-md-6 ad-cat" data-id="${cat.id}">
            <h2>${cat.title}</h2>
            <div class="sub-cat" data-id="${cat.id}"></div>

        </div>
    </c:forEach>
</div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
