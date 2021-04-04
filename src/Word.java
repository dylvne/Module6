
public class Word implements Comparable<Word> {
    private String word;
    private int frequency;

    /**
     * A string to be stored in wordList
     * @param word
     */
    public void setWord(String word) {
        this.word = word;
    }
    
    
    /** 
     * @param frequency
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    
    /** 
     * @return int
     */
    public int getFrequency() {
        return this.frequency;
    }
    
    /** 
     * @return String
     */
    public String getWord() {
        return this.word;
    }

    public Word(String word){
        this.setWord(word);
        this.setFrequency(1);
    }

    public void increase(){
        this.setFrequency(this.getFrequency() + 1);
    }

    
    /** 
     * @param word
     * @return int
     */
    @Override
    public int compareTo(Word word) {
        int compareFreq= word.getFrequency();

        return compareFreq - this.getFrequency();
    }

    //comparable
    
}
