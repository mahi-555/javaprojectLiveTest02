<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game Challenges - Monira Mahin Math Whiz</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Welcome, ${sessionScope.playerName}!</h2>
        <form action="game" method="POST">
            <input type="hidden" name="action" value="submit">
            
            <div class="question-card">
                <p><strong>Q1 (Prime Number - 2 Marks):</strong> Is the number <strong>${sessionScope.q1Num}</strong> prime? (Enter 1 for Prime, 0 for Not Prime)</p>
                <input type="number" name="q1Answer" required>
            </div>

            <div class="question-card">
                <p><strong>Q2 (Modulus - 2 Marks):</strong> Calculate remainder: <strong>${sessionScope.q2A} % ${sessionScope.q2B}</strong></p>
                <input type="number" name="q2Answer" required>
            </div>

            <div class="question-card">
                <p><strong>Q3 (Trigonometry - 3 Marks):</strong> Calculate Sine of <strong>${sessionScope.q3Angle}°</strong></p>
                <input type="number" step="any" name="q3Answer" required>
            </div>

            <div class="question-card">
                <p><strong>Q4 (Trigonometry - 3 Marks):</strong> Calculate Cosine of <strong>${sessionScope.q4Angle}°</strong></p>
                <input type="number" step="any" name="q4Answer" required>
            </div>

            <button type="submit">Submit Answers</button>
        </form>
    </div>
</body>
</html>
