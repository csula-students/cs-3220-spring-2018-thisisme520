<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../app.css">
		<title>admin-generator</title>
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
			<label for="generatorname">Generator Name</label><br>
			<input type="text" id="generatorname"><br>
			<label for="generatorrate">Generator Rate</label><br>
			<input type="number" id="generatorrate"><br>
			<label for="basecost">Base Cost</label><br>
			<input type="number" id="basecost"><br>
			<label for="unlockat">Unlock at</label><br>
			<input type="number" id="unlockat"><br>
			<label for="Description">Description</label><br>
			<input type "text" id ="description"><br>
			<button>Add|Edit</button>
		</form>

		<table>
			<tr>
				<th>Name</th>
				<th>Rate</th>
				<th>Cost</th>
				<th>Unlock At</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${generator}" var="generator">
			<tr>
				<td>${generator.getName()}</td>
				<td>${generator.getRate()}</td>
				<td>${generator.getBaseCost()}</td>
				<td>${generator.getUnlockAt()}</td>
				<td>${generator.getDescription()}</td>
				<td>
                    <a href='../admin/generators/?id=${generator.getId()}'>Edit</a>
                    <a href='../admin/generators/?id=${generator.getId()}'>Delete</a>

				</td>
			</tr>
			</c:forEach>

		</table>



	</body>
</html>