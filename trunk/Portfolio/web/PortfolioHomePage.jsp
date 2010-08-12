<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>PortfolioHomePage</title>
	</head>

	<body>
		<h4>Welcome to the Struts 2 Portfolio!</h4> 	
		<ul>
      <li><a href="<s:url action='LoginForm'/>">Login to an Existing Account</a></li>	
      <li><a href="<s:url action='Registration'/>">Create an Account</a></li>	
      <li><a href="<s:url action='ErrorProne'/>">Error Prone Action</a></li>	
      <li><a href="<s:url action='AddImage' namespace='/chapterFour/secure'/>">Add Image ( without logging in )</a></li>	
	  </ul> 
		
	</body>
	
</html>
