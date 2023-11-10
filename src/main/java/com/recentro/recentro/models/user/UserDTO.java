package com.recentro.recentro.models.user;


import com.recentro.recentro.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    String email;
    String password;
    UserRole role;

    public UserDTO(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
    }
}
