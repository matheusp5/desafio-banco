import java.util.Scanner;

public class Screens {
    private Scanner scanner = new Scanner(System.in);
    public String name;
    private double balance;

    public Screens(String name) {
        this.name = name;
        this.balance = 0;
    }

    public void HomeScreen() {

        System.out.println("******************************************");
        System.out.println();
        System.out.println("Nome:          " + name);
        System.out.println("Saldo:         R$ " + balance);
        System.out.println("Tipo de conta: Corrente");
        System.out.println();
        System.out.println("******************************************");

        while(true) {
            System.out.println();
            System.out.println("Operações");
            System.out.println();
            System.out.println("1- Consultar saldo");
            System.out.println("2- Receber valor");
            System.out.println("3- Transferir valor");
            System.out.println("4- Sair");
            System.out.println();

            System.out.print("Digite a opção desejada: ");
            int choose = scanner.nextInt();

            if(choose == 4) break;

            switch (choose) {
                case 1:
                    System.out.println();
                    this.getBalance();
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Qual o valor você deseja receber? ");
                    this.receiveValue(scanner.nextDouble());
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Qual o valor você deseja transferir? ");
                    this.transferValue(scanner.nextDouble());
                    break;
            }
        }
    }

    private void getBalance() {
        System.out.println("O seu saldo atual é de R$ " + this.balance);
    }

    private void receiveValue(double value) {
        if(value <= 0) {
            System.out.println("Valor inválido");
            return;
        }
        this.balance += value;
        System.out.println("Ótimo! Você recebeu R$ " + value);
        this.getBalance();
    }

    private void transferValue(double value) {
        if(value > this.balance || value < 0) {
            System.out.println("Você não possui essa quantia ou o valor é inválido!");
            return;
        }

        this.balance -= value;
        System.out.println("Você transferiu R$ " + value);
        this.getBalance();
    }


}
