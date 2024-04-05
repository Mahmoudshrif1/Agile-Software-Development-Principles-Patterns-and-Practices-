public class Game {
    private int itsScore;
    private int [] itsThrowns;
    private int itsCurrentThrow;
    private int itsCurrentFrame;
    private boolean firstThrow;
    public Game(){
        this.itsScore=0;
        itsThrowns=new int[21];
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
        adjustCurrentFrame(pins);
    }
    private void adjustCurrentFrame(int pins){
        if(firstThrow==true) {
            if(pins==10) //strike so increase the fram and it's gonna be the first
                //throw so we don't change the firstThrow
                itsCurrentFrame++;
            else
                firstThrow = false;
        }
        else {//second throw
            firstThrow=true;
            itsCurrentFrame++;
        }
        itsCurrentFrame= Math.min(11 , itsCurrentFrame); //limit frame to 10
    }

    public int scoreForFrame(int frame){
        int score=0, ball=0 , firstThrow , secondThrow , scoreFrame=0;
        for(int currentFrame=0; currentFrame<frame; currentFrame++) {
            firstThrow=itsThrowns[ball++];
            if(firstThrow==10){
                score+=10 + itsThrowns[ball]+itsThrowns[ball+1];
            }else {
                secondThrow = itsThrowns[ball++];
                scoreFrame = firstThrow + secondThrow;
                score += scoreFrame;
                if (scoreFrame == 10) score += itsThrowns[ball];
            }
        }
        return score;
    }
    public int getCurrentFrame(){
        return itsCurrentFrame;
    }
}
