import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by chetan on 14/3/17.
 */
public class Stats {
    public static class StatisticsAggregatorImpl implements StatisticsAggregator {
        private ConcurrentHashMap<String, Double> priceMap = new ConcurrentHashMap<>();
        private ConcurrentHashMap<String, Integer> countMap = new ConcurrentHashMap<>();
        @Override
        public void putNewPrice(String symbol, double price) {
            // YOUR CODE HERE
            if(countMap.contains(symbol) == false) {
                countMap.put(symbol,1);
                priceMap.put(symbol,price);
            } else {
                int oldCount = countMap.get(symbol);
                double oldAverage = priceMap.get(symbol);
                double sum = oldAverage*oldCount + price;
                int newCount = oldCount+1;
                double newAvg = sum/newCount;

                priceMap.put(symbol,newAvg);
                countMap.put(symbol,newCount);
            }
        }

        @Override
        public double getAveragePrice(String symbol) {
            if (priceMap.contains(symbol)) {
                return priceMap.get(symbol);
            } else {
                return 0.0;
            }
        }

        @Override
        public int getTickCount(String symbol) {
            // YOUR CODE HERE
            if (countMap.contains(symbol)) {
                return countMap.get(symbol);
            } else {
                return 0;
            }
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface StatisticsAggregator {
        // This is an input. Make note of this price.
        public void putNewPrice(String symbol, double price);

        // Get the average price
        public double getAveragePrice(String symbol);

        // Get the total number of prices recorded
        public int getTickCount(String symbol);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final StatisticsAggregator stats = new StatisticsAggregatorImpl();
            final Set<String> symbols = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            int threads = Integer.parseInt(inputs[0]);

            ExecutorService pool = Executors.newFixedThreadPool(threads);
            for (int i = 1; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                symbols.add(symbol);
                final double price = Double.parseDouble(tokens[1]);
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        stats.putNewPrice(symbol, price);
                    }
                });

            }
            pool.shutdown();
            try {
                pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (String symbol : symbols) {
                System.out.println(String.format("%s %.4f %d", symbol,
                        stats.getAveragePrice(symbol),
                        stats.getTickCount(symbol)));
            }
        }
        scanner.close();

    }
}
