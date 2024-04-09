#include "Shape.h"

typedef struct Shape *ShapePointer;

int main()
{
}

void DrawAllShapes(ShapePointer list[], int n)
{
    for (int i = 0; i < n; i++)
    {
        struct Shape *s = list[i];
        switch (s->itsType)
        {
        case Square:
            DrawSquare((struct Square *)s);
            break;
        case Circle:
            DrawCircle((struct Circle *)s);
            break;
        }
    }
}