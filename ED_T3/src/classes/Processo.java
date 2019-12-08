/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Random;

/**
 *
 * @author matheus
 */
public class Processo {
    private static int controleId;
    private final int id;
    private String descricao;
    private TipoProcesso tipo;
    protected Processo next;
    public int seconds;
    
    public Processo() {
        controleId++;
        id = controleId;
    }

    public void geraAleatoriamente() {
        Random random = new Random();
        tipo = TipoProcesso.values()[random.nextInt(3)];
        seconds = random.nextInt(60);
    }

    public TipoProcesso getTipo() {
            return tipo;
    }

    public void setTipo(TipoProcesso tipo) {
            this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Processo getNext() {
        return next;
    }

    public void setNext(Processo next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Processo [");
        if (tipo != null) {
            builder.append("tipo=");
            builder.append(tipo);
        }
        builder.append("]");
        return builder.toString();
    }
}
