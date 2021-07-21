//NMEC: 92948
//NOME: Raquel Resende Milheiro Pinto

// Complete the functions (marked by ...)
// so that it passes all tests in DateTimeTest.

#include <assert.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "SchedulingSequence.h"

// You may add auxiliary definitions and declarations here, if you need to.
void swap(TimeInterval **x, TimeInterval **y){
   TimeInterval *aux;
   aux=*x;
   *x=*y;
   *y=aux;
}

void moveArray(TimeInterval **t, int final, int inicio ){
  for(int i = inicio;i<final-1;i++){
    swap(&(t[i]), &(t[i+1]));
  }
}


// Create a SchedulingSequence capable of storing up to (capacity) intervals.
SchedulingSequence* SchedulingSequenceCreate(int capacity) {
  assert(capacity >= 0);
  // You must allocate space for the struct and for the intervals array!
  SchedulingSequence* s = (SchedulingSequence*)malloc(sizeof(*s));
  if(s==NULL){
    return NULL;
  }
  s->capacity = capacity;
  s->size = 0;
  s->intervals =(TimeInterval**)malloc(capacity * sizeof(*s->intervals));
  return s;

}

// Destroy SchedulingSequence *pss
void SchedulingSequenceDestroy(SchedulingSequence **pss) {
  assert(*pss != NULL);
  free((*pss)->intervals);
  free(*pss);
  *pss = NULL;

}

int SchedulingSequenceIsEmpty(SchedulingSequence *ss) {
  return ss->size == 0;
}

int SchedulingSequenceIsFull(SchedulingSequence *ss) {
  return ss->size == ss->capacity;
}

// Add interval *ti to *ss.
// Return true on success,
// return false if *ti overlaps any of the intervals in *ss.
int SchedulingSequenceAdd(SchedulingSequence *ss, TimeInterval *ti) {
  assert(!SchedulingSequenceIsFull(ss));
  int i = 0;
   while( (i < ss->size) && TimeIntervalCompare(ss->intervals[i], ti) <= 0){
     if(TimeIntervalOverlaps(ss->intervals[i], ti) > 0) return 0;
     i++;
   }

   if(i == ss->size){
     ss->intervals[i] = ti;
   }
   else {
     for (int j = ss->size ; j > i; j--){
       ss->intervals[j] = ss->intervals[j-1];
     }
     ss->intervals[i] = ti;
   }
   ss->size++;
   return 1;
}

// Get the interval at position (idx) of *ss.
// idx=0 is the first position idx=ss->size-1 is the last position.
// Precondition: 0 <= idx < ss->size.
TimeInterval *SchedulingSequenceGet(SchedulingSequence *ss, int idx) {
  assert (0 <= idx && idx < ss->size);
  return *(ss->intervals+idx);

}

// Remove the interval at position (idx) of *ss, and return it.
// idx=0 is the first position idx=ss->size-1 is the last position.
// Precondition: 0 <= idx < ss->size.
TimeInterval *SchedulingSequencePop(SchedulingSequence *ss, int idx) {
  assert (0 <= idx && idx < ss->size);
  // This implies !SchedulingSequenceIsEmpty(ss).
  TimeInterval* result = ss->intervals[idx];
  moveArray(ss->intervals, ss->size, idx);
  ss->size--;
  return result;

}

// You may add auxiliary definitions and declarations here, if you need to.
