package org.aptech.t2303e.config.properties;

import lombok.Data;
import org.aptech.t2303e.reflection.annotations.ConfigurationProperties;
import org.aptech.t2303e.reflection.annotations.Value;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Data
@ConfigurationProperties
public class DatabaseProperties {
    @Value("datasource.mysql.url")
    private String url;
    @Value("datasource.mysql.username")
    private String username;
    @Value("datasource.mysql.password")
    private String password;
//    public static void main(String[] args) {
//        DatabaseProperties databaseProperties = new DatabaseProperties();
//    }
//
//    public DatabaseProperties() {
//        // create reader for props file
//        try {
//            FileReader reader = new FileReader("./src/main/resources/application.properties");
//            Properties props = new Properties();
//            props.load(reader);
//            this.setUrl(props.getProperty("datasource.mysql.url"));
//            this.setUsername(props.getProperty("datasource.mysql.username"));
//            this.setPassword(props.getProperty("datasource.mysql.password"));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
