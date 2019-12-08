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
public class Pilha {
    private Processo topoPilha;
    
    public void inserir(Processo novo) {
        if (this.getTopoPilha() == null)
            this.setTopoPilha(novo);
        else {
            novo.setProximo(this.getTopoPilha());
            this.setTopoPilha(novo);
        }
    }
    
    public Processo proxima() {
        if (this.getTopoPilha() != null) {
            Processo prox = this.getTopoPilha();
            this.setTopoPilha(this.getTopoPilha().getProximo());
            return prox;
        }
        return null;
    }

    public Processo getTopoPilha() {
        return topoPilha;
    }

    public void setTopoPilha(Processo topoPilha) {
        this.topoPilha = topoPilha;
    }
    
}
