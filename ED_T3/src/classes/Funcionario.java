/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author matheus
 */
public class Funcionario {
    private Processo processo;
    private int id;
    protected Funcionario before, next;

    public Funcionario(Processo processo) {
            this.processo = processo;
    }

    public Funcionario() {}

    public Processo getProcesso() {
            return processo;
    }
    /**
     * @param processo the processo to set
     */
    public void setProcesso(Processo processo) {
            this.processo = processo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
