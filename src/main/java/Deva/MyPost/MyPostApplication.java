package Deva.MyPost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "myPost")
@EnableJpaRepositories("myPost.repository")
@EntityScan("myPost.beans")
public class MyPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPostApplication.class, args);
	}

}
