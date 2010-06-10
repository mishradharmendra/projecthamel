<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>My Account - Store</title>
        <link type="text/css" rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div id="header">
            <f:view>
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
                <h:form>
                    <%@include file="header.jspf" %>
                    <div align="center">
                        <h:panelGrid columns="2" rowClasses="even-row, odd-row">
                            <f:facet name="header">
                                <h:outputText value="Customer Account Information" />
                            </f:facet>
                            <h:outputText value="Name:"/>
                            <h:inputText id="name" value=
                                         "#{CustomerManagedBean.lgCustomer.name}"
                                         title="Name" />

                            <h:outputText value="Email:"/>
                            <h:inputText id="email" value=
                                         "#{CustomerManagedBean.lgCustomer.email}"
                                         title="Email" />

                            <h:outputText value="Username:"/>
                            <h:inputText id="username" value=
                                         "#{CustomerManagedBean.lgCustomer.username}"
                                         title="Username" />

                            <h:outputText value="Password:"/>
                            <h:inputSecret id="password" value=
                                           "#{CustomerManagedBean.lgCustomer.password}"
                                           title="Password" />
                            <h:commandButton action="#{CustomerManagedBean.edit}" value="Update"/>
                            <h:commandButton action="home" value="Cancel"/>
                        </h:panelGrid>
                    </div>
                </h:form>
            </f:view>
        </div>
    </body>
</html>