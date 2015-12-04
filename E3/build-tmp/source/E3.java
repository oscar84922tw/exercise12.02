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

public class E3 extends PApplet {

/*
  \u628a E2 \u7684 E2.pde \u7684\u7a0b\u5f0f\u78bc\u8cbc\u9032\u4f86
  \u5c07\u5c0f\u96de\u52a0\u9032\u904a\u6232\u4e2d\uff0c\u5c0f\u96de\u53ef\u4ee5\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52d5\uff0c
  \u78b0\u5230\u8eca\u5b50\u8981\u56de\u5230\u539f\u9ede\u3002
  \u8acb\u53c3\u8003 Chicken \u88e1\u9762\u7684\u65b9\u6cd5\uff0c\u4ee5\u53ca isHit \u65b9\u7a0b\u3002

*/

Car car[] = new Car[10] ;
Chicken chick;
public void setup (){
  
  chick = new Chicken(250,250);
  // \u5275\u5efa car \u7269\u4ef6
  for(int i = 0;i<10;i++){
  car[i] = new Car (-100,100+50*i,floor(random(3, 5))) ;
  }
}

public void draw () {
  background(255);
 
  for(int i = 0;i<10;i++){
  // \u628a\u8eca\u5b50\u756b\u51fa\u4f86
  car[i].display();
  
  // \u8eca\u5b50\u5f80\u524d\u8dd1
  car[i].moveForward();
  if (car[i].x > width ) car[i].reset(); 
  if(isHit(chick.x,chick.y,20,20,car[i].x,car[i].y,20,10)){
    chick.x = 250;
    chick.y = 250;
  }
  }
  chick.display();

  
}

public boolean isHit(float ax, float ay, float aw, float ah, float bx, float by, float bw, float bh) {
  return (
    ax+aw > bx       &&
    ax    < bx + bw  &&
    ay+ah > by       &&
    ay    < by + bh  );
}

public void keyPressed() {
  if (key == CODED ) {
    switch(keyCode) {
    case UP:
      chick.moveUp();
      break;
    case DOWN:
      chick.moveDown();
      // \u5c0f\u96de\u79fb\u52d5
      break;
    case LEFT:
      chick.moveLeft();
      // \u5c0f\u96de\u79fb\u52d5
      break;
    case RIGHT:
      chick.moveRight();
      // \u5c0f\u96de\u79fb\u52d5
      break;
    }
  }
}
/*
  \u628a E2 \u5b8c\u6210\u7684 Car \u7a0b\u5f0f\u78bc\u8cbc\u9032\u4f86
*/
class Car{
  int speed;
  int x;
  int y;
  PImage car;
  public Car (int x , int y) {
    this.x = x;
    this.y = y;
    this.speed = 10;
    car = loadImage("car.png");
  }
  public Car (int x,int y,int speed){
    this.x = x;
    this.y = y;
    this.speed = speed ;
    car = loadImage("car.png");
  }

  public void reset(){
    this.x = -5;
    this.y = floor(random(0, 500));
    x+=speed;
  }

  public void display(){
    image(car, x, y);
  }

  public void moveForward(){
    x+=speed;
  }
}
class Chicken {
  float x ; 
  float y ;
  PImage img ;
  float speed = 10 ; 
  Chicken (float x , float y ) {
    img = loadImage("chicken.png") ;
    this.x = x ; 
    this.y = y ;

  }
  public void reset(){
    x = width / 2  ;  // \u9019\u88cf\u6307\u7684\u662f \u6574\u500b\u904a\u6232\u7684 width
    y = 0 ; 
  }
  public void display (){
    image(img,x,y);
  }
  
  
  public void moveUp (){
    y-= speed ;
  }
  public void moveDown (){
    y+= speed ;
  }
  public void moveLeft (){
    x-= speed ;
  }
  public void moveRight (){
    x+= speed ;
  }
  
}
/* @pjs preload=
"car.png,
chicken.png"; */
  public void settings() {  size(500,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "E3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
