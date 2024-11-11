public class Cuenta {
    protected String numeroCuenta;
    protected String propietario;
    protected double saldo;
    protected int numeroDepositos;
    protected int numeroRetiros;
    protected double tasaAnual;
    protected double comisionMensual;

    public Cuenta(String numeroCuenta, String propietario, double saldoInicial, double tasaAnual) {
        this.numeroCuenta = numeroCuenta;
        this.propietario = propietario;
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
        this.numeroDepositos = 0;
        this.numeroRetiros = 0;
        this.comisionMensual = 0;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numeroDepositos++;
        } else {
            System.out.println("La cantidad a depositar debe ser positiva.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            numeroRetiros++;
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida.");
        }
    }

    public void calcularInteresMensual() {
        double interesMensual = (tasaAnual / 12) * saldo;
        saldo += interesMensual;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
        comisionMensual = 0; // Reiniciar la comisión mensual después de aplicarla
    }

    public void imprimir() {
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Propietario: " + propietario);
        System.out.println("Saldo: $" + saldo);
        System.out.println("Número de Depósitos: " + numeroDepositos);
        System.out.println("Número de Retiros: " + numeroRetiros);
        System.out.println("Tasa Anual: " + tasaAnual + "%");
        System.out.println("Comisión Mensual: $" + comisionMensual);
    }
}
