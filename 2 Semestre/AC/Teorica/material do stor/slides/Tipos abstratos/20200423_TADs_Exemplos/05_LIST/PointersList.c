//
// Joaluim Madeira, AlgC, April 2020
//
// Adapted from Tomás Oliveira e Silva, AED, September 2015
//
// Pointers LIST implementation based on an linked list
//

// ***************** COMPLETAR AS FUNCOES !!! *******************

#include "PointersList.h"

#include <assert.h>
#include <stdlib.h>

struct _PointersListNode {
  void* data;
  struct _PointersListNode* next;
};

struct _PointersList {
  int size;                           // current List size
  struct _PointersListNode* head;     // the head of the List
  struct _PointersListNode* tail;     // the tail of the List
  struct _PointersListNode* current;  // the current node
  int currentPos;
};

List* ListCreate(void) {
  List* l = (List*)malloc(sizeof(List));
  assert(l != NULL);

  l->size = 0;
  l->head = NULL;
  l->tail = NULL;
  l->current = NULL;
  l->currentPos = -1;  // Default: before the head of the list
  return l;
}

void ListDestroy(List** p) {
  assert(*p != NULL);
  List* l = *p;

  ListClear(l);

  free(l);
  *p = NULL;
}

void ListClear(List* l) {
  assert(l != NULL);

  struct _PointersListNode* p = l->head;
  struct _PointersListNode* aux;

  while (p != NULL) {
    aux = p;
    p = aux->next;
    free(aux);
  }

  l->size = 0;
  l->head = NULL;
  l->tail = NULL;
  l->current = NULL;
  l->currentPos = -1;  // Default: before the head of the list
}

int ListGetSize(const List* l) {
  assert(l != NULL);
  return l->size;
}

int ListIsEmpty(const List* l) {
  assert(l != NULL);
  return (l->size == 0) ? 1 : 0;
}

// Current node functions

int ListGetCurrentIndex(const List* l) {
  assert(l != NULL);
  return l->currentPos;
}

void* ListGetCurrentValue(const List* l) {
  assert(l != NULL && l->current != NULL);
  return l->current->data;
}





// fazer
void ListModifyCurrentValue(const List* l, void* p) {
  int index = ListGetCurrentIndex(l);
  if(index!=NULL){
    l->current = p;
    return 0;
  }else{
    return -1;
  }
}

// The move and search functions return 0 on success and -1 on failure (on
// success the current node is changed, on failure it is not changed)

// Search
// fazer
int ListSearchFromCurrent(const List* l, void* p) {
  struct _ListNode* aux = l->head;
  int pos = 0;
  int CompResult = 0;
  while(aux!=NULL){
    CompResult = l->compare(p,aux->item);
    if(CompResult <= 0){
      break;
    }
    aux = aux->next;
    pos++;
  }

  if(CompResult ==0){
     ListMove(l,pos);
     return 0;
  }else{
    return -1;
  }
  free(aux);
}

// Move to functions

int ListMove(List* l, int newPos) {
  assert (-1 <= newPos && newPos <= l->size) ;
  if (newPos == l->size)
    newPos = -1;  // fix newPos

  if (newPos == -1) {  // move outside
    l->current = NULL;
  } else if (newPos == 0) { // move to head
    l->current = l->head;
  } else if (newPos == l->size - 1) { // move to tail
    l->current = l->tail;
  } else {  // move to an inner node
    // Start at head (or current position) and move forward until newPos.
    //...
    l->current = l->head;
    for(int i = 0 ;i<newPos;i++){
      l->current = l->current->next;
    }
  }
  l->currentPos = newPos;
}

int ListMoveToNext(List* l) {
  ListMove(l, l->currentPos < l->size-1 ? l->currentPos + 1 : -1);
}

int ListMoveToPrevious(List* l) {
  ListMove(l, l->currentPos >= 0 ? l->currentPos - 1 : l->size-1);
}

int ListMoveToHead(List* l) {
  return ListMove(l, 0);
}

int ListMoveToTail(List* l) {
  return ListMove(l, l->size - 1);
}

// Insert functions

void ListInsertBeforeHead(List* l, void* p) {}

void ListInsertAfterTail(List* l, void* p) {}

void ListInsertAfterCurrent(List* l, void* p) {}

void ListInsertBeforeCurrent(List* l, void* p) {}

// Remove functions

void ListRemoveHead(List* l) {
  assert(l != NULL && l->size > 0);

  struct _PointersListNode* aux = l->head;

  if (l->current == l->head) {
    l->current = l->head->next;
    if (l->current == NULL) {
      l->currentPos = -1;
    } else {
      l->currentPos++;
    }
  }

  l->size--;

  if (l->size == 0) {
    l->head = NULL;
    l->tail = NULL;
  } else {
    struct _PointersListNode* next = l->head->next;
    l->head = next;
  }

  free(aux);
}

void ListRemoveTail(List* l) {}

void ListRemoveCurrent(List* l) {
  assert (ListCurrentIsInside(l));
  void* item = l->current->item;
  if (l->currentPos == 0)
    item = ListRemoveHead(l);
  else if (l->currentPos == l->size - 1)
    item = ListRemoveTail(l);
  else {
    // find node before current, change its next field,
    // free current, change current, change size
    //...
    struct _ListNode* aux =l->head;
    for(int i = 0;i<l->size-1;i++){
      if(l->compare(aux->next->item,item) ==0){ // se aux->next->item = item (se encontrarmos o item a remover)
        aux->next = l->current->next;
        free(l->current);
        l->current=aux->next;
        l->size--;
        break;
      }else{
        aux = aux->next;
      }
    }
  }
  return item;
}

void ListRemoveNext(List* l) {}

// Tests

void ListTestInvariants(const List* l) {
  assert(l->size >= 0);
  // check equivalence: size==0 <=> head==NULL <=> tail==NULL
  assert ( (l->size == 0) == (l->head == NULL) );
  assert ( (l->size == 0) == (l->tail == NULL) );
  // check equivalence size<=1 <=> head==tail
  assert ( (l->size <= 1) == (l->head == l->tail) );
  // check currentPos is valid
  assert( -1 <= l->currentPos && l->currentPos < l->size );
  // check that position outside <=> current==NULL
  assert( (l->currentPos == -1) == (l->current == NULL) );
  struct _ListNode* sn = l->head;
  for (int i = 0; i < l->size; i++) {
    if (i < l->size-1)
      assert(sn->next != NULL);
    else
      assert(sn == l->tail && sn->next == NULL);
    if (i == l->currentPos)
      assert(sn == l->current);
    sn = sn->next;
  }
}
