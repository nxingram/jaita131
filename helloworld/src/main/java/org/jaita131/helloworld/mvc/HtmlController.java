package org.jaita131.helloworld.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/")
public class HtmlController {

	@GetMapping("ciao")
	public String getCiaoHtml()
	{
		return "/ciao"; //restituisce: templates/ciao.html
	}
}
