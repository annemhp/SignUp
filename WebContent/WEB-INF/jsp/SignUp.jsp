<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="home.signup.title"/></title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
#login-box {
	margin-top: 10%;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
td{
	padding: 4%;
}
</style>
</head>
<body>
<div id="login-box" class="col-md-4 col-md-offset-4">
<h2 class="container-fluid" ><spring:message code="home.signup.welcomeMessage"/></h2>

	<form   action="/SignUp/submit.html" method=post>
			<table>
				<tr>
					<td><label for="userName">UserName:</label></td>
					<td><input type="text" id="userName" name="userName"
						required="required" pattern="[A-Za-z0-9]{5,}"
						title=<spring:message code="Pattern.user.userName"/>
						placeholder="UserName">
					</td>
				</tr>
				<tr>
					<td><label for="password">Password:</label></td>
					<td><input type="password" id="password" name="password"
						required="required" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title=<spring:message code="Pattern.user.password"/>
						placeholder="Password"></td>
				</tr>
				<tr>
				<td></td>
					<td colspan='2'><input type="submit" id="submit"
						class="btn btn-primary  center_div" value="SignUp"></td>
				</tr>
			</table>
			<div class="alert-warning" >${errorMessage}</div> 
	<form:errors class="alert-warning" path="user.*"/>
	</form>

</div>
</body>
</html>