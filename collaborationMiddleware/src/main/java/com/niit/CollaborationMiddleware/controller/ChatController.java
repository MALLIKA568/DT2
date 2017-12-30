package com.niit.CollaborationMiddleware.controller;

import java.util.Date;



@Controller
@RequestMapping("/")
public class ChatController 
{
	  private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	  @MessageMapping("/chat")  /*through which path msg can be sent*/
	  @SendTo("/topic/message")  /* where the msg will be passed to*/
	  public OutputMessage sendMessage(Message message)
	  {
		  logger.info("Message sent");
		  return new OutputMessage(message ,new Date());
	  }

}
