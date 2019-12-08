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
public class ListaProcesso {
    private Processo inicioLista;
    private Processo fimLista;
    
    public void inserir(Processo novo) {
        if (this.getInicioLista() == null)
            this.setInicioLista(novo);
        else 
            this.getFimLista().setProximo(novo);
        this.setFimLista(novo);
    }
    
    public Processo removerItem(int id) {
        Processo procRem = this.getInicioLista();
        while (procRem != null) {
            if (procRem.getId() == id) {
                Processo procAnt = this.getInicioLista();
                if (procAnt == procRem) {
                    this.setInicioLista(procRem.getProximo());
                    return procRem;
                } else {
                    while (procAnt != null) {
                        if (procAnt.getProximo() == procRem) {
                            procAnt.setProximo(procRem.getProximo());
                            return procRem;
                        } else
                            procAnt = procAnt.getProximo();
                    }
                }
            } else
                procRem = procRem.getProximo();
        }
        return null;
    }

    public Processo getInicioLista() {
        return inicioLista;
    }

    public void setInicioLista(Processo inicioLista) {
        this.inicioLista = inicioLista;
    }

    public Processo getFimLista() {
        return fimLista;
    }

    public void setFimLista(Processo fimLista) {
        this.fimLista = fimLista;
    }
    
}
