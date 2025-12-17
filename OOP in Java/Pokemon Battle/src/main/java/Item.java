public abstract class Item {
    private int turnoDeUso;
    public abstract void usarItem(Pokemon pokemon);

    public Item(int turnoDeUso) {
        this.turnoDeUso = turnoDeUso;
    }

    public int getTurnoDeUso() {
        return turnoDeUso;
    }

    public void setTurnoDeUso(int turnoDeUso) {
        this.turnoDeUso = turnoDeUso;
    }
}
