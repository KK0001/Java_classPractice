# sin(x)の導関数を求める

import math
import numpy as np
import matplotlib.pyplot as plt

# 関数を定義する
def defineFunction(x):
    return math.sin(x)

def main():

    #変数などの定義
    DIV_NUM = 100 #分割数
    X_MAX = 2 * math.pi #区間(今回は0〜2π)
    MIN_DIV = X_MAX/DIV_NUM #分割

    dx = MIN_DIV
    x = 0.0 #x
    dy0 = 0.0
    dy1 = 0.0 #1階微分用
    dy2 = 0.0 #2階微分用
    d2y0 = 0.0
    d2y1 = 0.0
    d3y0 = 0.0

    y0 = 0.0
    y1 = 0.0
    y2 = 0.0
    y3 = 0.0

    # プロット用配列
    x0 = []
    df0 = []
    df1 = []
    df2 = []
    df3 = []

    #微分する
    for i in range(DIV_NUM):
        y0 = defineFunction(x) #オリジナル
        y1 = defineFunction(x+dx) #1階微分用
        y2 = defineFunction(x+2*dx) #2階微分用
        y3 = defineFunction(x+3*dx) #3階微分用

        dy0 = (y1 - y0)/dx
        dy1 = (y2 - y1)/dx
        dy2 = (y3 - y2)/dx

        d2y0 = (dy1 - dy0)/dx
        d2y1 = (dy2 - dy1)/dx

        d3y0 = (d2y1 - d2y0)/dx

        #結果を出力
        print(str(x)+" "+str(y0)+" "+str(dy0)+" "+str(d2y0)+" "+str(d3y0))
        #プロット用配列
        x0.append(x)
        df0.append(y0)
        df1.append(dy0)
        df2.append(d2y0)
        df3.append(d3y0)

        x += dx

    print("-")
    # グラフ表示
    plt.plot(x0,df0,label="y0")
    plt.plot(x0,df1,label="dy0")
    plt.plot(x0,df2,label="d2y0")
    plt.plot(x0,df3,label="d3y0")
    plt.legend()
    plt.show()


if __name__ == "__main__":
    main()
