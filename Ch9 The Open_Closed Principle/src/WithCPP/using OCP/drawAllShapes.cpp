#include <iostream>
#include <vector>
using namespace std; 
class Shape{
    public: 
        Shape(){}
        virtual void draw() const=0; 
};
class Square : public Shape{
    public: 
        Square(){}  
        virtual void draw() const{
            cout<<"sQuare"<<endl; 
        }
        
};
class Circle : public Shape{
    public: 
        Circle(){} 
        virtual void draw() const{
            cout<<"cIrcle"<<endl; 
        } 
};

void DrawAllShapes(vector<Shape*>& list){
 vector<Shape*>::iterator i;
 for (i=list.begin(); i != list.end(); i++)
    (*i)->draw();
}

int main(void ){
    vector<Shape*> shapes; //pointers to Shape classes
    Shape *s1 =new Circle(); 
    s1->draw();
    // Shape s11= new Circle();  //Error you can't create a Abstract object but you can create them using pointers.
    //https://www.geeksforgeeks.org/pure-virtual-functions-and-abstract-classes/
    Shape *s2 = new Square; 
    Shape *s3 = new Square; 
    Shape *s4 = new Circle; 
    shapes.push_back(s1);
    shapes.push_back(s2);
    shapes.push_back(s3);
    shapes.push_back(s4); 
    DrawAllShapes(shapes);

}