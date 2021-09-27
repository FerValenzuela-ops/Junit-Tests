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
        int monto = plataChilena.getAmount();
        assertEquals(1000, monto);

    }

    @Test
    void testGetCurrency() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(1000, pesoChileno);
        String divisaNombre = (plataChilena.getCurrency().getName());
        Double divisaCambio = plataChilena.getCurrency().getRate();
        assertTrue((divisaNombre == "CLP") && (divisaCambio == 1.0 / 788));

    }

    @Test
    void testToStringCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(1000, pesoChileno);
        String infoPlata = plataChilena.toString();
        assertEquals("1000" + " " + "CLP", infoPlata);

    }

    @Test
    void testUniversalValueCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(1000, pesoChileno);
        double clpEnUSD = plataChilena.universalValue();
        assertEquals(1.26, clpEnUSD, 0.01);
    }

    @Test
    void testEqualsMoneyCLPtoARS() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(7880, pesoChileno);
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        Money plataArgentino = new Money(990, pesoArgentino);
        boolean montoEquivalente = plataChilena.equals(plataArgentino);
        assertTrue(montoEquivalente);

    }

    @Test
    void testAddARStoCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(7880, pesoChileno);
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        Money plataArgentino = new Money(990, pesoArgentino);

        Money anadirOtraMoenda = plataChilena.add(plataArgentino);
        assertEquals(7880 * 2, anadirOtraMoenda.getAmount());
    }

    @Test
    void testSubARStoCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(7880, pesoChileno);
        Currency pesoArgentino = new Currency("ARS", 1.0 / 99);
        Money plataArgentino = new Money(990, pesoArgentino);

        Money restarOtraMoenda = plataChilena.sub(plataArgentino);
        assertEquals(0, restarOtraMoenda.getAmount());
    }

    @Test
    void testIsZeroCLP() {
        Currency pesoChileno = new Currency("CLP", 1.0 / 788);
        Money plataChilena = new Money(0, pesoChileno);
        boolean validarCero = plataChilena.isZero();
        assertTrue(validarCero);
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
        int compararDineros = plataChilena.compareTo(plataArgentino);
        assertEquals(0, compararDineros);
    }

}
