<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../app.css">
		<title>Incremental Game</title>
	</head>
	<body>
		<h1>Incremental Game</h1>
		<nav>
            <a href="/admin/information">Information</a>
             |
            <a href="/admin/events">Events</a>
             |
            <a href="/admin/generators">Generators</a>
         </nav>

		<form method="post">
			<label for='event_name'>Event name</label><br>
			<input  type='text' id='eventname' /><br>
			<label for='event_description'>Event Descrption</label><br>
			<input type "text" id ="eventDescription"><br>
			<label for='triggerAt'>Trigger At</label><br>
			<input type='number' id='triggerAt' /><br>

			<button>Add|Edit</button>
		</form>

		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Trigger At </th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${eventEntries}" var="event">
			<tr>
				<td>${event.getName()}</td>
				<td>${event.getDescription()}</td>
				<td>${event.getTriggerAt()}</td>
				<td>
                    <a href='EditEventServlet?id=${event.getId()}'>Edit</a> 
                    <a href='DeleteEventServlet?id=${event.getId()}'>Delete</a>

				</td>
			</tr>
			</c:forEach>

		</table>



	</body>
</html>