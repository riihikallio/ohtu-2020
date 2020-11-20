/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 *
 * @author pera
 */
public class PankkiTest {

    Kirjanpito kirjanpito;
    Pankki p;

    @Before
    public void setUp() {
        kirjanpito = mock(Kirjanpito.class);
        p = new Pankki(kirjanpito);
    }

    @Test
    public void uudenPankinLuontiToimii() {
        assertNotNull(p);
    }
    
    @Test
    public void tilisiirtoToimii() {
        assertTrue(p.tilisiirto("Erkki", 13, "666", "999", 40));
    }

}
