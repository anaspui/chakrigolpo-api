package auth.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "username")
    @Size(min = 4, message = "Username must be atleast 4 Characters")
    @NotNull
    private String username;
    @Column(name = "password")
    @NotNull
    @Size(min = 8, message = "Password must be more than 8 Characters")
    private String password;



    public User() {

    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
//        this.roles = roles;
    }






    public int getuserId() {
        return userId;
    }

    public void setuserId(int  userId) {
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
                '}';
    }
}
