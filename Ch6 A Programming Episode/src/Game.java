public class Game {
    private int itsScore;
    private int [] itsThrowns;
    private int itsCurrentThrow;
    private int itsCurrentFrame;
    private boolean firstThrow;
    public Game(){
        this.itsScore=0;
        itsThrowns=new int[1000];
        itsCurrentThrow=0;
        itsCurrentFrame=1;
        firstThrow=true;
    }

    public int score(){
        return this.scoreForFrame(getCurrentFrame()-1);
    }
    public void add(int pins){
        itsThrowns[itsCurrentThrow++]=pins;
        this.itsScore+=pins;
        adjustCurrentFrame();
    }
    private void adjustCurrentFrame(){
        if(firstThrow==true)
            firstThrow=false;
        else {//second throw
            firstThrow=true;
            itsCurrentFrame++;
        }
    }

    public int scoreForFrame(int frame){
        int score=0, ball=0 , firstThrow , secondThrow , scoreFrame=0;
        for(int currentFrame=0; currentFrame<frame; currentFrame++) {
            firstThrow=itsThrowns[ball++];
            secondThrow=itsThrowns[ball++];
            scoreFrame = firstThrow+secondThrow;
            score+=scoreFrame;
            if(scoreFrame==10) score+=itsThrowns[ball];
        }
        return score;
    }
    public int getCurrentFrame(){
        return itsCurrentFrame;
    }
}
