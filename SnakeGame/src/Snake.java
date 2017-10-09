public class Snake {
    public int length = 3;
    public boolean right = true;
    public boolean left;
    public boolean up;
    public boolean down;

    public int[] X = new int[GameField.WIDTH*GameField.HEIGHT];
    public int[] Y = new int[GameField.WIDTH*GameField.HEIGHT];

    public Snake(){
        for (int i = 0; i > length; i++){
            X[i] = length*GameField.DOT_SIZE - i*GameField.DOT_SIZE;
            Y[i] = length*GameField.DOT_SIZE;
        }
    }

    public void move(){
        for(int i = length; i > 0; i--) {
            X[i] = X[i - 1];
            Y[i] = Y[i - 1];
        }
        if(this.left){
            X[0] -= GameField.DOT_SIZE;
        }
        if(this.right){
            X[0] += GameField.DOT_SIZE;
        }
        if(this.up){
            Y[0] -= GameField.DOT_SIZE;
        }
        if(this.down){
            Y[0] += GameField.DOT_SIZE;
        }
    }
}
