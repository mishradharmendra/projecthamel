<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>View/Manage Items - Store Admin</title>
        <link type="text/css" rel="stylesheet" href="../style.css"/>
    </head>
    <body>
        <div id="header">
            <f:view>
                <h:form>
                    <%@include file="header.jspf" %>
                    <div align="center">
                        <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
                        <h4>Item Listing</h4>
                        <h:dataTable title="Item Listing" headerClass="TableHeader"  value="#{ItemManagedBean.itemList}" var="item" border="0" cellpadding="3" cellspacing="0"
                                     rowClasses="even-row, odd-row" frame="border"  rules="all" style="border:solid 1px">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Name"/>
                                </f:facet>
                                <h:outputText value="#{item.name}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                </f:facet>
                                <h:graphicImage rendered="true" width="100px" height="100px" value="../images/#{item.image}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Quantity"/>
                                </f:facet>
                                <h:outputText value="#{item.quantity}"/>
                            </h:column>

                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Price"/>
                                </f:facet>
                                <h:outputText value="#{item.price}">
                                    <f:convertNumber maxFractionDigits="2"
                                                     groupingUsed="true"
                                                     currencySymbol="$"
                                                     type="currency"/>
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Barcode"/>
                                </f:facet>
                                <h:outputText value="#{item.barcode}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Min Quantity"/>
                                </f:facet>
                                <h:outputText value="#{item.minQuantity}"/>
                            </h:column>

                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Order Quantity"/>
                                </f:facet>
                                <h:outputText value="#{item.itemsToOrder}"/>
                            </h:column>

                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Shipping Cost"/>
                                </f:facet>
                                <h:outputText value="#{item.shippingCost}">
                                    <f:convertNumber maxFractionDigits="2"
                                                     groupingUsed="true"
                                                     currencySymbol="$"
                                                     type="currency"/>
                                </h:outputText>

                            </h:column>

                            <h:column>
                                <h:commandLink action="#{ItemManagedBean.editItem}" value="Edit">
                                    <f:param name="currentItemBarcode" value="#{item.barcode}"/>
                                </h:commandLink>
                            </h:column>


                            <h:column>
                                <h:commandLink action="#{ItemManagedBean.removeItem}" value="Remove">
                                    <f:param name="currentItemID" value="#{item.id}"/>
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                        <br>
                        <h:commandLink action="#{ItemManagedBean.createItem}"
                                       value="Add Item"/>
                    </div>
                </h:form>
            </f:view>
        </div>
    </body>
</html>