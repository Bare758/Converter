package Com.TransLator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

@Configuration
//Controller
@RestController
public class LangController {
	@Autowired
	private MessageSource messageSource;


//I18N The process of implementing services so they can be adapted to specific local languages, (localization) .
	@GetMapping(path = "/animals-I18N")
	public String Internationalized(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale, 
			@RequestParam(value = "word") String word) {
		
			//converting to json
			return ("{ \"" + word + "\":\"" + messageSource.getMessage(word+".txt",null,locale)+ "\"}");
	}
}
	