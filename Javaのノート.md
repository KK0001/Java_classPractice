# Javaの授業ノート
## Javaの変数の型、一覧
### 基本型
byte: 1バイト整数  
short: 短い整数  
int: 整数  
long: 長い整数  

float: 単精度浮動小数点数  
double: 倍精度浮動小数点数  

#### memo
通常はint型とdouble型をよく使う。たまにlong型も使う。  


## ランダム
インポート⇣  
import java.util.Random;  
ランダムな値を生成する変数の生成⇣  
Random rad = new Random();  
これを使う⇣
int random_num = rand.nextInt(10); //10までの整数から1つの整数を生成  

## 入力
インポート⇣  
import java.util.Scanner;  
入力させる変数⇣  
Scanner stdIn = new Scanner(System.in);  
これを使う⇣  
int r = stdIn.nextInt(); //これはint型  

## 文字の読み込み
インポート⇣  
import java.util.Scanner;  
入力させる変数⇣  
Scanner stdIn = new Scanner(System.in);  
これを使う⇣  
String s = stdIn.next();  
