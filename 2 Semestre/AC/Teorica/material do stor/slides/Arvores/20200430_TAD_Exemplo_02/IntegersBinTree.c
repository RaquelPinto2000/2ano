//
// Joaquim Madeira, AlgC, April 2020
//
// Adapted from an old example (ca. 2003)
//
// Integers Binary Tree --- FIRST VERSION --- INCOMPLETE
//

#include "IntegersBinTree.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "PointersQueue.h"
#include "PointersStack.h"

struct _TreeNode {
  ItemType item;
  struct _TreeNode* left;
  struct _TreeNode* right;
};

Tree* TreeCreate(void) { return NULL; }

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

int TreeGetMin(const Tree* root) {
  // ...
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

int TreeGetMax(const Tree* root) {
  // ...
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
  return 0;
}

void TreeTraverseInPREOrder(Tree* root, void (*function)(ItemType* p)) {
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

void TreeTraverseLevelByLevelWithQUEUE(Tree* root,void (*function)(ItemType* p)) { // travessia por niveis
  if (root == NULL) {
    return;
  }

  // Not checking for queue errors !!
  // Create the QUEUE for storing POINTERS

  Queue* queue = QueueCreate();

  QueueEnqueue(queue, root);

  while (QueueIsEmpty(queue) == 0) {
    Tree* p = QueueDequeue(queue);

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

void TreeTraverseInPREOrderWithSTACK(Tree* root,void (*function)(ItemType* p)) {
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

// no pseudo - codigo esta diferente ->slide 39
void TreeTraverseINOrderWithSTACK(Tree* root, void (*function)(ItemType* p)) {
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

// slide 52 as arvores 02 -> nao sei se esta bem o que fiz
int TreeAdd(Tree** pRoot, const ItemType item) {
  // ...
  if(*pRoot==NULL){
    (*pRoot)->item = item;
  }
  if((*pRoot)->left == NULL && (*pRoot)->right == NULL){
    (*pRoot)->left = item;
  }
  if((*pRoot)->left != NULL && (*pRoot)->right == NULL){
    (*pRoot)->left = item;
  }else if((*pRoot)->left == NULL && (*pRoot)->right != NULL){
    (*pRoot)->right=item;
  }
  if((*pRoot)->left != NULL && (*pRoot)->right != NULL){
    TreeAdd(&(*pRoot)->left,(*pRoot)->item);
    (*pRoot)->item = item;
  }
  return 0;
}

// E esta como se faz? E assim (nao tem nada nos slides acho eu)???
int TreeRemove(Tree** pRoot, const ItemType item) {
  // ...
  if(*pRoot == NULL){
    return 0;
  }
  if((*pRoot)->item == item){
    free(*pRoot);
  }
  if((*pRoot)->left != NULL){
    return TreeRemove((*pRoot)->letf, item);
  }
  if((*pRoot)->right != NULL){
    return TreeRemove((*pRoot)->right, item);
  }
  return 0;
}

// ...

// Storing and reading from a FILE

struct _fileNode {
  ItemType item;
  int emptyLeftSubTree;
  int emptyRightSubTree;
};

static void _storeInFile(const Tree* root, FILE* f, int fileType) {
  if (root == NULL) {
    return;
  }

  struct _fileNode r;
  r.item = root->item;// raiz da arvore
  // se a subarvore esq/dir for null(1) entao a arvore esta vazia
  // se a subarvore esq/dir nao for null(0) entao a arvore nao esta vazia
  r.emptyLeftSubTree = (root->left == NULL); // subarvore esquerda
  r.emptyRightSubTree = (root->right == NULL);// subarvore direita

  if (fileType == 1) {
    fprintf(f, "%d %d %d ", r.item, r.emptyLeftSubTree, r.emptyRightSubTree);
  } else {
    fwrite(&r, sizeof(struct _fileNode), 1, f);
  }

  _storeInFile(root->left, f, fileType);
  _storeInFile(root->right, f, fileType);
  //travessia em pre ordem
}

static void _getFromFile(Tree** pRoot, FILE* f, int fileType) {
  struct _fileNode r;

  if (fileType == 1) {
    fscanf(f, "%d", &r.item);
    fscanf(f, "%d", &r.emptyLeftSubTree);
    fscanf(f, "%d", &r.emptyRightSubTree);
  } else {
    fread(&r, sizeof(struct _fileNode), 1, f);
  }

  Tree* newNode = (Tree*)malloc(sizeof(struct _TreeNode));

  newNode->item = r.item; // raiz da arvore

  if (r.emptyLeftSubTree) { // subarvore esquerda
    newNode->left = NULL;
  } else {
    _getFromFile(&(newNode->left), f, fileType);
  }

  if (r.emptyRightSubTree) { // subarvore direita
    newNode->right = NULL;
  } else {
    _getFromFile(&(newNode->right), f, fileType);
  }

  *pRoot = newNode;
  //Reconstrucao em pre ordem
}

int TreeStoreInFile(const Tree* root, char* fileName, int fileType) {
  FILE* f = fopen(fileName, "w");
  if (f == NULL) {
    return 0;
  }

  _storeInFile(root, f, fileType);

  fclose(f);
  return 1;
}

Tree* TreeGetFromFile(char* fileName, int fileType) {
  FILE* f = fopen(fileName, "r");
  if (f == NULL) {
    return NULL;
  }

  Tree* root;
  _getFromFile(&root, f, fileType);

  fclose(f);
  return root;
}

// JUST FOR RUNNING EXAMPLES - REMOVE FROM THE INTERFACE

Tree* createExampleTree(void) {
  // SHOULD NEVER BE DONE LIKE THIS !!!???!!!

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
