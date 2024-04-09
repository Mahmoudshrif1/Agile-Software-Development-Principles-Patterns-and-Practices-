package WithJava;

import java.util.ArrayList;

public class drawAllShapes {
    static public void main(String []args){
        Shape s1= new Circle();
        s1.draw();
        Shape s2 = new Square();
        Shape s3 = new Square();
        Shape s4 = new Circle();
        ArrayList<Shape> shapes= new ArrayList<>();
        shapes.add(s1 );
        shapes.add(s2 );
        shapes.add(s3 );
        shapes.add(s4 );
        drawAllShapes(shapes);
    }
    public static void drawAllShapes(ArrayList<Shape> shapes){
        for(int i=0; i<shapes.size(); i++){
            shapes.get(i).draw();
        }
    }
}
