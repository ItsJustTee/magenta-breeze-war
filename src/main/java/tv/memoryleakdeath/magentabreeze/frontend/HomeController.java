package tv.memoryleakdeath.magentabreeze.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController extends BaseFrontendController {

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        return "home/home";
    }
}
