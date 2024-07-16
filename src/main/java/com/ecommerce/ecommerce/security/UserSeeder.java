package com.ecommerce.ecommerce.security;


import com.ecommerce.ecommerce.entites.Role;
import com.ecommerce.ecommerce.payloads.AddressDTO;
import com.ecommerce.ecommerce.payloads.CartDTO;
import com.ecommerce.ecommerce.payloads.UserDTO;
import com.ecommerce.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.HashSet;
import java.util.Set;

@Component
public class UserSeeder implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public void run(String... args) throws Exception {
        // Define roles
        Role roleAdmin = new Role(1L, "ROLE_ADMIN");
        Role roleUser = new Role(2L, "ROLE_USER");

        Set<Role> roles = new HashSet<>();
        roles.add(roleAdmin);
        roles.add(roleUser);

        // Define address
        AddressDTO address = new AddressDTO(1L,"Street", "buildingName","City", "State", "12345", "Country");

        // Define cart
        CartDTO cart = new CartDTO();


        // Create a default user
        String firstName = "John";
        String lastName = "Doe";
        String mobileNumber = "1234567890";
        String email = "john.doe@example.com";
        String rawPassword = "password";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        UserDTO defaultUser = new UserDTO(1L,firstName, lastName, mobileNumber, email, encodedPassword, roles, address, cart);

        // Save user using the user service
        UserDTO registeredUser = userService.registerUser(defaultUser);

        // Generate JWT token for the registered user
        String token = jwtUtil.generateToken(registeredUser.getEmail());

        // Print the generated token to the console
        System.out.println("Generated JWT Token for default user: " + token);
    }
}
