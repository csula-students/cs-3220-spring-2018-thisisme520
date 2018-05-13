<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../app.css">
		<title>game</title>
	</head>
	<body>
		<h1>Incremental Game</h1>

		<div class="head">
			<game-story-book></game-story-book>
		</div>

		<game-button></game-button>

		<game-counter></game-counter>

		<div class="generators">
			<game-generator data-id="0"></game-generator>
			<game-generator data-id="1"></game-generator>
			<game-generator data-id="2"></game-generator>
		</div>


		<script>
		  window.game = {
		  state: {
		  counter: 0
		  }
		  };
		  window.game.state = ${state};
		</script>
	</body>
</html>