<%@ include file="./include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FC Login Success</title>
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/style.css" />
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="htttp://www.binarytheme.com">YOUR LOGO HERE</a>
            </div>
            <!-- Collect the nav links for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="home">Home</a>
                    </li>
                    <%-- <li><a href="<%=request.getContextPath() %>/resources/html/createDeck.html">Create New Deck</a> --%>
                    <li><a href="deckForm">Create New Deck</a>
                    </li>
                    <li><a href="usersdecks?uid=${fcusers.userid}" id="decklist">List Decks</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	
	<div class="container">
		 <div class="row top-pad">

            <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2  text-center">
                <h1 > Dynamic FlashCards!   </h1>
            </div>
            <div class="row">
                    <div class="col-md-4 col-sm-4 text-center">
                   <h4>${fcusers.fname} ${fcusers.lname}</h4>
                            
            </div>
             <div class="col-md-4 col-sm-4 text-center">
                <img class="img-circle" src="/resources/img/img1.jpg">
                   <div id="decklistdiv">
                  <h4> DeckList </h4>
                </div>
                <table cellspacing="10" cellpadding="15">
<tr>
	<th>Deck Title</th>
	<th></th>
</tr>
	<c:forEach var="deckList" items="${decklist}">
		<tr>
		   <td>${deckList.title}</td>
		</tr>
	</c:forEach>
</table>
            </div>
            </div>

        </div>
	</div>

 <!--Core JavaScript file  -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.10.2.js"></script>
    <!--bootstrap JavaScript file  -->
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.js"></script>
   
</body>
</html>
