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
public class ListaMesa {
    private Mesa inicioLista;
    private Mesa fimLista;
    
    public void inserir(Mesa nova) {
        if (this.getInicioLista() == null)
            this.setInicioLista(nova);
        else 
            this.getFimLista().setProximo(nova);
        this.setFimLista(nova);
    }
    
    public StringBuilder listarMesasDispo() {
        StringBuilder mesasDisp = new StringBuilder();
        
        if (inicioLista != null) {
            Mesa aux = inicioLista;
            mesasDisp.append("Mesas de número:");
            while(aux != null) {
                mesasDisp.append(" ").append(aux.getNumero());
                aux = aux.getProximo();
            }
        }
        
        return mesasDisp;
    }
    
    public void removerItem(int numero) {
        Mesa mesaRem = this.getInicioLista();
        while (mesaRem != null) {
            if (mesaRem.getNumero() == numero) {
                Mesa mesaAnt = this.getInicioLista();
                
                if (mesaAnt == mesaRem) {
                    this.setInicioLista(mesaRem.getProximo());
                    return;
                } else {
                    while (mesaAnt != null) {
                        if (mesaAnt.getProximo() == mesaRem) {
                            mesaAnt.setProximo(mesaRem.getProximo());
                            return;
                        } else
                            mesaAnt = mesaAnt.getProximo();
                    }
                }
            } else
                mesaRem = mesaRem.getProximo();
        }
    }

    public Mesa getInicioLista() {
        return inicioLista;
    }

    public void setInicioLista(Mesa inicioLista) {
        this.inicioLista = inicioLista;
    }

    public Mesa getFimLista() {
        return fimLista;
    }

    public void setFimLista(Mesa fimLista) {
        this.fimLista = fimLista;
    }
    
}
