//
// Joaquim Madeira, AlgC, April 2020
//
// Adapted from an old example (ca. 2003)
//
// Integers Binary Tree --- FIRST VERSION --- INCOMPLETE
//

#ifndef _INTEGERS_BINTREE_
#define _INTEGERS_BINTREE_

// JUST storing integers
typedef int ItemType;

typedef struct _TreeNode Tree;

Tree* TreeCreate(void);

void TreeDestroy(Tree** pRoot); // ponteiro para um ponteiro pRoot

// Tree properties

int TreeIsEmpty(const Tree* root);

int TreeEquals(const Tree* root1, const Tree* root2);

int TreeMirrors(const Tree* root1, const Tree* root2);

// ...

// Getters

int TreeGetNumberOfNodes(const Tree* root);

int TreeGetHeight(const Tree* root);

ItemType TreeGetMin(const Tree* root); // retorna o valor minimo?

ItemType TreeGetMax(const Tree* root);

Tree* TreeGetPointerToMinNode(const Tree* root ; // retorna o ponteiro para o node com o valor minimo

Tree* TreeGetPointerToMaxNode(const Tree* root);

// ...

// Traversals

void TreeTraverseInPREOrder(Tree* root, void (*function)(ItemType* p)); // atravessar a arvore na pre ordem----??

void TreeTraverseINOrder(Tree* root, void (*function)(ItemType* p)); // atravessar a arvore em ordem----??

void TreeTraverseInPOSTOrder(Tree* root, void (*function)(ItemType* p)); //atravessar a arvore na ordem posterior---??

// ...

// Operations with items

int TreeContains(const Tree* root, const ItemType item); // ver se contem algum elemento -> const Tree* root ponteiro para a raiz

int TreeAdd(Tree** pRoot, const ItemType item); // adicionar um elemento -> Tree** pRoot ponteiro duplo(ponteiro para um ponteiro)

int TreeRemove(Tree** pRoot, const ItemType item); // remover um item da arvore -> Tree** pRoot ponteiro duplo(ponteiro para um ponteiro)

// ...

// JUST FOR RUNNING EXAMPLES - REMOVE FROM THE INTERFACE

Tree* createExampleTree(void);

#endif  // _INTEGERS_BINTREE_
