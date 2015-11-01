package cowd.domain;

import cowd.utils.constants.Constants;

public class Banner {

    private long seconds;

    public Banner(long seconds){
        this.seconds = seconds;
    }

    public void printBanner(){
        System.out.println(Constants.cowAsciiArt);
        System.out.println("Cows started.");
        System.out.println("Mooing every " + seconds +" seconds");
    }
}
