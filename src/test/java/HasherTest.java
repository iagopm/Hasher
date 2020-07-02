import org.junit.Test;

public class HasherTest {

    @Test
    public void hash() {
        System.out.println(Hasher.hash(("asd")));
        System.out.println(Hasher.hash("asd1234"));
        System.out.println(Hasher.hash(("Aasd1234")));
        System.out.println(Hasher.hash(("as as as")));
    }
}