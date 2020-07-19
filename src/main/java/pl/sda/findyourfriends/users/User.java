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
    private String username;
    private String firstName;
    private String lastName;
    @Column
    @NotBlank
    private String password;
    @Column
    @NotBlank
    @Email
    private String email;
    private String role;

}