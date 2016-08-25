<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Decks</title>
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/style.css" />
</head>
<body>
<div id="main" class="centerAlign">
		<div id="wrapper">
            <div id="header" class="caps centerAlign">
            <h3>&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; Welcome to FlashCardsBuilder!</h3>
            </div>
            
             <div class="column">
                <div>
                <h3>Build your own FlashCards Sets!</h3><br />
                   Create, list and share your flashcards to make things easy to remember!
                                     
                </div>
            </div>
            
             <div class="center">
                     	List of Decks:
				<c:forEach items="${deckList}" var="title">
					 <%--<a href=${pageContext.request.contextPath}/views/showCards.jsp?dckid=${title.deckid}>${title}</a> <br/>--%>
					<a href=${pageContext.request.contextPath}/showcards.html?dckid=${title.deckid}>${title}</a><br/>
					<%--<a href=${pageContext.request.contextPath}/showCards.html?dckid=${title.deckid}>${title}</a><br/>--%>
	    		</c:forEach>
            </div>
            
            <div class="column">
                <div>
                <h3>Register</h3><br />
                New users, 
                <a href="/FlashCardBuilder/userregistrationform">Sign up here! </a>
                <hr>
                <h3>Login</h3><br />
                <a href="/FlashCardBuilder/login">Login</a>     
                <!-- if wrong username/pwd, print wrong username/pwd message. -->
                		 ${NoLoginMatch}
                		            
                <!-- if successful login, print user's firstname and lastname -->
                
                	${sessionScope.user.fname} ${sessionScope.user.lname}	
                    <a href="/FlashCardBuilder/logout.html">Logout</a>                
                
                </div>
            </div>
            
			    
             <div id="footer" class="caps centerAlign">
            <h3>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; Copyright (C) Sonal </h3>
            </div>
            </div>
            
		</div>
<!--Core JavaScript file  -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.10.2.js"></script>
    <!--bootstrap JavaScript file  -->
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.js"></script>
</body>
</html>