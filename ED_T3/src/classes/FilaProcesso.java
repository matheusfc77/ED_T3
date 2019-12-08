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
            this.getFimFila().setNext(novo);
        this.setFimFila(novo);
    }
    
    public Processo proximo() {
        if (this.getInicioFila() != null) {
            Processo prox = this.getInicioFila();
            this.setInicioFila(this.getInicioFila().getNext());
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
    
    
    
    /*
    public int length;
    public Processo older;
    public Processo newer;

    public void add(Processo Processo) {

            if (length == 0) {
                    newer = older = Processo;
            }
            //newer.next = new Processo();
            newer.next = Processo;
            newer.next.before = newer;
            newer = newer.next;
            length++;
    }

    public void remove() {

            older = older.next;
            length--;
    }

    public Processo getAndRemove() {
            Processo processo = older;
            older = processo.next;
            return processo;
    }

    public Processo lastRow() {
            return older;
    }

    public Processo newerRow() {
            return newer;
    }


    public Processo get(int index) {
            Processo processo = older;
            for (int i = 0; processo != null && i < index; i++) 
                    processo = processo.next;
            return processo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Processo processo = older;
        builder.append("[");
        try {
            for (int i = 0; i < length; i++) {
                builder.append("{");
                builder.append(processo);
                builder.append("}");
                processo = processo.next;
            }
        } catch (Exception e) {
                // TODO: handle exception
        }

        builder.append("]");
        return builder.toString();
    }*/
}
