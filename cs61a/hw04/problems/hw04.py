HW_SOURCE_FILE = 'hw04.py'

def g(n):
    """Return the value of G(n), computed recursively.

    >>> g(1)
    1
    >>> g(2)
    2
    >>> g(3)
    3
    >>> g(4)
    10
    >>> g(5)
    22
    >>> from construct_check import check
    >>> check(HW_SOURCE_FILE, 'g', ['While', 'For'])
    True
    """
    if n <=3:
        return n
    else:
        return g(n-1) + 2*g(n-2) + 3*g(n-3)

def g_iter(n):
    """Return the value of G(n), computed iteratively.

    >>> g_iter(1)
    1
    >>> g_iter(2)
    2
    >>> g_iter(3)
    3
    >>> g_iter(4)
    10
    >>> g_iter(5)
    22
    >>> from construct_check import check
    >>> check(HW_SOURCE_FILE, 'g_iter', ['Recursion'])
    True
    """
    if n<=3:
        return n
    a,b,c = 1,2,3
    while(n > 3):
        a,b,c = b, c, (a * 3) + (b * 2) + c
        n -=1
    return c

def pingpong(n):
    """Return the nth element of the ping-pong sequence.

    >>> pingpong(7)
    7
    >>> pingpong(8)
    6
    >>> pingpong(15)
    1
    >>> pingpong(21)
    -1
    >>> pingpong(22)
    0
    >>> pingpong(30)
    6
    >>> pingpong(68)
    2
    >>> pingpong(69)
    1
    >>> pingpong(70)
    0
    >>> pingpong(71)
    1
    >>> pingpong(72)
    0
    >>> pingpong(100)
    2
    >>> from construct_check import check
    >>> check(HW_SOURCE_FILE, 'pingpong', ['Assign', 'AugAssign'])
    True
    """

    ''' 
    Does not work - uses assignment statements

    if_increasing = True #changes when checks the first 0 is a mult of 7 in beginning
    lst = [0]*(n+1)
    index = 1
    while index <= n:
        if if_increasing:
            lst[index] = lst[index-1] + 1
        else:
            lst[index] = lst[index-1] - 1
        if has_seven(index) or index%7 == 0:
            if_increasing = not if_increasing
        index += 1
    return lst[n]
    '''
    def nextElement(index,val,direction): 
        if index == n:#base case
            return val

        if ( (index + 1) % 7 == 0 or has_seven(index +1)):#swap direction
            #increment
            if direction:
                return nextElement(index+1, val + 1, not direction)
            #decrement
            else:
                return nextElement(index+1,val - 1, not direction)
        else:#does not swap direction
            #increment
            if direction:
                return nextElement(index+1, val + 1, direction)
            #decrement
            else:   
                return nextElement(index+1, val - 1, direction)
    return nextElement(1,1,True)

def has_seven(k):
    """Returns True if at least one of the digits of k is a 7, False otherwise.

    >>> has_seven(3)
    False
    >>> has_seven(7)
    True
    >>> has_seven(2734)
    True
    >>> has_seven(2634)
    False
    >>> has_seven(734)
    True
    >>> has_seven(7777)
    True
    """
    if k % 10 == 7:
        return True
    elif k < 10:
        return False
    else:
        return has_seven(k // 10)

def count_change(amount):
    """Return the number of ways to make change for amount.

    >>> count_change(7)
    6
    >>> count_change(10)
    14
    >>> count_change(20)
    60
    >>> count_change(100)
    9828
    """
    def check_amount(n,m):
        if n==0:
            return 1
        elif m > n or m==0:
            return 0
        else:
            return check_amount(n-m,m) + check_amount(n,m*2)
    return check_amount(amount,1)

###################
# Extra Questions #
###################

from operator import sub, mul

def make_anonymous_factorial():
    """Return the value of an expression that computes factorial.

    >>> make_anonymous_factorial()(5)
    120
    >>> from construct_check import check
    >>> check(HW_SOURCE_FILE, 'make_anonymous_factorial', ['Assign', 'AugAssign', 'FunctionDef', 'Recursion'])
    True
    """
    return 'YOUR_EXPRESSION_HERE'
