<html>
<body>
	<h1>Hello web services !</h1>
	<a href="http://localhost:8080/restWebService/rest/services">http://localhost:8080/restWebService/rest/services</a>
	<br/>
	
<h2>exemples REST (GET)</h2>
<br/>
<a href="http://localhost:8080/restWebService/rest/messageService/messages">http://localhost:8080/restWebService/rest/messageService/messages</a><br/>
<a href="http://localhost:8080/restWebService/rest/messageService/messages/number">http://localhost:8080/restWebService/rest/messageService/messages/number</a>


<h1>create message</h1>
<form action="http://localhost:8080/restWebService/rest/messageService/message" method="post">
body <textarea rows="5" cols="20" name="body"></textarea><br/>
subject<input type="text" name="subject" /><br/>
<input type="submit"><br/>
</form>


</body>
</html>
