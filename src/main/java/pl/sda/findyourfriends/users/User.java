package pl.sda.findyourfriends.users;

import lombok.*;
import pl.sda.findyourfriends.util.JpaOnly;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    @NotBlank
    @NotNull
    private String username;
    private String firstName;
    private String lastName;
    @Column
    @NotBlank
    @NotNull
    private String password;
    @Column
    @NotBlank
    @NotNull
    @Email
    private String email;
    private String role;
    public User(@NotBlank @NotNull String username, String firstName, String lastName,
                @NotBlank @NotNull String password, @NotBlank @NotNull @Email String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }
}