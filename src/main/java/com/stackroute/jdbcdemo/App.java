package com.stackroute.jdbcdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        //getting the application context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        //getting the dao bean
        JdbcDaoImpl jdbcDao = applicationContext.getBean("jdbcDaoImpl",JdbcDaoImpl.class);

        //create the table
        jdbcDao.createTable();

        //insert value into table
        jdbcDao.insertIntoTable(2,"two");

        //get all the rows of table
        List<Circle> circleList = jdbcDao.retrieveFromTable();

        //print the list
        for (Circle c :
                circleList) {
            System.out.println(c);
        }

        //delete a value from table
        jdbcDao.deleteFromTable(1);

        //get all the rows of table
        circleList = jdbcDao.retrieveFromTable();

        //print the list
        for (Circle c :
                circleList) {
            System.out.println(c);
        }

    }
}
