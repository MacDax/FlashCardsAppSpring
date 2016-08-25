<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
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
                <a class="navbar-brand"><img src="<%=request.getContextPath() %>/resources/img/flashcard+.jpg"  width=150 height=40/></a>
            </div>
            <!-- Collect the nav links for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="home">Home</a>
                    </li>
                    <li><a href="userRegistrationForm">User Registration</a>
                    </li>
                    <li><a href="loginForm">Login</a>
                    </li>
                    <!-- <li><a href="#">Contact</a> -->
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	 class="container">
          <div class="row top-pad">

            <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2  text-center">
                <h1 >Dynamic FlashCards!   </h1>
                 <p >
                            Create, List and Study your own dynamic flashCards!!
                       
                        </p>
            </div>

            

        </div>
	  <!-- /.row -->
        <div class="row">
            <div class="col-md-4 col-sm-4 text-center">
               <!--  <img class="img-circle" src="/resources/img/img1.jpg"> -->
                <h3>Deck List</h3>
                <h4> Entire DeckList fetched with help of REST API. </h4>
                <div id="decklistdiv" class="text-center">
                  
                </div>
            </div>
            <div class="col-md-4 col-sm-4 text-center">
               <!--  <img class="img-circle" src="img/img1.jpg"> -->
                <h3>Question-Answer List for Each Deck</h3>
               <h4>Fetched with help of REST API and jQuery AJAX</h4>
                <div id="cardlistdiv">
                   
                </div>
            </div>
            <div class="col-md-4 col-sm-4 text-left">
                <!-- <img class="img-circle" src="img/img2.jpg"> -->
                <h3>Users registered with this site</h3>
               <h4> Fetched with help of REST API and jQuery AJAX.</h4>
                <div id="userslistdiv" >
                </div>
            </div>
            
            
           
        </div>
         <!-- /.row -->
    </div>
    <!-- /.container -->

 <!--Core JavaScript file  -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.10.2.js"></script>
    <!--bootstrap JavaScript file  -->
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.js"></script>
    <!-- ajax files to load app's data -->
    <script src="<%=request.getContextPath() %>/resources/js/decklistquery.js"></script>
    <%-- <script src="<%=request.getContextPath() %>/resources/js/try.js"></script> --%>
    <script src="<%=request.getContextPath() %>/resources/js/userslist.js"></script>
</body>
</html>
