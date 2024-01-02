package auth.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int  roleId;
    @Column(name = "role_name")
    @NotNull(message = "Role Name Cannot Be Null")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_has_roles",
            joinColumns = {
                    @JoinColumn(name = "role_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")
            }
    )
    private List<User> users;

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Role() {

    }


    public int  getRoleId() {
        return roleId;
    }

    public void setRoleId(int  roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
