Car car[] = new Car[10] ;

void setup (){
  size(500,500);
  
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
  
  }
  
  
}


/*
  請把E1 的練習貼過來，並使用陣列裝 10 個 Car，
  車子的 y 軸位置間隔為 50 ，速度為 3.0 ~ 5.0 的隨機數字
*/
