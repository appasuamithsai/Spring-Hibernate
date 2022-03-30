<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>


<head>
<title>Custom Login Page </title>
<style>
    .failed{

        color:red;

    }
</style>
</head>

<h3> My Custom Login Page</h3>

    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                method="POST">

            <c:if test="${param.error!=null}">
                    <i class="failed">Sorry You Have Entered invalid username/password </i>
            </c:if>



                <p>
                    User name : <input type="text" name="username" />
                </p>
                 <p>
                    Password : <input type="password" name="password" />
                </p>

                <input type="submit" value="Login" />


    </form:form>

<body>

</body>
</html>