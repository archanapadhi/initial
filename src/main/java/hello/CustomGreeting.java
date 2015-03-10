/**
 * @author akp
 *
 */
package hello;

/**Task 4:
 * Add a form to your web service that allow users to enter their own greeting 
 * The model Class - CustomGreeting
 */
public class CustomGreeting {
	
	    private String greeting;
	    
	    public CustomGreeting() {
	    
	    }
	    
	    public CustomGreeting( String content) {
	        this.greeting = content;
	    }

	    public String getGreeting() {
	        return greeting;
	    }

	    public void setGreeting(String greeting) {
	        this.greeting = greeting;
	    }

}
