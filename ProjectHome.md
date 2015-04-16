The project is developed in Netbeans 6.7 hosted on glassfish v2.1 server. External warehouse is another web application hosted on same glassfish server (for development purpose).

The presentation layer is based on JSF 1.2 and Apache MyFaces. The model is JSF backing beans and entity EJB with EJB service beans as business logic layer.

Business requirements:
1. Customer can create accounts and purchase items.
2. Admin users can add inventory, view customer accounts.
3. System sends message to external warehouse whenever the minimum quantity of inventory item is reached or crossed.
4. System sends confirmation email of order to customer and warehouse.
5. External warehouse application admin users can view invoice/orders and inventory low levels.
6. External warehouse also adds inventory items. No need to keep employee information. Anybody interested can do this later.