//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// GraphBellmanFord - Bellman-Ford Alg. for the Shortest Paths Tree
//

#include "GraphBellmanFord.h"

#include <assert.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersStack.h"

struct _GraphBellmanFord {
  int* distance;
  int* predecessor;
  Graph* graph;
  unsigned int startVertex;
};

GraphBellmanFord* GraphBellmanFordExecute(Graph* g, unsigned int startVertex) {
  assert(g != NULL);
  assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

  GraphBellmanFord* bellmanFord =
      (GraphBellmanFord*)malloc(sizeof(struct _GraphBellmanFord));
  assert(bellmanFord != NULL);

  unsigned int numVertices = GraphGetNumVertices(g);

  //
  // COMPLETAR !!
  //
  // CRIAR e INICIALIZAR os campos de bellmanFord
  bellmanFord->distance = (int*) malloc(numVertices*sizeof(int));
  assert(bellmanFord->distance!=NULL);

  bellmanFord->predecessor=(int*)malloc(numVertices * sizeof(int));
  assert(bellmanFord->predecessor!=NULL);
  for(int i=0;i<numVertices;i++){
    bellmanFord->distance[i]=INT_MAX/2;
    bellmanFord->predecessor[i]= -1;
  }
  bellmanFord->distance[startVertex]=0;

  bellmanFord->predecessor[startVertex] = 0;
  //
  bellmanFord->graph = g;
  bellmanFord->startVertex = startVertex;

  // EXECUTAR O ALGORITMO
  // COMPLETAR !!

  int flag;
  for(int i=1;i<numVertices-1;i++){
    for(int u = 0;u<numVertices;u++){
     flag=0;
      unsigned int* neighbors = GraphGetAdjacentsTo(bellmanFord->graph,u);
      int* dist =  GraphGetDistancesToAdjacents(bellmanFord->graph,u);
      for(int v=1;v<=neighbors[0];v++){
        int uDist=bellmanFord->distance[u];
        int vDist=  bellmanFord->distance[v];
        if(uDist + dist[v]< vDist){
          bellmanFord->distance[neighbors[v]]= uDist+dist[v];
          bellmanFord->predecessor[neighbors[v]]=u;
          flag=1;
        }
      }
      free(neighbors);
      free(dist);

    }
    if(!flag){
       break;
     }
  }
  return bellmanFord;
}





void GraphBellmanFordDestroy(GraphBellmanFord** p) {
  assert(*p != NULL);

  GraphBellmanFord* aux = *p;

  free(aux->distance);
  free(aux->predecessor);

  free(*p);
  *p = NULL;
}

// Getting the result

unsigned int GraphBellmanFordHasPathTo(const GraphBellmanFord* p,
                                       unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return (p->distance[v] != INT_MAX);
}

int GraphBellmanFordDistanceTo(const GraphBellmanFord* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return p->distance[v];
}

Stack* GraphBellmanFordPathTo(const GraphBellmanFord* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = StackCreate(GraphGetNumVertices(p->graph));

  if (p->distance[v] == INT_MAX) {
    return s;
  }

  // Store the path
  for (unsigned int current = v; current != p->startVertex;
       current = p->predecessor[current]) {
    StackPush(s, current);
  }

  StackPush(s, p->startVertex);

  return s;
}

// DISPLAYING on the console

void GraphBellmanFordShowPath(const GraphBellmanFord* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = GraphBellmanFordPathTo(p, v);

  while (StackIsEmpty(s) == 0) {
    printf("%d ", StackPop(s));
  }

  printf(" --- Distance = %d", p->distance[v]);

  StackDestroy(&s);
}

void GraphBellmanFordDisplay(const GraphBellmanFord* p) {
  // COMPLETAR !!
  printf("---\n");
  int num =GraphGetNumVertices(p->graph);
  for(int i = 0;i<num;i++){
    GraphBellmanFordShowPath(p,i);
    printf("\n");
  }
  printf("---\n");
  if(p->predecessor){
    for(int i = 0; i<num;i++){
      printf("Predecessor = %2d\n", p->predecessor[i]);
    }
  }
  if (p->graph) {
    GraphDisplay(p->graph);
  }
  printf("StartVertex = %2d\n",p->startVertex);
  printf("---\n");
}
