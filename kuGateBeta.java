/*@author Kamau Charles M 
Reg #: I163S/19134/2014
*/ 
package mygate;

import java.awt.*;        // import statements to make necessary classes available
import java.awt.geom.*;
import static java.nio.channels.AsynchronousFileChannel.open;
import static java.nio.channels.AsynchronousFileChannel.open;

import javax.swing.*;
public class mygate extends JPanel {    
    /**
     * This main() routine makes it possible to run the class mygate
     * as an application.  It simply creates a window that contains a panel
     * of type mygate.  The program ends when the user closed the
     * window by clicking its close box.
     * @param args
     */
    public static void main(String[] args) {
        JFrame window;
        window = new JFrame("Java Graphics Project. Reg #: I163S/19134/2014_ Kamau Charles M.");  // The parameter shows in the window title bar.
        window.setContentPane( new mygate() ); // Show a Graphics starter in the window.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // End program when window closes.
        window.pack();  // Set window size based on the preferred sizes of its contents.
        window.setResizable(false); 
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( // Center window on screen.
                (screen.width - window.getWidth())/2, 
                (screen.height - window.getHeight())/2 );
        window.setVisible(true); // Open the window, making it visible on the screen.
    }
    
    private float pixelSize;  // This is the measure of a pixel in the coordinate system
                              // set up by calling the applyLimits method.  It can be used
                              // for setting line widths, for example.
    private Object Arc2D;
    
    /**
     * This constructor sets up a mygate when it is created.  Here, it
     * sets the size of the drawing area.  (The size is set as a "preferred size,"
     * which will be used by the pack() command in the main() routine.)
     */
    public mygate() {
        setPreferredSize( new Dimension(800,600) ); // Set size of drawing area, in pixels.
    }
    
    /**
     * The paintComponent method draws the content of the JPanel.  The parameter
     * is a graphics context that can be used for drawing on the panel.  Note that
     * it is declared to be of type Graphics but is actually of type Graphics2D,
     * which is a subclass of Graphics.
     */
    @Override
    protected void paintComponent(Graphics g) {   
        
        Graphics2D g2 = (Graphics2D)g.create();
        
        /* Turn on antialiasing in this graphics context, for better drawing.
         */
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        /* Fill in the entire drawing area with white.
         */

        g2.setPaint(Color.WHITE);
        g2.fillRect(0,0,getWidth(),getHeight()); 
        
        /* Set up a new coordinate system on the drawing area, by calling
         * the applyLimits() method that is defined below.  */
        
        applyapplyWindowToViewportTransformation(g2, -2600, 2600, -1075, 1075, true);    
        
        
        g2.draw( new Line2D.Double( -2600, 1075, 2600, 1075) ); 
        g2.draw( new Line2D.Double( -2600, -1075, 2600, -1075) ); 
        
        g2.setPaint(Color.BLACK);        
        g2.setStroke( new BasicStroke((float) (0.75*pixelSize)) );
        
        /* Creating arrays to hold the coordinates for our lines x1 paired with x1, y1 being the x and y 
    coordinates for the starting point and x2, y2 the coordinates for end point.*/
    int[] x1; 
        x1 = new int[]{-2154,-2153,-2166,-2114,-2119,-2068,-2022,-2018,-1976,-1921,-1920,-768,-768,-672,-695,-516,-516,-672,-695,-706,-565,-706,-766,-247,-1921,-2166,-708,-701,681,-702,-2167,-2128,-2131,-2131,-1750,-1835,-1750,-2021,-1952,-1952,-1701,-1651,-1649,-1700,-1952,-1666,-2021,-1666,-1651,-1646,-1454,-1680,-1680,-1456,-1454,-1417,-1418,-1418,-1439,-1439,-1447,-1447,-1532,-1538,-1538,-1544,-1544,-1551,-1551,-1560,-1560,-1641,-1650,-1650,-1655,-1697,-1687,-1687,-1679,-1655,-2021,-1666,-1416,-1354,-1418,-1437,-1445,-1445,-1453,-1531,-1566,-1646,-1646,-1696,-1793,-1787,-1787,-1795,-1797,-1812,-1816,-1797,-1824,-1822,-1919,-1916,-1914,-1922,-1925,-1949,-981,-905,-898,-840,-760,-725,-702,-568,-152,-184,-170,-152,-170,-94,106,149,-138,-103,-96,-147,156,156,173,161,156,-146,-143,-157,-164,802,898,900,1013,1525,1585,1647,1703,1736,1801,1870,1937,1417,1417,1470,1475,1506,1507,1666,1671,1711,1709,1992,2056,1868,1776,1778,1862,2168,2169,2209,2114,2104,2149,2179,1965,1965,741,637,659,659,673,673,659,557,638,552,259,303,268,330,321,379,466,-2166,-702,1506,1500,1500,1494,1493,1669,1709,1506,1710,1708,1709,1625,1620,1620,1615,1615,1599,1600,1592,1592,1507,1679,1698,1703,1704,1800,1810,1809,1816,1819,1830,1832,1836,1836,1936,1947,1946,1954,1954,1970,1987,1713,-725,-586,-566,196,153,153,611,628,727,709,-935,-763,-764,-771,-770,-934,747,747,742,741,849,-260,180,118,107,91,108,108,121,120,152,-39,69,70,-40,145,-118,152,-147,-87,-64,-82,-82,-97,-995,-1002,-1002,-1009,-1022,-896,-1022,-1021,-900,-875,-761,-754,-754,-750,-740,-765,-851,925,916,916,823,814,814,805,805,798,801,926,915,917,1030,1030,1034,925,926,907,-1919,-1927,-1926,-1933,-1952,-1707,-1699,-1699,-1793,-1803,-1803,-1812,-1812,-1825,-1825,-1823,-1647,-1658,-1657,-1663,-1665,-1473,-1437,-1443,-1444,-1451,-1451,-1459,-1531,-1534,-1534,-1544,-1545,-1552,-1460,-1475,1513,1514,1519,1594,1600,1601,1641,1641,1712,1755,1976,1976,1967,1967,1870,1863,1863,1853,1853,1840,1840,1830,1830,1712,1712,1763,2010,2003,1712,1705,1496,1601,1718,1601,-703,-1578,-1572,-1572,-1567,-1567,-1557,2179,2058,2005,680,2209,2206,2209,2171,2171,116,149,-103,-138,166,175,174,181,-170,-168,180,196,-152,302,268,267,332,-275,-295,-294,-263,-346,-406,181,467};
    int[] y1;
        y1 = new int[]{360,362,130,345,326,302,134,279,259,265,136,353,392,455,415,232,232,455,415,383,239,383,235,190,136,83,125,127,149,38,85,78,48,48,-65,40,49,-154,-248,-297,-297,-306,-259,-297,-248,-151,-154,-151,-259,-257,-310,-314,-359,-354,-310,-320,-362,-362,-364,-368,-368,-378,-381,-378,-368,-367,-359,-359,-368,-369,-378,-378,-379,-370,-370,-323,-321,-312,-312,-362,-154,-150,-321,-242,-362,-364,-370,-378,-380,-375,-380,-825,-379,-322,-840,-322,-312,-312,-298,-304,-311,-298,-324,-324,-840,-321,-320,-309,-303,-298,30,-837,-62,-833,-90,-69,-47,-153,-146,-179,-199,-348,-355,-365,-439,-445,-446,-470,-541,-595,-555,-555,-553,-982,-610,-613,-1002,-995,-554,-68,-814,42,-802,-793,-335,-790,-333,-801,-275,-796,-273,-203,-203,-277,-321,-314,-277,-223,-263,-249,-208,-203,-101,-102,100,-13,-6,115,138,152,201,388,414,446,200,200,182,477,434,434,404,404,409,262,478,261,203,333,382,456,494,714,890,84,127,-334,-334,-326,-326,-321,-107,-212,-314,-323,-322,-329,-334,-334,-327,-325,-319,-320,-323,-324,-333,-275,-258,-268,-271,-279,-276,-275,-265,-264,-256,-259,-268,-268,-275,-275,-272,-263,-263,-255,-256,-249,-251,-69,-172,-152,-195,-163,-141,-134,-152,-43,-29,84,87,37,37,-13,74,12,62,62,91,99,381,-199,-468,-610,-817,-816,-834,-835,-859,-860,-795,-795,-865,-868,-867,-974,-967,-554,-613,-819,-819,-834,-836,-838,-838,-846,-848,-858,-857,-858,-994,-994,-979,-823,-823,-830,-831,-837,-841,-839,-807,-807,-815,-795,-795,-804,-804,-811,-811,-928,-806,-808,-826,-824,-824,-973,-827,-980,-971,-841,-841,-849,-848,-860,-859,-858,-843,-840,-840,-848,-849,-857,-856,-849,-841,-826,-828,-835,-834,-844,-854,-844,-841,-833,-833,-825,-825,-821,-821,-825,-825,-833,-833,-952,-954,-810,-801,-800,-794,-794,-806,-802,-797,-817,-820,-811,-804,-804,-796,-795,-796,-805,-805,-813,-814,-806,-806,-798,-935,-962,-970,-962,-810,-962,-818,-811,-819,-804,-819,-48,-817,-817,-825,-825,-833,-833,447,200,361,135,153,202,153,136,116,-471,-444,-470,-445,-344,-345,-350,-372,-376,-207,-205,-175,-168,330,383,408,484,302,325,378,399,391,428,-372,887};
        int[] x2;
        x2 = new int[]{-2139,-2115,-707,-2119,-2068,-2071,-2018,-1976,-1978,-1921,-764,-764,-764,-672,-672,-672,-514,-514,-692,-692,-692,-703,-710,-279,-764,-708,-702,681,682,682,-2129,-2131,-1455,-1837,-1696,-1840,-1751,-1952,-1952,-1701,-1651,-1649,-1698,-1698,-1698,-1698,-1666,-1355,-1646,-1454,-1680,-1680,-1456,-1454,-1417,-1418,-1456,-1439,-1439,-1447,-1447,-1454,-1538,-1538,-1544,-1544,-1551,-1551,-1560,-1560,-1567,-1650,-1650,-1655,-1655,-1687,-1687,-1679,-1678,-1680,-1666,-1355,-1418,-1418,-1437,-1438,-1438,-1453,-1460,-1532,-1578,-1578,-1646,-1708,-1781,-1781,-1781,-1787,-1795,-1809,-1809,-1815,-1815,-1835,-1909,-1908,-1916,-1916,-1922,-1925,-994,-895,-837,-837,-762,-702,-568,-152,-152,-184,-152,-170,-170,-92,105,149,-138,-96,-88,156,156,173,178,178,161,156,-146,-164,-147,822,878,925,990,1506,1604,1626,1723,1708,1822,1847,1957,1471,1671,1475,1506,1507,1666,1671,1711,1709,1992,2056,1671,1859,1779,1728,2168,2169,2209,2204,2104,2149,2147,2147,1954,741,734,637,637,659,659,677,590,637,551,551,288,305,269,332,379,398,448,-2167,-701,1500,1500,1494,1493,1473,1709,1713,1710,1708,1709,1702,1620,1620,1615,1615,1599,1600,1592,1592,1585,1700,1698,1703,1704,1709,1810,1809,1816,1819,1830,1832,1836,1836,1846,1947,1946,1954,1954,1970,1987,1991,1987,-586,-566,-153,196,157,611,628,727,709,611,-763,-764,-771,-770,-752,-935,747,742,741,849,900,-262,165,109,91,108,108,121,121,152,145,69,70,-40,-39,-114,152,152,-147,-64,-82,-82,-97,-96,-1002,-1002,-1009,-1009,-896,-888,-1021,-900,-875,-875,-754,-754,-750,-748,-765,-832,-765,916,916,916,814,814,805,805,798,801,819,915,917,925,925,1034,926,926,907,906,-1927,-1926,-1933,-1933,-1707,-1699,-1699,-1708,-1803,-1803,-1812,-1812,-1825,-1825,-1823,-1835,-1658,-1657,-1663,-1663,-1473,-1437,-1443,-1444,-1451,-1451,-1459,-1460,-1534,-1534,-1544,-1545,-1552,-1552,-1475,-1668,1514,1519,1523,1600,1601,1641,1641,1646,1755,2000,1976,1967,1967,1958,1863,1863,1853,1853,1840,1840,1830,1830,1821,1713,1763,2010,2003,1975,1705,1719,1601,1718,1718,1610,709,-1572,-1572,-1567,-1567,-1557,-1555,2173,2049,2014,2209,2206,2013,2171,2171,1480,148,104,-137,-93,175,174,180,104,-94,-185,196,153,-184,284,303,330,322,-295,-294,-261,-346,-406,-416,180,380}; 
    int[] y2;
        y2 = new int[]{395,344,169,326,302,133,279,259,135,136,169,169,169,417,417,417,266,266,386,386,386,271,234,325,169,125,118,149,61,61,72,48,66,-50,-63,-150,-105,-248,-297,-297,-306,-259,-246,-246,-246,-246,-151,-245,-257,-310,-314,-359,-354,-310,-320,-362,-354,-364,-368,-368,-378,-379,-378,-368,-367,-359,-359,-368,-369,-378,-379,-379,-370,-370,-362,-321,-312,-312,-302,-359,-150,-245,-362,-321,-364,-369,-369,-380,-820,-821,-825,-825,-825,-842,-323,-323,-323,-312,-312,-312,-312,-324,-324,-840,-320,-323,-313,-313,-309,-304,-837,12,-70,-70,-824,-47,-153,-146,-168,-197,-348,-355,-376,-440,-363,-465,-466,-541,-595,-593,-593,-553,-983,-983,-982,-610,-613,-554,-553,-795,-47,-805,62,-334,-794,-335,-794,-280,-795,-276,-795,-279,-106,-321,-314,-277,-223,-263,-249,-208,-203,-101,-106,104,-45,-12,115,138,152,200,388,414,430,430,343,182,388,437,437,409,409,292,271,439,285,285,326,355,408,482,714,799,938,130,37,-334,-326,-326,-321,-322,-212,-251,-310,-322,-329,-332,-334,-327,-325,-319,-320,-323,-324,-333,-334,-276,-268,-271,-279,-282,-275,-265,-264,-256,-259,-268,-268,-275,-280,-272,-263,-263,-255,-256,-249,-200,-249,-172,-152,-145,-174,-89,-134,-152,-43,-29,-134,87,37,37,-13,-25,84,62,62,91,99,93,400,-344,-594,-817,-816,-834,-835,-862,-860,-867,-795,-865,-868,-795,-870,-967,-861,-596,-819,-819,-834,-836,-866,-838,-846,-848,-857,-857,-856,-994,-994,-979,-966,-823,-830,-831,-838,-841,-838,-841,-807,-815,-827,-795,-804,-804,-811,-811,-928,-932,-808,-826,-827,-827,-973,-980,-980,-971,-950,-841,-849,-848,-859,-859,-858,-843,-840,-840,-848,-849,-857,-856,-849,-841,-839,-828,-835,-834,-843,-854,-844,-841,-833,-833,-825,-825,-819,-821,-825,-825,-833,-833,-844,-954,-956,-801,-800,-799,-794,-806,-802,-797,-796,-820,-813,-804,-804,-796,-795,-796,-805,-805,-813,-814,-806,-806,-798,-797,-859,-970,-962,-810,-813,-818,-818,-819,-804,-818,-928,-29,-817,-825,-825,-833,-833,-843,486,355,201,153,202,200,136,116,108,-466,-439,-467,-440,-345,-350,-352,-377,-377,-199,-196,-163,-179,310,358,453,494,325,378,382,391,428,466,-351,731}; 

        /*Drawing using a loop with the array coordinates:    */
        
        for (int i=0; i<x1.length; i++){            
           /*if (i >= 377 && i <=380){                             
               continue;               
           }*/
                            
             g2.draw( new Line2D.Double( x1[i], y1[i], x2[i], y2[i]) ); 
        }
        
        
        g2.setPaint( new Color(156,35,9) ); // red 
        g2.fill3DRect(-1954, -1010, 289, 169, true);
        g2.fill3DRect(-1676, -956, 250, 169, true);
        g2.fill3DRect(-1020,-1003, 150, 169, true);
        g2.fill3DRect(-844,-950, 150, 169, true);
        g2.fill3DRect(-142,-985, 295, 117, true);
        
        g2.fill3DRect(900, -981, 150, 169, true);
        g2.fill3DRect(750,-930, 150, 169, true);
        g2.fill3DRect(1710,-987, 301, 169, true);
        g2.fill3DRect(1498,-920, 61, 169, true);
        g2.fill3DRect(1630,-908, 71, 169, true);
        //Curves:
        //g2.draw(new Arc2D.Double(-2151,424, 1500,3,-25,10));       
       g2.setPaint(Color.black);        
        g2.setStroke( new BasicStroke((float) (0.75*pixelSize)) );
        g2.drawArc(-2122, 207, 1385, 297, 15, 156);
        g2.drawArc(-2222, 251, 1540, 390, 28,128);
        g2.drawArc(-2245, 285, 1590, 450, 13,137);
        
        g2.drawArc(-1810, -339, 1410, 350, 184,115);
        g2.drawArc(-1789, -390, 1410, 350, 203,98);
        
        //right side
        g2.drawArc(568, 300, 1685, 397, 35, 117);
        g2.drawArc(568, 325, 1685, 397, 28, 125);
        g2.drawArc(560, 371, 1685, 397, 25, 130);
        g2.drawArc(-416, -343, 8586, 1597, 180, 37);
        
        
        //mid side 
        g2.drawArc(-870, 190, 1685, 399, 33, 110);
        g2.drawArc(-870, 150, 1685, 399, 33, 111);
     
        //right side below
        g2.drawArc(643, -435, 1150, 558, 207,143);
        g2.drawArc(643, -465, 1150, 558, 200,143);
        
        //text        
        
        g.setFont(new Font("TimesRoman", Font.BOLD, 11));         
        //g2.setStroke( new BasicStroke((float) (75*pixelSize)) );        
        g.drawString( "Enhancing Lives", 585,270 );
        g.drawString( "Transforming Higher Education", 105,279 );        
        g.setColor(Color.blue);        
        g.drawString( "ELIMU", 380,215 );
        g.drawString( "NI", 389,225 );
        g.drawString( "NGUVU", 380,235 );
        g.setFont(new Font("TimesRoman", Font.BOLD, 9));         
        g.drawString( "WELCOME", 382,350 );
        
        g.setFont(new Font("TimesRoman", Font.BOLD, 9));        
        
        
        //rectangles
       
       g2.setPaint( new Color(3,5,21) );  
       g2.fillRect(-698,42, 1377, 99);//left
       
       g.setFont(new Font("TimesRoman", Font.BOLD, 11));         
       g.setColor(Color.white);        
        g.drawString( "KENYATTA UNIVERSITY", 335,295 );
        
         g2.setPaint( new Color(41,63,208) );  
        g2.fillRect(-892, -964, 15, 463);//left
        g2.fillRect(-892, -964, 729, 15);
        g2.fillRect(-175,-943, 15, 367); // right
        g2.fillRect(-870,-764, 691, 4);
        g2.fillRect(-870,-724, 691, 4);//upper
        
        int startx = -892;
        int starty = -964;
        for (int i=0; i<13; i++){  
            startx= startx+55;                            
             g2.fillRect(startx, starty, 7, 183);
        }
        startx = -892;
        starty = -724;
               
        for (int i=0; i<13; i++){  
            startx= startx+55;                            
             g2.fillRect(startx, starty, 7, 183);
             starty=starty-10;
        }      
        
        g2.fillRect(1034, -944, 15, 463);//left
        g2.fillRect(1033, -945, 705, 15);
        g2.fillRect(1720,-930, 15, 367); // right
        g2.fillRect(1013,-742, 691, 7);
        g2.fillRect(1013,-700, 691, 7);//upper
        
        int startx2 = 980;
        int starty2 = -946;
        for (int i=0; i<13; i++){  
            startx2= startx2+55;                            
             g2.fillRect(startx2, starty2, 7, (366-5*i));
        }       
        
        
        g2.fillRect(-1702,-989, 15, 367);//left
        g2.fillRect(-1702,-989, 705, 15);//bottom
        g2.fillRect(-1020, -990, 15, 490); // right
        g2.fillRect(-1690, -767, 691, 7);//
        g2.fillRect(-1690,-797, 691, 7);//
        
        startx2 = -1702;
        starty2 = -950;
        for (int i=0; i<13; i++){  
            startx2= startx2+55;                            
             g2.fillRect(startx2, starty2, 7, (366+5*i));
        }      
        
        g2.fillRect(180,-953, 15, 367);//left
        g2.fillRect(180,-953, 710, 15);//bottom
        g2.fillRect(890,-947, 15, 490); // right
        g2.fillRect(192,-748, 691, 7);//upper
        g2.fillRect(195,-778, 691, 7);//lower mid
        
        startx2 = 180;
        starty2 = -930;
        for (int i=0; i<13; i++){  
            startx2= startx2+55;                            
             g2.fillRect(startx2, starty2, 7, (366+5*i));
        }            
        
    }
    
    /**
     * Applies a coordinate transform to a Graphics2D graphics context. The requested limits might be adjusted to preserve the
     * aspect ratio.
     *     This method sets the value of the global variable pixelSize, which is defined as the
     * maximum of the width of a pixel and the height of a pixel as measured in the
     * coordinate system.  (If the aspect ratio is preserved, then the width and 
     * height will agree.
     * @param g2 The drawing context whose transform will be set.
     * @param left requested x-value at left of drawing area.
     * @param right requested x-value at right of drawing area.
     * @param bottom requested y-value at bottom of drawing area; can be less than
     *     top, which will reverse the orientation of the y-axis to make the positive
     *     direction point upwards.
     * @param top requested y-value at top of drawing area.
     * @param preserveAspect if preserveAspect is false, then the requested view window
     *     rectangle will exactly fill the viewport; if it is true, then the limits will be
     *     expanded in one direction, horizontally or vertically, if necessary, to make the
     *     aspect ratio of the view window match the aspect ratio of the viewport.
     *     Note that when preserveAspect is false, the units of measure in the horizontal 
     *     and vertical directions will be different.
     */
    private void applyapplyWindowToViewportTransformation(Graphics2D g2,
            double left, double right, double bottom, double top, 
            boolean preserveAspect) {
        int width = getWidth();   // The width of this drawing area, in pixels.
        int height = getHeight(); // The height of this drawing area, in pixels.
        if (preserveAspect) {
            // Adjust the limits to match the aspect ratio of the drawing area.
            double displayAspect = Math.abs((double)height / width);
            double requestedAspect = Math.abs(( bottom-top ) / ( right-left ));
            if (displayAspect > requestedAspect) {
                // Expand the viewport vertically.
                double excess = (bottom-top) * (displayAspect/requestedAspect - 1);
                bottom += excess/2;
                top -= excess/2;
            }
            else if (displayAspect < requestedAspect) {
                // Expand the viewport vertically.
                double excess = (right-left) * (requestedAspect/displayAspect - 1);
                right += excess/2;
                left -= excess/2;
            }
        }
        g2.scale( width / (right-left), height / (bottom-top) );
        g2.translate( -left, -top );
        double pixelWidth = Math.abs(( right - left ) / width);
        double pixelHeight = Math.abs(( bottom - top ) / height);
        pixelSize = (float)Math.max(pixelWidth,pixelHeight);
    }
    
}