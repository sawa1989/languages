def solution(keymap, targets):
    answer = []
    alphabet = [ int(999) for _ in range(27)] # keymap 최대 100

    for key in keymap:
        for i in range(len(key)):
            if alphabet[ord(key[i])-ord('A')+1] >= i+1:
                alphabet[ord(key[i])-ord('A')+1]=i+1
                
    print(alphabet)
    
    for target in targets:
        flag=True
        result=0
        # print(target)
        for i in range(len(target)):
            if alphabet[ord(target[i])-ord('A')+1]==999:
                flag=False
                break
            result+=alphabet[ord(target[i])-ord('A')+1]
            
        if flag==True:
            answer.append(result)
        else:
            answer.append(-1)
    
    return answer
