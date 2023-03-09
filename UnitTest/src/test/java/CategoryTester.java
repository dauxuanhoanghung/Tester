
import com.dxhh.pojo.Category;
import com.dxhh.services.CategoryService;
import com.dxhh.unittest.JDBCUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class CategoryTester {

//    private static Connection conn;
//
//    @BeforeAll
//    public static void beforeAll() {
//        try {
//            conn = JDBCUtils.getConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @AfterAll
//    public static void afterAll() {
//        if (conn != null)
//            try {
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @Test
//    public void nameCategoryNotSame() throws SQLException {
//        CategoryService s = new CategoryService();
//        List<Category> categories = s.getCategories();
//
//        List<String> names = categories.stream().flatMap(c -> Stream.of(c.getName())).collect(Collectors.toList());
//        Set<String> testNames = new HashSet<>(names);
//
//        Assertions.assertEquals(names.size(), testNames.size());
//    }
    
}
