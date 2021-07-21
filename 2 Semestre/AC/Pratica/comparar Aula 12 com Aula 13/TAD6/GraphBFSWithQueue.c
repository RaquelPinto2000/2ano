//
// Joaquim Madeira, AlgC, May 2020
// João Manuel Rodrigues, AlgC, May 2020
//
// GraphBFS - QUEUE-based Breadth-First Search
//

#include "GraphBFSWithQueue.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersQueue.h"
#include "IntegersStack.h"

struct _GraphBFSWithQueue {
  unsigned int* marked;
  int* distance;
  int* predecessor;
  Graph* graph;
  unsigned int startVertex;
};

static void _dfs(GraphBFSWithQueue* traversal,unsigned int vertex) { // ver isto depois
  Queue* s = QueueCreate(GraphGetNumVertices(traversal->graph));
  QueueEnqueue(s,vertex);
  traversal->marked[vertex] = 1;
  while(!QueueIsEmpty(s)){
    vertex = QueueDequeue(s);
    unsigned int* neighbors = GraphGetAdjacentsTo(traversal->graph, vertex);
    for (int i = 1; i <= neighbors[0]; i++) {
      if (traversal->marked[neighbors[i]] == 0) {
        QueueEnqueue(s,neighbors[i]);
        traversal->marked[neighbors[i]] = 1;
      }
    }
  }
}

GraphBFSWithQueue* GraphBFSWithQueueExecute(Graph* g,
                                            unsigned int startVertex) {
  assert(g != NULL);
  assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

  GraphBFSWithQueue* traversal =
      (GraphBFSWithQueue*)malloc(sizeof(struct _GraphBFSWithQueue));
  assert(traversal != NULL);

  unsigned int numVertices = GraphGetNumVertices(g);

  //
  // COMPLETAR !!
  //
  // CRIAR e INICIALIZAR os campos de traversal
  traversal->marked = (unsigned int*)calloc(numVertices, sizeof(unsigned int));
  assert(traversal->marked != NULL);

  traversal->distance = (int*)calloc(numVertices, sizeof(int));
  assert(traversal->marked != NULL);

  traversal->predecessor = (int*)malloc(numVertices * sizeof(int));
  assert(traversal->predecessor != NULL);
  for(int i = 0 ;i<numVertices; i++ ){
    traversal->predecessor[i]=-1;
  //  traversal->distance[i]= ;
  }
  traversal->predecessor[startVertex] = 0;
  //
  traversal->graph = g;
  traversal->startVertex = startVertex;

  // EFETUAR A TRAVESSIA

  // COMPLETAR !!
  _dfs(traversal,startVertex);
  return traversal;
}

void GraphBFSWithQueueDestroy(GraphBFSWithQueue** p) {
  assert(*p != NULL);

  GraphBFSWithQueue* aux = *p;

  free(aux->marked);
  free(aux->predecessor);

  free(*p);
  *p = NULL;
}

// Getting the result

unsigned int GraphBFSWithQueueHasPathTo(const GraphBFSWithQueue* p,
                                        unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return p->marked[v];
}

Stack* GraphBFSWithQueuePathTo(const GraphBFSWithQueue* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = StackCreate(GraphGetNumVertices(p->graph));

  if (p->marked[v] == 0) {
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

void GraphBFSWithQueueShowPath(const GraphBFSWithQueue* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = GraphBFSWithQueuePathTo(p, v);

  while (StackIsEmpty(s) == 0) {
    printf("%d ", StackPop(s));
  }

  StackDestroy(&s);
}

void GraphBFSWithQueueDisplay(const GraphBFSWithQueue* p) {
  // COMPLETAR !!
  printf("---\n");
  if (p->marked) {
    printf("Marked");
  }
  if(p->distance){
    printf("Distance = %2d", *p->distance);
  }
  if(p->predecessor){
    printf("Predecessor = %2d", *p->predecessor);
  }
  if (p->graph) {
    GraphDisplay(p->graph);
  }
  printf("StartVertex = %2d\n",p->startVertex);
  printf("---\n");

}
