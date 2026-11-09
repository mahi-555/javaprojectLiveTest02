package controller;

import dao.ScoreDAO;
import model.GameScore;
import service.MathService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private ScoreDAO scoreDAO = new ScoreDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("leaderboard".equals(action)) {
            List<GameScore> topScores = scoreDAO.getTop10Scores();
            request.setAttribute("topScores", topScores);
            request.getRequestDispatcher("/leaderboard.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("start".equals(action)) {
            String playerName = request.getParameter("playerName");
            HttpSession session = request.getSession();
            session.setAttribute("playerName", playerName);

            Random rand = new Random();
            int q1Num = rand.nextInt(20) + 2;
            int q2A = rand.nextInt(50) + 1;
            int q2B = rand.nextInt(10) + 1;
            int q3Angle = 30 * (rand.nextInt(3) + 1);
            int q4Angle = 45 * (rand.nextInt(2) + 1);

            session.setAttribute("q1Num", q1Num);
            session.setAttribute("q2A", q2A);
            session.setAttribute("q2B", q2B);
            session.setAttribute("q3Angle", q3Angle);
            session.setAttribute("q4Angle", q4Angle);

            response.sendRedirect("game.jsp");
        } else if ("submit".equals(action)) {
            HttpSession session = request.getSession();
            String playerName = (String) session.getAttribute("playerName");

            int q1Num = (int) session.getAttribute("q1Num");
            int q2A = (int) session.getAttribute("q2A");
            int q2B = (int) session.getAttribute("q2B");
            double q3Angle = (int) session.getAttribute("q3Angle");
            double q4Angle = (int) session.getAttribute("q4Angle");

            int userQ1 = Integer.parseInt(request.getParameter("q1Answer"));
            int userQ2 = Integer.parseInt(request.getParameter("q2Answer"));
            double userQ3 = Double.parseDouble(request.getParameter("q3Answer"));
            double userQ4 = Double.parseDouble(request.getParameter("q4Answer"));

            int expectedQ1 = MathService.isPrime(q1Num);
            int expectedQ2 = MathService.calculateMod(q2A, q2B);
            double expectedQ3 = MathService.calculateSin(q3Angle);
            double expectedQ4 = MathService.calculateCos(q4Angle);

            int totalScore = 0;
            double tolerance = 0.01;

            if (userQ1 == expectedQ1) totalScore += 2;
            if (userQ2 == expectedQ2) totalScore += 2;
            if (Math.abs(userQ3 - expectedQ3) < tolerance) totalScore += 3;
            if (Math.abs(userQ4 - expectedQ4) < tolerance) totalScore += 3;

            GameScore scoreRecord = new GameScore();
            scoreRecord.setPlayerName(playerName != null ? playerName : "Anonymous");
            scoreRecord.setScore(totalScore);
            scoreRecord.setDifficulty("NORMAL");
            scoreDAO.saveScore(scoreRecord);

            request.setAttribute("score", totalScore);
            request.setAttribute("playerName", playerName);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
    }
}
