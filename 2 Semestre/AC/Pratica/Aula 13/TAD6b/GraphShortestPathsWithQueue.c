//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// GraphShortestPathsWithQueue - QUEUE algorithm for the Shortest Paths Tree
//

#include "GraphShortestPathsWithQueue.h"

#include <assert.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersStack.h"
#include "IntegersQueue.h"

struct _GraphShortestPathsWithQueue {
  int* distance;
  int* predecessor;
  Graph* graph;
  unsigned int startVertex;
};

GraphShortestPathsWithQueue* GraphShortestPathsWithQueueExecute(
    Graph* g, unsigned int startVertex) {
  assert(g != NULL);
  assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

  GraphShortestPathsWithQueue* ShortestPathsWithQueue =
      (GraphShortestPathsWithQueue*)malloc(
          sizeof(struct _GraphShortestPathsWithQueue));
  assert(ShortestPathsWithQueue != NULL);

  unsigned int numVertices = GraphGetNumVertices(g);

  //
  // COMPLETAR !!
  //
  // CRIAR e INICIALIZAR os campos de ShortestPathsWithQueue
  ShortestPathsWithQueue->distance = (int*)malloc(numVertices* sizeof(int));
  assert(ShortestPathsWithQueue->distance!=NULL);

  ShortestPathsWithQueue->predecessor = (int*)malloc (numVertices * sizeof(int));
  assert(ShortestPathsWithQueue->predecessor!=NULL);

  // iniciaizar os rotulos
  for(int i=0;i<numVertices;i++){
    ShortestPathsWithQueue->distance[i]=INT_MAX/2;
    ShortestPathsWithQueue->predecessor[i]=-1;
  }
  ShortestPathsWithQueue->distance[startVertex]=0;

  ShortestPathsWithQueue->predecessor[startVertex]=0;

  ShortestPathsWithQueue->graph = g;
  ShortestPathsWithQueue->startVertex = startVertex;


  int contains[numVertices];
  for(int i = 0;i<numVertices;i++){
    contains[i]=0;
  }
  // EXECUTAR O ALGORITMO
  // COMPLETAR !!

  Queue* q = QueueCreate(numVertices);
  QueueEnqueue(q,startVertex);
  contains[startVertex]=1;

  while(!QueueIsEmpty(q)){
    unsigned int u = QueueDequeue(q);
    contains[u]=0;
    int uDist = ShortestPathsWithQueue->distance[u];
    unsigned int* neighbors = GraphGetAdjacentsTo(ShortestPathsWithQueue->graph,u);
    int* dist =  GraphGetDistancesToAdjacents(ShortestPathsWithQueue->graph,u);

    for(int i = 1;i<=neighbors[0];i++){
      int vDist= ShortestPathsWithQueue->distance[neighbors[i]];
      if(uDist + dist[i]< vDist){
        ShortestPathsWithQueue->distance[neighbors[i]]= uDist+dist[i];
        ShortestPathsWithQueue->predecessor[neighbors[i]]=u;
        if(!contains[neighbors[i]]){
          QueueEnqueue(q,neighbors[i]);
        }
      }
    }
    free(neighbors);
    free(dist);
  }
  QueueDestroy(&q);
  return ShortestPathsWithQueue;
}

void GraphShortestPathsWithQueueDestroy(GraphShortestPathsWithQueue** p) {
  assert(*p != NULL);

  GraphShortestPathsWithQueue* aux = *p;

  free(aux->distance);
  free(aux->predecessor);

  free(*p);
  *p = NULL;
}

// Getting the result

unsigned int GraphShortestPathsWithQueueHasPathTo(
    const GraphShortestPathsWithQueue* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return (p->distance[v] != INT_MAX);
}

int GraphShortestPathsWithQueueDistanceTo(const GraphShortestPathsWithQueue* p,
                                          unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return p->distance[v];
}

Stack* GraphShortestPathsWithQueuePathTo(const GraphShortestPathsWithQueue* p,
                                         unsigned int v) {
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

void GraphShortestPathsWithQueueShowPath(const GraphShortestPathsWithQueue* p,
                                         unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = GraphShortestPathsWithQueuePathTo(p, v);

  while (StackIsEmpty(s) == 0) {
    printf("%d ", StackPop(s));
  }

  printf(" --- Distance = %d", p->distance[v]);

  StackDestroy(&s);
}

void GraphShortestPathsWithQueueDisplay(const GraphShortestPathsWithQueue* p) {
  // COMPLETAR !!
  printf("---\n");
  int num =GraphGetNumVertices(p->graph);
  for(int i = 0;i<num;i++){
    GraphShortestPathsWithQueueShowPath(p,i);
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
