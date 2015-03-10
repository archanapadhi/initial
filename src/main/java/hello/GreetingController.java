/**
 * @author akp
 *
 */
package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**Task 2,3,4:
 * The Controller class for Tasks 2,3 and 4.
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/test")
    public String tset(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "test";
    }
    
    @RequestMapping(value="/customgreeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("customgreeting", new CustomGreeting());
        return "customgreeting";
    }

    @RequestMapping(value="/customgreeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute CustomGreeting greeting, Model model) {
        model.addAttribute("greeting", greeting.getGreeting());
        return "result";
    }


}