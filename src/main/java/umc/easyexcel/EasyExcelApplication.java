package umc.easyexcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EasyExcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyExcelApplication.class, args);
	}

}
