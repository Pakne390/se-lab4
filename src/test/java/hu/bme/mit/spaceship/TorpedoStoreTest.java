    package hu.bme.mit.spaceship;

    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertFalse;
    import static org.junit.jupiter.api.Assertions.assertThrows;
    import static org.junit.jupiter.api.Assertions.assertTrue;

    import org.junit.jupiter.api.Test;

    class TorpedoStoreTest {

        @Test
        void fire_Success_DecreasesTorpedoCount() {
            TorpedoStore store = new TorpedoStore(3, 0.0);

            boolean result = store.fire(2);

            assertTrue(result);
            assertEquals(1, store.getTorpedoCount());
            assertFalse(store.isEmpty());
        }

        @Test
        void fire_Failure_DoesNotDecreaseTorpedoCount() {
            TorpedoStore store = new TorpedoStore(2, 1.0);

            boolean result = store.fire(1);

            assertFalse(result);
            assertEquals(2, store.getTorpedoCount());
            assertFalse(store.isEmpty());
        }

        @Test
        void fire_LastTorpedo_MakesStoreEmpty() {
            TorpedoStore store = new TorpedoStore(1, 0.0);

            store.fire(1);

            assertEquals(0, store.getTorpedoCount());
            assertTrue(store.isEmpty());
        }

        @Test
        void fire_InvalidNumberOfTorpedoes_ThrowsException() {
            TorpedoStore store = new TorpedoStore(2, 0.0);

            assertThrows(IllegalArgumentException.class, () -> store.fire(0));
            assertThrows(IllegalArgumentException.class, () -> store.fire(3));
            assertEquals(2, store.getTorpedoCount());
        }
    }
