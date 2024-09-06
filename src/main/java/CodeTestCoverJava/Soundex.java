package CodeTestCoverJava;

public class Soundex {

    private static final Map<Character, Character> SOUND_EX_MAP = new HashMap<>();

    static {
        SOUND_EX_MAP.put('b', '1');
        SOUND_EX_MAP.put('f', '1');
        SOUND_EX_MAP.put('p', '1');
        SOUND_EX_MAP.put('v', '1');
        SOUND_EX_MAP.put('c', '2');
        SOUND_EX_MAP.put('g', '2');
        SOUND_EX_MAP.put('j', '2');
        SOUND_EX_MAP.put('k', '2');
        SOUND_EX_MAP.put('q', '2');
        SOUND_EX_MAP.put('s', '2');
        SOUND_EX_MAP.put('x', '2');
        SOUND_EX_MAP.put('z', '2');
        SOUND_EX_MAP.put('d', '3');
        SOUND_EX_MAP.put('t', '3');
        SOUND_EX_MAP.put('l', '4');
        SOUND_EX_MAP.put('m', '5');
        SOUND_EX_MAP.put('n', '5');
        SOUND_EX_MAP.put('r', '6');
    }

    public static String encode(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        name = name.toUpperCase();
        StringBuilder soundex = new StringBuilder();

        soundex.append(name.charAt(0));

        // Previous encoded digit
        char prevDigit = '0';

        // Iterate over the remaining characters
        for (int i = 1; i < name.length(); i++) {
            char c = name.charAt(i);

            // Skip specific characters
            if ("AEIOUYHW".indexOf(c) >= 0) {
                continue;
            }

            // Get the encoded digit for the consonant
            char encodedDigit = SOUND_EX_MAP.getOrDefault(c, '0');

            // Avoid repeating digits
            if (encodedDigit != prevDigit) {
                soundex.append(encodedDigit);
                prevDigit = encodedDigit;
            }

            // Stop if we have the first letter and three digits
            if (soundex.length() == 4) {
                break;
            }
        }

        // Pad with zeros if necessary
        while (soundex.length() < 4) {
            soundex.append('0');
        }

        return soundex.toString();
    }
}
