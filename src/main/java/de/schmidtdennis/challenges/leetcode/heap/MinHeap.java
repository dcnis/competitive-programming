package de.schmidtdennis.challenges.leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {

    // (i*2)+1      first child
    // (i*2)+2      second child
    // (i-1)/2      parent

    static class MyMinHeap{
        List<Integer> heap = new ArrayList<>();

        public MyMinHeap(List<Integer> array){
            this.heap = buildHeap(array);
        }

        private List<Integer> buildHeap(List<Integer> array){
            // for each parent do siftDown
            int firstParentIndex = (array.size()-2)/2;

            for(int i = firstParentIndex; i >= 0; i--){
                siftDown(i, array.size()-1, array);
            }
            return array;
        }

        private void siftUp(int index){
            // check if parent is smaller than de.schmidtdennis.challenges.leetcode.heap.get(index)
            int indexParent = (index-1)/2;
            if(heap.get(index) < heap.get(indexParent)){
                swap(index, indexParent, this.heap);
                siftUp(indexParent);
            }
        }

        private void siftDown(int index, int endIndex, List<Integer> heap){

                if((endIndex) >= (index*2)+2) { // two children
                    int smallestChildIndex;
                    if (heap.get(index * 2 + 1) < heap.get(index * 2 + 2)) {
                        // left child is smaller
                        smallestChildIndex = index * 2 + 1;
                    } else {
                        smallestChildIndex = index * 2 + 2;
                    }

                    if (heap.get(index) > heap.get(smallestChildIndex)) {
                        swap(index, smallestChildIndex, heap);
                        siftDown(smallestChildIndex, endIndex, heap);
                    }
                } else if((heap.size()-1) == index*2+1){ // only left child
                    if(heap.get(index) > heap.get(index*2+1)){
                        swap(index, index*2+1, heap);
                    }
                } else {
                    // no child -> done
                }
            }

        public void insert(int value){
            // insert at the end of the de.schmidtdennis.challenges.leetcode.array -> siftUp
            heap.add(value);
            siftUp(heap.size()-1);
        }

        public int remove(){
            // swich first element with last element
            // siftDown first element
            int returnValue = heap.get(0);
            swap(0, heap.size()-1, this.heap);
            heap.remove(heap.size()-1);
            siftDown(0, heap.size()-1, this.heap);
            return returnValue;
        }

        public int peek(){
            return heap.get(0);
        }

        private void swap(int index1, int index2, List<Integer> heap){
            int tmp = heap.get(index1);
            heap.set(index1, heap.get(index2));
            heap.set(index2, tmp);
        }

    }

    public static void main(String[] args) {
        MyMinHeap program = new MyMinHeap(new ArrayList<>(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)));
        program.insert(76);
        System.out.println(program.peek());
        System.out.println(program.remove());
        System.out.println(program.peek());
        System.out.println(program.remove());
        System.out.println(program.peek());
        program.insert(87);

    }
}
