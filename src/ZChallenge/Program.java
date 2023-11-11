package ZChallenge;

import ZChallenge.entities.Contract;
import ZChallenge.entities.Installment;
import ZChallenge.services.ContractService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Entre os dados do contrato:");
        System.out.print("Número: ");
        int number = sc.nextInt();

        System.out.println("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(),fmt);
        System.out.println("Valor do contrato: ");
        double totalValue = sc.nextDouble();
        Contract contract = new Contract(number,date,totalValue);


        System.out.println("Entre com o número de parcelas: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(null);

        contractService.processContract(contract, n);

        System.out.println("Parcelas: ");

        for(Installment installment: contract.getInstallments()){
            System.out.println(installment);
        }


        sc.close();
    }
}
