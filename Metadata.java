import java.util.concurrent.*;

public class Metadata extends TimerTask {
      private double maxTime;
      private double currentTime;

      Metadata(double t) {
            maxTime = t;
            currentTime = t;
      }

      public void run() {
            try {
                  currentTime -= 0.01;
                  if (currentTime <= 0) {
                        currentTime = maxTime;
                  }
            } catch (Exception ex) {
                  System.out.println("error running thread " + ex.getMessage());
            }
      }

      public void setMaxTime(double d) {
            maxTime = d;
            if (currentTime > d) {
                  currentTime = d;
            }
      }

      public double getCurrentTime() {
            return currentTime;
      }
      public double getMaxTime() {
            return maxTime;
      }
}
