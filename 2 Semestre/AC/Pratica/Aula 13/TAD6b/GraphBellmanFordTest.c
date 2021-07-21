
// GraphBellmanFord EXAMPLE
//

#include "Graph.h"
#include "GraphBellmanFord.h"

int main(void) {
  Graph* g01 = GraphCreate(6, 0, 1);

  GraphAddWeightedEdge(g01, 0, 5, 3);
  GraphAddWeightedEdge(g01, 2, 4, 2);
  GraphAddWeightedEdge(g01, 2, 3, 7);
  GraphAddWeightedEdge(g01, 1, 2, 6);
  GraphAddWeightedEdge(g01, 0, 1, 5);
  GraphAddWeightedEdge(g01, 3, 4, 1);
  GraphAddWeightedEdge(g01, 3, 5, 9);
  GraphAddWeightedEdge(g01, 0, 2, 8);

  //GraphDisplay(g01);
  int vertex = 0;
  GraphBellmanFord* traversal = GraphBellmanFordExecute(g01, vertex);
  GraphBellmanFordDisplay(traversal);
  printf("Path from 0 to 5: ");
  GraphBellmanFordShowPath(traversal, 5);
  printf("\n");

  GraphBellmanFordDestroy(&traversal);

  GraphDestroy(&g01);

  return 0;
}
