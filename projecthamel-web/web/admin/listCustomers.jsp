<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>View/Manage Customers - Store Admin</title>
        <link type="text/css" rel="stylesheet" href="../style.css"/>
    </head>
    <body>
        <div id="header">
            <f:view>
                <h:form>
                    <%@include file="header.jspf" %>
                    <div align="center">
                        <h4>Customer Listing</h4>
                        <h:dataTable title="Customer Listing" headerClass="TableHeader"  value="#{CustomerManagedBean.customerList}" var="item" border="0" cellpadding="3" cellspacing="0"
                                     rowClasses="even-row, odd-row"  rules="all" style="border:solid 1px">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Name"/>
                                </f:facet>
                                <h:outputText value="#{item.name}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Email"/>
                                </f:facet>
                                <h:outputText value="#{item.email}"/>
                            </h:column>

                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Username"/>
                                </f:facet>
                                <h:outputText value="#{item.username}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Password"/>
                                </f:facet>
                                <h:outputText value="#{item.password}"/>
                            </h:column>
                            <h:column>
                                <h:commandLink action="#{CustomerManagedBean.removeCustomer}" value="Remove">
                                    <f:param name="currentCustomerID" value="#{item.id}"/>
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </div>
                </h:form>
            </f:view>
        </div>
    </body>
</html>