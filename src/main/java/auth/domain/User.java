package auth.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @NotNull
    private int  userId;
    @Column(name = "username")
    @NotNull
    private String username;
    @Column(name = "password")
    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_has_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private List<Role> roles;

    public User(int  userId, String username, String password, List<Role> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User() {

    }

    public int  getUserId() {
        return userId;
    }

    public void setUserId(int  userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
