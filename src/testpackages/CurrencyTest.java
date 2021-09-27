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
        assertEquals(1.0 / 788, pesoChileno.universalValue(1.0));
    }

    @Test
    public void testUniversalValueGBP() {
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        assertEquals(1.0 / 0.73, libra.universalValue(1.0));
    }

    @Test
    public void testUniversalValueARS() {
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        assertEquals(1.0 / 99, pesoArgentino.universalValue(1.0));
    }

    @Test
    public void testGetNameCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        assertEquals("CLP", pesoChileno.getName());

    }

    @Test
    public void testGetNameARS() {
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        assertEquals("ARS", pesoArgentino.getName());

    }

    @Test
    public void testGetNameGBP() {
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        assertEquals("GBP", libra.getName());

    }

    @Test
    public void testGetRateCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        assertEquals(1.0 / 788, pesoChileno.getRate());
    }

    @Test
    public void testGetRateARS() {
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        assertEquals(1.0 / 99, pesoArgentino.getRate());
    }

    @Test
    public void testGetRateGBP() {
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        assertEquals(1.0 / 0.73, libra.getRate());
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
        assertEquals(7959.595, pesoChileno.valueInThisCurrency(1000.00, pesoArgentino), 0.001);

    }

    @Test
    public void testValueInThisCurrencyGBPtoARS() {
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        assertEquals(135616.43, pesoArgentino.valueInThisCurrency(1000.00, libra), 0.01);

    }

    @Test
    public void testValueInThisCurrencyCLPToGBP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Currency libra = new Currency("GBP", 1.0 / 0.73);
        assertEquals(1079452.05, pesoChileno.valueInThisCurrency(1000.00, libra), 0.01);

    }

}
