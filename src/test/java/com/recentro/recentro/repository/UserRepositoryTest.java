package com.recentro.recentro.repository;



import com.recentro.recentro.models.User;
import com.recentro.recentro.models.UserRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByEmail() {
        // Crie um novo objeto User
        User user = new User();
        user.setEmail("example@example.com");
        user.setPassword("password");
        user.setRole(UserRole.USER);

        // Salve o usuário no banco de dados de teste
        userRepository.save(user);

        // Execute o método findByEmail
        User result = userRepository.findByEmail("example@example.com");

        // Verifique se o resultado não é nulo
        assertNotNull(result);

        // Verifique se o email do resultado corresponde ao esperado
        assertEquals("example@example.com", result.getEmail());

    }
}
