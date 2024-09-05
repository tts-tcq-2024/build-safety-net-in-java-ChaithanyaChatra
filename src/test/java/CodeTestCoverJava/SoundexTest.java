package CodeTestCoverJava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoundexTest {

    @Test
    public void testEmptyString() {
        assertEquals("", Soundex.generateSoundex(""));
    }
    
    @Test
    public void testNullInput() {
        assertEquals("", Soundex.generateSoundex(null));
    }

    @Test
    public void testSingleCharacter() {
    assertEquals("A000", Soundex.generateSoundex("A"));    
    }

    @Test
    public void testNormalNames() {
        assertEquals("A530", Soundex.generateSoundex("Ashcraft"));
        assertEquals("C520", Soundex.generateSoundex("Carpenter"));
    }
    
    @Test
    public void testPaddingZeros() {
        assertEquals("M650", Soundex.generateSoundex("Miller")); 
        assertEquals("T400", Soundex.generateSoundex("Tarek")); 
    }
}
