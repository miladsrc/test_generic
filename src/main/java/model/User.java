package model;

import base.model.BaseEntity;
import base.repository.BaseRepository;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity<Integer> {
    String firstName;
    String lastName;
    String username;
    String password;

    public User(Integer integer, String firstName, String lastName, String username, String password) {
        super(integer);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
}
