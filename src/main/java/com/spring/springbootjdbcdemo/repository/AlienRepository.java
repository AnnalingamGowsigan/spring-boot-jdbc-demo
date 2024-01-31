package com.spring.springbootjdbcdemo.repository;

import com.spring.springbootjdbcdemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

@Repository
public class AlienRepository {
    private JdbcTemplate jdbcTemplate;


    public void save(Alien alien){
        String sql = "insert into alien (id,name, tech) values (?,?,?)";
        int rows =  jdbcTemplate.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println("No of rows inserted: " + rows);
    }

    public List<Alien> getAll(){
        String sql = "select * from alien";

        RowMapper<Alien> rawMapper = new RowMapper<Alien>(){
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien alien = new Alien();

                alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setName(rs.getString(3));

                return alien;
            }

        };

        List<Alien> aliens =  jdbcTemplate.query(sql,rawMapper);
        return aliens;

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
