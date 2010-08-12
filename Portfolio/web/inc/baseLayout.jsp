<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><tiles:insertAttribute name="title" ignore="true" /></title>
            <link type="text/css" rel="stylesheet" href="http://localhost:8080/Portfolio/inc/style.css" />
    </head>
    <body>
        <table border="0" cellpadding="0" cellspacing="0" align="center">
            <tr>
               
                <td width ="500" height="30">
                    <tiles:insertAttribute name="header" />
                </td>
                 <td height="20">
                    <tiles:insertAttribute name="images" />
                </td>
                
            </tr>
            <tr valign="top">
                <td style="color:#2D8ED2;"  width="500">
                    <tiles:insertAttribute name="body" />
                </td>
                <td bgcolor="#F0FFFF" height="500">
                    <tiles:insertAttribute name="menu" />
                </td>
                
            </tr>
            <tr valign="top">
                <td height="20" colspan="2">
                    <tiles:insertAttribute name="footer" />
                </td>
            </tr>
        </table>
    </body>
</html>
