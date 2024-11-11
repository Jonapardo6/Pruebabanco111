public class CuentaCorriente extends Cuenta {
    private double sobregiro;

    public CuentaCorriente(String numeroCuenta, String propietario, double saldoInicial, double tasaAnual) {
        super(numeroCuenta, propietario, saldoInicial, tasaAnual);
        this.sobregiro = 0;
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
            } else {
                double diferencia = cantidad - saldo;
                saldo = 0;
                sobregiro += diferencia;
            }
            numeroRetiros++;
        } else {
            System.out.println("Cantidad inválida para retirar.");
        }
    }

    @Override
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            if (sobregiro > 0) {
                if (cantidad >= sobregiro) {
                    cantidad -= sobregiro;
                    sobregiro = 0;
                    saldo += cantidad;
                } else {
                    sobregiro -= cantidad;
                }
            } else {
                saldo += cantidad;
            }
            numeroDepositos++;
        } else {
            System.out.println("La cantidad a depositar debe ser positiva.");
        }
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Sobregiro: $" + sobregiro);
    }
}
