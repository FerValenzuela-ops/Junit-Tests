package testpackages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tareabanco.Currency;
import tareabanco.Money;

class MoneyTest {


    @Test
    void testGetAmountCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(1000, pesoChileno);
        assertEquals(1000, plataChilena.getAmount());

    }

    @Test
    void testGetCurrency() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(1000, pesoChileno);
        assertTrue((plataChilena.getCurrency().getName() == "CLP") && (plataChilena.getCurrency().getRate() == 1.0 / 788));

    }

    @Test
    void testToStringCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(1000, pesoChileno);
        assertEquals(1000 + " CLP", plataChilena.toString());

    }

    @Test
    void testUniversalValueCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(1000, pesoChileno);
        assertEquals(1.26, plataChilena.universalValue(), 0.01);
    }

    @Test
    void testEqualsMoneyCLPtoARS() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(7880, pesoChileno);
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        Money plataArgentino = new Money(990, pesoArgentino);
        assertTrue(plataChilena.equals(plataArgentino));

    }

    @Test
    void testAddARStoCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(7880, pesoChileno);
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        Money plataArgentino = new Money(990, pesoArgentino);

        Money anadirOtraMoneda = plataChilena.add(plataArgentino);
        assertEquals(7880 * 2, anadirOtraMoneda.getAmount());
    }

    @Test
    void testSubARStoCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(7880, pesoChileno);
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        Money plataArgentino = new Money(990, pesoArgentino);

        Money restarOtraMoneda = plataChilena.sub(plataArgentino);
        assertEquals(0, restarOtraMoneda.getAmount());
    }

    @Test
    void testIsZeroCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(0, pesoChileno);
        assertTrue(plataChilena.isZero());
    }

    @Test
    void testNegateCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(1000, pesoChileno);
        Money plataNegada = plataChilena.negate();
        assertEquals(-1000, plataNegada.getAmount());
    }

    @Test
    void testCompareToEqCLPtoARS() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(7880, pesoChileno);
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        Money plataArgentino = new Money(990, pesoArgentino);
        assertEquals(0, plataChilena.compareTo(plataArgentino));
    }

}
