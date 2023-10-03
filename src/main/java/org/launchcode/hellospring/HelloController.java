package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
    //this now lives at /hello/goodbye because we added @RequestMapping above the class
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=[name]
//    @GetMapping("hello") // replaced with RequestMapping to allow both GET and POST
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/[name]
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //now lives at /hello/form

    @GetMapping ("form")
    public String helloForm() {
        return "form";
    }

}
