/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Scanner;

/**
 *
 * @author matheus
 */
public class Main {
    public static Pilha analise = new Pilha();
    public static Pilha projeto = new Pilha();
    public static Pilha programacao = new Pilha();
    public static ListaMesa mesas = new ListaMesa();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FilaProcesso entrada = new FilaProcesso();
        FilaProcesso esperaAnalise = new FilaProcesso();
        ListaProcesso analisandoProc = new ListaProcesso();
        FilaProcesso arquivamento = new FilaProcesso();
        
        //Pilha entrada = new Pilha();
        //Pilha analise = new Pilha();
        //Pilha projeto = new Pilha();
        //Pilha programacao = new Pilha();
        
        //ListaProcesso ltProc = new ListaProcesso();
        //ListaMesa ltMesa = new ListaMesa();
        
        Processo proc;
        Funcionario func = null;
        Mesa mesa = null;
        
        String op;
        int analiseFin = 0;
        int progFin = 0;
        int projFin = 0;
        
        populaListaMesas();
        
        System.out.println("Sistema para o gerenciamento de equipe");
        
        do {
            System.out.println("Opções: \n\t(0) Sair\n\t(1) Novo processo\n\t(2)Separar processos\n\t(3)Pegar processo\n\t(4)Ver mesas disponíveis\n\t(5) Finalizar análise\n\t(6)Arquivar processo\n\t(7) Relatório");
            op = in.nextLine();
            switch (op) {
                case "0":
                    System.out.println("Sistema encerrado");
                    break;
                case "1":
                    proc = gerarProcesso();
                    entrada.inserir(proc);
                    break;
                case "2":
                    separarProcessos(entrada);
                    System.out.println("Processos separados com sucesso");
                    break;
                case "3":
                    System.out.print("Informe o tipo do processo (A-Análise / PG-Programação / PJ - Projeto): ");
                    String tipo = in.nextLine();
                    proc = pegarProcesso(tipo);
                    
                    while (proc == null && !"0".equals(tipo)) {
                        System.out.print("Não há mais processos desse tipo. Tente outro formato ou digite 0 para voltar: ");
                        proc = pegarProcesso(tipo);
                    }
                    
                    if (proc != null) {
                        System.out.printf("Processo:\n\tID: %d\n\tDescrição: %s\n", 
                                proc.getId(), 
                                proc.getDescricao());
                        esperaAnalise.inserir(proc);
                        System.out.println("Para realizar a análise, verifique quais mesas estão disponíveis (Opção 4)");
                    }
                    break;
                case "4":
                    StringBuilder mesasDisp = mesas.listarMesasDispo();
                    System.out.println(mesasDisp);
                    
                    if (mesasDisp != null) {
                        System.out.print("Deseja analisar algum processo (S/N)?: ");
                        if ("s".equalsIgnoreCase(in.nextLine())) {
                            proc = esperaAnalise.proximo();
                            
                            System.out.printf("Próximo processo da fila de análise:\n\tID: %d\n\tDescrição: %s\n",
                                    proc.getId(), proc.getDescricao());
                            System.out.print("Escolha a mesa: ");
                            mesas.removerItem(Integer.parseInt(in.nextLine()));
                            
                            analisandoProc.inserir(proc);
                        }
                    } else
                        System.out.println("Não há mesas disponíveis no momento");
                    break;
                case "5":
                    System.out.print("Informe a o Nº da mesa utilizada: ");
                    int num = Integer.parseInt(in.nextLine());
                    
                    if (verificarMesa(num)) {
                        mesa = new Mesa();
                        mesa.setNumero(num);
                        mesas.inserir(mesa);
                    }
                    
                    System.out.print("Informe o ID do processo: ");
                    int id = Integer.parseInt(in.nextLine());
                    proc = analisandoProc.removerItem(id);
                    
                    if (proc != null) {
                        System.out.println("Processo encaminhado para o arquivamento");
                        arquivamento.inserir(proc);
                    } else
                        System.out.println("Processo não encontrado na lista \"Em análise\"");
                    
                    break;
                case "6":
                    proc = arquivamento.proximo();
                    
                    if (proc != null) {
                        switch (proc.getTipo()) {
                            case ANALISE:
                                analiseFin++;
                                break;
                            case PROGRAMACAO:
                                progFin++;
                                break;
                            case PROJETO:
                                projFin++;
                                break;
                        }
                        System.out.printf("Processo ID %d finalisado\n", proc.getId());
                    } else
                        System.out.println("Não há processos na fila de arquivamento");
                    
                    break;
                case "7":
                    System.out.printf("Nº de funcionários na fila para analisar processo: %d"
                            + "\nNº de funcionários na fila do arquivamento: %d"
                            + "\nNº de funcionários analisando processos: %d"
                            + "\nNº de processos fechados até o momento: %d. "
                            + "Dentre os quais:\n\tAnálise: %d\n\tProgramação: %d\n\tProjeto: %d"
                            + "\nNº de processos nas pilhas:\n\tAnálise: %d\n\tProgramação: %d\n\tProjeto: %d"
                            + "\nNº de mesas livres: %d\n",
                            numElementos(esperaAnalise), numElementos(arquivamento),
                            numElementos(analisandoProc), analiseFin + progFin + projFin,
                            analiseFin, progFin, projFin, numElementos(analise), 
                            numElementos(programacao), numElementos(projeto),
                            numElementos(mesas));
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (!"0".equals(op));
        
    }
    
    public static void populaListaMesas() {
        int NUMMESAS = 5;
        
        for (int i = 0; i < NUMMESAS; i++) {
            Mesa mesa = new Mesa();
            mesa.setNumero(i + 1);
            mesas.inserir(mesa);
        }
    }
    
    public static Processo gerarProcesso() {
        Scanner in = new Scanner(System.in);
        Processo proc = new Processo();

        System.out.print("Descrição: ");
        proc.setDescricao(in.nextLine());

        System.out.print("Tipo (A-Análise / PG-Programação / PJ - Projeto): ");
        String tipo = in.nextLine();
        do {
            switch (tipo.toUpperCase()) {
                case "A":
                    proc.setTipo(TipoProcesso.ANALISE);
                    break;
                case "PG":
                    proc.setTipo(TipoProcesso.PROGRAMACAO);
                    break;
                case "PJ":
                    proc.setTipo(TipoProcesso.PROJETO);
                    break;
                default:
                    System.out.print("Opção inválida. Tente novamente: ");
                    tipo = in.nextLine();
            }
        } while (proc.getTipo() == null);
    
        return proc;
    }
    
    public static void separarProcessos(FilaProcesso fila) {
        //Pilha analise = new Pilha();
        //Pilha projeto = new Pilha();
        //Pilha programacao = new Pilha();
        System.out.println("e1");
        Processo aux = fila.getInicioFila();
        while (aux != null) {
            System.out.println(aux.getTipo());
            switch (aux.getTipo()) {
                case ANALISE:
                    analise.inserir(aux);
                    break;
                case PROGRAMACAO:
                    programacao.inserir(aux);
                    break;
                case PROJETO:
                    projeto.inserir(aux);
                    break;
            }
            aux = aux.getNext();
        }
        System.out.println(fila.getInicioFila());
        System.out.println(fila.getFimFila());
        
        fila.setInicioFila(null);
        fila.setFimFila(null);
        
        System.out.println(fila.getInicioFila());
        System.out.println(fila.getFimFila());
    }
    
    public static Processo pegarProcesso(String tipo) {
        Processo prox = null;
        switch (tipo.toUpperCase()) {
            case "A":
                prox = analise.proxima();
                break;
            case "PG":
                prox = programacao.proxima();
                break;
            case "PJ":
                prox = projeto.proxima();
                break;
        }
        return prox;
    }
    
    public static boolean verificarMesa(int num) {
        Mesa aux = mesas.getInicioLista();
        
        while (aux != null) {
            if (aux.getNumero() == num)
                return false;
            aux = aux.getNext();
        }
        
        return true;
    }
    
    public static int numElementos(FilaProcesso fila) {
        int numElemen = 0;
        Processo aux = fila.getInicioFila();
        
        while (aux != null) {
            numElemen++;
            aux = aux.getNext();
        }
        
        return numElemen;
    }
    
    public static int numElementos(ListaProcesso lista) {
        int numElemen = 0;
        Processo aux = lista.getInicioLista();
        
        while (aux != null) {
            numElemen++;
            aux = aux.getNext();
        }
        
        return numElemen;
    }
    
    public static int numElementos(Pilha pilha) {
        int numElemen = 0;
        Processo aux = pilha.getTopoPilha();
        
        while (aux != null) {
            numElemen++;
            aux = aux.getNext();
        }
        
        return numElemen;
    }
    
    public static int numElementos(ListaMesa mesas) {
        int numElemen = 0;
        Mesa aux = mesas.getInicioLista();
        
        while (aux != null) {
            numElemen++;
            aux = aux.getNext();
        }
        
        return numElemen;
    }
    
/*
    public static void separarProcessos(FilaFuncionario processos) {
        for (int i = 0; i < processos.length; i++) {
            if (TipoProcesso.ANALISE == processos.get(i).getTipo()) {
                analise.add(processos.get(i));
            } else if (TipoProcesso.PROGRAMACAO == processos.get(i).getTipo()) {
                System.out.println("pro" + processos.get(i));
                programacao.add(processos.get(i));
            } else if (TipoProcesso.ANALISE == processos.get(i).getTipo()) {
                projeto.add(processos.get(i));
            }
        }
    }

    public static FilaFuncionario geraFilaDeProcessos(int rounds) {

        FilaFuncionario filaDeProcessos = new FilaFuncionario();
        for (int i = 0; i < rounds; i++) {
            Processo processo = new Processo();
            processo.geraAleatoriamente();
            filaDeProcessos.add(processo);
        }
        return filaDeProcessos;
    }
    /*
    public static void geraFuncionarios() {
        for (int i = 0; i < array.length; i++) {

        }
    }
    */
}
