/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.unittest;

import com.dxhh.pojo.Choice;
import com.dxhh.pojo.Question;
import com.dxhh.services.QuestionService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        
        Question q = new Question("What's ... name?", 3);
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("yours", false, q.getId()));
        choices.add(new Choice("your", true, q.getId()));
        choices.add(new Choice("mine", false, q.getId()));
        choices.add(new Choice("him", false, q.getId()));
        QuestionService s = new QuestionService();
        s.insertQuestion(q, choices);
    }
}
