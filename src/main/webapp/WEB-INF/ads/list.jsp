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

        <div class="p-2 m-2 ad-container align-self-start">

        <div class="card " style="width: 18rem;">
            <c:if test="${not empty ad.img}">
                <img class="card-img-top ad-list-img" src="${ad.img}" alt="${ad.title}">
            </c:if>
            <div class="card-body">
                <h5 class="card-the">${ad.title}</h5>
                <p class="card-text">${fn:substring(ad.description, 0, 100)}...</p>
                <a href="#" class="btn btn-primary" data-id="${ad.id}">View Ad</a>
                <span><fmt:formatDate value="${ad.createdAt}" pattern="M/dd h:mm a" /></span>
            </div>
        </div>
        </div>
    </c:forEach>
    </div>

    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</div>

</body>
</html>