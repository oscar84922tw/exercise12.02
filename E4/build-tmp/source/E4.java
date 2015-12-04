import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class E4 extends PApplet {

/*

\u8acb\u5b8c\u6210 Arrow \u985e\u5225\uff0c\u4e26\u61c9\u7528\u4ed6\uff0c\u6539\u5beb\u539f\u672c\u7684\u7a0b\u5f0f\u78bc\u3002

*/

PImage arrow ;
final int ArrowLength = 30 ;
final int numberOfArrowPerSide = 10 ;
final int fixImageOffset = ArrowLength / 2 ;
public void setup (){
  arrow =  loadImage("arrow.png") ;
  
  imageMode(CENTER);

}

public void draw(){
  background(255);

  for (int i = 0  ; i < numberOfArrowPerSide ; i++){
    for (int j = 0 ; j < numberOfArrowPerSide ; j++){

      int currentArrowX = fixImageOffset  + i * ArrowLength ;
      int currentArrowY = fixImageOffset  + j * ArrowLength ;

      // \u5148\u8a18\u4f4f\u795e\u4e4b\u624b\u539f\u672c\u7684\u4f4d\u7f6e
      pushMatrix();

      // \u628a\u795e\u4e4b\u624b\u79fb\u5230\u8981\u756b\u756b\u7684\u4f4d\u7f6e
      translate(currentArrowX,currentArrowY);

      // \u6307\u5b9a\u795e\u4e4b\u624b\u7684\u89d2\u5ea6\uff0c\u4f7f\u4ed6\u7784\u6e96\u6ed1\u9f20\u65b9\u5411
      rotate( atan2(mouseY - currentArrowY , mouseX - currentArrowX )) ;

      // \u795e\u4e4b\u624b\u5728\u87a2\u5e55\u4e0a\u756b\u51fa\u6771\u897f
      image(arrow,0,0);

      // \u795e\u4e4b\u624b\u56de\u5230\u4e00\u958b\u59cb\u7684\u5730\u65b9
      popMatrix();
    }
  }
}

/* @pjs preload=
"arrow.png"; */
  public void settings() {  size(300 , 300) ; }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "E4" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
