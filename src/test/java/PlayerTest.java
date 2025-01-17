import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testPlayer() {
        Game game = new Game();
        game.setupGame();

        Player player = game.getPlayers().get(0);

        assertEquals("Player 1", player.getName());
        assertTrue(player.getHand().isEmpty());
        assertEquals(2, player.getFields().size());

        Beanometer beanometer = new Beanometer(Map.of(4, 1, 6, 2, 8, 3, 10, 4));
        BeanType beanType = new BeanType("Blue Bean", beanometer);
        Card card = new Card(beanType);

        player.getHand().add(card);
        System.out.println("Player's hand before planting: " + player.getHand().size());
        player.plantBeanFromHand();

        System.out.println("Player's hand after planting: " + player.getHand().size());
        System.out.println("Field status: " + player.getFieldStatus());

        assertTrue(player.getHand().isEmpty());
        String[] fieldStatuses = player.getFieldStatus().split("\n");
        assertEquals("1 Blue Bean(s)", fieldStatuses[0].trim());
        assertEquals("Empty field", fieldStatuses[1].trim());
    }
}
