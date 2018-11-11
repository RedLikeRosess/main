package secondassignment;

public class Process {
    
    private int sizeX;
    private int sizeY;
    
    private Gamer actualPlayer;

    private Gamer[][] table;

    public Process(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        actualPlayer = Gamer.X;

        table = new Gamer[sizeX][sizeY];
        for (int i = 0; i < sizeX; ++i) {
            for (int j = 0; j < sizeY; ++j) {
                table[i][j] = Gamer.NOBODY;
            }
        }
    }

    public Gamer step(int row, int column) {
        if (table[row][column] != Gamer.NOBODY) {
            return table[row][column];
        }

        table[row][column] = actualPlayer;

        if (actualPlayer == Gamer.X) {
            actualPlayer = Gamer.O;
        } else {
            actualPlayer = Gamer.X;
        }

        return table[row][column];
    }

    public Gamer findWinner() {
        for (int i = 0; i < sizeX; ++i) {
            if (table[0][i] != Gamer.NOBODY) {
                boolean ok = true;
                for (int j = 1; ok && j < sizeY; ++j) {
                    ok = ok && table[j][i] == table[0][i];
                }
                if (ok) {
                    return table[0][i];
                }
            }
        }
        for (int i = 0; i < sizeX; ++i) {
            if (table[i][0] != Gamer.NOBODY) {
                boolean ok = true;
                for (int j = 1; ok && j < sizeY; ++j) {
                    ok = ok && table[i][j] == table[i][0];
                }
                if (ok) {
                    return table[i][0];
                }
            }
        }
        if (table[0][0] != Gamer.NOBODY) {
            boolean ok = true;
            for (int j = 1; ok && j < sizeY; ++j) {
                ok = ok && table[j][j] == table[0][0];
            }
            if (ok) {
                return table[0][0];
            }
        }
        if (table[0][sizeY - 1] != Gamer.NOBODY) {
            boolean ok = true;
            for (int j = 1; ok && j < sizeY; ++j) {
                ok = ok && table[j][sizeY - 1 - j] == table[0][sizeY - 1];
            }
            if (ok) {
                return table[0][sizeY - 1];
            }
        }

        return Gamer.NOBODY;
    }

    public Gamer getActualPlayer() {
        return actualPlayer;
    }
}
