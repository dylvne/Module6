
//import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class App extends Application {

    Stage window;
    Scene scene1, scene2;

    public static String fileName = "";
    public static ArrayList<Word> wordList = new ArrayList<Word>();

    
    /** 
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        //parts of the scene

        // Button exit = new Button("Exit");
        // exit.setOnAction(e -> System.exit(0));

        window = primaryStage;

        Label label1 = new Label("Welcome to the first scene!");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        //Layout 1 - children are laid out in a vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 200);

        //Button 2
        Button button2 = new Button("This scene sucks, go back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene (layout2, 600, 300);


        primaryStage.setTitle("word occurrences");

        primaryStage.setScene(scene1);

        primaryStage.show();
        
    }

    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        launch(args);
        String text = "";
        System.out.println(new File(".").getAbsoluteFile());
        System.out.println("Please enter the name of the file to scan");
        fileName = System.console().readLine();

        File file = new File(fileName);

        if (file.exists()){
            System.out.println("this file exists");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                text = text + " " + scanner.nextLine();
            }
            scanner.close();
            //System.out.println(text);
            String[] wordArr = text.split("\\s+|-|—|\\.|\"|\\?|!|;|,|'s|\\r?\\n|:|\\s|'");
            for (String string : wordArr) {
                
                //System.out.println(string);

                if(string == ""|| string == " "){

                }
                else{
                    if(inWordList(string,wordList)){
                        increaseWordFreq(string, wordList);
                    }
                    else{
                        wordList.add(new Word(string));
                    }
                }

            }
        }
        else{
            System.out.println("this file not found");
        }

        Collections.sort(wordList);

        for (int i = 0; i < 20; i++) {
            String string = wordList.get(i).getWord();
            int frequency = wordList.get(i).getFrequency();
            System.out.println(string + " : " + frequency);
        }
    }

    /**
     * 
     * @param string
     * @param wordList
     * @return true if string is found in wordList
     */
    public static boolean inWordList(String string, ArrayList<Word> wordList){

        for (Word word : wordList) {
            if(string.toLowerCase().equalsIgnoreCase(word.getWord())){
                return true;
            }
        }

        return false;
    }

    /**
     * Increases a words frequency in the wordList
     * @param string
     * @param wordList
     */
    public static void increaseWordFreq(String string, ArrayList<Word> wordList){
        for (Word word : wordList) {
            if(string.toLowerCase().equalsIgnoreCase(word.getWord())){
                word.increase();
            }
        }
    }

    @Test
    public void testIncreasedWordFreq(){
        ArrayList<Word> testList = new ArrayList<Word>();
        Word testWord = new Word("word");
        testList.add(testWord);
        increaseWordFreq("word", testList);
        assertEquals(2, testList.get(0).getFrequency());
    }


}
