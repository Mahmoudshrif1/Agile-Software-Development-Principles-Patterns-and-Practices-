public class Frame {
    private int itsScore;
    public Frame(){
        this.itsScore=0;
    }

    public int score(){
        return this.itsScore;
    }
    public void add(int pins){
        this.itsScore+=pins;
    }
}
