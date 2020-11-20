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

public class KirjanpitoTest {

    Kirjanpito k;

    @Before
    public void setUp() {
        k = new Kirjanpito();
    }

    @Test
    public void kirjanpitoLuontiToimii() {
        assertNotNull(k);
    }

    @Test
    public void tapahtumanLisaysToimii() {
        k.lisaaTapahtuma("Kukkuu");
        assertEquals(k.getTapahtumat().size(), 1);
    }
}
