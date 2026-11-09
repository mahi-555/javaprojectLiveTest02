package dao;

import model.GameScore;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/math_whiz_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "mahin555";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveScore(GameScore score) {
        String sql = "INSERT INTO game_scores (player_name, score, difficulty, played_at) VALUES (?, ?, ?, NOW())";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, score.getPlayerName());
            pstmt.setInt(2, score.getScore());
            pstmt.setString(3, score.getDifficulty());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GameScore> getTop10Scores() {
        List<GameScore> scores = new ArrayList<>();
        String sql = "SELECT * FROM game_scores ORDER BY score DESC, played_at ASC LIMIT 10";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                GameScore score = new GameScore();
                score.setId(rs.getInt("id"));
                score.setPlayerName(rs.getString("player_name"));
                score.setScore(rs.getInt("score"));
                score.setDifficulty(rs.getString("difficulty"));
                score.setPlayedAt(rs.getTimestamp("played_at"));
                scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }
}
