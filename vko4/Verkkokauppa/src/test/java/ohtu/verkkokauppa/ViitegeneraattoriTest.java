/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pera
 */
public class ViitegeneraattoriTest {
    
    @Test
    public void generaattorinLuontiToimii() {
        assertNotNull(new Viitegeneraattori());
    }
    
    @Test
    public void uudenViitteenLuontiToimii() {
        Viitegeneraattori vg = new Viitegeneraattori();
        assertTrue(vg.uusi() > 0);
    }
    
}
