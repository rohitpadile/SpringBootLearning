package org.gfg.JBDL_71_SrpingBootDemo;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration //Marked with @Configuration, indicating that it is a source of bean definitions.
public class DBBean {
//Connection method level bean is created because always we have to open and close connection
//for a specific method. Instead now by this connection() method we open the connection when we
//pass it in the constructor of PersonRepository.
//SO METHOD LEVEL BEAN IS NOT JUST CREATING OBJECT BUT ALSO INVOKING THE METHOD.

//NOTE: Method-level beans are created for the class type that is returned by the method.
/*
CONCLUDE:
When Spring processes the configuration class (`DBBean`), it calls the
`connection()` method to create a new instance of `Connection`.
This instance is then stored in the Spring application context as a bean of type `Connection`.
*/
    @Bean
    public Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/JBDL_71",
                                "root", "rootroot");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/JBDL_71");
//        dataSource.setUsername("root");
//        dataSource.setPassword("rootroot");
//        return dataSource;
//    }
}
