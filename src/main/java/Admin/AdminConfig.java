package Admin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AdminConfig {
    @Bean
    CommandLineRunner commandLineRunner(AdminRepository repository){
        return args -> {
            Admin hasan =new Admin(
                    1L,
                    "hasan",
                    "hasan.omar@gmail.com",

                    LocalDate.of(2003, Month.OCTOBER,5)
            );
            Admin BONES =new Admin(
                    1L,
                    "BONES",
                    "BONES.FTP@gmail.com",

                    LocalDate.of(1993, Month.SEPTEMBER,25  )
            );
            repository.saveAll(
                    List.of(hasan,BONES)
            );
        };
    }
}
