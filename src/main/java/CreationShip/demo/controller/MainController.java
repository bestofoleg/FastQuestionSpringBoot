package CreationShip.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @RequestMapping(value = "index")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

}
