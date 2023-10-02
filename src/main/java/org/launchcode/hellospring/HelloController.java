package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
    //this now lives at /hello/goodbye because we added @RequestMapping above the class
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=[name]
//    @GetMapping("hello") // replaced with RequestMapping to allow both GET and POST
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return helloAgain(name, language);
    }
    //handles requests of the form /hello/[name]
    @GetMapping("{name}")
    public String helloAgain(@PathVariable String name, @PathVariable String language) {
        String greeting = "";

        if (language.equals("english")) {
            greeting = "Hello,";
        }
        else if (language.equals("spanish")) {
            greeting = "Hola,";
        }
        else if (language.equals("french")) {
            greeting = "Bonjour,";
        }
        else if (language.equals("swedish")) {
            greeting = "Hallå,";
        }
        else if (language.equals("german")) {
            greeting = "Hallo,";
        }

        return "<html>" +
                "<body>" +
                "<h1>" + greeting + " " + name + "</h1>" +
                "</body>" +
                "</html>";
    }

    //now lives at /hello/form

    @GetMapping ("form")
    public String helloForm() {
        return
                "<html>" +
                        "<body>" +
                        "<form action = '/hello' method = 'post'>" + //submit a request to /hello because we already have a handler method for this
                        "<input type = 'text' name = 'name' />" +
                        "<select name='language'>" +
                            "<option selected = 'selected' value='english'>English</option>" +
                            "<option value='spanish'>Spanish</option>" +
                            "<option value='french'>French</option>" +
                            "<option value='swedish'>Swedish</option>" +
                            "<option value='german'>German</option>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
    }

}
