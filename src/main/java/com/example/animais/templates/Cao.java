
package com.example.animais.templates;

public final class Cao {
    
    private static int cnt = 0;
    private int id = -1;
    private String nome;

    
    public Cao(String nome) throws Exception {
        
        if (nome == null || nome.equals(""))
            throw new Exception("ERRO - Nome invalido");
 
        this.id = cnt++;
        this.nome = nome;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
