package io.ansonchoi.byeservice.restc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bye")
public class ByeRestController {

    @GetMapping
    public String bye() {
        return "bye";
    }
}
