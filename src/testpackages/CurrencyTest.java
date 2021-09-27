package testpackages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tareabanco.Currency;

class CurrencyTest {

    @Test
    public void testCurrencyCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        assertEquals("CLP" + 1.0 / 788, pesoChileno.getName() + pesoChileno.getRate());
    }

    @Test
    public void testCurrencyGBP() {
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        assertEquals("GBP" + 1.0 / 0.73, libra.getName() + libra.getRate());
    }

    @Test
    public void testCurrencyARS() {
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        assertEquals("ARS" + 1.0 / 99, pesoArgentino.getName() + pesoArgentino.getRate());
    }

    @Test
    public void testUniversalValueCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Double valorUniversal = pesoChileno.universalValue(1.0);
        assertEquals(1.0 / 788, valorUniversal);
    }

    @Test
    public void testUniversalValueGBP() {
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        Double valorUniversal = libra.universalValue(1.0);
        assertEquals(1.0 / 0.73, valorUniversal);
    }

    @Test
    public void testUniversalValueARS() {
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        Double valorUniversal = pesoArgentino.universalValue(1.0);
        assertEquals(1.0 / 99, valorUniversal);
    }

    @Test
    public void testGetNameCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        String nombreMoneda = pesoChileno.getName();
        assertEquals("CLP", nombreMoneda);

    }

    @Test
    public void testGetNameARS() {
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        String nombreMoneda = pesoArgentino.getName();
        assertEquals("ARS", nombreMoneda);

    }

    @Test
    public void testGetNameGBP() {
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        String nombreMoneda = libra.getName();
        assertEquals("GBP", nombreMoneda);

    }

    @Test
    public void testGetRateCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Double rateMoneda = pesoChileno.getRate();
        assertEquals(1.0 / 788, rateMoneda);
    }

    @Test
    public void testGetRateARS() {
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        Double rateMoneda = pesoArgentino.getRate();
        assertEquals(1.0 / 99, rateMoneda);
    }

    @Test
    public void testGetRateGBP() {
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        Double rateMoneda = libra.getRate();
        assertEquals(1.0 / 0.73, rateMoneda);
    }

    @Test
    public void testSetRateCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        pesoChileno.setRate(1.0 / 790);
        assertEquals(1.0 / 790, pesoChileno.getRate());
    }

    @Test
    public void testSetRateARS() {
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        pesoArgentino.setRate(1.0 / 790);
        assertEquals(1.0 / 790, pesoArgentino.getRate());
    }

    @Test
    public void testSetRateGBP() {
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        libra.setRate(1.0 / 790);
        assertEquals(1.0 / 790, libra.getRate());
    }

    @Test
    public void testValueInThisCurrencyCLPToARS() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);


        Double arsToCLP = pesoChileno.valueInThisCurrency(1000.00, pesoArgentino);

        assertEquals(7959.595, arsToCLP, 0.001);

    }

    @Test
    public void testValueInThisCurrencyGBPtoARS() {
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);


        Double arsToGBP = pesoArgentino.valueInThisCurrency(1000.00, libra);

        assertEquals(135616.43, arsToGBP, 0.01);

    }

    @Test
    public void testValueInThisCurrencyCLPToGBP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Currency libra = new Currency("GBP", 1.0 / 0.73);


        Double gbpToCLP = pesoChileno.valueInThisCurrency(1000.00, libra);

        assertEquals(1079452.05, gbpToCLP, 0.01);

    }

}
