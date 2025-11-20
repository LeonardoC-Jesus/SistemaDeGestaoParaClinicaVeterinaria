import banco.BancoConexao;

import java.util.Scanner;

public class ClinicaVeterinariaApp {

    private static Scanner scanner = new Scanner(System.in);
    private static int entrada = -1;

    public static void main(String[] args) {
        BancoConexao.getConexao();
        rodarMenuPrincipal();
    }

    public static void rodarMenuPrincipal() {
        while (entrada != 0) {
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("(1) Acessar Consultas");
            System.out.println("(2) Acessar sistema de Crud");
            System.out.println("(0) Sair do Sistema");
            entrada = scanner.nextInt();
            if (entrada == 1) {
                do {
                    System.out.println("Selecione a opção desejada:");
                    System.out.println("(1) Agendar consulta");
                    System.out.println("(2) Visualizar consulta");
                    System.out.println("(3) Deletar consulta");
                    System.out.println("(4) Editar consulta");
                    System.out.println("(0) Voltar");
                    entrada = scanner.nextInt();
                } while (entrada != 0);
                entrada = -1;

            } else if (entrada == 2) {
                    do {
                        System.out.println("Selecione a opção desejada:");
                        System.out.println("(1) Criar [Proprietário, Animal, Veterinário]");
                        System.out.println("(2) Atualizar [Proprietário, Animal, Veterinário]");
                        System.out.println("(3) Deletar [Proprietário, Animal, Veterinário]");
                        System.out.println("(4) Listar [Proprietário, Animal, Veterinário]");
                        System.out.println("(0) Voltar");
                        entrada = scanner.nextInt();
                    } while (entrada != 0);
                    entrada = -1;

                } else if (entrada != 0){
                System.out.println("Opção Indisponível!!");
            }
        }
    }
}
