/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.services;

import com.dxhh.pojo.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CategoryService {
    public List<Category> getCategories() throws SQLException {
        try (Connection conn = JDBCUtils.getConnection()) {
            List<Category> categories = new ArrayList<>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM category");
            while(rs.next()) {
                Category c = new Category(rs.getLong("id"), rs.getString("name"));
                categories.add(c);
            }
            return categories;
        }
    }
}
