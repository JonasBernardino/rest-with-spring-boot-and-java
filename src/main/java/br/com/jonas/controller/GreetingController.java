package br.com.jonas.controller;

import br.com.jonas.model.Greeting;
import br.com.jonas.service.GreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping()
public class GreetingController {

    @Autowired
    private GreetingServices service;

    private static final String template = "hello, %s!";
    private final AtomicLong conter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting hello(
            @RequestParam(value = "name", defaultValue = "World")
            String name) {
        return new Greeting(conter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("sum/{one}/{two}")
    public Double sum(
            @PathVariable(value = "one") String one,
            @PathVariable(value = "two") String two) throws Exception {
        return service.sum(one, two);
    }

    @GetMapping("multiplication/{one}/{two}")
    public Double multiplication(
            @PathVariable(value = "one") String one,
            @PathVariable(value = "two") String two) throws Exception {
        return service.multiplication(one, two);
    }

    @GetMapping("subtraction/{one}/{two}")
    public Double subtraction(
            @PathVariable(value = "one") String one,
            @PathVariable(value = "two") String two) throws Exception {
        return service.subtraction(one, two);
    }

    @GetMapping("division/{one}/{two}")
    public Double division(
            @PathVariable(value = "one") String one,
            @PathVariable(value = "two") String two) throws Exception {
        return service.division(one, two);
    }

    @GetMapping("average/{one}/{two}")
    public Double average(
            @PathVariable(value = "one") String one,
            @PathVariable(value = "two") String two) throws Exception {
        return service.average(one, two);
    }

    @GetMapping("square/{one}")
    public Double square(
            @PathVariable(value = "one") String one) throws Exception {
        return service.square(one);
    }
}
