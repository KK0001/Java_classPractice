# exp(x)の微分

import math
from sympy import *

# def defineFunction(x):
#     return math.exp(x)

def main():

    x = Symbol("x")                 # symbolとして使う変数の宣言
    f = math.exp(x)      # 関数f(x)の定義
    df = diff(f, x)                 # 関数f(x)をxで微分
    # sf = integrate(f, x)            # 関数f(x)をxで積分
    # s1 = integrate(f, (x,0,1))     # [-1,1]の有限区間でf(x)をxで積分
    # s2 = integrate(f, (x,-oo,oo))   # [-oo,oo]の区間でf(x)をxで積分
    print("f = "+str(f))            # 計算結果の表示
    # print("df = "+str(df))
    # print("sf = "+str(sf))
    # print("s1 = "+str(s1))
    # print("s2 = "+str(s2))


if __name__ == "__main__":
    main()
