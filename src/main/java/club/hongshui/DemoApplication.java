package club.hongshui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
//		return springApplicationBuilder.sources(DemoApplication.class);
//	}
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}

}
