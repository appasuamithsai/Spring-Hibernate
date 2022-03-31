<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>

<head>

<title> I am new ...</title>

</head>

<body>
<p>
    Welcome to new Page!!
</p>
    <hr>
        User : <security:authentication property="principal.username" />
        <br><br>
        Role (s):<security:authentication property="principal.authorities" />
    <hr>

    <security:authorize access="hasRole('MANAGER')" >
             <p>
                    <a href="${pageContext.request.contextPath}/leaders" >Leadership Meeting </a>
                    (Only for Manager peeps)
              </p>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')" >
         <p>
                <a href="${pageContext.request.contextPath}/systems" >IT System Meeting </a>
                (Only for Admin peeps)
         </p>
        </security:authorize>
    <hr>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />

    </form:form>


</body>

</html>