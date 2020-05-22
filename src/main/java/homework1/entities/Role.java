package homework1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Role {

    @Id
    @Getter
    @Setter
    @Column(name = "role_id")
    private String id;

    @Getter
    @Setter
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
}
