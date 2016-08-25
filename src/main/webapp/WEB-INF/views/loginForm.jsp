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
                    <li><a href="${context}/home">Home</a>
                    </li>
                    <li><a href="userRegistrationForm">User Registration</a>
                    </li>
                    <li><a href="#">Services</a>
                    </li>
                    <li><a href="#">Contact</a>
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
                 <p >  
                       
                        </p>
            </div>

                    <div class="row">
                    <div class="col-md-4 col-sm-4 text-center">
                <img class="img-circle" src="img/img1.jpg">
                <h3>Login!</h3>
               
      	<form:form action="./processlogin" method="POST" commandName="fcusers">
      	<fieldset>
      	<form:label path="email"><fmt:message key="emailLabel" /></form:label>
      	<form:input path="email" />
      	<form:errors path="email"/><br/>
      	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="<fmt:message key="enterBtn" />">
      	</fieldset>
      	</form:form>
      	
		<!-- <form name="loginForm" action="./processlogin" method="POST">
		<fieldset>
 		username : <input type="TEXT" name="email" ></font><BR>
	    &nbsp;&nbsp;&nbsp;<input type="submit" name="Logon" value="Enter">
		</fieldset>
		</form> -->
	  
    
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
	
	
	
