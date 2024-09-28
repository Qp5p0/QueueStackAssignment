package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestQueueStack {
   @Test
   public void testSplit1()
   {
      Queue<Character> original = new ArrayQueue<Character>(5);
      original.enqueue('a');
      original.enqueue('b');
      original.enqueue('c');
      original.enqueue('d');
      original.enqueue('e');
      Queue<Character> oq = new ArrayQueue<Character>(5);
      Queue<Character> eq = new ArrayQueue<Character>(5);
      QueueStackTester.split(original, oq, eq);
      assertEquals(3, oq.length());
      assertEquals(2, eq.length());
      char tmp = oq.serve();
      assertEquals(tmp, 'a');
      tmp = oq.serve();
      assertEquals(tmp, 'c');
      tmp = oq.serve();
      assertEquals(tmp, 'e');
      tmp = eq.serve();
      assertEquals(tmp, 'b');
      tmp = eq.serve();
      assertEquals(tmp, 'd');
   }
   @Test
   public void testSplit2()
   {
      Queue<Integer> original = new LinkedQueue<Integer>();
      original.enqueue(2);
      original.enqueue(1);
      original.enqueue(3);
      original.enqueue(4);
      original.enqueue(6);
      original.enqueue(5);
      Queue<Integer> oq = new LinkedQueue<Integer>();
      Queue<Integer> eq = new LinkedQueue<Integer>();
      QueueStackTester.split(original, oq, eq);
      assertEquals(3, oq.length());
      assertEquals(3, eq.length());
      int tmp = oq.serve();
      assertEquals(tmp, 2);
      tmp = oq.serve();
      assertEquals(tmp, 3);
      tmp = oq.serve();
      assertEquals(tmp, 6);
      tmp = eq.serve();
      assertEquals(tmp, 1);
      tmp = eq.serve();
      assertEquals(tmp, 4);
      tmp = eq.serve();
      assertEquals(tmp, 5);
   }
   @Test
   public void testSplit3()
   {
      Queue<String> original = new LinkedQueue<String>();
      original.enqueue("Hello");
      Queue<String> oq = new LinkedQueue<String>();
      Queue<String> eq = new LinkedQueue<String>();
      QueueStackTester.split(original, oq, eq);
      assertEquals(1, oq.length());
      assertEquals(0, eq.length());
      String tmp = oq.serve();
      assertEquals(tmp, "Hello");
   }
   @Test
   public void testSplit4()
   {
      Queue<String> original = new LinkedQueue<String>();
      Queue<String> oq = new LinkedQueue<String>();
      Queue<String> eq = new LinkedQueue<String>();
      QueueStackTester.split(original, oq, eq);
      assertEquals(0, oq.length());
      assertEquals(0, eq.length());
   }
   @Test
   public void testRemove1()
   {
      LinkedPQ<Character> pq = new LinkedPQ<Character>();
      pq.enqueue('a', 10);
      pq.enqueue('b', 5);
      pq.enqueue('c', 2);
      pq.enqueue('d', 8);
      pq.enqueue('e', 3);
      QueueStackTester.remove(pq, 5);
      assertEquals(3, pq.length());
      PQElement<Character> tmp = pq.serve();
      assertEquals(tmp.data, 'a');
      assertEquals(tmp.p, 10);
      tmp = pq.serve();
      assertEquals(tmp.data, 'd');
      assertEquals(tmp.p, 8);
      tmp = pq.serve();
      assertEquals(tmp.data, 'b');
      assertEquals(tmp.p, 5);
   }
   @Test
   public void testRemove2()
   {
      LinkedPQ<Character> pq = new LinkedPQ<Character>();
      pq.enqueue('a', 10);
      pq.enqueue('b', 5);
      pq.enqueue('d', 8);
      QueueStackTester.remove(pq, 5);
      assertEquals(3, pq.length());
      PQElement<Character> tmp = pq.serve();
      assertEquals(tmp.data, 'a');
      assertEquals(tmp.p, 10);
      tmp = pq.serve();
      assertEquals(tmp.data, 'd');
      assertEquals(tmp.p, 8);
      tmp = pq.serve();
      assertEquals(tmp.data, 'b');
      assertEquals(tmp.p, 5);
   }
   @Test
   public void testRemove3()
   {
      LinkedPQ<String> pq = new LinkedPQ<String>();
      pq.enqueue("Alice", 10);
      pq.enqueue("Bob", 5);
      pq.enqueue("Charlie", 2);
      QueueStackTester.remove(pq, 12);
      assertEquals(0, pq.length());
   }
   @Test
   public void testRemove4()
   {
      LinkedPQ<Integer> pq = new LinkedPQ<Integer>();
      QueueStackTester.remove(pq, 12);
      assertEquals(0, pq.length());
   }
   @Test
   public void testSearch1()
   {
      Stack<Integer> st = new ArrayStack<Integer>(5);
      st.push(5);
      st.push(7);
      st.push(5);
      st.push(3);
      st.push(2);
      assertEquals(true, QueueStackTester.search(st, 3));
      assertEquals(false, QueueStackTester.search(st, 1));
   }
   @Test
   public void testSearch2()
   {
      Stack<String> st = new LinkedStack<String>();
      st.push("Alice");
      st.push("Bob");
      st.push("Charlie");
      assertEquals(true, QueueStackTester.search(st, "Charlie"));
      assertEquals(false, QueueStackTester.search(st, "David"));
      assertEquals(true, QueueStackTester.search(st, "Alice"));
   }
   @Test
   public void testSearch3()
   {
      Stack<Integer> st = new ArrayStack<Integer>(5);
      assertEquals(false, QueueStackTester.search(st, 1));
   }
}
