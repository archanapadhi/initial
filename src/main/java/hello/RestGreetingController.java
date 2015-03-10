/**
 * @author akp
 *
 */
package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**Bonus Task 1:
 * Add a REST interface to your web app.
 * The Rest Controller class to return JSON response 
 */
@RestController
public class RestGreetingController {
	
	private static final String template = "Hello, %s!";
  

    @RequestMapping("/greetingjson")
    public CustomGreeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new CustomGreeting(
                            String.format(template, name));
    }

}
