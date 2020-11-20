/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author pera
 */
public class VarastoTest {

    final int ID = 3;
    Kirjanpito kirjanpito;
    Varasto v;

    @Before
    public void setUp() {
        kirjanpito = mock(Kirjanpito.class);
        v = new Varasto(kirjanpito);
    }

    @Test
    public void uudenVarastonLuontiToimii() {
        assertNotNull(v);
    }

    @Test
    public void saldoToimii() {
        assertEquals(v.saldo(ID), 30);
    }

    @Test
    public void haeTuoteToimii() {
        Tuote t = v.haeTuote(3);
        assertTrue("Sierra Nevada Pale Ale".equals(t.toString()));
    }

    @Test
    public void haeOlematonTuoteToimii() {
        assertNull(v.haeTuote(-1));
    }

    @Test
    public void otaVarastostaToimii() {
        Tuote t = v.haeTuote(ID);
        v.otaVarastosta(t);
        assertEquals(v.saldo(ID), 29);
    }

    @Test
    public void palautaVarastoonToimii() {
        Tuote t = v.haeTuote(ID);
        v.palautaVarastoon(t);
        assertEquals(v.saldo(ID), 31);
    }

}
