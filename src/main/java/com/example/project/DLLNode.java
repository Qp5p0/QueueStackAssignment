package com.example.project;

public class DLLNode<T> {
	public T data;
	public DLLNode<T> next;
    public DLLNode<T> previous;
    public DLLNode(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    public DLLNode() {
        this.data = null;
        this.next = null;
        this.previous = null;
    }
    public DLLNode(T data, DLLNode<T> next, DLLNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
}