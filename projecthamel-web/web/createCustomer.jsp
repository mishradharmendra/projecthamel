<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>New Account - Store</title>
        <link type="text/css" rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div id="header">
            <f:view>
                <h:form id="signupForm">
                    <%@include file="header.jspf" %>
                    <div class="clear"/>
                    <div align="center">
                        <!--h:messages styleClass="Error" layout="table"-->
                        <h:panelGrid  rowClasses="even-row, odd-row" columns="3">
                            <f:facet name="header">
                                <h:outputText value="Customer Information" />
                            </f:facet>
                            <h:outputText styleClass="Body-Small" value="Name:"/>
                            <h:inputText id="name" value=
                                         "#{CustomerManagedBean.customer.name}"
                                         title="Name" required="true" requiredMessage="Name is required.">
                            </h:inputText>
                            <h:message for="name" style="color: red;"/>

                            <h:outputText styleClass="Body-Small" value="Email:"/>
                            <h:inputText id="email" value=
                                         "#{CustomerManagedBean.customer.email}"
                                         title="Email" required="true" requiredMessage="Email is required.">
                                <f:validator validatorId="validator" />
                            </h:inputText>
                            <h:message for="email" style="color: red;"/>

                            <h:outputText styleClass="Body-Small" value="Username:"/>
                            <h:inputText id="username" value=
                                         "#{CustomerManagedBean.customer.username}"
                                         title="Username" required="true" requiredMessage="Username is required.">
                            </h:inputText>
                            <h:message for="username" style="color: red;"/>

                            <h:outputText styleClass="Body-Small" value="Password:"/>
                            <h:inputSecret id="password" value=
                                           "#{CustomerManagedBean.customer.password}"
                                           title="Password" required="true" requiredMessage="Password is required.">
                            </h:inputSecret>
                            <h:message for="password" style="color: red;"/>

                            <h:commandButton action="#{CustomerManagedBean.create}" value="Submit"/>
                            <h:commandButton immediate="true" action="home" value="Cancel"/>
                            &nbsp;
                        </h:panelGrid>
                    </div>
                </h:form>
            </f:view>
        </div>
    </body>
</html>