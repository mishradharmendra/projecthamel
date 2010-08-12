<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

    <head>        
    </head>

    <body>
        <h4>Enter your username and password to login to your portfolio.</h4>
        <s:form action="login.action">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:submit align="center"/>
        </s:form>


    </body>

</html>
