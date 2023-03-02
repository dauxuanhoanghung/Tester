/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.services;

import com.dxhh.pojo.Choice;
import com.dxhh.unittest.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ChoiceService {
    public int addChoice(Choice c) throws SQLException {
        try (Connection conn = JDBCUtils.getConnection()) {
            String sql = "INSERT INTO choice(id, content, is_correct, question_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, c.getId());
            stm.setString(2, c.getContent());
            stm.setBoolean(3, c.isCorrect());
            stm.setString(4, c.getQuestionId());
            
            int r = stm.executeUpdate();
            return r;
        }
    }
}
