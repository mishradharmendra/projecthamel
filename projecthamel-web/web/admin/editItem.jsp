<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Edit Item - Store Admin</title>
        <link type="text/css" rel="stylesheet" href="../style.css"/>
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
                                <h:outputText value="Item Information" />
                            </f:facet>
                            <h:outputText value="Name:"/>
                            <h:inputText id="name" value=
                                         "#{ItemManagedBean.item.name}"
                                         title="Name" />

                            <h:graphicImage width="100px" height="100px" value="../images/#{ItemManagedBean.item.image}"/>
                            <t:inputFileUpload id="file" value="#{ItemManagedBean.uploadedFile}"
                                title="Image" />

                            <h:outputText value="Quantity:"/>
                            <h:inputText id="quantity" value=
                                         "#{ItemManagedBean.item.quantity}"
                                         title="Quantity" />

                            <h:outputText value="Price:"/>
                            <h:inputText id="price" value=
                                         "#{ItemManagedBean.item.price}"
                                         title="Price" />

                            <h:outputText value="Barcode:"/>
                            <h:inputText id="barcode" value=
                                           "#{ItemManagedBean.item.barcode}"
                                           title="Barcode" />

                            <h:outputText value="Min Quantity:"/>
                            <h:inputText id="minQuantity" value=
                                           "#{ItemManagedBean.item.minQuantity}"
                                           title="Min Quantity" />


                            <h:commandButton action="#{ItemManagedBean.edit}" value="Update"/>
                            <h:commandButton immediate="true" action="admin" value="Cancel"/>
                        </h:panelGrid>
                    </div>
                </h:form>
            </f:view>
        </div>
    </body>
</html>