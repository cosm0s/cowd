package cowd.core;

import cowd.domain.Banner;

public class Mooing {

    private long elapsedInSeconds;
    private boolean isStarted;
    private long startCowdIn;
    private Banner banner;

    public Mooing(long elapsedInSeconds, long startCowdIn, Banner banner){
        this.elapsedInSeconds = elapsedInSeconds;
        this.startCowdIn = startCowdIn;
        this.banner = banner;
        this.isStarted = true;
    }

    public void start(){

        long threadSleepTime = this.elapsedInSeconds*1000;

        this.banner.printBanner();

        while(this.isStarted){
            long uptime = System.currentTimeMillis() - this.startCowdIn;
            System.out.println("[service uptime in " + uptime/1000 + " seconds] mooo!");
            try {
                Thread.sleep(threadSleepTime - uptime%10);
            } catch (InterruptedException e) {
                this.isStarted = false;
            }
        }
    }

}
