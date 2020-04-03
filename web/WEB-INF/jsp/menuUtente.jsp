<%-- 
    Document   : menuUtente
    Created on : Apr 3, 2020, 12:07:16 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h2>Benvenuto.</h2>
        <form:form method="get" action="apriSegnalazione">
            <button type="submit">Apri Segnalazione</button>
        </form:form>
        
    </body>
</html>
