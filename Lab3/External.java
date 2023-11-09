import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class External {
    public static void showMemory(){
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
        long usedMemoryMB = heapMemoryUsage.getUsed() / (1024 * 1024);
        long maxMemoryMB = heapMemoryUsage.getMax() / (1024 * 1024);
        System.out.println("Heap Memory Usage: " + usedMemoryMB + " MB / " + maxMemoryMB + " MB");
    }
}
