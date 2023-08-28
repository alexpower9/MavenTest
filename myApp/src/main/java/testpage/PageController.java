package testpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController
{
	@GetMapping(path = "my-page")
    public String myPage()
	{
        return "my-page"; // This maps to a Thymeleaf template named "my-page.html"
    }
}
