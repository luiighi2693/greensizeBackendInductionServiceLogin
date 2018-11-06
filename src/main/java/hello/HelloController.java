package hello;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "Users management API")
@RequestMapping("/")
public class HelloController {
    @Value("${demo.login.username}")
    private String demoUsername;

    @Value("${demo.login.password}")
    private String demoPassword;

    @CrossOrigin
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @CrossOrigin
    @PostMapping("/login")
    public Boolean login(@RequestBody RequestDataLogin requestDataLogin) {
        return demoUsername.equals(requestDataLogin.getUsername())
                && demoPassword.equals(requestDataLogin.getPassword());
    }
    
}
