import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class Dizhu {
	public static void main(String args[]){
        Changgong worker = new Changgong();
        FutureTask<Integer> jiangong = new FutureTask<Integer>(worker);
        new Thread(jiangong).start();
        while(!jiangong.isDone()){
            try {
                System.out.println("看长工做完了没...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int amount;
        try {
            amount = jiangong.get();
            System.out.println("工作做完了,上交了"+amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
