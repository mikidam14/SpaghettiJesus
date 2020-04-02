<%-- 
    Document   : impiegatiList
    Created on : 3-dic-2017, 17.38.24
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Esempio CRUD</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 

    <h2>Impiegati</h2>  
   <c:if test="${!empty tutti}">
	<table class="tg">
	<tr>
		<th width="120">Nome</th>
		<th width="80">Stipendio</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${tutti}" var="e">
		<tr>
			<td>${e.name}</td>
			<td>${e.salary}</td>
			<td><a href="<c:url value='/edit/${e.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${e.id}' />" >Delete</a></td>
                        <td><a href="<c:url value='/increment/${e.id}' />" >Increment</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
 <br/>
 <a href="<c:url value='/add' />">Aggiungi</a><br>
 <a href="<c:url value='/incrementsalary' />">Increment</a>

</html>