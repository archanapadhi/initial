/**
 * @author akp
 *
 */
package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** Bonus Task 2:
 * Add a database to store your data.  
 * Either store form or REST data in a database and add a method in your controller to get this data out.
 * The DB used is MongoDB.
 * The Controller Class for Candidates
 */
@Controller
public class CandidateController {

	@Autowired
	private MongoTemplate template;
	private final AtomicLong counter = new AtomicLong();

	/**
	 * @param model
	 * @return the view to add candidate details
	 */
	@RequestMapping(value={"/addcandidate"},method=RequestMethod.GET)
	public String addCandidate(ModelMap model){
		model.addAttribute("candidate",new Candidate());
		return "addcandidate";
	}

	/**
	 * @param candidate
	 * @param model
	 * @return the view to display the candidate details
	 */
	@RequestMapping(value={"/addcandidate"},method=RequestMethod.POST)
	public String showCandidate(@ModelAttribute Candidate candidate,ModelMap model){
		//Increment the candidate ID on each insert to maintain a unique value in the DB
		candidate.setId(counter.incrementAndGet());
		template.insert(candidate,"candidate");
		return "showcandidate";
	}
	
	/**
	 * @param model
	 * @return the view to prompt the user to enter a valid candidate ID.
	 */
	@RequestMapping(value={"/searchcandidate"},method=RequestMethod.GET)
	public String searchCandidate(ModelMap model){
		model.addAttribute("candidate",new Candidate());
		return "searchcandidate";
	}

	/**
	 * @param candidate
	 * @param model
	 * @return the canadidate's detail page if the Id is valid. If not, ask to enter details again. 
	 */
	@RequestMapping(value={"/searchcandidate"},method=RequestMethod.POST)
	public String showSearchedCandidate(@ModelAttribute Candidate candidate,ModelMap model){
		if(candidate.getId()==null)
		{
			return "searchcandidate";
		}
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(candidate.getId()));
		Candidate retrievedCandidate = template.findOne(query,Candidate.class);
		if(retrievedCandidate == null)
		{
			return "searchcandidate";	
		}
		else
		{
			model.addAttribute("candidate",retrievedCandidate);
			return "showcandidate";
		}
	}
	
	/**
	 * @param candidate
	 * @param model
	 * @return a view that fetches all the candidates from the db.If there exists none, asks the user to add
	 */
	@RequestMapping(value={"/showall"},method=RequestMethod.GET)
	public String showSearchedCandidate(ModelMap model){
		List<Candidate> retrievedCandidates = template.findAll(Candidate.class);
		if(retrievedCandidates == null)
		{
			return "addcandidate";	
		}
		else
		{
			model.addAttribute("candidates",retrievedCandidates);
			return "showall";
		}
	}

}


