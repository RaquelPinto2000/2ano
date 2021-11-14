//
// Joaquim Madeira, AlgC, April 2020
//
// Adapted from an old example (ca. 2003)
//
// Integers Binary Tree --- FIRST VERSION --- INCOMPLETE
//



#include <assert.h>
#include <stdlib.h>

#include "IntegersBinTree.h"

struct _TreeNode {
  ItemType item;
  struct _TreeNode* left;
  struct _TreeNode* right;
};

Tree* TreeCreate(void){ return NULL} ;

void TreeDestroy(Tree** pRoot) {
  // ...
  Tree* root = *pRoot;
  if(root==NULL){
    return;
  }
  TreeDestroy(&(root->left));
  TreeDestroy(&(root->right));
  free(root);
  *pRoot=NULL;
}

int TreeIsEmpty(const Tree* root) { return root == NULL; }

//Return 1 se forem iguais e 0 se forem diferentes
int TreeEquals(const Tree* root1, const Tree* root2) {
  // ...
  if(root1 == NULL && root2 == NULL){
    return 1;
  }
  if(root1==NULL || root2 == NULL){
    return 0;
  }
  if(root1->item != root2->item){
    return 0:
  }
  return TreeEquals(root1->left, root2->left) && TreeEquals(root1->right, root2->right);
}

// e se forem arvores espechadas????????????????????????? E assim ???
//Return 1 se forem iguais e 0 se forem diferentes
int TreeMirrors(const Tree* root1, const Tree* root2) {

  if(root1 == NULL && root2 == NULL){
    return 1;
  }
  if(root1==NULL || root2 == NULL){
    return 0;
  }
  if(root1->item != root2->item){
    if(root1->left == root2->right || root1->right == root2->left){
      return 1;
    }
    return 0;
  }
  return 0;
}

int TreeGetNumberOfNodes(const Tree* root) {
  // ...
  if(root == NULL){
    return 0;
  }
  return 1 + TreeGetNumberOfNodes(root->left)+TreeGetNumberOfNodes(root->right);
}

int TreeGetHeight(const Tree* root) {
  // ...
  if(root ==NULL){
    return -1;
  }
  int left = TreeGetHeight(root->left);
  int right = TreeGetHeight(root->right);
  if(left>right){
    return 1+left;
  }else{
    return 1 + right;
  }
}


ItemType TreeGetMin(const Tree* root){
  if(root==NULL){
    return NO_ITEM; // returna o item do no?
  }
  ItemType min = root->item;
  ItemType minLeftSubTree = TreeGetMin(root->left);
  if(minLeftSubTree != NO_ITEM && minLeftSubTree<min){ // <min -> podemos usar o min deiretamente aqui
    min=minLeftSubTree;
  }
  ItemType minRightSubTree = TreeGetMin(root->right);
  if(minRightSubTree != NO_ITEM && minRightSubTree <min){ // <min -> podemos usar o min deiretamente aqui
    min = minRightSubTree;
  }
  return min;
}

ItemType TreeGetMax(const Tree* root){
  if(root==NULL){
    return NO_ITEM; // returna o item do no?
  }
  ItemType max = root->item;
  ItemType maxLeftSubTree = TreeGetMin(root->left);
  if(maxLeftSubTree != NO_ITEM && maxLeftSubTree<min){
    max=maxLeftSubTree;
  }
  ItemType maxRightSubTree = TreeGetMin(root->right);
  if(maxRightSubTree != NO_ITEM && maxRightSubTree <max){
    max = maxRightSubTree;
  }
  return max;
}

// retorna o ponteiro para o node com o valor minimo
Tree* TreeGetPointerToMinNode(const Tree* root) {
  if(root==NULL){
    return NO_ITEM;
  }
  ItemType min = root->item;
  ItemType minLeftSubTree = TreeGetMin(root->left);
  if(minLeftSubTree != NO_ITEM && minLeftSubTree<min){
    min=minLeftSubTree;
  }
  ItemType minRightSubTree = TreeGetMin(root->right);
  if(minRightSubTree != NO_ITEM && minRightSubTree <min){
    min = minRightSubTree;
  }
  return &min;
}

// retorna o ponteiro para o node com o valor maximo
Tree* TreeGetPointerToMaxNode(const Tree* root){
  if(root==NULL){
    return NO_ITEM;
  }
  ItemType max = root->item;
  ItemType maxLeftSubTree = TreeGetMin(root->left);
  if(maxLeftSubTree != NO_ITEM && maxLeftSubTree<min){
    max=maxLeftSubTree;
  }
  ItemType maxRightSubTree = TreeGetMin(root->right);
  if(maxRightSubTree != NO_ITEM && maxRightSubTree <max){
    max = maxRightSubTree;
  }
  return &max;
}



void TreeTraverseInPREOrder(Tree* root, void (*function)(ItemType* p)) { // 0 & ou isto (*function)(ItemType* p) e comercial e permite obter o ponteiro
  // ...
  if(root==NULL){
    return;
  }
  function(root->item);
  TreeTraverseInPREOrder(root->left,function);
  TreeTraverseINPREOrder(root->right,function);
}

void TreeTraverseINOrder(Tree* root, void (*function)(ItemType* p)) {
  // ...
  if(root==NULL){
    return;
  }
  TreeTraverseINOrder(root->left,function);
  function(root->item);
  TreeTraverseINOrder(root->right,function);
}

void TreeTraverseInPOSTOrder(Tree* root, void (*function)(ItemType* p)) {
  // ...
  if(root==NULL){
    return;
  }
  TreeTraverseInPOSTOrder(root->left,function);
  TreeTraverseInPOSTOrder(root->right,function);
  function(root->item);

}

int TreeContains(const Tree* root, const ItemType item) {
  // ...
  if(root==NULL){
    return 0;
  }
  if(root->item ==item){
    return 1;
  }
  return TreeContains(root->left,item) || TreeContains(root->right,item);
}

// no exemplo seguinte do TAD nas pastas
int TreeAdd(Tree** pRoot, const ItemType item) {
  // ...

  return 0;
}
// no exemplo seguinte do TAD nas pastas
int TreeRemove(Tree** pRoot, const ItemType item) {
  // ...
  return 0;
}

// ...

// JUST FOR RUNNING EXAMPLES - REMOVE FROM THE INTERFACE

Tree* createExampleTree(void) {
  // SHOULD NEVER BE DONE LIKE THIS !!!???!!!
  // NUNCA DEVEMOS FAZER ASSIM -> esta a mostrar como nao fazer

  int numNodes = 8;

  Tree* nodes[numNodes];

  for (int i = 0; i < numNodes; i++) {
    nodes[i] = (Tree*)malloc(sizeof(Tree));
    nodes[i]->item = i + 1;
    nodes[i]->left = nodes[i]->right = NULL;
  }

  nodes[3]->left = nodes[7];

  nodes[1]->left = nodes[3];
  nodes[1]->right = nodes[4];

  nodes[2]->left = nodes[5];
  nodes[2]->right = nodes[6];

  nodes[0]->left = nodes[1];
  nodes[0]->right = nodes[2];

  return nodes[0];
}
