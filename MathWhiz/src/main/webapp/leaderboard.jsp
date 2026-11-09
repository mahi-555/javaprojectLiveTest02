<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Leaderboard - Monira Mahin Math Whiz</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Top 10 Leaderboard</h2>
        <table>
            <thead>
                <tr>
                    <th>Rank</th>
                    <th>Player Name</th>
                    <th>Score</th>
                    <th>Difficulty</th>
                    <th>Played At</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${topScores}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${row.playerName}</td>
                        <td>${row.score}</td>
                        <td>${row.difficulty}</td>
                        <td>${row.playedAt}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="index.jsp" class="btn-link">Home</a>
    </div>
</body>
</html>
