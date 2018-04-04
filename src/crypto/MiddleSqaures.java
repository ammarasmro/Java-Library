package crypto;

import java.util.ArrayList;
import java.util.List;

/**
 * This class uses the ancient Middle Squares method to generate pseudo-random numbers
 * It uses a seed, gets the middle values of the square of the seed value, then replaces the seed with the new value
 */
public class MiddleSqaures {

    private int seed;
    private int currentSeed;

    /**
     * Constructor to get the seed as the current time in milliseconds
     */
    public MiddleSqaures(){
        long millis = System.currentTimeMillis() % 1000;
        seed = (int) millis;
        currentSeed = seed;
    }

    /**
     * Constructor to seed the generator manually
     * @param seed: A user determined seed
     */
    public MiddleSqaures(int seed){
        this.seed = seed;
        this.currentSeed = seed;
    }

    public int getSeed(){ return seed; }

    public int getNext(){
        return getNextMiddleSquare();
    }

    /**
     *
     * @return: the middle 3 numbers of the generated number
     */
    public int getNextMiddleSquare(){
        int temp = currentSeed * currentSeed;
        temp = temp / 10;
        currentSeed = temp % 1000;
        return currentSeed;
    }

    /**
     *
     * @param size: intended size of the generated sequence
     * @return: a sequence of pseudo-random values
     */
    public List<Integer> getSequence(int size){
        List<Integer> seq = new ArrayList<>();
        for(int i = 0; i < size; i++){
            seq.add(getNext());
        }
        return seq;
    }

    public static void main(String[] args) {
        MiddleSqaures middleSqaures = new MiddleSqaures();
        System.out.println(middleSqaures.getSeed());
        System.out.println(middleSqaures.getSequence(10));
    }
}
