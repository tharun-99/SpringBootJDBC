package com.spring.boot.jdbc.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public UserDao(){

    }

    public int createTable(){
        String query  = "CREATE TABLE IF NOT EXISTS User(id int primary key, name varchar(200), age int, city varchar(200))";
        int update = this.jdbcTemplate.update(query);
        return update;
    }

    public int insertUser(Integer id, String name, Integer age, String city){
        String query = "INSERT INTO User(id, name, age, city) values(?,?,?,?)";
        int update = this.jdbcTemplate.update(query, new Object[]{id, name, age, city});
        return update;
    }

    public int updateUser(Integer id, String name){
        String query = "UPDATE User SET name=? WHERE id=?";
        int result = this.jdbcTemplate.update(query, new Object[]{name, id});
        return result;
    }

    public int deleteUser(Integer id){
        String query = "DELETE FROM User WHERE id=?";
        int result = this.jdbcTemplate.update(query, new Object[]{id});
        return result;
    }
}
