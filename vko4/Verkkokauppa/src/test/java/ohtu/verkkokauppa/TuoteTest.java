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

/**
 *
 * @author pera
 */
public class TuoteTest {
    
    @Test
    public void tuoteVertailuKunSamat() {
    Tuote t1 = new Tuote(99,"Diiba",999);
    Tuote t2 = new Tuote(99,"Daaba",666);
    assertTrue(t1.equals(t2));
    }
    
    @Test
    public void tuoteVertailuKunEri() {
    Tuote t1 = new Tuote(66,"Diiba",999);
    Tuote t2 = new Tuote(99,"Diiba",999);
    assertFalse(t1.equals(t2));
    }
}
