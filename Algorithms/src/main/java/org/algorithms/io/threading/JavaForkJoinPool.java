package org.algorithms.io.threading;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

class MyRecursiveTask extends RecursiveTask<Boolean> {
    private final List<Integer> data;
    private final Integer target;
    public MyRecursiveTask(List<Integer> data, int target) {
        this.data = data;
        this.target = target;
    }

    @Override
    protected Boolean compute() {
        if(data.size() > 25) {
            System.out.println("Splitting workload: "+ data.size());
            int load1 = data.size() / 2;
            var myRecursiveTask = new MyRecursiveTask(
                    data.subList(0, load1), target
            );
            var myRecursiveTask1 = new MyRecursiveTask(
                    data.subList(load1, load1 * 2), target
            );

            var first = myRecursiveTask.fork();
            var last = myRecursiveTask1.compute();

            try {
                return first.get() || last;
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }

        }

        return data.contains(target);
    }
}

class MyRecursiveAction extends RecursiveAction {
    private final List<Integer> data;
    private final Integer target;
    public MyRecursiveAction(List<Integer> data, int target) {
        this.data = data;
        this.target = target;
    }
    @Override
    protected void compute() {
        if(data.size() > 25) {
            System.out.println("Splitting workload: "+ data.size());
            int load1 = data.size() / 2;
            var myRecursiveAction1 = new MyRecursiveAction(
                    data.subList(0, load1), target
            );
            var myRecursiveAction2 = new MyRecursiveAction(
                    data.subList(load1, data.size()), target
            );

            myRecursiveAction1.fork();
            myRecursiveAction2.compute();
        } else {
            System.out.println("Doing workload alone: " + data.size());
            System.out.println("Founding target in data => "+ data.contains(target));
        }
    }
}

public class JavaForkJoinPool {
    public static void main(String[] args) {

       var data = IntStream.range(0, 100).boxed().toList();

        try(var forkJoin = ForkJoinPool.commonPool()) {
            forkJoin.invoke(new MyRecursiveAction(data, 72));
//            System.out.println(found);
            forkJoin.shutdown();
        }
    }
}
