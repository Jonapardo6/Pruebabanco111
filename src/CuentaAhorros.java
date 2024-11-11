public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(String numeroCuenta, String propietario, double saldoInicial, double tasaAnual) {
        super(numeroCuenta, propietario, saldoInicial, tasaAnual);
        this.activa = saldoInicial >= 100;
    }

    @Override
    public void depositar(double cantidad) {
        if (activa) {
            super.depositar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva. No se pueden realizar depósitos.");
        }
        verificarEstadoCuenta();
    }

    @Override
    public void retirar(double cantidad) {
        if (activa) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva. No se pueden realizar retiros.");
        }
        verificarEstadoCuenta();
    }

    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1; // $1 por cada retiro adicional
        }
        super.extractoMensual();
        verificarEstadoCuenta();
    }

    private void verificarEstadoCuenta() {
        activa = saldo >= 100;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Estado de la Cuenta: " + (activa ? "Activa" : "Inactiva"));
    }
}
