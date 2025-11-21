import banco.BancoConexao;
import dao.*;
import model.*;

import java.util.Scanner;

public class ClinicaVeterinariaApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ProprietarioAnimalDAO propDao = new ProprietarioAnimalDAO();
    private static final VeterinarioDAO vetDao = new VeterinarioDAO();
    private static final AnimalDAO animalDao = new AnimalDAO();
    private static final ConsultaDAO consultaDao = new ConsultaDAO();
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
            entrada = Integer.parseInt(scanner.nextLine());
            switch (entrada) {
                case 1 -> menuConsultas();
                case 2 -> menuCrud();
                case 0 -> System.out.println("opção Invalida!");
            }
            entrada = -1;
        }
    }

    public static void menuConsultas() {
        while (entrada != 0) {
            System.out.println("Selecione a opção desejada:");
            System.out.println("(1) Agendar consulta");
            System.out.println("(2) Visualizar consulta");
            System.out.println("(3) Deletar consulta");
            System.out.println("(4) Editar consulta");
            System.out.println("(0) Voltar");
            entrada = Integer.parseInt(scanner.nextLine());
            switch (entrada) {
                case 1 -> agendarConsulta();
                case 2 -> listarConsulta();
                case 3 -> deleteConsulta();
                case 4 -> editarConsulta();
                case 0 -> {
                }
                default -> System.out.print("Opção inválida");
            }
            entrada = -1;
        }
    }

    private static void editarConsulta() {
    }

    private static void deleteConsulta() {
    }

    private static void listarConsulta() {
    }

    private static void agendarConsulta() {
    }

    private static void menuCrud() {
        while (entrada != 0) {
            System.out.println("--- Menu CRUD ---");
            System.out.println("1 - Proprietário (criar/listar/editar/deletar)");
            System.out.println("2 - Animal (criar/listar/editar/deletar)");
            System.out.println("3 - Veterinário (criar/listar/editar/deletar)");
            System.out.println("0 - Voltar");
            entrada = Integer.parseInt(scanner.nextLine());
            switch (entrada) {
                case 1 -> menuProprietario();
                case 2 -> menuAnimal();
                case 3 -> menuVeterinario();
                case 0 -> {
                }
                default -> System.out.println("Opção inválida");
            }
            entrada = -1;
        }
    }

    private static void menuVeterinario() {
    }

    private static void menuAnimal() {
    }

    //-------------------Propietário-----------------

    private static void menuProprietario() {
        while (entrada != 0) {
            System.out.println("--- Proprietário ---");
            System.out.println("1 - Criar");
            System.out.println("2 - Listar");
            System.out.println("3 - Editar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Voltar");
            entrada = scanner.nextInt();
            switch (entrada) {
                case 1 -> inserirPropietario();
                case 2 -> listarPropietario();
                case 3 -> atualizarPropietario();
                case 4 -> deletarPropietario();
                case 0 -> {
                }
                default -> System.out.println("Opção inválida");
            }
            entrada = -1;
        }
    }

    private static void inserirPropietario() {

        //-----------------Nome---------------

        System.out.println("Informe o seu nome:");
        String nome = scanner.nextLine();

        //-----------------Cpf---------------

        System.out.println("Informe o seu CPF:");
        String cpf = scanner.nextLine();

        //-----------------Email---------------

        System.out.println("Informe o seu endereço email:");
        String EnderecoEmail = scanner.nextLine();

        //-------------------Telefone-----------------

        System.out.print("Informe o seu Telefone, ");
        System.out.println("DDI:");
        Integer ddi = scanner.nextInt();

        System.out.println("DDD:");
        Integer ddd = scanner.nextInt();

        System.out.println("Prefixo:");
        Integer prefixo = scanner.nextInt();

        System.out.println("Numero:");
        Integer numerotel = scanner.nextInt();


        //-------------------Endereço-----------------

        System.out.println("Rua:");
        String rua = scanner.nextLine();

        System.out.println("Bairro:");
        String bairro = scanner.nextLine();

        System.out.println("Cidade:");
        String cidade = scanner.nextLine();

        System.out.println("Número:");
        int numero = Integer.parseInt(scanner.nextLine());

        Email email = new Email(EnderecoEmail);
        Endereco end = new Endereco(rua, bairro, cidade, numero);
        Telefone telefone = new Telefone(ddd, ddd, prefixo, numerotel);
        ProprietarioAnimal p = new ProprietarioAnimal(nome, telefone, email, cpf, end);
        ProprietarioAnimal ProprietarioAnimal = p;
        propDao.inserirPropietario(p);
        System.out.println("Proprietario nserido com sucesso!!! Cpf: " + p.getCpf());
    }

    private static void listarPropietario() {

    }

    private static void atualizarPropietario() {
    }

    private static void deletarPropietario() {
    }
}



