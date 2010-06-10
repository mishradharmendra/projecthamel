<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>New Item - Store Admin</title>
        <link type="text/css" rel="stylesheet" href="../style.css"/>
    </head>
    <body>
        <div id="header">
            <f:view>
                <h:form enctype="multipart/form-data">
                    <%@include file="header.jspf" %>                   
                    <div align="center">
                        <h:panelGrid   headerClass="TableHeader"  rowClasses="even-row, odd-row" columns="3">
                            <f:facet name="header">
                                <h:outputText value="Item Information" />
                            </f:facet>
                            <h:outputText styleClass="Body-Small" value="Name:"/>
                            <h:inputText id="name" value=
                                         "#{ItemManagedBean.item.name}"
                                         title="Name" />
                            <h:message for="name" style="color:red;" />
                            
                            <h:outputLabel for="file" value="Image:" />
                            <t:inputFileUpload id="file" value="#{ItemManagedBean.uploadedFile}"
                                title="Image" />
                            <h:message for="file" style="color:red;" />
                            

                            <h:outputText styleClass="Body-Small" value="Quantity:"/>
                            <h:inputText id="quantity" value=
                                         "#{ItemManagedBean.item.quantity}"
                                         title="Quantity" size="2" maxlength="2" immediate="true">
                                <f:validateLongRange maximum="50"
                                                     minimum="5"/>
                            </h:inputText>
                            <h:message for="quantity" style="color:red;" />


                            <h:outputText styleClass="Body-Small" value="Price:"/>
                            <h:inputText id="price" value=
                                         "#{ItemManagedBean.item.price}"
                                         title="Price" size="7" maxlength="7" immediate="true">
                                <f:convertNumber maxFractionDigits="2"
                                                 groupingUsed="true"
                                                 currencySymbol="$"
                                                 maxIntegerDigits="5"
                                                 type="currency"/>
                            </h:inputText>
                            <h:message for="price" style="color:red;" />

                            <h:outputText styleClass="Body-Small" value="Barcode:"/>
                            <h:inputText id="barcode" value=
                                         "#{ItemManagedBean.item.barcode}"
                                         title="Barcode" />
                            <h:message for="barcode" style="color:red;" />

                            <h:outputText styleClass="Body-Small" value="Min Quantity:"/>
                            <h:inputText id="minQuantity" value=
                                         "#{ItemManagedBean.item.minQuantity}"
                                         title="Barcode" size="2" maxlength="2" />
                            <h:message for="minQuantity" style="color:red;" />

                           
                           
                        </h:panelGrid>
                         <h:commandButton action="#{ItemManagedBean.create}" value="Submit"/>
                            <h:commandButton immediate="true" action="home" value="Cancel"/>
                    </div>

                </h:form>
            </f:view>
        </div>
    </body>
</html>