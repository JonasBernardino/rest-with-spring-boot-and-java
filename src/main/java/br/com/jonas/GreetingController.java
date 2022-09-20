package br.com.jonas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping
public class GreetingController {

    private static final String template = "hello, %s!";
    private  final AtomicLong conter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting hello (@RequestParam(value = "name", defaultValue = "World")
                               String name){
        return new Greeting(conter.incrementAndGet(), String.format(template, name));
    }

}
