#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    int data;
    struct Node *next;
} Node;

// Add a node to the end of the list
void add(Node *head, int data)
{
    Node *item = malloc(sizeof(Node));
    item->data = data;
    item->next = NULL;
    if (head == NULL)
    { // Means the list is empty
        head = item;
    }
    else
    { // Traverse at the end of the list
        Node *iterator = head;
        while (iterator->next != NULL)
        {
            iterator = iterator->next;
        }
        iterator = item;
    }
}

void printList(Node *head)
{
    Node *iterator = head;
    while (iterator != NULL)
    {
        printf("node value: %d\n", iterator->data);
        iterator = iterator->next;
    }
}

// Create head

int main()
{
    Node *head = NULL;
    add(head, 2);
    printf("Hello");
    // add(head, 5);
    // add(head, 2);
    // Traverse the linked list
    // printList(head);

    /*
    Node *item1 = malloc(sizeof(Node));
    item1->data = 5;
    item1->next = NULL;
    head = item1;

    Node *item2 = malloc(sizeof(Node));
    item2->data = 2;
    item2->next = NULL;
    item1->next = item2;

    free(item1);
    free(item2);
    */
}