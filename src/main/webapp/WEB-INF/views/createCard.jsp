<%@ include file="./include.jsp"%>
<html>
<head>
<title>User Login Details</title>
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
                    <ul class="nav navbar-nav">
                    <li><a href="home">Home</a>
                    </li>
                    <%-- <li><a href="<%=request.getContextPath() %>/resources/html/createDeck.html">Create New Deck</a> --%>
                    <li><a href="deckForm">Create New Deck</a>
                    </li>
                    <li><a href="usersdecks?uid=${fcusers.userid}" id="decklist">List My Decks</a>
                    <%-- <li><a href="usersdecks?uid=${fcusers.userid}">List My Decks</a> --%>
                    </li>
                </ul>
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
                 <p >  
                       
                        </p>
            </div>

                    <div class="row">
                    <div class="col-md-4 col-sm-4 text-center">
                <img class="img-circle" src="img/img1.jpg">
                <h3>${fcusers.fname} , &nbsp; &nbsp; ${fcusers.lname}</h3>
                <h3>${fcdeck.title}</h3>
                <h4>Create Card</h4>
               
      	<form:form name="cardForm" action="./createcard" method="POST" commandName="fccard">
      	
      	<form:label path="question"><fmt:message key="questionLabel" /></form:label>
      	<form:input path="question" />
      	<form:errors path="question"/><br/>
      	<form:label path="answer"><fmt:message key="answerLabel" /></form:label>
      	<form:input path="answer" />
      	<form:errors path="answer"/><br/>
      	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="createCard" value="<fmt:message key="enterBtn" />">
      
      	</form:form>
      	</div>
      	
      	<div class="col-md-4 col-sm-4 text-left">
                <img class="img-circle" src="img/img2.jpg">
                <h3>List of All Decks</h3>
               <div id="decklistdiv">
                  <h4> DeckList fetched with help of REST API. </h4>
                </div>
            </div>
      	
        </div>

        </div>
	</div>

 <!--Core JavaScript file  -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.10.2.js"></script>
    <!--bootstrap JavaScript file  -->
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/try.js"></script>
</body>
</html>
	
	
	
