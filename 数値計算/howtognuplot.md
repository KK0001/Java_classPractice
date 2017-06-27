# How to gnuplot
gnuplotの使い方(OSX)  

## インストール
参考: http://qiita.com/noanoa07/items/a20dccff0902947d3e0c  
  1. [AquaTerm](https://sourceforge.net/projects/aquaterm/files/)と[X11](https://www.xquartz.org/)のインストール(OSXの場合、output用に不可欠)  
  2. gnuplotのインストール: `brew install gnuplot --with-aquaterm --with-x11`  
  3. 起動してみる。`Terminal type set to 'aqua'`の表示があればOK。  
  (👆の1.で入れたAquaTermが設定される。)  

## Howto
* プロット: `plot sin(x)`など  
* ファイルからプロットする場合: `plot "hoge.txt"`  
* ファイルの1列目と横軸、2列目を縦軸にしてプロット: `gnuplot "hoge.txt" u ($1):($2)`  
(省略した場合でもこれになる。)  
* 重ねて描画: `replot ~`  
* xの範囲を設定(-100~100): `set xrange[-100:100]`  

#### EPSで出力
参考: http://www.gnuplot-cmd.com/in-out/output.html
```hoetognuplot.txt
gnuplot> set terminal postscript eps # 出力先をEPSに設定
gnuplot> set output 'test.eps' # 出力ファイル名をtest.epsに設定
gnuplot> plot x # グラフをEPSにプロット
gnuplot> # 出力先を標準出力に戻す
gnuplot> set terminal aqua```
