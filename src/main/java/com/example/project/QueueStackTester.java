package com.example.project;

public class QueueStackTester {
	public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq) {
		recSplit(q, oq, eq, q.length(), 1);
	}

	private static <T> void recSplit(Queue<T> q, Queue<T> oq, Queue<T> eq, int count, int pos) {
		if (pos > count)
			return;
		T element = q.serve();
		q.enqueue(element);
		if (pos % 2 == 1) {
			if (!oq.full())
				oq.enqueue(element);
		} else {
			if (!eq.full())
				eq.enqueue(element);
		}
		recSplit(q, oq, eq, count, pos + 1);
	}

	public static <T> void remove(LinkedPQ<T> pq, int p) {

		LinkedPQ<T> tempQueue = new LinkedPQ<T>();
		PQElement<T> tempData;

		while (pq.length() != 0) {
			if ((tempData = pq.serve()).p >= p)
				tempQueue.enqueue(tempData.data, tempData.p);
		}

		while (tempQueue.length() != 0) {
			tempData = tempQueue.serve();
			pq.enqueue(tempData.data, tempData.p);
		}

	}

	public static <T> boolean search(Stack<T> st, T e) {
		if (st.empty())
			return false;
		T top = st.pop();
		boolean found;
		if (top.equals(e))
			found = true;
		else
			found = search(st, e);
		st.push(top);
		return found;
	}
}