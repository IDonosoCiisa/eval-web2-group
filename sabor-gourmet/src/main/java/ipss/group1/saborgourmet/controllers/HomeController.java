package ipss.group1.saborgourmet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// Controllador para la vista base del proyecto, redirige a la vista home.
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";  
    }
}
