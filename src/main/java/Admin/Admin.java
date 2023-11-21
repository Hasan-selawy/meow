package Admin;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Admin {
    @Id
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )

    private Long id;
    private String name;
    private String email;

    private LocalDate bd;
    @Transient
    private  int age;

    public Admin() {
    }

    public Admin(Long id,
                 String name,
                 String email,

                 LocalDate bd) {
        this.id = id;
        this.name = name;
        this.email = email;

        this.bd = bd;
    }

    public Admin(String name,
                 String email,

                 LocalDate bd) {
        this.name = name;
        this.email = email;

        this.bd = bd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return Period.between(this.bd,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBd() {
        return bd;
    }

    public void setBd(LocalDate bd) {
        this.bd = bd;
    }

    @Override
    public String toString() {
        return "admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", bd=" + bd +
                '}';
    }

    public static class adminController {
    }
}

