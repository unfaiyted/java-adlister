<%--
  Created by IntelliJ IDEA.
  User: danelmiller
  Date: 4/16/18
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<%! boolean doAction = false; %>
<%

    doAction = (request.getParameter("username") != null && request.getParameter("username").equals("root"));
    doAction = (request.getParameter("password") != null && request.getParameter("password").equals("password"));


    if(doAction) {    response.sendRedirect("profile.jsp");       }

%>

<html>
<head>
    <title>Login</title>
</head>
<body>


<%--<p>Query String: <%= request.getQueryString() %></p>--%>
<%--<p>"username=root" parameter: <%= request.getParameter("username").equals("root") %></p>--%>
<%--<p>"password" parameter: <%= request.getParameter("password").equals("password") %></p>--%>

<%--<p>User-Agent header: <%= request.getHeader("user-agent") %></p>--%>

<form method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username">

    <label for="password">Password:</label>
    <input type="password" id="password" name="password">

    <button type="submit">LOGIN!</button>
</form>


</body>
</html>
