<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>


            <div class="form-group row">

             <div class="col-6">
                <label for="catId">Category</label>
            <select class="selectpicker test" id="catId" name="catId" data-width="100%">

            <c:forEach var="cat" items="${categories}">

                <c:choose>
                    <c:when test="${cat.mainId=='0'}">
                            <c:if test="${cat.id!='1'}">
                            </optgroup>
                            </c:if>
                        <optgroup label="${cat.title}">
                    </c:when>
                    <c:otherwise>
                       <option value="${cat.id}">${cat.title}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
            </select>

             </div>


              <div class="col-6">
                  <label for="img-url">Image Link</label>
                  <input class="form-control" type="url" placeholder="https://imgurl.com/image.jpg" name="img-url" id="img-url">
              </div>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control ad-description" type="text" rows="8"></textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />

</body>
</html>
