/*
  把 E2 的 E2.pde 的程式碼貼進來
  將小雞加進遊戲中，小雞可以上下左右移動，
  碰到車子要回到原點。
  請參考 Chicken 裡面的方法，以及 isHit 方程。

*/

Car car[] = new Car[10] ;
Chicken chick;
void setup (){
  size(500,500);
  chick = new Chicken(250,250);
  // 創建 car 物件
  for(int i = 0;i<10;i++){
  car[i] = new Car (-100,100+50*i,floor(random(3, 5))) ;
  }
}

void draw () {
  background(255);
 
  for(int i = 0;i<10;i++){
  // 把車子畫出來
  car[i].display();
  
  // 車子往前跑
  car[i].moveForward();
  if (car[i].x > width ) car[i].reset(); 
  if(isHit(chick.x,chick.y,20,20,car[i].x,car[i].y,20,10)){
    chick.x = 250;
    chick.y = 250;
  }
  }
  chick.display();

  
}

boolean isHit(float ax, float ay, float aw, float ah, float bx, float by, float bw, float bh) {
  return (
    ax+aw > bx       &&
    ax    < bx + bw  &&
    ay+ah > by       &&
    ay    < by + bh  );
}

void keyPressed() {
  if (key == CODED ) {
    switch(keyCode) {
    case UP:
      chick.moveUp();
      break;
    case DOWN:
      chick.moveDown();
      // 小雞移動
      break;
    case LEFT:
      chick.moveLeft();
      // 小雞移動
      break;
    case RIGHT:
      chick.moveRight();
      // 小雞移動
      break;
    }
  }
}
