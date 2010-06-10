<%-- 
    Document   : userLogin
    Created on : May 26, 2010, 1:51:58 PM
    Author     : rosharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>User Login</title>
        <link type="text/css" rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div id="header">
            <f:view>
                <h:form>
                    <%@include file="header.jspf" %>
                    <div align="center">
                        <h:messages styleClass="ErrorMsg" layout="table"/>
                        <h:panelGrid rowClasses="even-row, odd-row" columns="2">
                             <f:facet name="header">
                                <h:outputText value="Login Information" />
                            </f:facet>
                            <h:outputLabel styleClass="Body-Small" value="User Name"/>
                            <h:inputText id="username" value="#{CustomerManagedBean.lgCustomer.username}"/>
                            <h:outputLabel styleClass="Body-Small" value="Password"/>
                            <h:inputSecret id="password" value="#{CustomerManagedBean.lgCustomer.password}"/>
                        </h:panelGrid>
                        <h:commandButton value=" Login " action="#{CustomerManagedBean.validateLogin}"/>
                    </div>
                </h:form>
            </f:view>

        </div>
    </body>
</html>

