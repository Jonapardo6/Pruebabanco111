import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una Cuenta de Ahorros
        System.out.println("Ingrese los datos para la Cuenta de Ahorros:");
        System.out.print("Número de Cuenta: ");
        String numeroCuentaAhorros = scanner.nextLine();  // Arreglado, usando scanner.nextLine() para capturar la entrada
        System.out.print("Propietario: ");
        String propietarioAhorros = scanner.nextLine();
        System.out.print("Saldo Inicial: ");
        double saldoInicialAhorros = scanner.nextDouble();
        System.out.print("Tasa Anual (%): ");
        double tasaAnualAhorros = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        CuentaAhorros cuentaAhorros = new CuentaAhorros(numeroCuentaAhorros, propietarioAhorros, saldoInicialAhorros, tasaAnualAhorros);

        // Realizar operaciones en la Cuenta de Ahorros
        cuentaAhorros.depositar(200);
        cuentaAhorros.retirar(50);
        cuentaAhorros.extractoMensual();
        cuentaAhorros.imprimir();

        // Crear una Cuenta Corriente
        System.out.println("\nIngrese los datos para la Cuenta Corriente:");
        System.out.print("Número de Cuenta: ");
        String numeroCuentaCorriente = scanner.nextLine();
        System.out.print("Propietario: ");
        String propietarioCorriente = scanner.nextLine();
        System.out.print("Saldo Inicial: ");
        double saldoInicialCorriente = scanner.nextDouble();
        System.out.print("Tasa Anual (%): ");
        double tasaAnualCorriente = scanner.nextDouble();

        CuentaCorriente cuentaCorriente = new CuentaCorriente(numeroCuentaCorriente, propietarioCorriente, saldoInicialCorriente, tasaAnualCorriente);

        // Realizar operaciones en la Cuenta Corriente
        cuentaCorriente.depositar(500);
        cuentaCorriente.retirar(700); // Esto generará un sobregiro
        cuentaCorriente.extractoMensual();
        cuentaCorriente.imprimir();

        scanner.close();  // Cerramos el scanner al final
    }
}
