package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.TwitterCLIRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * "@SpringBootApplication" helps you add all of the following annotations:
 * - @Configuration
 * - @EnableAutoConfiguration
 * - @ComponentScan
 */
@SpringBootApplication(scanBasePackages = "ca.jrvs.apps.twitter")
public class TwitterCLISpringBoot implements CommandLineRunner {

    private TwitterCLIRunner runner;

    @Autowired
    public TwitterCLISpringBoot(TwitterCLIRunner runner) {
        this.runner = runner;
    }
    
    @Override
    public void run(String... args) throws Exception {
        runner.run(args);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TwitterCLISpringBoot.class);
        //Turn off the web application
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
