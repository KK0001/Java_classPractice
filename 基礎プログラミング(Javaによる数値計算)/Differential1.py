# exp(x)の微分

import math

def defineFunction(x):
    return math.exp(x);

def main():

    #変数などの定義
    DIV_NUM = 100 #分割数
    X_MAX = 1.0 #区間
    MIN_DIV = X_MAX/DIV_NUM #分割

    dx = MIN_DIV
    x = 0.0 #x
    dy1 = 0.0 #1階微分用
    dy2 = 0.0 #2階微分用
    d2y = 0.0 #2階微分用

    #微分する
    for i in range(DIV_NUM):
        y0 = defineFunction(x) #オリジナル
        y1 = defineFunction(x+dx) #1階微分用
        y2 = defineFunction(x+2*dx) #2階微分用

        dy1 = (y1 - y0)/dx #1階微分

        dy2 = (y2 - y1)/dx #2階微分用
        d2y = (dy2 - dy1) / dx #2階微分

        #結果を出力
        print(str(x)+" "+str(y0)+" "+str(dy1)+" "+str(d2y))

        x += MIN_DIV


if __name__ == "__main__":
    main()
