import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(){
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(GameField.WIDTH*GameField.DOT_SIZE,GameField.HEIGHT*GameField.DOT_SIZE);
        setLocationRelativeTo(null);
        add(new GameField());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        MainWindow mainWindow = new MainWindow();
    }
}
