#include <iostream>
#include <vector>
#include "Shape.cpp"


int main(){

}
void DrawAllShapes(vector<Shape*>& list)
{
 vector<Shape*>::iterator i;
 for (i=list.begin(); i != list.end(); i++)
    (*i)->Draw();
}