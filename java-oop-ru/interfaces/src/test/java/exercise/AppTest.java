package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;


class AppTest {

    private ReversedSequence reversedSequence;

    @BeforeEach
    public void setUp() {
        reversedSequence = new ReversedSequence("hello");
    }

    @Test
    void testBuildApartmentsList1() {
        List<Home> apartments = new ArrayList<>(List.of(
            new Flat(41, 3, 10),
            new Cottage(125.5, 2),
            new Flat(80, 10, 2),
            new Cottage(150, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
            "Квартира площадью 44.0 метров на 10 этаже",
            "Квартира площадью 90.0 метров на 2 этаже",
            "2 этажный коттедж площадью 125.5 метров"
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testBuildApartmentsList2() {
        List<Home> apartments = new ArrayList<>(List.of(
            new Cottage(100, 1),
            new Flat(190, 10, 2),
            new Flat(180, 30, 5),
            new Cottage(250, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
            "1 этажный коттедж площадью 100.0 метров",
            "Квартира площадью 200.0 метров на 2 этаже",
            "Квартира площадью 210.0 метров на 5 этаже",
            "3 этажный коттедж площадью 250.0 метров"
        ));

        List<String> result = App.buildApartmentsList(apartments, 4);
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void testBuildApartmentsList3() {
        List<Home> apartments = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        List<String> result = App.buildApartmentsList(apartments, 10);
        assertThat(result).isEqualTo(expected);
    }

    // BEGIN
    @Test
    public void testLength() {
        assertThat(reversedSequence.length()).isEqualTo(5);
    }

    @Test
    public void testCharAt() {
        assertThat(reversedSequence.charAt(0)).isEqualTo('o');
        assertThat(reversedSequence.charAt(1)).isEqualTo('l');
        assertThat(reversedSequence.charAt(2)).isEqualTo('l');
        assertThat(reversedSequence.charAt(3)).isEqualTo('e');
        assertThat(reversedSequence.charAt(4)).isEqualTo('h');
    }

    @Test
    public void testToString() {
        assertThat(reversedSequence.toString()).isEqualTo("olleh");
    }

    @Test
    public void testEmptyString() {
        ReversedSequence emptySequence = new ReversedSequence("");
        assertThat(emptySequence.length()).isEqualTo(0);
        assertThat(emptySequence.toString()).isEqualTo("");
    }

    @Test
    public void testSingleCharString() {
        ReversedSequence singleCharSequence = new ReversedSequence("a");
        assertThat(singleCharSequence.length()).isEqualTo(1);
        assertThat(singleCharSequence.toString()).isEqualTo("a");
    }
    // END
}
