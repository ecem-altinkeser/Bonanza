import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {
    private Field field;
    private Card card1;
    private Card card2;

    @BeforeEach
    void setUp() {
        field = new Field();
        card1 = new Card("Blue Bean", 4);
        card2 = new Card("Red Bean", 3);
    }

    @Test
    void testPlantBean() {
        field.plantBean(card1);
        assertTrue(field.getCards().contains(card1), "Field should contain the planted card.");
    }

    @Test
    void testHarvestBeans() {
        field.plantBean(card1);
        field.plantBean(card2);
        List<Card> harvested = field.harvestBeans();
        assertTrue(harvested.contains(card1) && harvested.contains(card2), "Harvested cards should contain all planted cards.");
        assertEquals(0, field.getCards().size(), "Field should be empty after harvesting.");
    }
}