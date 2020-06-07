package hw8_Multithreading;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.*;

public class MaxElementSearching {

    private static final int ROWS = 4;
    private static final int COLS = 100;
    private static final int BOUND = 100;

    public static void main(String[] args) {

        Random rand = new Random(47);

        /** Create matrix   */
        List<ArrayList<Integer>> matrix = new ArrayList<>(ROWS);
        for (int i = 0; i < ROWS; i++) {
            matrix.add(new ArrayList<Integer>(COLS));
            for (int j = 0; j < COLS; j++) {
                matrix.get(i).add(rand.nextInt(BOUND));
            }
        }
        for (List<Integer> integers : matrix) {
            System.out.println(integers);
        }


        Date start;
        Date end;

        /**
         * Multithreading
         */
        start = new Date();
        System.out.println(new MultiThreadSearch(matrix, ROWS, COLS).getMax());
        end = new Date();

        System.out.println("Multithreading was working: " + (end.getTime() - start.getTime()) + " ms");

        /**
         * Singlethreading
         */
        start = new Date();
        System.out.println(new SingleThreadSearch(matrix, ROWS, COLS).getMax());
        end = new Date();

        System.out.println("Singlethreadinig was working: " + (end.getTime() - start.getTime()) + " ms");
    }
}

class SingleThreadSearch {
    List<ArrayList<Integer>> matrix;
    private final int ROWS;
    private final int COLS;

    public SingleThreadSearch(List<ArrayList<Integer>> matrix, int rows, int cols) {
        this.matrix = matrix;
        ROWS = rows;
        COLS = cols;
    }

    public Integer getMax(){

        Integer max = matrix.get(0).get(0);

        try {
            for (ArrayList<Integer> integers : matrix) {
                for (Integer integer : integers) {
                    if (max < integer)
                        max = integer;
                    TimeUnit.MILLISECONDS.sleep(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return max;
    }
}

class MultiThreadSearch {
    List<ArrayList<Integer>> matrix;
    private final int ROWS;
    private final int COLS;

    public MultiThreadSearch(List<ArrayList<Integer>> matrix, int rows, int cols) {
        this.matrix = matrix;
        ROWS = rows;
        COLS = cols;
    }

    public Integer getMax(){

        /** Main task   */
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < ROWS; i++) {
            results.add(exec.submit(new RowFinder(matrix.get(i))));
        }

        /** Final task  */
        Integer max = null;

        if (!results.isEmpty()){
            try {
                max = results.get(0).get();

                for (Future<Integer> result : results) {
                    if (result.get() > max) {
                        max = result.get();
                    }
                }
            } catch (InterruptedException| ExecutionException e ) {
                e.printStackTrace();
            }
        }

        exec.shutdown();

        return max;
    }
}

class RowFinder implements Callable<Integer> {
    List<Integer> row;

    public RowFinder(List<Integer> row) {
        this.row = row;
    }

    @Override
    public Integer call() throws Exception {

        if (row.isEmpty())
            return null;

        int max = row.get(0);

        try {
            for (Integer current : row) {
                if(current > max)
                    max = current;
                TimeUnit.MILLISECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (Integer)max;
    }
}
