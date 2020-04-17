
package com.example.animais;

import com.example.animais.templates.Cao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/*
   @RestController = @Controller + @ResponseBody
   @GetMapping = @RequestMapping(method=.GET) etc...
*/
@RestController
public class CaoController {
    
    /* Objectos em memoria */
    List<Cao> caes = new ArrayList<>();
    
    public CaoController() {
        
        try {
        
            caes.add(new Cao("Bobi"));
            caes.add(new Cao("Baubau"));
            
        } 
        catch (Exception ex) {
            System.out.println("ERRO - Nomes invalidos");
        }
    }
    
    @GetMapping(value = {"/", "/{id}"})
    public ResponseEntity<List<Cao>> index(
            @PathVariable(value = "id") Optional<Integer> id
    ) {
        
        List<Cao> lista = new ArrayList<>();
        Iterator<Cao> it = caes.iterator();
        
        try {
            while (it.hasNext()) {
                
                Cao c = it.next();
                
                if (c.getId() == id.get()) {
                    lista.add(c);
                    break;
                }
            }
            
            return ResponseEntity.ok(lista);
        } 
        catch (NoSuchElementException ex) { return ResponseEntity.ok(caes); }
        
    }
    
    @PostMapping(value = "/")
    public ResponseEntity<Cao> create(final Optional<Cao> novo_cao) {
        
        if (!novo_cao.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        caes.add(novo_cao.get());
        return ResponseEntity.ok(novo_cao.get());
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cao> delete(@PathVariable(value = "id") int id) {
        
        Iterator<Cao> it = caes.iterator();
        
        while (it.hasNext()) {
            
            Cao c = it.next();
            
            if (c.getId() == id) {
                it.remove();
                return ResponseEntity.ok(c);
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Cao> update(
            @PathVariable(value = "id") int id, Optional<Cao> novo_cao
    ) {
        
        try {

            Iterator<Cao> it = caes.iterator();
        
            while (it.hasNext()) {

                Cao c = it.next();

                if (c.getId() == id) {
                    c.setNome(novo_cao.get().getNome());
                    return ResponseEntity.ok(c);
                }
            }
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } 
        catch (Exception ex) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); }
        
    }
}
