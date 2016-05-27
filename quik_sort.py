#!/usr/bin/python3
# -*- coding: utf-8 -*-

LIST_COUNT = 1000
LOOP_COUNT = 500
MAX_NUM = 10000

def data_generate():
    import random
    return [random.randint( 1, MAX_NUM) for _ in range( LIST_COUNT)]

def quick_sort(data):
    
    if len(data) < 1:
        return data

    pivot = data[0]

    pivot = data[0]
    left = []
    right = []
    for x in range( 1, len(data)):
        if data[ x] <= pivot:
            left.append(data[ x])
        else:
            right.append(data[ x])

    left = quick_sort(left)
    right = quick_sort(right)

    return left + [pivot] + right


if __name__ == '__main__':
    import time
    import sys

    start = time.time()

    for _ in range(LOOP_COUNT):
        data = data_generate()
        quick_sort(data)
        print( '.', end='') if (_+1) % ( LOOP_COUNT // 10) != 0 else print( str(_ // ( LOOP_COUNT // 10) + 1) + "0%" )
        sys.stdout.flush()

    end = time.time()
    print('quick_sort 経過時間:', (end - start))
    print('           平均時間:', (end - start) / LOOP_COUNT)

    '''
    配列を2つに分けて比較して大きい方を選択する方法
    '''


def data_generate():
    import random
    return [random.randint(1, MAX_NUM) for _ in range(LIST_COUNT)]

def quick_sort2(data):
    
    if len(data) < 1:
        return data

    pivot = data[0]

    if len(data) > 2:
        pivot = data[ 0] if data[0] < data[1] else data[1]

    # pivot = data[0]
    left = []
    right = []
    for x in range( 1, len(data)):
        if data[ x] <= pivot:
            left.append( data[x])
        else:
            right.append( data[x])

    left = quick_sort2(left)
    right = quick_sort2(right)

    return left + [pivot] + right


if __name__ == '__main__':
    import time
    import sys

    start = time.time()

    for _ in range(LOOP_COUNT):
        data = data_generate()
        quick_sort2(data)
        print( '.', end='') if (_+1) % ( LOOP_COUNT // 10) != 0 else print( str(_ // ( LOOP_COUNT // 10) + 1) + "0%" )
        sys.stdout.flush()

    end = time.time()
    print('quick_sort2 経過時間:', (end - start))
    print('            平均時間:', (end - start) / LOOP_COUNT)

    '''
    配列から3点比較して中間値を選択する方法
    '''

def data_generate():
    import random
    return [random.randint( 1, MAX_NUM) for _ in range( LIST_COUNT)]

def quick_sort3(data):
    
    if len(data) < 1:
        return data

    pivot = data[0]

        # 配列から3点比較して中間値を選択する
    if len(data) > 3:
        pivot = data[2] if pivot > data[2] else pivot
        pivot = data[1] if pivot < data[1] else pivot

    # pivot = data[0]
    left = []
    right = []
    for x in range(1, len(data)):
        if data[ x] <= pivot:
            left.append(data[ x])
        else:
            right.append(data[ x])

    left = quick_sort3(left)
    right = quick_sort3(right)

    return left + [pivot] + right


if __name__ == '__main__':
    import time
    import sys

    start = time.time()

    for _ in range(LOOP_COUNT):
        data = data_generate()
        quick_sort3(data)
        print( '.', end='') if (_+1) % (LOOP_COUNT // 10) != 0 else print( str(_ // ( LOOP_COUNT // 10) + 1) + "0%" )
        sys.stdout.flush()

    end = time.time()
    print( 'quick_sort3 経過時間:', (end - start))
    print( '            平均時間:', (end - start) / LOOP_COUNT)

    '''
    結果、最初のやつが一番早かった。。。。
    ''' 