/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.services;

import java.sql.Connection;
import com.dxhh.unittest.JDBCUtils;
import com.dxhh.pojo.Question;
import com.dxhh.pojo.Choice;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class QuestionService {
    
    public int insertQuestion(Question q, List<Choice> choices) throws SQLException {
        try (Connection conn = JDBCUtils.getConnection()) {
            String sql = "INSERT INTO question(id, content, category_id) VALUES (?, ?, ?)";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, q.getId());
            stm.setString(2, q.getContent());
            stm.setLong(3, q.getCategoryId());
            
            int r = stm.executeUpdate();
            choices.forEach(e -> {
                ChoiceService s = new ChoiceService();
                try {
                    s.addChoice(e);
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            return r;
        }
    }
}
