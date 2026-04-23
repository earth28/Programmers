def solution(s): 
    stack = []
    
    for i in s :
        if i == '(' :   # 여는 괄호면 스택에 추가
            stack.append(i)
        else :  # 스택이 비어있으면 짝이 안 맞음
            if not stack :
                return False
            stack.pop() # 짝이 맞으므로 pop
    
    # 모든 괄호 처리 후 스택이 비어있어야 올바른 괄호
    return not stack