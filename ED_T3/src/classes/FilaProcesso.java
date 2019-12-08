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
public class FilaProcesso {
    private Processo inicioFila;
    private Processo fimFila;
    
    public void inserir(Processo novo) {
        if (this.getInicioFila() == null)
            this.setInicioFila(novo);
        else
            this.getFimFila().setProximo(novo);
        this.setFimFila(novo);
    }
    
    public Processo proximo() {
        if (this.getInicioFila() != null) {
            Processo prox = this.getInicioFila();
            this.setInicioFila(this.getInicioFila().getProximo());
            return prox;
        }
        return null;
    } 

    public Processo getInicioFila() {
        return inicioFila;
    }

    public void setInicioFila(Processo inicioFila) {
        this.inicioFila = inicioFila;
    }

    public Processo getFimFila() {
        return fimFila;
    }

    public void setFimFila(Processo fimFila) {
        this.fimFila = fimFila;
    }

}
