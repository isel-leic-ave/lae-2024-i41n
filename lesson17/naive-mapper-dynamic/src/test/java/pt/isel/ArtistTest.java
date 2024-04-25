package pt.isel;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArtistTest {
    @Test
    void testArtistLastFm() {
        //ArtistLastFm alfm = new ArtistLastFm("Ana", "", 9, null);
        Arrays.asList(ArtistLastFm.class.getDeclaredMethods())
                .forEach(c -> System.out.println(c));
    }

}
