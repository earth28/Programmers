def solution(mats, park):
    
    # 큰 돗자리부터 확인하기 위해 내림차순 정렬
    mats.sort(reverse = True)
    
    row = len(park)
    col = len(park[0])
    
    # 돗자리 크기 하나씩 확인
    for size in mats:
        
        # 시작 위치 탐색
        for i in range(row - size + 1):
            for j in range(col - size + 1):
                
                can_place = True
                
                # size x size 영역 확인
                for x in range(i, i + size):
                    for y in range(j, j + size):
                        
                        if park[x][y] != "-1":
                            can_place = False
                            break
                    
                    if not can_place:
                        break
                
                # 설치 가능하면 바로 반환
                if can_place:
                    return size
    
    return -1