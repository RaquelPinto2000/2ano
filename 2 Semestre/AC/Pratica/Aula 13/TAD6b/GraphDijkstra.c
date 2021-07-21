//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// GraphDijkstra - Dijkstra Alg for the Shortest Paths Tree
//

#include "GraphDijkstra.h"

#include <assert.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersStack.h"
#include "PriorityQueue.h"

struct _GraphDijkstra {
  int* distance;
  int* predecessor;
  Graph* graph;
  unsigned int startVertex;
};

// FOR THE PRIORITY QUEUE /////////////////////////////////////////////

// The items in the priority queue will be ID:PRIORITY pairs (type ITEM)

typedef struct {
  int id;   // item id (assigned automatically = index in ITEM array)
  int pri;  // item priority (assigned by the user)
} ITEM;

// The priority comparator for items.
int comparator(const void* p1, const void* p2) {
  return ((ITEM*)p1)->pri - ((ITEM*)p2)->pri;
}

// The printer for items.
void printer(void* p) {
  ITEM* pitem = (ITEM*)p;
  printf("%d:%d", pitem->id, pitem->pri);
}

///////////////////////////////////////////////////////////////////////

GraphDijkstra* GraphDijkstraExecute(Graph* g, unsigned int startVertex) {
  assert(g != NULL);
  assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

  GraphDijkstra* result = (GraphDijkstra*)malloc(sizeof(struct _GraphDijkstra));
  assert(result != NULL);

  unsigned int numVertices = GraphGetNumVertices(g);

  //
  // COMPLETAR !!
  //
  // CRIAR e INICIALIZAR os campos de result

  result->distance = (int*) malloc (numVertices*sizeof(int));
  assert(result->distance!=NULL);
  result->predecessor = (int*) malloc(numVertices*sizeof(int));
  assert(result->predecessor!=NULL);

  for(int i = 1; i<numVertices;i++){
    result->distance[i]=INT_MAX/2;
    result->predecessor[i]=-1;
  }
  result->distance[startVertex]=0;
  result ->predecessor[startVertex]=0;
  result->graph = g;
  result->startVertex = startVertex;

  // COMPLETAR !!
  PriorityQueue* q = PriorityQueueCreate(numVertices,comparator,printer);
  ITEM items[numVertices];
  for(int i=0;i<numVertices;i++){
    items[i].id = i;
    items[i].pri = INT_MAX/2;
    PriorityQueueInsert(q,&(items[i]));
  }
  items[startVertex].pri=0;
  PriorityQueueDecreasePriority(q,&(items[startVertex]));

  while(!PriorityQueueIsEmpty(q)){
    unsigned int u = ((ITEM*) (PriorityQueueGetMin(q)))->id;
    PriorityQueueRemoveMin(q);
    int uDist = result->distance[u];
    unsigned int* neighbors = GraphGetAdjacentsTo(result->graph,u);
    int* dist =  GraphGetDistancesToAdjacents(result->graph,u);

    for(int i = 1;i<=neighbors[0];i++){
      int vDist= result->distance[neighbors[i]];

      if(uDist + dist[i]< vDist){
        result->distance[neighbors[i]]= uDist+dist[i];
        result->predecessor[neighbors[i]]=u;
        items[neighbors[i]].pri= result->distance[neighbors[i]];
        PriorityQueueDecreasePriority(q,&items[neighbors[i]]);
      }
    }
    free(neighbors);
    free(dist);
  }
    PriorityQueueDestroy(&q);
    return result;
}

void GraphDijkstraDestroy(GraphDijkstra** p) {
  assert(*p != NULL);

  GraphDijkstra* aux = *p;

  free(aux->distance);
  free(aux->predecessor);

  free(*p);
  *p = NULL;
}

// Getting the result

unsigned int GraphDijkstraHasPathTo(const GraphDijkstra* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return (p->distance[v] != INT_MAX);
}

int GraphDijkstraDistanceTo(const GraphDijkstra* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return p->distance[v];
}

Stack* GraphDijkstraPathTo(const GraphDijkstra* p, unsigned int v) {
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

void GraphDijkstraShowPath(const GraphDijkstra* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = GraphDijkstraPathTo(p, v);

  while (StackIsEmpty(s) == 0) {
    printf("%d ", StackPop(s));
  }

  printf(" --- Distance = %d", p->distance[v]);

  StackDestroy(&s);
}

void GraphDijkstraDisplay(const GraphDijkstra* p) {
  // COMPLETAR !!
  printf("---\n");
  int num =GraphGetNumVertices(p->graph);
  for(int i =0 ;i<num;i++){
    GraphDijkstraShowPath(p,i);
    printf("\n" );
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
