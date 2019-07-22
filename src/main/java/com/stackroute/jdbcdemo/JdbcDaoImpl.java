package com.stackroute.jdbcdemo;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcDaoImpl extends JdbcDaoSupport {

    //method to create a table
    void createTable() {
        String sql = "create table circle(id int primary key,name varchar(20))";    //the query to execute
        if (this.getJdbcTemplate() != null) {                                       //check if JdbcTemplate is null
            this.getJdbcTemplate().execute(sql);                                    //execute the query
            System.out.println("Table created");
        }
    }

    //method to get all rows from the table
    List<Circle> retrieveFromTable() {
        String sql = "select * from circle";                                //the query to execute
        if (this.getJdbcTemplate() != null) {                               //check if JdbcTemplate is null
            return this.getJdbcTemplate().query(sql,new CircleMapper());    //execute the query with the help of -
        }                                                                   //- RowMapper implementation
        return null;
    }

    //The RowMapper implementation
    private final class CircleMapper implements RowMapper<Circle>{

        @Override
        public Circle mapRow(ResultSet resultSet, int i) throws SQLException {
            Circle circle = new Circle();                       //get the circle object
            circle.setId(resultSet.getInt("id"));            //put the values
            circle.setName(resultSet.getString("name"));
            return circle;                                      //return the circle object
        }
    }

    //method to insert into table
    void insertIntoTable(int id, String name) {
        String sql = "insert into circle values (?,?)";         //query to execute
        if (this.getJdbcTemplate() != null) {                   //check if JdbcTemplate is null
            this.getJdbcTemplate().update(sql, id, name);       //execute the query
            System.out.println("data inserted into table");
        }
    }

    void deleteFromTable(int id){
        String sql = "delete from circle where id=?";           //query to execute
        if (this.getJdbcTemplate() != null) {                   //check if JdbcTemplate is null
            this.getJdbcTemplate().update(sql, id);             //execute the query
            System.out.println("data deleted from table");
        }
    }
}
