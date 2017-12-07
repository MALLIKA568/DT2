package com.niit.Collobaration.config;
@Configuration
@EnableWebMvc

@ComponentScan("com.niit.Collaboration")

public class WebResolver {
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		System.out.println("Resolver has been called....");
		
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		
		irvr.setPrefix("/WEB-INF/jsp");
		irvr.setSuffix(".jsp");
		return irvr;
		
		
	}
}
