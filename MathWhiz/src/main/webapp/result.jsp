<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game Result</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Game Results</h2>
        <p>Player: <strong>${playerName}</strong></p>
        <p class="score-display">Your Final Score: <strong>${score} / 10</strong></p>
        
        <div class="actions">
            <a href="index.jsp" class="btn-link">Play Again</a>
            <a href="game?action=leaderboard" class="btn-link">View Leaderboard</a>
        </div>
    </div>
</body>
</html>
