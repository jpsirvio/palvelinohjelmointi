package pavelinohjelmointi.modelandview3.web;


import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pavelinohjelmointi.modelandview3.domain.Friend;


@Controller
public class FriendController {
	
	ArrayList<Friend> friends = new ArrayList<Friend>();
	
	@GetMapping("/index")
	public String listFriends(Model model) {
	
		model.addAttribute("friend", new Friend());
			
		return "index";
	}
	
	@PostMapping("/index")
	public String submitFriend(@ModelAttribute Friend friend, Model model) {
		
		friends.add(friend);
		model.addAttribute("friends", friends);
		
		return "index";
	}
	
}
