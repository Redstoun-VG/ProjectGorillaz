

import static org.junit.jupiter.api.Assertions.*;

import com.javarush.grebenshikov.service.GameLogic;
import com.javarush.grebenshikov.model.GameState;
import org.junit.jupiter.api.Test;
;

class GameLogicTest {

    private GameLogic gameLogic = new GameLogic();
    private GameState state = new GameState();

    @Test
    void testStartToInvestigation() {
        state.setCurrentScene("start");
        String nextScene = gameLogic.processChoice(state, "begin");
        assertEquals("investigation", nextScene);
    }

    @Test
    void testLibraryMadness() {
        state.setCurrentScene("library");
        String nextScene = gameLogic.processChoice(state, "read");
        assertEquals("madness", nextScene);
        assertTrue(state.isMad());
    }

    @Test
    void testCellarSafe() {
        state.setCurrentScene("cellar");
        String nextScene = gameLogic.processChoice(state, "ignore");
        assertEquals("safe", nextScene);
        assertFalse(state.isMad());
    }

    @Test
    void testSceneDescriptions() {
        assertNotNull(gameLogic.getSceneDescription("start"));
        assertNotNull(gameLogic.getSceneDescription("madness"));
        assertNotNull(gameLogic.getSceneDescription("safe"));
    }
}
