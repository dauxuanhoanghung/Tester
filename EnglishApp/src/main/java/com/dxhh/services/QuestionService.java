/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.services;

import java.sql.Connection;
import com.dxhh.pojo.Question;
import com.dxhh.pojo.Choice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionService {

    public int insertQuestion(Question q, List<Choice> choices) throws SQLException {
        try ( Connection conn = JDBCUtils.getConnection()) {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO question(id, content, category_id) VALUES (?, ?, ?)";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, q.getId());
            stm.setString(2, q.getContent());
            stm.setLong(3, q.getCategoryId());

            int r = stm.executeUpdate();
            for (Choice c : choices) {
                sql = "INSERT INTO choice(id, content, is_correct, question_id) VALUES (?, ?, ?, ?)";
                PreparedStatement stm1 = conn.prepareCall(sql);
                stm1.setString(1, c.getId());
                stm1.setString(2, c.getContent());
                stm1.setBoolean(3, c.isCorrect());
                stm1.setString(4, c.getQuestionId());
                r += stm1.executeUpdate();
            }
            conn.commit();

            return r;
        }
    }

    public List<Question> getQuestions() throws SQLException {
        try (Connection conn = JDBCUtils.getConnection()) {
            List<Question> questions = new ArrayList<>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM question");
            while (rs.next()) {
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getLong("category_id"));
                questions.add(q);
            }
            return questions;
        }
    }
}
