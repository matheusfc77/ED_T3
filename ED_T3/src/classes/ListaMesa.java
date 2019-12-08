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
            this.getFimLista().setNext(nova);
        this.setFimLista(nova);
    }
    
    public StringBuilder listarMesasDispo() {
        StringBuilder mesasDisp = new StringBuilder();
        
        if (inicioLista != null) {
            Mesa aux = inicioLista;
            mesasDisp.append("Mesas de número:");
            while(aux != null) {
                mesasDisp.append(" ").append(aux.getNumero());
                aux = aux.getNext();
            }
        }
        
        return mesasDisp;
    }
    
    public void removerItem(int numero) {
        Mesa mesaRem = this.getInicioLista();
        while (mesaRem != null) {
            if (mesaRem.getNumero() == numero) {
                Mesa mesaAnt = this.getInicioLista();
                while (mesaAnt != null) {
                    if (mesaAnt.getNext() == mesaRem) {
                        mesaAnt.setNext(mesaRem.getNext());
                        return;
                    } else
                        mesaAnt = mesaAnt.getNext();
                }
            } else
                mesaRem = mesaRem.getNext();
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
    
    
    
    /*
    private Mesa inicioLista;
    private Mesa fimLista;

    public void add(Mesa novo) {
            if (fimLista != null) {
                    fimLista.next = novo;
            } else {
                    inicioLista = novo;
            }
            fimLista = novo;
    }

    public Mesa get(int index) {
            Mesa aux = inicioLista;
            for (int i = 0; i < index; i++) {
                    aux = aux.next;
            }
            return aux;

    }

    public void remove(int index) {
            Mesa aux = inicioLista;
            if (index == 0) {
                    inicioLista = inicioLista.next;
            } else {
                    for (int i = 0; i < index-1; i++) {
                            aux = aux.next;
                    }
                    aux.next = aux.next.next;
            }
    }
    
    public StringBuilder listarMesasDispo() {
        StringBuilder mesasDisp = new StringBuilder();
        
        if (inicioLista != null) {
            Mesa aux = inicioLista;
            while(aux != null) {
                mesasDisp.append("\nNúmero: ").append(aux.getNumero());
                aux = aux.getNext();
            }
        } else
            mesasDisp.append("Não há mesas disponíveis");
        
        return mesasDisp;
    }*/
}
