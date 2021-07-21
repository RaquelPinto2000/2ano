//NMEC: 92948
//NOME: Raquel Resende Milheiro Pinto
//
// João Manuel Rodrigues, AlgC, May 2020
//
// A SchedulingSequence based on a SORTED LIST.

//// PROCURE ... E COMPLETE ////

#include <assert.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "SchedulingSequence.h"

// You may add auxiliary definitions and declarations here, if you need to.



// Comparison function to be used in generic SortedList.
static int cmpTI(const void* a, const void* b) {
  return TimeIntervalCompare((TimeInterval*)a, (TimeInterval*)b);
}

// Create a SchedulingSequence capable of storing intervals.
// (Argument capacity is ignored!)
SchedulingSequence* SchedulingSequenceCreate(int capacity) {
  assert(capacity >= 0);
  // You must allocate space for the struct and create an empty intervals list!
  //...
  SchedulingSequence* s = (SchedulingSequence*) malloc(sizeof(*s));
  if(s==NULL){
    return NULL;
  }
  s->size = 0;
  s->intervals = ListCreate(cmpTI);
  return s;

}

// Destroy SchedulingSequence *pss
void SchedulingSequenceDestroy(SchedulingSequence **pss) {
  assert(*pss != NULL);
  ListDestroy(&(*pss)->intervals);
  free(*pss);
  *pss=NULL;

}

int SchedulingSequenceIsEmpty(SchedulingSequence *ss) {
  return ss->size == 0;
}

int SchedulingSequenceIsFull(SchedulingSequence *ss) {
  return 0;  // NEVER Full!
}

// Add interval *ti to *ss.
// Return true on success,
// return false if *ti overlaps any of the intervals in *ss.
int SchedulingSequenceAdd(SchedulingSequence *ss, TimeInterval *ti) {
  assert(!SchedulingSequenceIsFull(ss));
  if(ListInsert(ss->intervals,ti)==0){
    ss->size++;
    return 1;
  }else{
    return 0;
  }
}

// Get the interval at position (idx) of *ss.
// idx=0 is the first position idx=ss->size-1 is the last position.
// Precondition: 0 <= idx < ss->size.
TimeInterval *SchedulingSequenceGet(SchedulingSequence *ss, int idx) {
  assert (0 <= idx && idx < ss->size);
  TimeInterval* t;
  ListMove(ss->intervals, idx);
  t = (TimeInterval*)ListGetCurrentItem(ss->intervals);
  return t;

}

// Remove the interval at position (idx) of *ss, and return it.
// idx=0 is the first position idx=ss->size-1 is the last position.
// Precondition: 0 <= idx < ss->size.
TimeInterval *SchedulingSequencePop(SchedulingSequence *ss, int idx) {
  assert (0 <= idx && idx < ss->size);
  // This implies !SchedulingSequenceIsEmpty(ss).
  assert(!SchedulingSequenceIsEmpty(ss));
  ListMove(ss->intervals, idx);
  TimeInterval* t = (TimeInterval*)ListGetCurrentItem(ss->intervals);
  ListRemoveCurrent(ss->intervals);
  ss->size--;
  return t;



}

// You may add auxiliary definitions and declarations here, if you need to.
