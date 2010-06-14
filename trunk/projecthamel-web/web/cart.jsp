<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>View Cart - Store </title>
        <link type="text/css" rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div id="header">
            <f:view>
                <h:form>
                    <%@include file="header.jspf" %><br><br><br><br>
                    <h:messages styleClass="ErrorMsg" layout="table"/>
                    <div align="center">                        
                        <h:dataTable title="Customer Listing" headerClass="TableHeader"  value="#{InvoiceManagedBean.invoiceService.invoice.items}" var="item" border="0" cellpadding="3" cellspacing="0"
                                     rowClasses="even-row, odd-row"  rules="all" style="border:solid 1px">
                             <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Name"/>
                                </f:facet>
                                <h:outputText value="#{item.name}"/>
                            </h:column>
                             <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Price"/>
                                </f:facet>
                                <h:outputText value="#{item.price}"/>
                            </h:column>
                              <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Remove Item"/>
                                </f:facet>
                                  <h:commandLink value="Remove Item"
                                                 action="#{InvoiceManagedBean.removeItem}">
                                      <f:param name="currentItemBarcode" value="#{item.barcode}" />
                                  </h:commandLink>
                            </h:column>
                        </h:dataTable>
                        <br>
                        <h:outputText value="Total Cost"/>
                        <h:outputText value="#{InvoiceManagedBean.invoiceService.invoice.totalCost}">
                             <f:convertNumber currencySymbol="$"
                                                 type="currency"/>
                        </h:outputText><br>
                        <h:commandButton value="Checkout" action="#{InvoiceManagedBean.checkout}"/>
                        
                        <h:commandButton value="Clear Cart" action="#{InvoiceManagedBean.clearCart}"/>
                    </div>
                </h:form>
            </f:view>
        </div>
    </body>
</html>