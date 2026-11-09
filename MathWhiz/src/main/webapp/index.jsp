<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>MONIRA MAHIN – MATH WHIZ</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>MONIRA MAHIN – MATH WHIZ</h1>
        <form action="game" method="POST">
            <input type="hidden" name="action" value="start">
            <label for="playerName">Enter Your Name:</label>
            <input type="text" id="playerName" name="playerName" required autocomplete="off">
            <button type="submit">Start Game</button>
        </form>
        <br>
        <a href="game?action=leaderboard" class="btn-link">View Leaderboard</a>
    </div>
</body>
</html>
