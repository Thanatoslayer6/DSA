#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int data;
    struct Node *next;
} Node;


// Add a node to the end of the list
void add(Node *head, int data) {
    Node *new_node = malloc(sizeof(Node));
    new_node->data = data;
    if (head == NULL) { 
        head = new_node;
        new_node->next = NULL;
    } else {
        new_node->next = head;
    }
}

void printList(Node *head) {
    Node *iterator = head;
    while (iterator->next != NULL) {
        printf("node value: %d\n", iterator->data);
        iterator = iterator->next;
    }
}


int main() {
    // Create head
    Node *head = NULL;
    add(head, 5);
    add(head, 2);
    // Traverse the linked list
    printList(head);
}