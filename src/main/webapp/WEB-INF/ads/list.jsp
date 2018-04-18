<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Category Name</h1>


    <div class="d-flex flex-row flex-wrap">
    <c:forEach var="ad" items="${ads}">
        <div class="p-2 m-2 ad-container">
            <h3>${ad.title}</h3>
            <div class="image"><img src="${ad.img}" alt="${ad.title}" class="img-fluid"></div>
            <p>${fn:substring(ad.description, 0, 150)}...
            </p>
            <p>
                <fmt:formatDate value="${ad.createdAt}" pattern="MM/dd HH:mm" />
            </p>

        </div>
    </c:forEach>
    </div>






</div>

</body>
</html>
s