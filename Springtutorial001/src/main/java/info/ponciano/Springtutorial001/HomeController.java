package info.ponciano.Springtutorial001;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private HomeModel model;

    public HomeController() {
        model = new HomeModel();
    }

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping( "/progress")
    public @ResponseBody Progress getProgress() {
        return this.model.getProgress();
    }

    @PostMapping("/data")
    public String getData( Model model)  {
        this.model.run();
        DataModel data = this.model.getData();
        //add attributes to the model
        model.addAttribute("id",data.getId());
        model.addAttribute("name",data.getName());
        return "home";
    }
}
