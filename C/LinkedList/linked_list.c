#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Node
{
    int data;
    struct Node *next;
} Node;

// Add a node to the end of the list
void add_node(Node **head, int data, bool to_front)
{
    Node *item = (Node*)malloc(sizeof(Node));
    item->data = data;
    item->next = NULL;

    if (*head == NULL) {  // If the list is empty
        *head = item;
        return;
    }

    if (to_front) { // Add the node to the front O(1)
        item->next = *head;
        *head = item;
        return;
    }

    Node *iterator = *head; // Add the node to the back
    while (iterator->next != NULL)
    {
        iterator = iterator->next;
    }
    iterator->next = item;
}

void remove_node(Node **head, int index) {
    if (index < 0) return;
    // If the user wants to remove the first item in the list/front
    if (index == 0) {
        Node *node_to_remove = *head;
        *head = (*head)->next;
        free(node_to_remove);
        node_to_remove = NULL;
        return;
    }

    // If it's not the last element
    int count = 0;
    Node *iterator = *head;
    while (count != index - 1) {
        iterator = iterator->next;
        count++;
    }

    // Save the element to remove
    Node *node_to_remove = iterator->next;

    // Connect current iterator 2 nodes ahead
    iterator->next = iterator->next->next;

    node_to_remove->next = NULL;
    free(node_to_remove);
    node_to_remove = NULL;
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

int main()
{
    Node *head = NULL;
    add_node(&head, 2, false);
    add_node(&head, 3, false);
    add_node(&head, 4, false);
    add_node(&head, 5, false);

    remove_node(&head, 2);

}