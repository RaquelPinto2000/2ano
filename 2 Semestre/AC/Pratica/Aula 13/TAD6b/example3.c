//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// Shortest Paths example
//

#include "Graph.h"
#include "GraphBellmanFord.h"
#include "GraphDijkstra.h"
#include "GraphShortestPathsWithQueue.h"

int main(int argc, char**argv) { // antes tinha void
Graph* g01;
  if(argc==1){ // faz isto
     g01= GraphCreate(6, 0, 1);
    GraphAddWeightedEdge(g01, 0, 5, 1);
    GraphAddWeightedEdge(g01, 2, 4, 2);
    GraphAddWeightedEdge(g01, 2, 3, 3);
    GraphAddWeightedEdge(g01, 1, 2, 4);
    GraphAddWeightedEdge(g01, 0, 1, 5);
    GraphAddWeightedEdge(g01, 3, 4, 6);
    GraphAddWeightedEdge(g01, 3, 5, 1);
    GraphAddWeightedEdge(g01, 0, 2, 8);

    GraphDisplay(g01);


  }else{
    FILE* f = fopen(argv[1],"r");

    g01 = GraphFromFile(f);
  }

  int vertex = 5;

  GraphBellmanFord* shortestPathsBF = GraphBellmanFordExecute(g01, vertex);

  for (int i = 0; i < GraphGetNumVertices(g01); i++) {
    printf("Path from %d to %d: ", vertex, i);
    GraphBellmanFordShowPath(shortestPathsBF, i);
    printf("\n");
  }

  GraphBellmanFordDestroy(&shortestPathsBF);

  printf("---\n");

  GraphShortestPathsWithQueue* shortestPathsWithQueue =
      GraphShortestPathsWithQueueExecute(g01, vertex);

  for (int i = 0; i < GraphGetNumVertices(g01); i++) {
    printf("Path from %d to %d: ", vertex, i);
    GraphShortestPathsWithQueueShowPath(shortestPathsWithQueue, i);
    printf("\n");
  }

  GraphShortestPathsWithQueueDestroy(&shortestPathsWithQueue);

  printf("---\n");


  GraphDijkstra* shortestPathsDijkstra = GraphDijkstraExecute(g01, vertex);

  for (int i = 0; i < GraphGetNumVertices(g01); i++) {
    printf("Path from %d to %d: ", vertex, i);
    GraphDijkstraShowPath(shortestPathsDijkstra, i);
    printf("\n");
  }

  GraphDijkstraDestroy(&shortestPathsDijkstra);

  GraphDestroy(&g01);


  return 0;
}
