package tareabanco;


public class Money implements Comparable<Money> {

    private int amount;
    private Currency currency;
    
    
    
   

    /**
     * New Money
     *
     * @param amount   Cantidad de dinero
     * @param currency La moneda en la que está el dinero
     */


    public Money(Integer amount, Currency currency) {
        this.amount = amount * 1000;
        this.currency = currency;
    }

    /**
     * @return La cantidad de dinero
     */
    public Integer getAmount() {
        int amountNormal = this.amount / 1000;
        return amountNormal;
    }

    /**
     * @return la moneda en la que esta el dinero
     */
    public Currency getCurrency() {
        return this.currency;
    }

    /**
     * Retorna la cantidad de dinero en formato string. en la forma (cantidad)
     * (nombremoneda). Por ejemplo: "99.99 USD" Recuerda que las cantidades se
     * guardan como entero!!! y para el ejemplo anterior se guarda 9999!
     *
     * @return String que representa el dinero
     */
    @Override
    public String toString() {
        return this.getAmount().toString() + " " + this.getCurrency().getName();
    }

    /**
     * Obtiene el valor universal del dinero.
     *
     * @return valor del dinero en la moneda universal
     */
    public Double universalValue() {
        double valorUniversalPlata = this.getAmount() * this.currency.getRate();
        return valorUniversalPlata;
    }

    /**
     * Verifica si el valor de este dinero es igual al valor de otro dinero en
     * otra moneda.
     *
     * @param other el dinero con el que tenemos que comparar
     * @return verdadero si son iguales, falso sino.
     */
    public Boolean equals(Money other) {
        if ((double) this.universalValue() ==  other.universalValue()) {
            return true;
        } else {
            return false;
        }


    }

    /**
     * Suma más dinero al dinero actual, no importanto la moneda
     *
     * @param other el dinero que quiero sumar al actual
     * @return un nuevo objeto dinero, que tiene la misma moneda que este
     * objeto, pero la suma de las dos cantidades (recuerda convertir antes de
     * sumar!)
     */
    public Money add(Money other) {
        double aMonedaOriginal = (this.universalValue() + other.universalValue()) * Math.pow(this.getCurrency().getRate(), -1);
        Money nuevaPlataTotal = new Money((int) aMonedaOriginal, this.getCurrency());
        return nuevaPlataTotal;
    }

    /**
     * Resta la cantidad de dinero... similar a la suma!
     *
     * @param other el dinero que quiero restar al actual
     * @return un nuevo objeto dinero, que tiene la misma moneda que este
     * objeto, pero diferencia de las dos cantidades (recuerda convertir antes
     * de restar!)
     */
    public Money sub(Money other) {
        double aMonedaOriginal = (this.universalValue() - other.universalValue()) * Math.pow(this.getCurrency().getRate(), -1);
        Money nuevaPlataTotal = new Money((int) aMonedaOriginal, this.getCurrency());
        return nuevaPlataTotal;
    }

    /**
     * Verifica si este dinero es cero!
     *
     * @return True si tengo 0. False sino
     */
    public Boolean isZero() {
        if (this.getAmount() == 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * El mismo dinero actual, pero con el signo cambiado : si tengo 10.00 CLP
     * -> -10.00 CLP
     *
     * @return nueva instancia de Money, signo invertido.
     */
    public Money negate() {
        Money nuevaPlataNegada = new Money((int) (this.getAmount() * -1), this.getCurrency());
        return nuevaPlataNegada;
    }

    /**
     * Compara dos Dineros Esto es necesario pues se implementa la interfaz
     * comparable.
     * <p>
     * (Recuerda que los enteros (Integer) ya implementan Comparable, y que
     * puedes usar el método universalValue) Cuidado! Debes caster el objeto a
     * Money!
     *
     * @return 0 si los dineros son iguales. -1 Si este dinero es menor que el
     * otro dinero . 1 Si este dinero es más que el otro
     */

    public int compareTo(Money othermoney) {

        return this.universalValue().compareTo(othermoney.universalValue());


    }
}
