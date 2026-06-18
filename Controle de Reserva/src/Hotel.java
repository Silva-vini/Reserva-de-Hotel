import com.controle.entity.Reserva;

import java.util.Scanner;

public class Hotel {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Reserva[] reservaDeQuarto = new Reserva[10];
        int contador = 0;
        System.out.println("Olá, seja bem vindo a Reserva de Hotel!");
        int opcaomenu;

        do {
            System.out.println("MENU PRINCIPAL \nDigite uma das opções abaixo. \n1) Cadastrar nova reserva. \n2) Lista de Reservas. \n3) Alterar Reserva. \n4) Cancelar Reserva. \n5) Busca de reserva. \n6) Ordenar Reservas. \n7) Sair.");
            opcaomenu = scanner.nextInt();
            System.out.println();
            switch (opcaomenu){
                case 1:
                    contador = cadastrarReserva(scanner, reservaDeQuarto, contador);
                    break;
                case 2:
                    contador = listarReserva(reservaDeQuarto, contador);
                    break;
                case 3:
                    contador = alteraReserva(reservaDeQuarto, contador, scanner);
                    break;
                case 4:
                    contador = cancelarReserva(reservaDeQuarto, contador, scanner);
                    break;
                case 5:
                    contador = buscaHospede(reservaDeQuarto, contador, scanner);
                    break;
                case 6:
                    reservaDeQuarto = ordenarDias(reservaDeQuarto, contador);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção inválida digite novamente!");
            }


        }while (opcaomenu != 7);

        System.out.println("Obrigado por usar nossas serviços, até logo!");

        scanner.close();

    }


    public static int cadastrarReserva(Scanner scanner, Reserva[] reservaDeQuarto, int contador){
        Reserva nova = new Reserva();
        if(contador < 10){

            scanner.nextLine();

            System.out.println("Digite o nome do hóspede?");
            nova.setNome(scanner.nextLine());

            System.out.println("Digite o CPF");
            nova.setCpf(scanner.nextLine());

            String tipo;
            do {
                System.out.println("Tipo de quarto (standard, luxo, presidencial): ");
                tipo = scanner.nextLine().toLowerCase();

                if(!tipo.equals("standard") && !tipo.equals("luxo") && !tipo.equals("presidencial")) {
                    System.out.println("Tipo inválido! Digite novamente.");
                }
            } while(!tipo.equals("standard") && !tipo.equals("luxo") && !tipo.equals("presidencial"));

            nova.setTipoDeQuarto(tipo);

            double minimoAplicavel = 0;
            if(tipo.equals("standard")) {
                minimoAplicavel = Reserva.MINIMO_STANDARD;
            } else if(tipo.equals("luxo")) {
                minimoAplicavel = Reserva.MINIMO_LUXO;
            } else {
                minimoAplicavel = Reserva.MINIMO_PRESIDENCIAL;
            }

            do {
                System.out.println("Valor da Diária negociada?");
                nova.setValorDiaria(scanner.nextDouble());

                if(nova.getValorDiaria() < minimoAplicavel) {
                    System.out.println("Valor inválido! O mínimo para " + nova.getTipoDeQuarto() +
                            " é R$" + minimoAplicavel);
                }
            } while(nova.getValorDiaria() < minimoAplicavel);


            do {
                System.out.println("Quantos dias?");
                nova.setNumeroDeDias(scanner.nextInt());

                if(nova.getNumeroDeDias() <= 0) {
                    System.out.println("Número de dias inválido! Digite um valor maior que 0.");
                }
            } while(nova.getNumeroDeDias() <= 0);

            String decisao;
            scanner.nextLine();
            do{
                System.out.println("Deseja  Sim para confirmar sua reserva e Não caso não queira confirmar ");
                decisao = scanner.nextLine();

                if(decisao.equals("sim")) {
                    reservaDeQuarto[contador] = nova;
                    contador++;
                }

            }while(!decisao.equals("sim") && !decisao.equals("não"));

        }else{
            System.out.println("Infelizmente excedeu a quantidade de reservas, tente novamente mais tarde!");
        }
        System.out.println();

        return contador;
    }

    static int listarReserva(Reserva[] reservaDeQuarto, int contador){
        for (int i = 0; i < contador; i++){
            System.out.println("Nome: " + reservaDeQuarto[i].getNome());
            System.out.println("CPF: " + reservaDeQuarto[i].getCpf());
            System.out.println("Quarto: " + reservaDeQuarto[i].getTipoDeQuarto());
            System.out.println("Dias: " + reservaDeQuarto[i].getNumeroDeDias());
            System.out.println("Valor total: " + reservaDeQuarto[i].calcularValorTotal());
            System.out.println();

        }
        return contador;

    }

    public static int alteraReserva (Reserva[] reservaDeQuarto, int contador, Scanner scanner) {
        System.out.println("Digite o CPF para encontrarmos a reserva.");
        scanner.nextLine();
        String cpf = scanner.nextLine();

        int posicaoEncontrada = -1;
        for (int i = 0; i < contador; i++) {
            if (reservaDeQuarto[i].getCpf().equals(cpf)) {
                posicaoEncontrada = i;
            }
        }
        if (posicaoEncontrada == -1){
            System.out.println("Reserva não encontrada!");

        }else{
            Reserva reserva = reservaDeQuarto[posicaoEncontrada];
            System.out.println("Reserva encontrada:");
            System.out.println(reserva);

            System.out.println();
            System.out.println("Digite os novos dados da reserva:");

            System.out.print("Nome: ");
            reserva.setNome(scanner.nextLine());

            System.out.print("CPF: ");
            reserva.setCpf(scanner.nextLine());

            System.out.print("Tipo de quarto (standard, luxo, presidencial): ");
            reserva.setTipoDeQuarto(scanner.nextLine().toLowerCase());

            double minimoAplicavel;
            if(reserva.getTipoDeQuarto().equalsIgnoreCase("standard")) {
                minimoAplicavel = Reserva.MINIMO_STANDARD;
            } else if(reserva.getTipoDeQuarto().equalsIgnoreCase("luxo")) {
                minimoAplicavel = Reserva.MINIMO_LUXO;
            } else if(reserva.getTipoDeQuarto().equalsIgnoreCase("presidencial")) {
                minimoAplicavel = Reserva.MINIMO_PRESIDENCIAL;
            } else {
                System.out.println("Tipo de quarto inválido!");
                return contador;
            }

            do {
                System.out.print("Valor da diária: ");
                reserva.setValorDiaria(scanner.nextDouble());

                if(reserva.getValorDiaria() < minimoAplicavel) {
                    System.out.println("Valor inválido! O mínimo para " + reserva.getTipoDeQuarto() +
                            " é R$" + minimoAplicavel);
                }
            } while(reserva.getValorDiaria() < minimoAplicavel);

            System.out.print("Número de dias: ");
            reserva.setNumeroDeDias(scanner.nextInt());
            scanner.nextLine(); // consumir quebra de linha

            System.out.println("Reserva alterada com sucesso!");
        }
        System.out.println();

        return contador;
    }

    public static int cancelarReserva (Reserva[] reservaDeQuarto, int contador, Scanner scanner){
        System.out.println("Digite o CPF para encontrarmos a reserva.");
        scanner.nextLine();
        String cpf = scanner.nextLine();

        int posicaoEncontrada = -1;
        for (int i = 0; i < contador; i++) {
            if (reservaDeQuarto[i].getCpf().equals(cpf)) {
                posicaoEncontrada = i;
            }
        }
        if (posicaoEncontrada == -1){
            System.out.println("Reserva não encontrada!");
            System.out.println();

        }else{
            System.out.println("Reserva enconatrada:");
            System.out.println(reservaDeQuarto [posicaoEncontrada]);

            System.out.println("Deseja cancelar esse reserva!");
            String decisao = scanner.nextLine();

            if (decisao.equalsIgnoreCase("sim")) {
                for (int i = posicaoEncontrada; i < contador - 1; i++) {
                    reservaDeQuarto[i] = reservaDeQuarto[i + 1];
                }
                reservaDeQuarto[contador - 1] = null;
                contador--;

                System.out.println("Reserva cancelada com sucesso!");
            } else {
                System.out.println("Cancelamento abortado.");
            }
        }
        System.out.println();
        return contador;
    }

    public static int buscaHospede (Reserva[] reservaDeQuarto, int contador, Scanner scanner) {
        System.out.println("Digite o CPF para encontrarmos a reserva.");
        scanner.nextLine();
        String cpf = scanner.nextLine();

        int posicaoEncontrada = -1;
        for (int i = 0; i < contador; i++) {
            if (reservaDeQuarto[i].getCpf().equals(cpf)) {
                posicaoEncontrada = i;
            }
        }
        if (posicaoEncontrada == -1){
            System.out.println("Reserva não encontrada!");

        }else{
            System.out.println(reservaDeQuarto [posicaoEncontrada]);
        }
        System.out.println();

        return contador;
    }

    public static Reserva[] ordenarDias (Reserva[] reservaDeQuarto, int contador) {

        for (int i = 0; i < contador - 1; i++){
            for (int j = 0; j < contador - 1 - i; j++){
                if(reservaDeQuarto[j].getNumeroDeDias() < reservaDeQuarto[j+1].getNumeroDeDias()) {
                    Reserva temp = reservaDeQuarto[j];
                    reservaDeQuarto[j] = reservaDeQuarto[j+1];
                    reservaDeQuarto[j+1] = temp;
                }
            }

        }
        System.out.println("Reservas em ordem decrescente:");
        for (int i = 0; i < contador; i++) {
            System.out.println("Nome: " + reservaDeQuarto[i].getNome());
            System.out.println("CPF: " + reservaDeQuarto[i].getCpf());
            System.out.println("Quarto: " + reservaDeQuarto[i].getTipoDeQuarto());
            System.out.println("Dias: " + reservaDeQuarto[i].getNumeroDeDias());
            System.out.println("Valor total: R$" + reservaDeQuarto[i].calcularValorTotal());
            System.out.println();
        }

        return reservaDeQuarto;
    }
    
}