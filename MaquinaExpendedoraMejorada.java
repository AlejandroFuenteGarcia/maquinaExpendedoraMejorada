public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    
    private int numeroBilletesVendidos;
    
    private boolean maquinaConPremio;
    
    private int maximoDeBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean maquinaPremio, int maximoBilletes){
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        maquinaConPremio = maquinaPremio;
        maximoDeBilletes = maximoBilletes;
        maximoDeBilletes = 0;
    }
    public MaquinaExpendedoraMejorada(boolean maquinaPremio, int maximoBilletes){
        precioBillete = 20;
        estacionOrigen = "Leon";
        estacionDestino = "Salamanca";
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        numeroBilletesVendidos = 0;
        maquinaConPremio = maquinaPremio;
        maximoDeBilletes = maximoBilletes;
        maximoBilletes = 0;
    }
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }    
    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (maximoDeBilletes == numeroBilletesVendidos){
             System.out.println("Lo lamentamos se ha llegado al maximo de billetes vendidos");
            }
        else{
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
    }
    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta;
        
        cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (maximoDeBilletes == numeroBilletesVendidos){
            System.out.println("Lo lamentamos se ha llegado al maximo de billetes vendidos");
        }
        else {
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();      
                    if (maquinaConPremio == true){
                    System.out.println("¡PREMIOOO! Tienes un descuento de " + precioBillete / 4 + " para gastar en el negocio que quieras");
                }
        
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                numeroBilletesVendidos = (numeroBilletesVendidos + 1 );
            }else {
                System.out.println("Itroduce" + cantidadDeDineroQueFalta + "euros más");
            }
        }
    }
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }
    public int getNumeroDeBilletesVendidos(){
        return numeroBilletesVendidos;
    }
    public void imprimirNumeroBilletesVendidos(){
        System.out.println("Van" + numeroBilletesVendidos + " billetes vendidos");
    }    
    public int vaciarDineroDeLaMaquina() {
        int vaciadoDeMaquina = totalDineroAcumulado + balanceClienteActual;
        if (balanceClienteActual == 0){
            totalDineroAcumulado = 0;
            balanceClienteActual = 0;
        }else {
            vaciadoDeMaquina = -1;
        }
        return vaciadoDeMaquina;
    }
}    
