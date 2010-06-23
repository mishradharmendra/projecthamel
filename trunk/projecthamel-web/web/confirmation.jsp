<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Confirm Address - Store</title>
        <link type="text/css" rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div id="header">
            <f:view>
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
                <h:form>
                    <%@include file="header.jspf" %>
                    <div align="center">
                        <h:inputHidden value= "#{CustomerManagedBean.lgCustomer.id}"/>
                        <h:panelGrid columns="3" rowClasses="even-row, odd-row">
                            <f:facet name="header">
                                <h:outputText value="Your Account Information" />
                            </f:facet>
                            <f:facet name="header">
                                <h:outputText value="Customer Information" />
                            </f:facet>


                            <h:outputText styleClass="Body-Small" value="Name:"/>
                            <h:inputText id="name" value=
                                         "#{CustomerManagedBean.lgCustomer.name}"
                                         title="Name" required="true" requiredMessage="Name is required.">
                            </h:inputText>
                            <h:message for="name" style="color: red;"/>

                            <h:outputText styleClass="Body-Small" value="Street:"/>
                            <h:inputText id="street" size="50"  value=
                                         "#{CustomerManagedBean.lgCustomer.street}"
                                         title="Street" required="true" requiredMessage="Street is required.">
                            </h:inputText>
                            <h:message for="street" style="color: red;"/>

                            <h:outputText styleClass="Body-Small" value="City:"/>
                            <h:inputText id="city"  value=
                                         "#{CustomerManagedBean.lgCustomer.city}"
                                         title="Street" required="true" requiredMessage="City is required.">
                            </h:inputText>
                            <h:message for="city" style="color: red;"/>

                            <h:outputText styleClass="Body-Small" value="State:"/>
                            <h:selectOneMenu id="state" value=
                                             "#{CustomerManagedBean.lgCustomer.state}"
                                             title="State" >
                                <f:selectItem id="item1" itemLabel="AK" itemValue="AK" />
                                <f:selectItem id="item2" itemLabel="AR" itemValue="AR" />
                                <f:selectItem id="item3" itemLabel="MA" itemValue="MA" />
                                <f:selectItem id="item4" itemLabel="NY" itemValue="NY" />
                                <f:selectItem id="item5" itemLabel="VA" itemValue="VA" />

                            </h:selectOneMenu>
                            <h:message for="city" style="color: red;"/>

                            <h:outputText styleClass="Body-Small" value="Zip Code:"/>
                            <h:inputText id="zip" size="5"  value=
                                         "#{CustomerManagedBean.lgCustomer.zip}"
                                         title="Zip Code" required="true" requiredMessage="Zip Code is required.">
                                <f:convertNumber  minIntegerDigits="5" maxIntegerDigits="5"/>
                            </h:inputText>
                            <h:message for="zip" style="color: red;"/>

                            <h:outputText styleClass="Body-Small" value="Phone #:"/>
                            <h:inputText id="phone"  value=
                                         "#{CustomerManagedBean.lgCustomer.phone}"
                                         title="Phone" required="true" requiredMessage="Phone # is required.">
                                <f:convertNumber minIntegerDigits="10" maxIntegerDigits="10"/>
                            </h:inputText>
                            <h:message for="phone" style="color: red;"/>

                            <h:commandButton action="#{OrderManagedBean.confirm}" value="Confirm"/>
                            <h:commandButton action="cart" value="Cancel"/>
                        </h:panelGrid>
                    </div>
                </h:form>
            </f:view>
        </div>
    </body>
</html>