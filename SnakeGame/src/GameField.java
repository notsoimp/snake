import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GameField extends JPanel implements ActionListener{
    public static final int DOT_SIZE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public boolean inGame = true;
    public Snake snake;
    public Apple apple;
    public Image appleIm;
    public Image dotIm;

    public GameField(){
        setBackground(Color.black);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    public void initGame(){
        snake = new Snake();
        Timer timer = new Timer(250,this);
        timer.start();
        apple = new Apple();
    }

    public void loadImages(){
        try{
            appleIm = ImageIO.read(getClass().getResource("/apple.png"));
            dotIm = ImageIO.read(getClass().getResource("/dot.png"));
        }
        catch(IOException e){}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(inGame){
            g.drawImage(appleIm, apple.X, apple.Y, this);
            for(int i = 0; i < snake.length; i++){
                g.drawImage(dotIm, snake.X[i], snake.Y[i], this);
            }
        }
        else{
            g.setColor(Color.white);
            Font font = new Font("Arial", Font.BOLD, 15);
            g.setFont(font);
            g.drawString("Game Over!", WIDTH*DOT_SIZE/3, HEIGHT*DOT_SIZE/2);
        }
    }

    public void checkApple(){
        if(snake.X[0] == apple.X && snake.Y[0] == apple.Y){
            snake.length++;
            apple = new Apple();
        }
    }

    public void checkCollisions(){
        for (int i = snake.length; i > 0; i--) {
            if(i>4 && snake.X[0] == snake.X[i] && snake.Y[0] == snake.Y[i])
                inGame = false;
        }
        if (snake.X[0]>WIDTH*DOT_SIZE){
            inGame = false;
        }
        if (snake.X[0]<0){
            inGame = false;
        }
        if (snake.Y[0]>HEIGHT*DOT_SIZE){
            inGame = false;
        }
        if (snake.Y[0]<0){
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            checkCollisions();
            snake.move();
        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && !snake.right){
                snake.left = true;
                snake.up = false;
                snake.down = false;
            }
            if(key == KeyEvent.VK_RIGHT && !snake.left){
                snake.right = true;
                snake.up = false;
                snake.down = false;
            }
            if(key == KeyEvent.VK_UP && !snake.down){
                snake.up = true;
                snake.right = false;
                snake.left = false;
            }
            if(key == KeyEvent.VK_DOWN && !snake.up){
                snake.down = true;
                snake.left = false;
                snake.right = false;
            }
        }
    }
}
