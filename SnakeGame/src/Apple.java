import java.util.Random;

public class Apple {
    public int X;
    public int Y;

    public Apple(){
        Random random = new Random();
        this.X = random.nextInt(GameField.WIDTH)*GameField.DOT_SIZE;
        this.Y = random.nextInt(GameField.HEIGHT)*GameField.DOT_SIZE;
    }
}
