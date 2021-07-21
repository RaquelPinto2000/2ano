//
// Joaquim Madeira, AlgC, April 2020
//
// Adapted from an old example (ca. 2003)
//
// Integers Binary Search Tree --- INCOMPLETE
//

#include "BinarySearchTree.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "PointersQueue.h"
#include "PointersStack.h"

struct _BSTreeNode {
  ItemType item;
  struct _BSTreeNode* left;
  struct _BSTreeNode* right;
};

BSTree* BSTreeCreate(void) { return NULL; }

void BSTreeDestroy(BSTree** pRoot) {
  // ...
  BSTree* root = *pRoot;
  if(root==NULL){
    return;
  }
  BSTreeDestroy(&(root->left));
  BSTreeDestroy(&(root->right));
  free(root);
  *pRoot=NULL;
}

int BSTreeIsEmpty(const BSTree* root) { return root == NULL; }

//
// NEW - Adapted from
// https://www.geeksforgeeks.org/check-if-a-binary-tree-is-bst-simple-and-efficient-approach/
//
int _isBST(const BSTree* root, ItemType* prevItem) {
  if (root == NULL) {
    return 1;
  }
  // IN_ORDER TRAVERSAL
  if (_isBST(root->left, prevItem) == 0) {
    return 0;
  }
  // Allow only distinct valued nodes
  if (root->item <= *prevItem) {
    return 0;
  }
  // Update prevValue to current
  *prevItem = root->item;

  return _isBST(root->right, prevItem);
}
//
// NEW
//
int BSTreeIsBST(const BSTree* root) {
  int prevItem = MIN_POSSIBLE;

  return _isBST(root, &prevItem);
}

int BSTreeEquals(const BSTree* root1, const BSTree* root2) {
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
  return BSTreeEquals(root1->left, root2->left) && BSTreeEquals(root1->right, root2->right);

}

// nao sei se e assim
int BSTreeMirrors(const BSTree* root1, const BSTree* root2) {
  // ...
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

int BSTreeGetNumberOfNodes(const BSTree* root) {
  // ...
  if(root == NULL){
    return 0;
  }
  return 1 + BSTreeGetNumberOfNodes(root->left)+BSTreeGetNumberOfNodes(root->right);

}

int BSTreeGetHeight(const BSTree* root) {
  // ...
  if(root ==NULL){
    return -1;
  }
  int left = BSTreeGetHeight(root->left);
  int right = BSTreeGetHeight(root->right);
  if(left>right){
    return 1+left;
  }else{
    return 1 + right;
  }
  return 0;
}

int BSTreeGetMin(const BSTree* root) {
  // ...
  if(root==NULL){
    return NO_ITEM;
  }
  if(root->left == NULL){
    return root->item;
  }
  return BSTreeGetMin(root->left);
  //TPC - fazer funcao ITERATIVA
  /*
    if(root==NULL){
      return NO;NO_ITEM;
    }
    while(root->left != NULL){
      root=root->left;
    }

    return root->item;
  */
}

int BSTreeGetMax(const BSTree* root) {
  // ...
  if(root==NULL){
    return NO;NO_ITEM;
  }
  while(root->right != NULL){
    root=root->right;
  }

  return root->item;

  //TPC -> fazer funcao recursiva
  /* if(root==NULL){
    return NO_ITEM;
  }
  if(root->right == NULL){
    return root->item;
  }
  return BSTreeGetMin(root->right);
  */

}

void BSTreeTraverseInPREOrder(BSTree* root, void (*function)(ItemType* p)) {
  // ...
  if(root==NULL){
    return;
  }
  function(root->item);
  BSTreeTraverseInPREOrder(root->left,function);
  BSTreeTraverseINPREOrder(root->right,function);
}

void BSTreeTraverseINOrder(BSTree* root, void (*function)(ItemType* p)) {
  // ...
  if(root==NULL){
    return;
  }
  BSTreeTraverseINOrder(root->left,function);
  function(root->item);
  BSTreeTraverseINOrder(root->right,function);
}

void BSTreeTraverseInPOSTOrder(BSTree* root, void (*function)(ItemType* p)) {
  // ...
  if(root==NULL){
    return;
  }
  BSTreeTraverseInPOSTOrder(root->left,function);
  BSTreeTraverseInPOSTOrder(root->right,function);
  function(root->item);
}

void BSTreeTraverseLevelByLevelWithQUEUE(BSTree* root,
                                         void (*function)(ItemType* p)) {
  if (root == NULL) {
    return;
  }

  // Not checking for queue errors !!
  // Create the QUEUE for storing POINTERS

  Queue* queue = QueueCreate();

  QueueEnqueue(queue, root);

  while (QueueIsEmpty(queue) == 0) {
    BSTree* p = QueueDequeue(queue);

    function(&(p->item));

    if (p->left != NULL) {
      QueueEnqueue(queue, p->left);
    }
    if (p->right != NULL) {
      QueueEnqueue(queue, p->right);
    }
  }

  QueueDestroy(&queue);
}

void BSTreeTraverseInPREOrderWithSTACK(BSTree* root,void (*function)(ItemType* p)){
  if (root == NULL) {
    return;
  }
  while(StackIsEmpty(stack)==0){
    Tree* p = StackPop(stack);
    function(&(p->item));
    // Pay attencion to the push order
    if(p->right!=NULL){
      StackPush(stack,p->right);
    }
    if(p->left!=NULL){
      StackPush(stack, p->left);
    }
  }
}

void BSTreeTraverseINOrderWithSTACK(BSTree* root, void (*function)(ItemType* p)) {
  if (root == NULL) {
    return;
  }
  while(StackIsEmpty(stack)==0){
    Tree* p = StackPop(stack);

    // Pay attencion to the push order
    if(p->right!=NULL){
      StackPush(stack,p->right);
    }

    function(&(p->item));

    if(p->left!=NULL){
      StackPush(stack, p->left);
    }
  }
}

// ...

int BSTreeContains(const BSTree* root, const ItemType item) {
  // ...
  while(root!=NULL){
    if(root->item == item){
      return 1;
    }
    if(root->item >item ){
      root->root->left;
    }else{
      root = root->right;
    }
  }
  return 0;

  //TPC - fazer uma funcao RECURSIVA
/*  if(root==NULL){
    return 0;
  }
  if(root->item == item){
    return 1;
  }
  if(root->item >item ){
     BSTreeContains(root->left,item);
  }else{
     BSTreeContains(root->right,item);
  }
  return 0;
  */
}

//
// NEW
//
int BSTreeAdd(BSTree** pRoot, const ItemType item) {
  BSTree* root = *pRoot;

  struct _BSTreeNode* new = (struct _BSTreeNode*)malloc(sizeof(*new));
  assert(new != NULL);

  new->item = item;
  new->left = new->right = NULL;

  if (root == NULL) {
    *pRoot = new;
    return 1;
  }

  // procura a posicao
  struct _BSTreeNode* prev = NULL;
  struct _BSTreeNode* current = root;

  while (current != NULL) {
    if (current->item == item) {
      free(new);
      return 0;
    }  // Not allowed

    prev = current;
    if (current->item > item) {
      current = current->left;
    } else {
      current = current->right;
    }
  }

  // acorar um no
  if (prev->item > item) {
    prev->left = new;
  } else {
    prev->right = new;
  }
  return 0;

  //TPC - fazer de maneira recursiva (nao creio que e assim)
  /*
  BSTree* root = *pRoot;

  struct _BSTreeNode* new = (struct _BSTreeNode*)malloc(sizeof(*new));
  assert(new != NULL);

  new->item = item;
  new->left = new->right = NULL;

  if (root == NULL) {
    *pRoot = new;
    return 1;
  }

  // procura a posicao
  struct _BSTreeNode* prev = NULL;
  struct _BSTreeNode* current = root;
  if(current==NULL){
    return 0;
  }
  if (current->item == item) {
    free(new);
    return 0;
  }  // Not allowed

  prev = current;
  if (current->item > item) {
    current = current->left;
  } else {
    current = current->right;
  }
  BSTreeAdd(*root,item);

  // acorar um no
  if (prev->item > item) {
    prev->left = new;
  } else {
    prev->right = new;
  }
  return 0;
  */
}

//
// NEW
//
void _deleteNextNode(BSTree** pRoot, ItemType* pItem) {// substituir pelo sucessor e apaga-lo
  if ((*pRoot)->left == NULL) {
    // FOUND IT
    BSTree* auxPointer = *pRoot;

    *pItem = auxPointer->item;

    *pRoot = auxPointer->right;

    free(auxPointer);
  } else {
    _deleteNextNode(&((*pRoot)->left), pItem);
  }
}

//
// NEW
//
// Esta função interna remove o nó apontado por * pPointer.
// Observe que pPointer é o endereço de uma variável que aponta para o nó
// para ser removido. Quando remove o nó, também define essa variável como NULL.
// Essa variável é o campo raiz da estrutura _BSTreeHeader
// ou o campo esquerdo ou direito da estrutura _BSTreeNode pai.
// (Apontar para campos dentro de uma estrutura é algo que você não pode fazer em Java.)
void _removeNode(BSTree** pPointer) { // menor item
  BSTree* nodePointer = *pPointer;

  if ((nodePointer->left == NULL) && (nodePointer->right == NULL)) { // se nao tiver nos a esq nem dir e uma folha
    /* A LEAF node  -> se for uma folha*/

    free(nodePointer);

    *pPointer = NULL;

    return;
  }

  if (nodePointer->left == NULL) { // se so tiver a subarvore direita-> so 1 filho
    /* It has only a RIGHT sub-tree */

    *pPointer = nodePointer->right;

    free(nodePointer);

    return;
  }

  if (nodePointer->right == NULL) {// se so tiver a subarvore esquerda -> so um filho
    /* It has only a LEFT sub-tree */

    *pPointer = nodePointer->left;

    free(nodePointer);

    return;
  }

  /* Node has TWO CHILDREN */
  /* Replace its item with the item of the next node in-order */
  /* And remove that node */

  _deleteNextNode(&(nodePointer->right), &(nodePointer->item)); // substituir pelo sucessor e apaga-lo


  // TPC - fazer isto mas recursivo
  /*
  BSTree* nodePointer = *pPointer;
  if ((nodePointer->left == NULL) && (nodePointer->right == NULL)) {
    // A LEAF node
    free(nodePointer);
    *pPointer = NULL;
    return;
  }

  if (nodePointer->left == NULL) {
    // It has only a RIGHT sub-tree
    _removeNode(*nodePointer->right);

  }
  if (nodePointer->right == NULL) {
    // It has only a LEFT sub-tree //

    _removeNode(*nodePointer->left);
  }
    free(nodePointer);

  // Node has TWO CHILDREN
  //Replace its item with the item of the next node in-order
  // And remove that node

  _deleteNextNode(&(nodePointer->right), &(nodePointer->item));

*/

}

// TPC -remover o max recursivamente
/*void _removeNodeMAX(BSTree** pPointer) { //para o menor item
  BSTree* nodePointer = *pPointer;
  if ((nodePointer->left == NULL) && (nodePointer->right == NULL)) {
    // A LEAF node
    free(nodePointer);
    *pPointer = NULL;
    return;
  }
  if (nodePointer->right == NULL) {
    // It has only a LEFT sub-tree //

    _removeNode(*nodePointer->left);
  }
  if (nodePointer->left == NULL) {
    // It has only a RIGHT sub-tree
    _removeNode(*nodePointer->right);

  }

  free(nodePointer);

  // Node has TWO CHILDREN
  //Replace its item with the item of the next node in-order
  // And remove that node

  _deleteNextNode(&(nodePointer->right), &(nodePointer->item));

}
*/

//
// NEW - Search for the node and remove it
//       with the help an auxiliary function
//
int BSTreeRemove(BSTree** pRoot, const ItemType item) {
  BSTree* root = *pRoot;

  if (root == NULL) {
    return 0;
  }
  if (root->item == item) {
    _removeNode(pRoot);
    return 1;
  }
  if (root->item > item) { // se o item do no for maior que o item que queremos vai para a esquerda
    return BSTreeRemove(&(root->left), item);
  }
//se nao vai direita
  return BSTreeRemove(&(root->right), item);
}

// ...

// Storing and reading from a FILE

struct _fileNode {
  ItemType item;
  int emptyLeftSubBSTree;
  int emptyRightSubBSTree;
};

static void _storeInFile(const BSTree* root, FILE* f, int fileType) {
  if (root == NULL) {
    return;
  }

  struct _fileNode r;
  r.item = root->item;
  r.emptyLeftSubBSTree = (root->left == NULL);
  r.emptyRightSubBSTree = (root->right == NULL);

  if (fileType == 1) {
    fprintf(f, "%d %d %d ", r.item, r.emptyLeftSubBSTree,
            r.emptyRightSubBSTree);
  } else {
    fwrite(&r, sizeof(struct _fileNode), 1, f);
  }

  _storeInFile(root->left, f, fileType);
  _storeInFile(root->right, f, fileType);
}

static void _getFromFile(BSTree** pRoot, FILE* f, int fileType) {
  struct _fileNode r;

  if (fileType == 1) {
    fscanf(f, "%d", &r.item);
    fscanf(f, "%d", &r.emptyLeftSubBSTree);
    fscanf(f, "%d", &r.emptyRightSubBSTree);
  } else {
    fread(&r, sizeof(struct _fileNode), 1, f);
  }

  BSTree* newNode = (BSTree*)malloc(sizeof(struct _BSTreeNode));

  newNode->item = r.item;

  if (r.emptyLeftSubBSTree) {
    newNode->left = NULL;
  } else {
    _getFromFile(&(newNode->left), f, fileType);
  }

  if (r.emptyRightSubBSTree) {
    newNode->right = NULL;
  } else {
    _getFromFile(&(newNode->right), f, fileType);
  }

  *pRoot = newNode;
}

int BSTreeStoreInFile(const BSTree* root, char* fileName, int fileType) {
  FILE* f = fopen(fileName, "w");
  if (f == NULL) {
    return 0;
  }

  _storeInFile(root, f, fileType);

  fclose(f);
  return 1;
}

BSTree* BSTreeGetFromFile(char* fileName, int fileType) {
  FILE* f = fopen(fileName, "r");
  if (f == NULL) {
    return NULL;
  }

  BSTree* root;
  _getFromFile(&root, f, fileType);

  fclose(f);
  return root;
}

// JUST FOR RUNNING EXAMPLES - REMOVE FROM THE INTERFACE

//
// TO DO : change to BST
//
BSTree* createExampleBSTree(unsigned int n) {
  int numNodes = 20;

  BSTree* root = BSTreeCreate();

  for (int i = 10; i < numNodes; i += 2) {
    BSTreeAdd(&root, 2 * i + 1);
  }

  for (int i = 0; i < numNodes; i += 2) {
    BSTreeAdd(&root, 2 * i);
  }

  return root;
}
