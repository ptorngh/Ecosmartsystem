package com.example.Ecosmartsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBCategoryRepository {

    @Autowired
    private DataSource dataSource;

    public List<Category> getCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM CATEGORY")) {

            while (rs.next()) {
                categoryList.add(rsCategory(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }


    private Category rsCategory(ResultSet rs) throws SQLException {
        return new Category(rs.getInt("ID"),
                rs.getString("NAME"));
    }

    public String getCategoryName (int categoryid) {
        Category category1 = new Category();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM CATEGORY WHERE ID = '" + categoryid + "'")) {

            while (rs.next()) {
                category1 = rsCategory(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category1.getName();
    }

}