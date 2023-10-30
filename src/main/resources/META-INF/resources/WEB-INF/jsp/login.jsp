<html>
	<head>
		<title> Login Page</title>
	</head>
	<body>
	<h1>Spring</h1>
		<p>Welcome to the login page ${ name }!!</p>
		<br/>
		<form method="post">
			Name: <input type="text" name="name">
			Password: <input type="password" name="password">
			<input type="submit">
		</form>
		<p style="color:red">${err}</p>
	</body>
</html>
