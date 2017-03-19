package ohtu.ohtuvarasto;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double eps = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), eps);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), eps);
    }

    @Test
    public void uudenVarastonTilavuusAinaEiNegatiivinen() {
        assertEquals(0, new Varasto(-10).getTilavuus(), eps);
        assertEquals(0, new Varasto(-10, 0).getTilavuus(), eps);
    }

    @Test
    public void konstruktoriAsettaaAlkusaldonOikein() {
        assertEquals(0, new Varasto(10, -1).getSaldo(), eps);
        assertEquals(0, new Varasto(10, 0).getSaldo(), eps);
        assertEquals(5, new Varasto(10, 5).getSaldo(), eps);
        assertEquals(10, new Varasto(10, 10).getSaldo(), eps);
        assertEquals(10, new Varasto(10, 11).getSaldo(), eps);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
        assertEquals(8, varasto.getSaldo(), eps);
    }

    @Test
    public void lisaysLisaaSaldoaTilavuuteenAsti() {
        varasto.lisaaVarastoon(10);
        assertEquals(10, varasto.getSaldo(), eps);
    }

    @Test
    public void lisaysEiLisaaSaldoaYliTilavuuden() {
        varasto.lisaaVarastoon(11);
        assertEquals(10, varasto.getSaldo(), eps);
    }

    @Test
    public void negatiivisenMaaranLisaysEiMuutaSaldoa() {
        varasto.lisaaVarastoon(8);
        varasto.lisaaVarastoon(-1);
        assertEquals(8, varasto.getSaldo(), eps);
    }

    @Test
    public void tyhjaLisaysEiMuutaSaldoa() {
        varasto.lisaaVarastoon(8);
        varasto.lisaaVarastoon(0);
        assertEquals(8, varasto.getSaldo(), eps);
    }

    @Test
    public void lisaysPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);
        assertEquals(2, varasto.paljonkoMahtuu(), eps);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
        assertEquals(2, varasto.otaVarastosta(2), eps);
    }

    @Test
    public void saldoEiMuutuJosOtettavaMaaraNegatiivinen() {
        varasto.lisaaVarastoon(8);
        assertEquals(0, varasto.otaVarastosta(-1), eps);
        assertEquals(0, varasto.otaVarastosta(0), eps);
        assertEquals(8, varasto.getSaldo(), eps);
    }

    @Test
    public void varastostaEiVoiOttaaSaldoaSuurempaaMaaraa() {
        varasto.lisaaVarastoon(8);
        assertEquals(8, varasto.otaVarastosta(9), eps);
        assertEquals(0, varasto.getSaldo(), eps);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);
        varasto.otaVarastosta(2);
        assertEquals(4, varasto.paljonkoMahtuu(), eps);
    }

    @Test
    public void merkkijonoesitysToimii() {
        varasto.lisaaVarastoon(8);
        assertEquals("saldo = 8.0, vielä tilaa 2.0", varasto.toString());
    }

}
