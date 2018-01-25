package denglj.learn.springboot.rest;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static String template = "hello %s!";
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world.") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
