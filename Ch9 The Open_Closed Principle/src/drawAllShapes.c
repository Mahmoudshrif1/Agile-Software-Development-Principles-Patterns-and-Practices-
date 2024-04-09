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
        case square:
            DrawSquare((struct Square *)s);
            break;
        case circle:
            DrawCircle((struct Circle *)s);
            break;
        }
    }
}