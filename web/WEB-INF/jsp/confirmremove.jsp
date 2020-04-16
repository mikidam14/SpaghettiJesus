<%-- 
    Document   : confirmremove
    Created on : Apr 16, 2020, 8:15:31 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conferma</title>
        <style>
            #btns { 
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div style="text-align: center"><h2>Sei sicuro di voler eliminare questa segnalazione?</h2></div>
        <div id="btns">
            <br/>
            <form:form method="post" action="removeSe">
                    <button type="submit">Conferma</button>
            </form:form>
            <br/>
            <form:form method="post" action="backtout">
                    <button type="submit">Cancella</button>
            </form:form>
        </div>
    </body>
</html>
