package com.example.Ecosmartsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBTransactionRepository {

    @Autowired
    private DataSource dataSource;

    public List<Transaction> getTransactionList() {
        List<Transaction> transactionList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM TRANSACTION ORDER BY DATE")) {

            while (rs.next()) {
                transactionList.add(rsTransaction(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionList;
    }

    public int totalPerCategory(String Category) {
        int sum = 0;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM TRANSACTION WHERE CATEGORY = '" + Category + "'")) {

            while (rs.next()) {
                sum = rsTransaction(rs).getAmount() + sum;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sum;
    }

    private Transaction rsTransaction(ResultSet rs) throws SQLException {
        return new Transaction(rs.getInt("ID"),
                rs.getString("CATEGORY"),
                rs.getInt("AMOUNT"),
                rs.getInt("DATE"));
    }

}