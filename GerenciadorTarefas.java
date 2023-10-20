package exercicio_1;

import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    String descricao;
    boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }
}

public class GerenciadorTarefas {
    public static void main(String[] args) {
        ArrayList<Tarefa> listaTarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Gerenciador de Tarefas =====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Atualizar Tarefa");
            System.out.println("3. Excluir Tarefa");
            System.out.println("4. Listar Tarefas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    Tarefa tarefa = new Tarefa(descricao);
                    listaTarefas.add(tarefa);
                    System.out.println("Tarefa adicionada com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite o índice da tarefa a ser atualizada: ");
                    int indiceAtualizacao = scanner.nextInt();
                    scanner.nextLine();
                    if (indiceAtualizacao >= 0 && indiceAtualizacao < listaTarefas.size()) {
                        System.out.print("Digite a nova descrição da tarefa: ");
                        String novaDescricao = scanner.nextLine();
                        listaTarefas.get(indiceAtualizacao).descricao = novaDescricao;
                        System.out.println("Tarefa atualizada com sucesso.");
                    } else {
                        System.out.println("Índice inválido. Tarefa não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o índice da tarefa a ser excluída: ");
                    int indiceExclusao = scanner.nextInt();
                    if (indiceExclusao >= 0 && indiceExclusao < listaTarefas.size()) {
                        listaTarefas.remove(indiceExclusao);
                        System.out.println("Tarefa excluída com sucesso.");
                    } else {
                        System.out.println("Índice inválido. Tarefa não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("===== Lista de Tarefas =====");
                    for (int i = 0; i < listaTarefas.size(); i++) {
                        Tarefa t = listaTarefas.get(i);
                        System.out.println(i + ": " + (t.concluida ? "[Concluída] " : "") + t.descricao);
                    }
                    break;

                case 5:
                    System.out.println("Saindo do programa.");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
