<%-- 
    Document   : azioneverificapagerespfk
    Created on : Apr 16, 2020, 7:54:08 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu azioni di verifica</title>
        <style>
            #center{
                display: flex; 
                justify-content:center;
            }
            table {
                border-collapse: collapse;
            }
            
            td{
                text-align: center;
                padding: 5px;
            }
            
            table, th, td {
                border: 1px solid black;
            }
            
            #btns { 
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div id="center"><h2>AZIONI DI VERIFICA</h2></div>
        <div id="center">
                <table>
                    <tr style="background-color: cornflowerblue">
                        <th>Id</th>
                        <th>Descrizione</th>
                        <th>Utente</th>
                        <th>AzCr</th>
                    </tr>
                    <tr style="background-color: lightcyan">
                        <td>3</td>
                        <td>Verificare la prossima fornitura</td>
                        <td>utente1</td>
                        <td>9</td>
                    </tr>
                </table>
            
        </div>
        <div id="btns">
            <br/>
            <form:form method="post" action="backtout">
                    <button type="submit">Indietro</button>
            </form:form>
        </div>
    </body>
</html>
