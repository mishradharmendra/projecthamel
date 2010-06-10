<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link type="text/css" rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div id="header">
            <f:view>
                <h:form>
                    <%@include file="header.jspf" %><br><br><br><br>
                     <h:messages layout="table"/>
                    <h4>Select from the list of latest items in the store..</h4>
                    <table>
                        <tr>
                            <td width="10%">
                            </td>
                            <td>
                                <h:dataTable value="#{ItemManagedBean.itemList}" var="item" border="0" cellpadding="4" cellspacing="4"
                                             rowClasses="even-row, odd-row" rows="2" first="2">

                                    <h:column>
                                        <h:graphicImage width="100px" height="100px"  value="../images/#{item.image}"/><br>
                                        <h:outputText value="#{item.name}"/><br>
                                        <h:outputText value="#{item.price}"/><br>                                         
                                        <h:commandLink  value="Add" action="#{InvoiceManagedBean.addItem}">
                                            <f:param name="currentItemBarcode" value="#{item.barcode}"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </td>
                            <td width="10%">
                            </td>
                            <td>
                                <h:dataTable  value="#{ItemManagedBean.itemList}" var="item" border="0" cellpadding="4" cellspacing="4"
                                              rowClasses="even-row, odd-row" rows="2" first="0">

                                    <h:column>
                                        <h:graphicImage width="100px" height="100px" value="../images/#{item.image}"/><br>
                                        <h:outputText value="#{item.name}"/><br>
                                        <h:outputText value="#{item.price}"/><br>
                                         <h:commandLink value="Add" action="#{InvoiceManagedBean.addItem}">
                                            <f:param name="currentItemBarcode" value="#{item.barcode}"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </td>
                            <td width="10%">
                            </td>
                            <td>
                                <h:dataTable  value="#{ItemManagedBean.itemList}" var="item" border="0" cellpadding="4" cellspacing="4"
                                              rowClasses="even-row, odd-row" rows="2" first="4">

                                    <h:column>
                                        <h:graphicImage width="100px" height="100px" value="../images/#{item.image}"/><br>
                                        <h:outputText value="#{item.name}"/><br>
                                        <h:outputText value="#{item.price}"/><br>
                                        <h:commandLink value="Add" action="#{InvoiceManagedBean.addItem}">
                                            <f:param name="currentItemBarcode" value="#{item.barcode}"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </td>
                        </tr>
                    </table>
                </h:form>
            </f:view>
        </div>
    </body>
</html>