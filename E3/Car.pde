/*
  把 E2 完成的 Car 程式碼貼進來
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
