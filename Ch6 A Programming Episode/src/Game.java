public class Game {
    private int itsScore;
    private int [] itsThrowns;
    private int itsCurrentThrow;
    private int itsCurrentFrame;
    private boolean firstThrowInFrame;

    private int ball;
    private int firstThrow;
    private int secondThrow;
    public Game(){
        this.itsScore=0;
        itsThrowns=new int[21];
        itsCurrentThrow=0;
        itsCurrentFrame=1;
        firstThrowInFrame=true;
        ball=0;
        firstThrow=0;
        secondThrow=0;
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
        if(firstThrowInFrame==true) {
            if(pins==10) //strike so increase the fram and it's gonna be the first
                //throw so we don't change the firstThrowInFrame
                itsCurrentFrame++;
            else
                firstThrowInFrame = false;
        }
        else {//second throw
            firstThrowInFrame=true;
            itsCurrentFrame++;
        }
        itsCurrentFrame= Math.min(11 , itsCurrentFrame); //limit frame to 10
    }

    public int scoreForFrame(int frame){
        int score=0,  scoreFrame=0;
        for(int currentFrame=0; currentFrame<frame; currentFrame++) {
            firstThrow=itsThrowns[ball];
            if(firstThrow==10){
                ball++;
                score+=10 + itsThrowns[ball]+itsThrowns[ball+1];
            }else {
                score+=handleSecondThrow();
            }
        }
        return score;
    }
    private int handleSecondThrow(){
        int score= 0 ;
        secondThrow = itsThrowns[ball+1];
        int scoreFrame = firstThrow + secondThrow;

        if (scoreFrame == 10) {
            ball+=2;
            score += scoreFrame+ itsThrowns[ball];
        }else{
            ball+=2;
            score= scoreFrame;
        }
        return score;
    }
    public int getCurrentFrame(){
        return itsCurrentFrame;
    }
}
