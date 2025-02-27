<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="static/styles.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Test Form</title>
</head>
<body>
<main>
    <h1>Client Data</h1>
    <form action="svUsers" method="post">
        <p>
            <label for="inp_id">Id</label>
            <input name="id" type="number" id="inp_id">
        </p>
        <p>
            <label for="inp_name">Fisrt Name</label>
            <input name="firstName" type="text" id="inp_name">
        </p>
        <p>
            <label for="inp_last_name">Last Name</label>
            <input name="lastName" type="text" id="inp_last_name" name>
        </p>
        <p><button type="submit">Send</button></p>
    </form>
    <h2><a href="svUsers">Show User List</a></h2>
</main>
</body>