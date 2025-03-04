package peaksoft.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import  jakarta.persistence.*;
import lombok.ToString;

@Table
@Entity(name = "users")
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_gen")
    @SequenceGenerator(name = "student_gen",
    sequenceName = "student_seq",
    allocationSize = 1,
    initialValue = 1)
    private Long id;

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private Byte age;

    public User() {
    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

}