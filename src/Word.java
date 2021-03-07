public class Word implements Comparable<Word> {
    private String word;
    private int frequency;

    public void setWord(String word) {
        this.word = word;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return this.frequency;
    }
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

    @Override
    public int compareTo(Word word) {
        int compareFreq= word.getFrequency();

        return compareFreq - this.getFrequency();
    }

    //comparable
    
}
