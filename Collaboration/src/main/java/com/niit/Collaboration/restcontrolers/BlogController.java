package com.niit.Collaboration.restcontrolers;
@RestController
public class BlogController {
	@Autowired
	BlogDAO blogDAO;
	
	@PostMapping(value="/insertBlog")
	
	public ResponseEntity<String> insertBlog(BlogPart blogPart)
	{
		int i=10;
	 if(blogDAO.addBlog(blogPart))
	 {
		 return new ResponseEntity<String>("Blog is added successfully",HttpStatus.OK);
		 
	 }
	 
	 else
	 {
		 return new ResponseEntity<String>("error in response entity",HttpStatus.SERVICE_UNAVAILABLE);
	 }
		
		
	}
}
