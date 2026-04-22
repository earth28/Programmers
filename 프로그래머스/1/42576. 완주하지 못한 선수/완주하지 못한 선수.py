from collections import defaultdict

def solution(participant, completion):
    answer = ''
    
    # 이름별 등장 횟수를 저장할 딕셔너리 생성
    # 기본값 0으로 설정
    map = defaultdict(lambda : 0)
    
    # 참가자 이름 카운트 (+1)
    for i in participant :
        map[i] += 1
    
    # 완주자 이름 카운트 감소 (-1)
    for i in completion :
        map[i] -= 1
        
    # 값이 1 이상인 사람(완주하지 못한 사람) 찾기
    for key in map :
        if map[key] >0 :
            answer = key;
            break;
    
    return answer