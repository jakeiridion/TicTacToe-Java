import java.awt.*;
import java.awt.event.*;

public class GUI{
    private TicTacToe game;
    private Frame frame;
    private Label label, score, result;
    private Button tl,tm,tr,ml,mm,mr,bl,bm,br, xStart, oStart;
    private int wrongButtonWasClicked = 0;
    private int afterReset = 0;
    private int currentPlayer = 0;
    private int xScore = 0;
    private int oScore = 0;
    
    public GUI(){
        game = new TicTacToe();
        
        // Frame
        frame = new Frame("TicTacToe");
        frame.setSize(300, 450);
        frame.setLayout(null);
        frame.setVisible(true);
        
        // Allowing the App to close.
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we) {
                frame.dispose();
                System.exit(0);
            }
        });
        
        // Player instructions.
        label = new Label("Welcher Spieler soll beginnen?");
        label.setSize(300,25);
        label.setLocation(0, 100);
        label.setAlignment(Label.CENTER);
        frame.add(label);
        
        // Result of the last match.
        result = new Label("");
        result.setSize(300,25);
        result.setLocation(0, 40);
        result.setAlignment(Label.CENTER);
        
        // Player Score.
        score = new Label("X:" + xScore + " | " + "O:" + oScore);
        score.setSize(300,25);
        score.setLocation(0, 400);
        score.setAlignment(Label.CENTER);
        
        // Chose who beginns button --> X
        xStart = new Button("X");
        xStart.setSize(100,100);
        xStart.setLocation(25,150);
        xStart.setFont(new Font("", Font.PLAIN, 50));
        xStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                initGUI();
            }
        });
        frame.add(xStart);
        
        // Chose who beginns button --> O
        oStart = new Button("O");
        oStart.setSize(100,100);
        oStart.setLocation(175,150);
        oStart.setFont(new Font("", Font.PLAIN, 50));
        oStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                currentPlayer = 1;
                initGUI();
            }
        });
        frame.add(oStart);
        
        tl = new Button("");
        tl.setSize(100,100);
        tl.setLocation(0,100);
        tl.setFont(new Font("", Font.PLAIN, 50));
        tl.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                clickButton(tl);
            }
        });
        
        tm = new Button("");
        tm.setSize(100,100);
        tm.setLocation(100,100);
        tm.setFont(new Font("", Font.PLAIN, 50));
        tm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                clickButton(tm);
            }
        });
        
        tr = new Button("");
        tr.setSize(100,100);
        tr.setLocation(200,100);
        tr.setFont(new Font("", Font.PLAIN, 50));
        tr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                clickButton(tr);
            }
        });
        
        ml = new Button("");
        ml.setSize(100,100);
        ml.setLocation(0,200);
        ml.setFont(new Font("", Font.PLAIN, 50));
        ml.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                clickButton(ml);
            }
        });
        
        mm = new Button("");
        mm.setSize(100,100);
        mm.setLocation(100,200);
        mm.setFont(new Font("", Font.PLAIN, 50));
        mm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                clickButton(mm);
            }
        });
        
        mr = new Button("");
        mr.setSize(100,100);
        mr.setLocation(200,200);
        mr.setFont(new Font("", Font.PLAIN, 50));
        mr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                clickButton(mr);
            }
        });
        
        bl = new Button("");
        bl.setSize(100,100);
        bl.setLocation(0,300);
        bl.setFont(new Font("", Font.PLAIN, 50));
        bl.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                clickButton(bl);
            }
        });
        
        bm = new Button("");
        bm.setSize(100,100);
        bm.setLocation(100,300);
        bm.setFont(new Font("", Font.PLAIN, 50));
        bm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                clickButton(bm);
            }
        });
        
        br = new Button("");
        br.setSize(100,100);
        br.setLocation(200,300);
        br.setFont(new Font("", Font.PLAIN, 50));
        br.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                clickButton(br);
            }
        });
    }
    
    // Clear the frame then start the game.
    private void initGUI(){
        frame.removeAll();
        label.setText("Spieler " + getCurrentPlayerCharacter() +" darf beginnen.");
        label.setLocation(0, 50);
        frame.add(label);
        frame.add(tl);
        frame.add(tm);
        frame.add(tr);
        frame.add(ml);
        frame.add(mm);
        frame.add(mr);
        frame.add(bl);
        frame.add(bm);
        frame.add(br);                
    }
    
    // Changes the current player value to the opposite of its current state.
    private void changeCurrentPlayer(){
        if(currentPlayer == 0){
            currentPlayer = 1;
        }
        else{
            currentPlayer = 0;
        }
    }
    
    // Updates the Label.
    // Message after a new round started is different then the normal one.
    private void updateLabel(){
        if(afterReset == 1){
            label.setText("Spieler " + getCurrentPlayerCharacter() +" darf beginnen.");
            afterReset = 0;
        }
        else{
            label.setText("Spieler " + getCurrentPlayerCharacter() + " ist am Zug.");        
        }
    }
    
    // Returns a string of the current player's character (either X or O).
    private String getCurrentPlayerCharacter(){
        if(currentPlayer == 0){
            return "X";
        }
        else{
            return "O";
        }
    }
    
    // Changes the text of the pressed button and changes the value in the TicTacToe class.
    private void writeButton(Button b){
        if(b.getLabel().equals("X") || b.getLabel().equals("O")){
            wrongButtonWasClicked = 1;
        }
        else if(b.equals(tl)){
            b.setLabel(getCurrentPlayerCharacter());
            game.setFieldValue("tl", getCurrentPlayerCharacter());
        }
        else if(b.equals(tm)){
            b.setLabel(getCurrentPlayerCharacter());
            game.setFieldValue("tm", getCurrentPlayerCharacter());
        }
        else if(b.equals(tr)){
            b.setLabel(getCurrentPlayerCharacter());
            game.setFieldValue("tr", getCurrentPlayerCharacter());
        }
        else if(b.equals(ml)){
            b.setLabel(getCurrentPlayerCharacter());
            game.setFieldValue("ml", getCurrentPlayerCharacter());
        }
        else if(b.equals(mm)){
            b.setLabel(getCurrentPlayerCharacter());
            game.setFieldValue("mm", getCurrentPlayerCharacter());
        }
        else if(b.equals(mr)){
            b.setLabel(getCurrentPlayerCharacter());
            game.setFieldValue("mr", getCurrentPlayerCharacter());
        }
        else if(b.equals(bl)){
            b.setLabel(getCurrentPlayerCharacter());
            game.setFieldValue("bl", getCurrentPlayerCharacter());
        }
        else if(b.equals(bm)){
            b.setLabel(getCurrentPlayerCharacter());
            game.setFieldValue("bm", getCurrentPlayerCharacter());
        }
        else if(b.equals(br)){
            b.setLabel(getCurrentPlayerCharacter());
            game.setFieldValue("br", getCurrentPlayerCharacter());
        }
    }
    
    // Resets the screen. Clears the Button Texts.
    private void resetScreen(){
        tl.setLabel("");
        tm.setLabel("");
        tr.setLabel("");
        ml.setLabel("");
        mm.setLabel("");
        mr.setLabel("");
        bl.setLabel("");
        bm.setLabel("");
        br.setLabel("");
    }
    
    // Increases the score of the current player by one.
    private void givePoint(){
        if(getCurrentPlayerCharacter().equals("X")){
            xScore ++;
        }
        else if(getCurrentPlayerCharacter().equals("O")){
            oScore ++;
        }
    }
    
    // Starts displaying the score after a point difference.
    // Refreshes the score.
    private void updateScore(){
        if(xScore == 0 && oScore == 0){
            frame.add(score);
        }
        givePoint();
        score.setText("X:" + xScore + " | " + "O:" + oScore);
    }
    
    // Updates the result message after a win.
    private void updateResultWin(){
        label.setLocation(0, 65);
        result.setText("Spieler " + getCurrentPlayerCharacter() + " hat gewonnen!");
        frame.add(result);
    }
    
    // Updates the result message after a tie.
    private void updateResultTie(){
        label.setLocation(0, 65);
        result.setText("Unentschieden!");
        frame.add(result);
    }
    
    // resets the result label by removing it from the frame.
    private void resetResult(){
        frame.remove(result);
        label.setLocation(0, 50);
    }
    
    // resets the entire game and changes the value afterGame so that we know to change the
    // instructions.
    private void resetGame(){
        game.reset();
        resetScreen();
        afterReset = 1;    
    }
    
    // Checks the field for a win or a tie.
    private void checkField(){
        if(game.isWin()){
            updateResultWin();
            updateScore();
            resetGame();
        }
        else if(game.isTie()){
            updateResultTie();
            resetGame();
        }
    }
    
    // The Function called after a button is pressed.
    private void clickButton(Button b){
        writeButton(b);
        if(result.isEnabled()){
            resetResult();
        }
        if(wrongButtonWasClicked == 0){        
            checkField();
            changeCurrentPlayer();
            updateLabel();
        }
        wrongButtonWasClicked = 0;
    }
}
