#include <iostream>
using namespace std;

// Node structure
struct Node {
    int data;
    Node* next;
};

// Function to add a node at the end
void addNode(Node*& head, int value) {
    Node* newNode = new Node(); // Create a new node
    newNode->data = value;      // Set its data
    newNode->next = nullptr;    // Initially, it points to null

    if (head == nullptr) {
        head = newNode; // If the list is empty, make the new node the head
    } else {
        Node* temp = head;
        while (temp->next != nullptr) { // Traverse to the last node
            temp = temp->next;
        }
        temp->next = newNode; // Add the new node at the end
    }
}

// Function to delete a node by value
void deleteNode(Node*& head, int value) {
    if (head == nullptr) return; // If the list is empty, do nothing

    // If the node to be deleted is the head
    if (head->data == value) {
        Node* temp = head;
        head = head->next; // Move the head to the next node
        delete temp;       // Free the old head
        return;
    }

    Node* current = head;
    Node* previous = nullptr;

    while (current != nullptr && current->data != value) {
        previous = current;          // Keep track of the previous node
        current = current->next;    // Move to the next node
    }

    // If the value was found
    if (current != nullptr) {
        previous->next = current->next; // Bypass the current node
        delete current;                 // Free the node
    }
}

// Function to display the linked list
void displayList(Node* head) {
    Node* current = head;
    while (current != nullptr) {
        cout << current->data << " -> "; // Print the data
        current = current->next;          // Move to the next node
    }
    cout << "nullptr" << endl; // Indicate the end of the list
}

// Main function
int main() {
    Node* head = nullptr; // Initialize the head of the list

    // Adding nodes
    addNode(head, 10);
    addNode(head, 20);
    addNode(head, 30);

    // Display the list
    cout << "Linked List: ";
    displayList(head);

    // Deleting a node
    cout << "Deleting 20..." << endl;
    deleteNode(head, 20);
    
    // Display the list again
    cout << "Linked List after deletion: ";
    displayList(head);

    // Cleanup: delete all nodes
    deleteNode(head, 10);
    deleteNode(head, 30);

    return 0; // End of the program
}
