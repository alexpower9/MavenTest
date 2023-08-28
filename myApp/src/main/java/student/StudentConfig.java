package student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig
{
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository)
	{
		return args -> 
		{
			Student alex = new Student(
					"Alex Power",
					"alexpower9@gmail.com",
					LocalDate.of(2002, Month.JANUARY, 4)
					);
			Student skip = new Student(
					"Skip Jones",
					"skipjones@gmail.com",
					LocalDate.of(2005, Month.JANUARY, 4)
					);
			repository.saveAll(List.of(alex,skip));
		};
	}
}
