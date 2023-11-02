package com.recentro.recentro.services;

import static org.junit.jupiter.api.Assertions.*;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.User;
import com.recentro.recentro.models.UserRole;
import com.recentro.recentro.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void testSaveNewUser() {
        User newUser = new User();
        newUser.setEmail("newuser@example.com");
        newUser.setPassword("password");
        newUser.setRole(UserRole.USER);

        when(userRepository.save(newUser)).thenReturn(newUser);

        try {
            // Tente salvar o novo usuário
            User savedUser = userService.save(newUser);
            assertEquals("newuser@example.com", savedUser.getEmail());
        } catch (ExistingEmail ex) {
            fail("Deveria ter salvo o novo usuário, mas ocorreu uma exceção ExistingEmail.");
        }

        // Verificando se o método save foi chamado uma vez
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    void testSaveUserWithExistingEmail() {
        User existingUser = new User();
        existingUser.setEmail("existing@example.com");
        existingUser.setPassword("password");
        existingUser.setRole(UserRole.ADMIN);

        when(userRepository.findByEmail(existingUser.getEmail())).thenReturn(existingUser);

        // Tente salvar o usuário com o mesmo email
        try {
            userService.save(existingUser);
            fail("Deveria ter lançado uma exceção ExistingEmail, mas não lançou.");
        } catch (ExistingEmail ex) {
            // Exceção esperada
        }

        // Verifique se o método save não foi chamado
        verify(userRepository, never()).save(existingUser);
    }
}
