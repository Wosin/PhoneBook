package com.gft.Rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gft.service.SearchingService;
import com.gft.service.XMLService;
@ComponentScan("com.gft")
@RestController
public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
  @Autowired
    XMLService xm;
  	@Autowired
  	SearchingService ss;
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {

     
return xm.XMLtoJson();
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String get(@PathVariable String id)  {
        return ss.SearchByNumber(id, xm.XMLtoJson());
    }

    @RequestMapping(value = "/users/prefix/{prefix}", method = RequestMethod.GET)
    public String getPrefix(@PathVariable String prefix)  {
        return ss.SearchByPrefix(prefix, xm.XMLtoJson());
    }
}