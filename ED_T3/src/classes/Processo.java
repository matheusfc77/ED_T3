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
public class Processo {
    private static int controleId;
    private final int id;
    private String descricao;
    private TipoProcesso tipo;
    protected Processo proximo;
    
    public Processo() {
        controleId++;
        id = controleId;
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

    public Processo getProximo() {
        return proximo;
    }

    public void setProximo(Processo proximo) {
        this.proximo = proximo;
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
