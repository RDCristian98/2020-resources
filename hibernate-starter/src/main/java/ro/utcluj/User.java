package ro.utcluj;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "USERS" )
public class User {
    private Long id;

    private String name;

    public User() {
        // this form used by Hibernate
    }

    public User(String name) {
        // for application use, to create new events
        this.name = name;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
