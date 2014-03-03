<%-- 
    Document   : index
    Created on : 03-mar-2014, 11:03:25
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="misTags" prefix="Scb"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados Real Madrid</title>
    </head>
    <body>
        <table border="3" style="border-color: #0000CC" bgcolor="#99DDFF" cellspacing="0" align="center">
            <tr>
                <td colspan="3"><b>Resultados de la Semana</b></td>
            </tr>
            <tr>
                <td colspan="3" border="2"><b>CHAMPIONS</b></td>
            </tr>
            <tr>
                <td colspan="3">CASA</td>
            </tr>
            <Scb:championCasa/>
            <tr>
                <td colspan="3">FUERA</td>
            </tr>
            <Scb:championFuera/>
            <tr>
                <td colspan="3" border="3"><b>LIGA</b></td>
            </tr>
            <tr>
                <td colspan="3">CASA</td>
            </tr>
            <Scb:ligaCasa/>
            <tr>
                <td colspan="3">FUERA</td>
            </tr>
            <Scb:ligaFuera/>
        </table>

    </body>
</html>
