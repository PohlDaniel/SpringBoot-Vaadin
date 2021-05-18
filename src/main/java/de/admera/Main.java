package de.admera;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import de.admera.database.InitDatabase;

@SpringBootApplication
@ComponentScan({"de.admera"})
public class Main extends SpringBootServletInitializer {

	@Autowired
	InitDatabase initDatabase;
	
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(new Class[] { Main.class});
    }
    
    @PostConstruct
    public void init() {
    	initDatabase.init();
    }
}
