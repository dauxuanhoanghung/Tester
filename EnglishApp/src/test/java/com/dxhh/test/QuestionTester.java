/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.test;
import com.dxhh.services.JDBCUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 *
 * @author admin
 */
public class QuestionTester {
    //Q1 != null
    //Q1 choice
    //Q1 cate
    //Q1 
    private static Connection conn;

    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JDBCUtils.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterAll
    public static void afterAll() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void testAddSuccess() {
        
    }
}
