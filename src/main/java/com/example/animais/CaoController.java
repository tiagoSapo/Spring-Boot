
package com.example.animais;

import com.example.animais.templates.Cao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaoController {
    
    List<Cao> caes = new ArrayList<>();
    
    @GetMapping("/")
    public void index(@RequestParam("id") Optional<Integer> id) {
        
    }
    
    public void create() {
        
    }
    
    public void delete() {
        
    }
    
}
