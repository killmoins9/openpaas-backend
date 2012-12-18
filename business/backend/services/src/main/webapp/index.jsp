<html>
<body>
	<h1>Hello web services !</h1>
	<a href="http://localhost:8080/restWebService/rest/services">http://localhost:8080/restWebService/rest/services</a>
	<br/>
	
<h2>exemples REST (GET)</h2>
<br/>
<a href="http://localhost:8080/restWebService/rest/messageService/messages">
http://localhost:8080/restWebService/rest/messageService/messages</a>
<br/>
<a href="http://localhost:8080/restWebService/rest/messageService/messages/number">
http://localhost:8080/restWebService/rest/messageService/messages/number</a>
<br/>
<a href="http://localhost:8080/restWebService/rest/userService/users">
http://localhost:8080/restWebService/rest/userService/users
</a>



<h1>create message</h1>
<form action="http://localhost:8080/restWebService/rest/messageService/message" method="post">
body <textarea rows="5" cols="20" name="body"></textarea><br/>
subject<input type="text" name="subject" /><br/>
<input type="submit"><br/>
</form>

<h1>create user</h1>
<form action="http://localhost:8080/restWebService/rest/userService/user" method="post">
firstname<input type="text" name="firstname" /></textarea><br/>
lastname<input type="text" name="lastname" /><br/>
login<input type="text" name="login" /><br/>
mail<input type="text" name="mail" /><br/>
<input type="submit"><br/>
</form>




</body>
</html>
