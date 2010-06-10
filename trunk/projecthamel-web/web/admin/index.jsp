<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
        <link type="text/css" rel="stylesheet" href="../style.css"/>
    </head>
    <body>
        <div id="header">
            <f:view>
                <h:form>
                    <%@include file="header.jspf" %>
                    <h:panelGroup>
                        <h:panelGrid rowClasses="even-row, odd-row" width="100%" headerClass="TableHeader" columns="1">
                            <f:facet name="header">
                                <h:outputText value="Customer Information" />
                            </f:facet>
                            <h:commandLink action="#{CustomerManagedBean.listCustomer}"
                                           value="View/Manage Customers"/>
                        </h:panelGrid>
                    </h:panelGroup>
                    <br>
                    <br>
                    <br>
                    <br>
                    <h:panelGroup>
                        <h:panelGrid cellspacing="2" rowClasses="even-row, odd-row"  width="100%" headerClass="TableHeader" columns="1">
                            <f:facet name="header">
                                <h:outputText value="Manage Inventory" />
                            </f:facet>
                            <h:commandLink action="#{ItemManagedBean.listItems}"
                                           value="View Items"/>
                            <h:commandLink action="#{ItemManagedBean.createItem}"
                                           value="Add Item"/>
                        </h:panelGrid>
                    </h:panelGroup>
                    <br>
                    <br>
                    <br>
                    <br>
                    <h:panelGroup>
                        <h:panelGrid rowClasses="even-row, odd-row" width="100%" headerClass="TableHeader" columns="1">
                            <f:facet name="header">
                                <h:outputText value="Billing Information" />
                            </f:facet>
                            <h:commandLink action="#{InvoiceManagedBean.listCustomer}"
                                           value="View Invoices"/>
                        </h:panelGrid>
                    </h:panelGroup>


                </h:form>
            </f:view>
        </div>
    </body>
</html>