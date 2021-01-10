package Lab01;

public class Population {
    public static void main(String[] args) {
        final long startPop = 312032486;
        final long years = 5;
        final long seconds = years*365*24*60*60;

        long birth = Math.floorDiv(seconds, 7);
        long death = Math.floorDiv(seconds, 13);
        long immigrant = Math.floorDiv(seconds, 45);

        long finalPop = startPop + birth - death + immigrant;
        System.out.println(finalPop);
    }
}
