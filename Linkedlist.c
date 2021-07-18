typedef struct LinkListNode {
	 int val;
	 struct LinkListNode *next;
}LinkListNode;

typedef struct {
	 LinkListNode *head;
	 LinkListNode *tail;
	 int cnt;
} MyLinkedList;

LinkListNode *createLinkListNode(int val){
	 LinkListNode *node = malloc(sizeof(LinkListNode));
	 node->val = val;
	 node->next = NULL;
	 return node;
}
/** Initialize your data structure here. */

MyLinkedList* myLinkedListCreate() {
	 MyLinkedList* list = malloc(sizeof(MyLinkedList));
	 list->head = NULL;
	 list->tail = NULL;
	 list->cnt = 0;
	 return list;
}

/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
int myLinkedListGet(MyLinkedList* obj, int index) {
	 if(index >= obj->cnt) {
		  return -1;
	 }
	 LinkListNode *node = obj->head;
	 while(index > 0) {
		  node = node->next;
		  index--;
	 }
	 return node->val;
}

/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
void myLinkedListAddAtHead(MyLinkedList* obj, int val) {
	 LinkListNode *node = createLinkListNode(val);	  
	 if(obj->head == NULL){
		  obj->head = node;
	 }else {
		  node->next = obj->head;
		  obj->head = node;
	 }
	 if(obj->tail == NULL){
		  obj->tail = node;
	 }
	 obj->cnt++;
}

/** Append a node of value val to the last element of the linked list. */
void myLinkedListAddAtTail(MyLinkedList* obj, int val) {
	 LinkListNode *node = createLinkListNode(val);	  
	 if(obj->tail == NULL){
		  obj->tail = node;
	 }else {			 
		  obj->tail->next = node;
		  obj->tail = node;			
	 }
	 if(obj->head == NULL){
		  obj->head = node;
	 }
	 obj->cnt++;
}

void myLinkedListDeleteAtHead(MyLinkedList* obj, int val) {
	 if(obj->head == NULL)
		  return;
	 
	 LinkListNode *temp = obj->head;
	 obj->head = obj->head->next;
	 free(temp);
	 if(obj->head == NULL) {
		  obj->tail = NULL;
	 }
	 obj->cnt--;
}


/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
void myLinkedListAddAtIndex(MyLinkedList* obj, int index, int val) {
	 if(index > obj->cnt){
		  return;
	 }else if(index == 0){
		  myLinkedListAddAtHead(obj, val);
		  return;
	 }else if(index == obj->cnt) {
		  myLinkedListAddAtTail(obj, val);
		  return;
	 }
	 
	 LinkListNode *cur = obj->head, *prev;
	 while(index){
		  prev = cur;
		  cur = cur->next;
		  index--;
	 }
	 LinkListNode *new = createLinkListNode(val);	 
	 prev->next = new;
	 new->next = cur;
	 obj->cnt++;
}

/** Delete the index-th node in the linked list, if the index is valid. */
void myLinkedListDeleteAtIndex(MyLinkedList* obj, int index) {
	 if(index >= obj->cnt){
		  return;
	 }else if(index == 0){
		  myLinkedListDeleteAtHead(obj, index);
		  return;
	 }
	 LinkListNode *cur = obj->head, *prev;
	 while(index){
		  prev = cur;
		  cur = cur->next;
		  index--;
	 }
	 prev->next = cur->next;
	 if(cur == obj->tail) {
		  obj->tail = prev;
	 }
	 free(cur);
	 obj->cnt--;
  
}

void myLinkedListFree(MyLinkedList* obj) {
	 int cnt = obj->cnt;
	 LinkListNode *cur = obj->head;
	 while(cnt){
		  LinkListNode *next = cur->next;
		  free(cur);
		  cur = next;
		  cnt--;
	 }
	 free(obj);
}

/**
 * Your MyLinkedList struct will be instantiated and called as such:
 * MyLinkedList* obj = myLinkedListCreate();
 * int param_1 = myLinkedListGet(obj, index);
 
 * myLinkedListAddAtHead(obj, val);
 
 * myLinkedListAddAtTail(obj, val);
 
 * myLinkedListAddAtIndex(obj, index, val);
 
 * myLinkedListDeleteAtIndex(obj, index);
 
 * myLinkedListFree(obj);
*/
