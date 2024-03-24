package am.cs322;

import am.cs322.model.CreateUserRequest;
import am.cs322.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@ComponentScan("am.cs322")
@SpringBootTest(classes = {UserController.class})
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void createUserTest() throws Exception {
        CreateUserRequest request = new CreateUserRequest("Eduard", "Grigoryan");
        UserDTO userDTO = new UserDTO("Eduard Grigoryan");

        when(userService.createUser(request.firstName(), request.lastName())).thenReturn(userDTO);

        mockMvc.perform(post("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"firstName\": \"Eduard\", \"lastName\": \"Grigoryan\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.fullName").value("Eduard Grigoryan"));
    }
}