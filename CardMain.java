import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.Graphics2D;

public class CardMain implements ActionListener, KeyListener {
    private static Object App;

    public static int x_pos = 4;
    public static int y_pos = 4;


    public static int translation_pos = 0;

    public static int[][] arr = {   {1, 2, 3, 4, 5, 6}, //x_pos
                                    {7, 8, 9, 10,11,12},
                                    {13,14,15,16,17,18},
                                    {19,20,21,22,23,24},
                                    {25,26,27,28,29,30},
                                    {31,32,33,34,35,36}};
                                    // y_pos




    public static void main(String[] args) {

//        try {
//
//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        JFrame frame =  new JFrame();
        frame.setSize(300,200);
        //------------------------------------
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// When the application is closed close to program
        //------------------------------------
        JLabel lab = new JLabel("hello form java swing");
        frame.add(lab);

        frame.setVisible(true); //make it visible

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
//                new Main();
                CardMain gui = new CardMain();
                frame.addKeyListener(gui);
                gui.go();
            }
        });



//        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleAtFixedRate(App::myTask, 0, 1, TimeUnit.SECONDS);

//        int mainRows = 6;
//        int mainCols = 6;
//        int[][] mainMatrix = new int[mainRows][mainCols];

        int[][] arr = { {1, 2, 3, 4, 5, 6}, //x_pos
                        {7, 8, 9, 10,11,12},
                        {13,14,15,16,17,18},
                        {19,20,21,22,23,24},
                        {25,26,27,28,29,30},
                        {31,32,33,34,35,36}};
                       // y_pos


//        int center,
//        int left,
//        int right,
//        int up,
//        int down


        int playerX = 2;
        int playerY = 2;
        
        //todo error handel the range (0 x_pos 0  y_pos 5 x_pos 5  y_pos)
            
//        int width = 3;
//        int[][] player = new int[][];




        int width = 6;
        int location = (x_pos + ( y_pos * width)) + 1;


//        int center ;
//        int left;
//        int  right;
//        int up;
//        int down;
        int translation_pos = 0;







        //try catch 80000
        try {
            System.out.println("location " + arr[y_pos][x_pos]);
            System.out.println("location " + arr[y_pos][x_pos - 1]);
            System.out.println("location " + arr[y_pos][x_pos - 2]);
            System.out.println("location " + arr[y_pos - 1][x_pos - 2]);

            for (int i = 0; i < 2; i += 1) {
                x_pos -= 1;
                int[] game_map = player(arr, x_pos, y_pos, translation_pos, translation_pos, translation_pos, translation_pos, translation_pos);
                System.out.println("game map: " + "\n" + Arrays.toString(game_map));
                TimeUnit.SECONDS.sleep(1);
            }
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
            System.out.println("error code: 80000 util.concurrent.TimeUnit");
        }

     

//        }

//        System.out.println(location);
//        System.out.println(location % x_pos);
//





//        int isIndex = 0;
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                count++;
//                System.out.println(count);
//            }
//        }
//        isIndex = arr[x_pos][ y_pos];
//        System.out.println("The index: " + location + ", Is: " + isIndex);
//        System.out.println();
    }

    public static int[] player(int[][] arr,int x_pos,int y_pos ,
                                 int center,
                                 int left,
                                 int  right,
                                 int up,
                                 int down ) {



        center = arr[ y_pos][x_pos];
        left = arr[ y_pos][x_pos - 1];
        right = arr[ y_pos][x_pos + 1];
        up = arr[ y_pos - 1][x_pos];
        down = arr[ y_pos + 1][x_pos];

        int[] positions;
        positions = new int[]{center,left,right,up,down};


        return positions;


    }
    private void go() {



        System.out.println("test_____");






    }






    @Override
    public void keyTyped(KeyEvent e) {
        // Not implemented

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        int[] game_map = player(arr, x_pos, y_pos, translation_pos, translation_pos, translation_pos, translation_pos, translation_pos);

        switch(keyCode) {
            case  KeyEvent.VK_RIGHT:
                // code block
                System.out.println("RIGHT");
                x_pos += 1;
                System.out.println("game map: " + "\n" + Arrays.toString(game_map));
                break;
            case KeyEvent.VK_LEFT:
                // code block
                System.out.println("LEFT");
                x_pos -= 1;
                System.out.println("game map: " + "\n" + Arrays.toString(game_map));
                break;
            case KeyEvent.VK_UP:
                // code block
                System.out.println("UP");
                y_pos -= 1;
                System.out.println("game map: " + "\n" + Arrays.toString(game_map));
                break;
            case KeyEvent.VK_DOWN:
                // code block
                System.out.println("DOWN");
                y_pos += 1;
                System.out.println("game map: " + "\n" + Arrays.toString(game_map));
                break;
            default:
                // code block
        }

        if(x_pos == 6){
            x_pos -= 1 ;
        }
        if(x_pos == 1){
            x_pos += 1 ;
        }
        if(y_pos == 1){
            x_pos -= 1 ;
        }
        if(y_pos == 6){
            x_pos += 1 ;
        }

    }

    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

    }

    private void handleArrowKey(boolean rightArrow) {
//        TextHitInfo newPosition;
        if (rightArrow) {
//            newPosition = textLayout.getNextRightHit(insertionIndex);



        } else {
//            newPosition = textLayout.getNextLeftHit(insertionIndex);
        }

        // getNextRightHit() / getNextLeftHit() will return null if
        // there is not a caret position to the right (left) of the
        // current position.
//        if (newPosition != null) {
//            // Update insertionIndex.
//            insertionIndex = newPosition.getInsertionIndex();
//            // Repaint the Component so the new caret(s) will be displayed.
//            frame.repaint();
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}



