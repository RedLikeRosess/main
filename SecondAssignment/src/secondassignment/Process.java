package secondassignment;

public class Process {
    
    private int sizeX;
    private int sizeY;
    
    private Gamer actualGamer;

    public Gamer[][] table;

    public Process(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        actualGamer = Gamer.X;

        table = new Gamer[sizeX][sizeY];
        for (int i = 0; i < sizeX; ++i) {
            for (int j = 0; j < sizeY; ++j) {
                table[i][j] = Gamer.NOBODY;
            }
        }
    }

    public void step(int row, int column) {
        for (int i = sizeX-1; i > 0; i--){
                if (table[i][column] == Gamer.NOBODY) {
                    table[i][column] = actualGamer;
                    for (int c = sizeX-1; c > 0; c-- ){
                    }
                    if (actualGamer == Gamer.X) {
                    actualGamer = Gamer.O;
                    } else {
                    actualGamer = Gamer.X;
                    }
                    break;
                }                           
        }
    }

    public Gamer findWinner() {
        //Horizontal
        int cntHX = 0;
        int cntHO = 0;
        for (int i = sizeX-1; i > 0; i--){
            for (int j = sizeY-1; j > 0; j--){
                if (table[i][j] == Gamer.X && table[i][j] == table[i][j-1]){
                    cntHX++;
                    if(cntHX == 3){
                        return Gamer.X;
                    }
                }
                else{
                    cntHX = 0;
                }
                if (table[i][j] == Gamer.O && table[i][j] == table[i][j-1]){
                    cntHO++;
                    if(cntHO == 3){
                        return Gamer.O;
                    }
                }
                else{
                    cntHO = 0;
                }
            }
        }
        
        //Vertical
        int cntVX = 0;
        int cntVO = 0;
        for (int j = sizeY-1; j >= 0; j--){
            for (int i = sizeX-1; i > 0; i--){            
                if (table[i][j] == Gamer.X && table[i][j] == table[i-1][j]){
                    cntVX++;
                    if(cntVX == 3){
                        return Gamer.X;
                    }
                }
                else{
                    cntVX = 0;
                }
                if (table[i][j] == Gamer.O && table[i][j] == table[i-1][j]){
                    cntVO++;
                    if(cntVO == 3){
                        return Gamer.O;
                    }
                }
                else{
                    cntVO = 0;
                }
            }
        }
        //Diagonal
        /*100
          010
          001*/
        int cntDX = 0;
        int cntDO = 0;
        for (int i = sizeX-4; i > 0; i--){ 
            for (int j = sizeY-4; j >= 0; j--){
                if (table[i][j] == Gamer.X && table[i][j] == table[i+1][j+1] && table[i][j] == table[i+2][j+2] && table[i][j] == table[i+3][j+3]){
                    cntDX++;
                    System.out.println(cntDX);
                    if(cntDX == 1){
                        return Gamer.X;
                    }
                }
                else{
                    cntDX = 0;
                }
                if (table[i][j] == Gamer.O && table[i][j] == table[i+1][j+1] && table[i][j] == table[i+2][j+2] && table[i][j] == table[i+3][j+3]){
                    cntDO++;
                    if(cntDO == 1){
                        return Gamer.O;
                    }
                }
                else{
                    cntDO = 0;
                }
            }
        }
        /*001
          010
          100*/
        for (int i = sizeX-4; i > 0; i--){ 
            for (int j = sizeY-1; j >= 3; j--){
                if (table[i][j] == Gamer.X && table[i][j] == table[i+1][j-1] && table[i][j] == table[i+2][j-2] && table[i][j] == table[i+3][j-3]){
                    cntDX++;
                    System.out.println(cntDX);
                    if(cntDX == 1){
                        return Gamer.X;
                    }
                }
                else{
                    cntDX = 0;
                }
                if (table[i][j] == Gamer.O && table[i][j] == table[i+1][j-1] && table[i][j] == table[i+2][j-2] && table[i][j] == table[i+3][j-3]){
                    cntDO++;
                    if(cntDO == 1){
                        return Gamer.O;
                    }
                }
                else{
                    cntDO = 0;
                }
            }
        }
        return Gamer.NOBODY;        
    }

    public Gamer getActualGamer() {
        return actualGamer;
    }
    
    public int getRows() {
        return sizeX-1;
    }
}
