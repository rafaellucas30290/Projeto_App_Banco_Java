import Model.*;

import Services.*;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Banco banco = new Banco();

        Scanner scanner = new Scanner(System.in);


        System.out.println("Bem-vindo ao Banco Interativo!");


        while (true) {

            System.out.println("\nEscolha uma opção:");

            System.out.println("1 - Criar Conta Corrente");

            System.out.println("2 - Criar Conta Poupança");

            System.out.println("3 - Depositar");

            System.out.println("4 - Sacar");

            System.out.println("5 - Transferir");

            System.out.println("6 - Consultar Saldo");

            System.out.println("7 - Sair");


            int opcao = scanner.nextInt();

            scanner.nextLine(); // Limpar buffer


            switch (opcao) {

                case 1:

                    System.out.print("Digite o nome do cliente: ");

                    String nome1 = scanner.nextLine();

                    System.out.print("Digite o CPF do cliente: ");

                    String cpf1 = scanner.nextLine();

                    Cliente cliente1 = new Cliente(nome1, cpf1);


                    System.out.print("Digite o número da conta: ");

                    int numero1 = scanner.nextInt();

                    Conta conta1 = new ContaCorrente(numero1, cliente1);

                    banco.adicionarConta(conta1);

                    System.out.println("Conta Corrente criada com sucesso!");

                    break;


                case 2:

                    System.out.print("Digite o nome do cliente: ");

                    String nome2 = scanner.nextLine();

                    System.out.print("Digite o CPF do cliente: ");

                    String cpf2 = scanner.nextLine();

                    Cliente cliente2 = new Cliente(nome2, cpf2);


                    System.out.print("Digite o número da conta: ");

                    int numero2 = scanner.nextInt();

                    Conta conta2 = new ContaPoupanca(numero2, cliente2);

                    banco.adicionarConta(conta2);

                    System.out.println("Conta Poupança criada com sucesso!");

                    break;


                case 3:

                    System.out.print("Digite o número da conta para depósito: ");

                    int numeroDep = scanner.nextInt();

                    System.out.print("Digite o valor para depósito: ");

                    double valorDep = scanner.nextDouble();


                    Conta contaDep = buscarConta(banco, numeroDep);

                    if (contaDep != null) {

                        banco.depositar(contaDep, valorDep);

                        System.out.println("Depósito realizado com sucesso!");

                    } else {

                        System.out.println("Conta não encontrada.");

                    }

                    break;


                case 4:

                    System.out.print("Digite o número da conta para saque: ");

                    int numeroSaque = scanner.nextInt();

                    System.out.print("Digite o valor para saque: ");

                    double valorSaque = scanner.nextDouble();


                    Conta contaSaque = buscarConta(banco, numeroSaque);

                    if (contaSaque != null) {

                        banco.sacar(contaSaque, valorSaque);

                        System.out.println("Saque realizado com sucesso!");

                    } else {

                        System.out.println("Conta não encontrada.");

                    }

                    break;


                case 5:

                    System.out.print("Digite o número da conta de origem: ");

                    int numeroOrigem = scanner.nextInt();

                    System.out.print("Digite o número da conta de destino: ");

                    int numeroDestino = scanner.nextInt();

                    System.out.print("Digite o valor para transferência: ");

                    double valorTransf = scanner.nextDouble();


                    Conta contaOrigem = buscarConta(banco, numeroOrigem);

                    Conta contaDestino = buscarConta(banco, numeroDestino);


                    if (contaOrigem != null && contaDestino != null) {

                        banco.transferir(contaOrigem, contaDestino, valorTransf);

                        System.out.println("Transferência realizada com sucesso!");

                    } else {

                        System.out.println("Conta de origem ou destino não encontrada.");

                    }

                    break;


                case 6:

                    System.out.print("Digite o número da conta: ");

                    int numeroSaldo = scanner.nextInt();


                    Conta contaSaldo = buscarConta(banco, numeroSaldo);

                    if (contaSaldo != null) {

                        System.out.println("Saldo da conta " + numeroSaldo + ": R$" + contaSaldo.getSaldo());

                    } else {

                        System.out.println("Conta não encontrada.");

                    }

                    break;


                case 7:

                    System.out.println("Obrigado por usar o Banco Interativo. Até logo!");

                    scanner.close();

                    return;


                default:

                    System.out.println("Opção inválida! Tente novamente.");

            }

        }

    }


    private static Conta buscarConta(Banco banco, int numero) {

        for (Conta conta : banco.getContas()) {

            if (conta.getNumero() == numero) {

                return conta;

            }

        }

        return null;

    }

}


